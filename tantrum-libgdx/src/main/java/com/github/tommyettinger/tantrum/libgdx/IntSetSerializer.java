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

import com.badlogic.gdx.utils.IntSet;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link IntSet}s.
 */
public class IntSetSerializer extends Serializer<IntSet> {
    public IntSetSerializer(Fury fury) {
        super(fury, IntSet.class);
    }

    @Override
    public void write(final MemoryBuffer output, final IntSet data) {
        final int len = data.size;
        output.writeVarUint32(len);
        IntSet.IntSetIterator it = data.iterator();
        for (int item; it.hasNext;) {
            item = it.next();
            output.writeInt32(item);
        }
    }

    @Override
    public IntSet read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        IntSet data = new IntSet(len);
        for (int i = 0; i < len; i++) {
            data.add(input.readInt32());
        }
        return data;
    }
}
