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

import com.github.tommyettinger.ds.IntLongMap;
import com.github.tommyettinger.ds.IntLongOrderedMap;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link IntLongMap}s.
 */
public class IntLongMapSerializer extends Serializer<IntLongMap> {

    public IntLongMapSerializer(org.apache.fory.config.Config fory) {
        super(fory, IntLongMap.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final IntLongMap data) {
        fory.getBuffer().writePrimitiveArrayWithSize(data.keySet().toArray(), Platform.INT_ARRAY_OFFSET, data.size() << 2);
        fory.getBuffer().writePrimitiveArrayWithSize(data.values().toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
        fory.writeInt64(data.getDefaultValue());
    }

    @Override
    public IntLongMap read(org.apache.fory.context.ReadContext fory) {
        IntLongMap data = new IntLongMap(Support.readIntsAndSize(fory.getBuffer()), Support.readLongsAndSize(fory.getBuffer()));
        data.setDefaultValue(fory.readInt64());
        return data;
    }
}