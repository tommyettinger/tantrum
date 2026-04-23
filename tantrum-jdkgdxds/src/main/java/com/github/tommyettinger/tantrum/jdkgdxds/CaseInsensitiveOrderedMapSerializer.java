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

import com.github.tommyettinger.ds.CaseInsensitiveOrderedMap;
import com.github.tommyettinger.ds.OrderType;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.serializer.collection.MapSerializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link CaseInsensitiveOrderedMap}s.
 */
@SuppressWarnings("rawtypes")
public class CaseInsensitiveOrderedMapSerializer extends MapSerializer<CaseInsensitiveOrderedMap> {

    public CaseInsensitiveOrderedMapSerializer(org.apache.fory.resolver.TypeResolver resolver) {
        super(resolver, CaseInsensitiveOrderedMap.class, true);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final CaseInsensitiveOrderedMap data) {
        fory.writeVarUint32(data.size());
        for(Object k : data.keySet()){
            fory.writeRef(k);
        }
        for(Object v : data.values()){
            fory.writeRef(v);
        }
        fory.writeString(data.getOrderType().name());
        fory.writeRef(data.getDefaultValue());
    }

    @Override
    public CaseInsensitiveOrderedMap<?> read(org.apache.fory.context.ReadContext fory) {
        final int len = fory.readVarUint32();
        CharSequence[] ks = new CharSequence[len];
        Object[] vs = new Object[len];
        for (int i = 0; i < len; i++) {
            ks[i] = (CharSequence) fory.readRef();
        }
        for (int i = 0; i < len; i++) {
            vs[i] = fory.readRef();
        }

        CaseInsensitiveOrderedMap data = new CaseInsensitiveOrderedMap<>(ks, vs, OrderType.valueOf(fory.readString()));
        data.setDefaultValue(fory.readRef());
        return data;

    }
}