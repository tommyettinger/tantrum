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

import com.github.tommyettinger.ds.LongLongOrderedMap;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;
import io.fury.util.Platform;

/**
 * Fury {@link Serializer} for jdkgdxds {@link LongLongOrderedMap}s.
 */
public class LongLongOrderedMapSerializer extends Serializer<LongLongOrderedMap> {

    public LongLongOrderedMapSerializer(Fury fury) {
        super(fury, LongLongOrderedMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final LongLongOrderedMap data) {
        output.writePrimitiveArrayWithSizeEmbedded(data.keySet().toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
        output.writePrimitiveArrayWithSizeEmbedded(data.values().toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
    }

    @Override
    public LongLongOrderedMap read(MemoryBuffer input) {
        return new LongLongOrderedMap(input.readLongsWithSizeEmbedded(), input.readLongsWithSizeEmbedded());
    }
}