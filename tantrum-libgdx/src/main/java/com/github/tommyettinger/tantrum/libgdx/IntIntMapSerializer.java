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

import com.badlogic.gdx.utils.IntIntMap;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link IntIntMap}s.
 */
public class IntIntMapSerializer extends Serializer<IntIntMap> {
    public IntIntMapSerializer(Fury fury) {
        super(fury, IntIntMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final IntIntMap data) {
        final int len = data.size;
        output.writeVarUint32(len);
        IntIntMap.Keys keys = data.keys();
        for (int item; keys.hasNext;) {
            item = keys.next();
            output.writeInt32(item);
            output.writeInt32(data.get(item, 0));
        }
    }

    @Override
    public IntIntMap read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        IntIntMap data = new IntIntMap(len);
        for (int i = 0; i < len; i++) {
            data.put(input.readInt32(), input.readInt32());
        }
        return data;
    }
}
