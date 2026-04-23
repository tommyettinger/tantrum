/*
 * Copyright (c) 2024 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.tommyettinger.tantrum.jdkgdxds;

import com.github.tommyettinger.ds.EnumOrderedMap;
import com.github.tommyettinger.ds.OrderType;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.serializer.collection.MapSerializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link EnumOrderedMap}s.
 */
@SuppressWarnings("rawtypes")
public class EnumOrderedMapSerializer extends MapSerializer<EnumOrderedMap> {

    public EnumOrderedMapSerializer(org.apache.fory.resolver.TypeResolver resolver) {
        super(resolver, EnumOrderedMap.class, true);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final EnumOrderedMap data) {
        fory.writeVarUint32(data.size());
        fory.writeString(data.getOrderType().name());
        for(Enum<?> k : data.keySet()){
            fory.writeRef(k);
        }
        for(Object v : data.values()){
            fory.writeRef(v);
        }
        fory.writeRef(data.getDefaultValue());
    }

    @Override
    public EnumOrderedMap<?> read(org.apache.fory.context.ReadContext fory) {
        final int len = fory.readVarUint32();
        OrderType type = OrderType.valueOf(fory.readString());
        if(len == 0) return new EnumOrderedMap<>(type);
        Enum<?>[] ks = new Enum[len];
        for (int i = 0; i < len; i++) {
            ks[i] = (Enum<?>) fory.readRef();
        }
        Object[] vs = new Object[len];
        for (int i = 0; i < len; i++) {
            vs[i] = fory.readRef();
        }

        EnumOrderedMap data = new EnumOrderedMap<>(ks, vs, type);
        data.setDefaultValue(fory.readRef());
        return data;
    }
}