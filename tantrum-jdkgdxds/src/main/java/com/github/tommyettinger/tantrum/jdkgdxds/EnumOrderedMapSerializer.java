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
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.serializer.collection.MapSerializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link EnumOrderedMap}s.
 */
@SuppressWarnings("rawtypes")
public class EnumOrderedMapSerializer extends MapSerializer<EnumOrderedMap> {

    public EnumOrderedMapSerializer(Fory fory) {
        super(fory, EnumOrderedMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final EnumOrderedMap data) {
        output.writeVarUint32(data.size());
        fory.writeJavaString(output, data.getOrderType().name());
        for(Enum<?> k : data.keySet()){
            fory.writeRef(output, k);
        }
        for(Object v : data.values()){
            fory.writeRef(output, v);
        }
        fory.writeRef(output, data.getDefaultValue());
    }

    @Override
    public EnumOrderedMap<?> read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        OrderType type = OrderType.valueOf(fory.readJavaString(input));
        if(len == 0) return new EnumOrderedMap<>(type);
        Enum<?>[] ks = new Enum[len];
        for (int i = 0; i < len; i++) {
            ks[i] = (Enum<?>) fory.readRef(input);
        }
        Object[] vs = new Object[len];
        for (int i = 0; i < len; i++) {
            vs[i] = fory.readRef(input);
        }

        EnumOrderedMap data = new EnumOrderedMap<>(ks, vs, type);
        data.setDefaultValue(fory.readRef(input));
        return data;
    }
}