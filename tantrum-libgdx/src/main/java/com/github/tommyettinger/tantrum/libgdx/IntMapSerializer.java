/*
 * Copyright (c) 2022-2024 See AUTHORS file.
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

package com.github.tommyettinger.tantrum.libgdx;

import com.badlogic.gdx.utils.IntMap;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link IntMap}s.
 */
public class IntMapSerializer extends Serializer<IntMap> {
    public IntMapSerializer(Fury fury) {
        super(fury, IntMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final IntMap data) {
        final int len = data.size;
        output.writePositiveVarInt(len);
        IntMap.Keys keys = data.keys();
        for (int item; keys.hasNext;) {
            item = keys.next();
            output.writeInt(item);
            fury.writeRef(output, data.get(item));
        }
    }

    @Override
    public IntMap<?> read(MemoryBuffer input) {
        final int len = input.readPositiveVarInt();
        IntMap data = new IntMap(len);
        for (int i = 0; i < len; i++) {
            data.put(input.readInt(), fury.readRef(input));
        }
        return data;
    }
}
