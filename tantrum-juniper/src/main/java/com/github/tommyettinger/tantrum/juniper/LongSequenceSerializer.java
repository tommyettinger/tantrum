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

package com.github.tommyettinger.tantrum.juniper;

import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;
import com.github.tommyettinger.random.LongSequence;
import io.fury.util.Platform;

/**
 * Kryo {@link Serializer} for jdkgdxds {@link LongSequence}s.
 */
public class LongSequenceSerializer extends Serializer<LongSequence> {

    public LongSequenceSerializer(Fury fury) {
        super(fury, LongSequence.class);
    }

    @Override
    public void write(MemoryBuffer output, final LongSequence data) {
        output.writePrimitiveArrayWithSizeEmbedded(data.items, Platform.LONG_ARRAY_OFFSET, data.size << 3);
    }

    @Override
    public LongSequence read(MemoryBuffer input) {
        return new LongSequence(input.readLongsWithSizeEmbedded());
    }
}