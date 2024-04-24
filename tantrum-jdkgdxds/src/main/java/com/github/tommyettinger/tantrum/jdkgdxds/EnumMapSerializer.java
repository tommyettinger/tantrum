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

import com.github.tommyettinger.ds.EnumMap;
import com.github.tommyettinger.tantrum.jdkgdxds.helpers.Support;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;
import io.fury.util.Platform;

/**
 * Fury {@link Serializer} for jdkgdxds {@link EnumMap}s.
 */
@SuppressWarnings("rawtypes")
public class EnumMapSerializer extends Serializer<EnumMap> {

    public EnumMapSerializer(Fury fury) {
        super(fury, EnumMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final EnumMap data) {
        output.writePositiveVarInt(data.size());
        for(Object v : data.keySet()){
            fury.writeRef(output, v);
        }
        for(Object v : data.values()){
            fury.writeRef(output, v);
        }
    }

    @Override
    public EnumMap<?> read(MemoryBuffer input) {
        final int len = input.readPositiveVarInt();
        if(len == 0) return new EnumMap<>();
        Enum<?>[] ks = new Enum[len];
        for (int i = 0; i < len; i++) {
            ks[i] = (Enum<?>) fury.readRef(input);
        }
        Object[] vs = new Object[len];
        for (int i = 0; i < len; i++) {
            vs[i] = fury.readRef(input);
        }

        return new EnumMap<>(ks, vs);
    }
}