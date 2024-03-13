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

import com.github.tommyettinger.ds.LongDeque;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;
import io.fury.util.Platform;

/**
 * Fury {@link Serializer} for jdkgdxds {@link LongDeque}s.
 */
public class LongDequeSerializer extends Serializer<LongDeque> {

    public LongDequeSerializer(Fury fury) {
        super(fury, LongDeque.class);
    }

    @Override
    public void write(final MemoryBuffer output, final LongDeque data) {
        output.writePrimitiveArrayWithSizeEmbedded(data.toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
    }

    @Override
    public LongDeque read(MemoryBuffer input) {
        return new LongDeque(input.readLongsWithSizeEmbedded());
    }
}