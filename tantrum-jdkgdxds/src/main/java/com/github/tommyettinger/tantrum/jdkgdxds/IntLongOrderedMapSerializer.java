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

import com.github.tommyettinger.ds.IntDeque;
import com.github.tommyettinger.ds.IntLongOrderedMap;
import com.github.tommyettinger.ds.LongLongOrderedMap;
import com.github.tommyettinger.ds.OrderType;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link IntLongOrderedMap}s.
 */
public class IntLongOrderedMapSerializer extends Serializer<IntLongOrderedMap> {

    public IntLongOrderedMapSerializer(org.apache.fory.config.Config fory) {
        super(fory, IntLongOrderedMap.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final IntLongOrderedMap data) {
        fory.getBuffer().writePrimitiveArrayWithSize(data.keySet().toArray(), Platform.INT_ARRAY_OFFSET, data.size() << 2);
        fory.getBuffer().writePrimitiveArrayWithSize(data.values().toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
        fory.writeString(data.getOrderType().name());
        fory.writeInt64(data.getDefaultValue());
    }

    @Override
    public IntLongOrderedMap read(org.apache.fory.context.ReadContext fory) {
        IntLongOrderedMap data = new IntLongOrderedMap(Support.readIntsAndSize(fory.getBuffer()), Support.readLongsAndSize(fory.getBuffer()), OrderType.valueOf(fory.readString()));
        data.setDefaultValue(fory.readInt64());
        return data;

    }
}