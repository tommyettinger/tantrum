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

import com.github.tommyettinger.ds.LongLongMap;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;
import com.github.tommyettinger.tantrum.digital.helpers.Support;

/**
 * Fory {@link Serializer} for jdkgdxds {@link LongLongMap}s.
 */
public class LongLongMapSerializer extends Serializer<LongLongMap> {

    public LongLongMapSerializer(Fory fory) {
        super(fory, LongLongMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final LongLongMap data) {
        output.writePrimitiveArrayWithSize(data.keySet().toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
        output.writePrimitiveArrayWithSize(data.values().toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
        output.writeInt64(data.getDefaultValue());
    }

    @Override
    public LongLongMap read(MemoryBuffer input) {
        LongLongMap data = new LongLongMap(Support.readLongsAndSize(input), Support.readLongsAndSize(input));
        data.setDefaultValue(input.readInt64());
        return data;

    }
}