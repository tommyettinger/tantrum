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
import com.github.tommyettinger.ds.LongIntOrderedMap;
import com.github.tommyettinger.ds.LongLongOrderedMap;
import com.github.tommyettinger.ds.OrderType;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link LongIntOrderedMap}s.
 */
public class LongIntOrderedMapSerializer extends Serializer<LongIntOrderedMap> {

    public LongIntOrderedMapSerializer(Fory fory) {
        super(fory, LongIntOrderedMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final LongIntOrderedMap data) {
        output.writePrimitiveArrayWithSize(data.keySet().toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
        output.writePrimitiveArrayWithSize(data.values().toArray(), Platform.INT_ARRAY_OFFSET, data.size() << 2);
        fory.writeJavaString(output, data.getOrderType().name());
        output.writeInt32(data.getDefaultValue());
    }

    @Override
    public LongIntOrderedMap read(MemoryBuffer input) {
        LongIntOrderedMap data = new LongIntOrderedMap(Support.readLongsAndSize(input), Support.readIntsAndSize(input), OrderType.valueOf(fory.readJavaString(input)));
        data.setDefaultValue(input.readInt32());
        return data;
    }
}