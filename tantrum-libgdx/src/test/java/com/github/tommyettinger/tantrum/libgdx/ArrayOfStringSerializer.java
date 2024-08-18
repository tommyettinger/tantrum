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

import com.badlogic.gdx.utils.Array;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link Array}s.
 */
public class ArrayOfStringSerializer extends Serializer<Array> {
    public ArrayOfStringSerializer(Fury fury) {
        super(fury, Array.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Array data) {
        final int len = data.size;
        output.writeBoolean(data.ordered);
        output.writeVarUint32(len);
        for (Object item : data) {
            fury.writeString(output, item.toString());
        }
    }

    @Override
    public Array<?> read(MemoryBuffer input) {
        final boolean ordered = input.readBoolean();
        final int len = input.readVarUint32();
        Array<String> data = new Array<>(ordered, len);
        for (int i = 0; i < len; i++) {
            data.add(fury.readString(input));
        }
        return data;
    }
}