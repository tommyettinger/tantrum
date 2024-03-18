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

package com.github.tommyettinger.tantrum.libgdx;

import com.badlogic.gdx.utils.IntArray;
import com.github.tommyettinger.tantrum.libgdx.helpers.Support;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;
import io.fury.util.Platform;

/**
 * Fury {@link Serializer} for jdkgdxds {@link IntArray}s.
 */
public class IntArraySerializer extends Serializer<IntArray> {

    public IntArraySerializer(Fury fury) {
        super(fury, IntArray.class);
    }

    @Override
    public void write(final MemoryBuffer output, final IntArray data) {
        output.writeBoolean(data.ordered);
        output.writePrimitiveArrayWithSizeEmbedded(data.items, Platform.INT_ARRAY_OFFSET, data.size << 2);
    }

    @Override
    public IntArray read(MemoryBuffer input) {
        final boolean ordered = input.readBoolean();
        final int[] items = Support.readIntsWithSizeEmbedded(input);
        return new IntArray(ordered, items, 0, items.length);
    }
}