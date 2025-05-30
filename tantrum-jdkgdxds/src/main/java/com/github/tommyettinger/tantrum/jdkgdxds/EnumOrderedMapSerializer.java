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
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;
import org.apache.fury.serializer.collection.MapSerializer;

/**
 * Fury {@link Serializer} for jdkgdxds {@link EnumOrderedMap}s.
 */
@SuppressWarnings("rawtypes")
public class EnumOrderedMapSerializer extends MapSerializer<EnumOrderedMap> {

    public EnumOrderedMapSerializer(Fury fury) {
        super(fury, EnumOrderedMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final EnumOrderedMap data) {
        output.writeVarUint32(data.size());
        for(Enum<?> k : data.keySet()){
            fury.writeRef(output, k);
        }
        for(Object v : data.values()){
            fury.writeRef(output, v);
        }
        fury.writeRef(output, data.getDefaultValue());
    }

    @Override
    public EnumOrderedMap<?> read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        if(len == 0) return new EnumOrderedMap<>();
        Enum<?>[] ks = new Enum[len];
        for (int i = 0; i < len; i++) {
            ks[i] = (Enum<?>) fury.readRef(input);
        }
        Object[] vs = new Object[len];
        for (int i = 0; i < len; i++) {
            vs[i] = fury.readRef(input);
        }

        EnumOrderedMap data = new EnumOrderedMap<>(ks, vs);
        data.setDefaultValue(fury.readRef(input));
        return data;
    }
}