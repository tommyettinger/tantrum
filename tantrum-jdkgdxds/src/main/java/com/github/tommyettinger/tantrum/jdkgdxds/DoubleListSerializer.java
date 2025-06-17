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

import com.github.tommyettinger.ds.DoubleList;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link DoubleList}s.
 */
public class DoubleListSerializer extends Serializer<DoubleList> {

    public DoubleListSerializer(Fory fory) {
        super(fory, DoubleList.class);
    }

    @Override
    public void write(final MemoryBuffer output, final DoubleList data) {
        output.writePrimitiveArrayWithSize(data.items, Platform.DOUBLE_ARRAY_OFFSET, data.size() << 3);
    }

    @Override
    public DoubleList read(MemoryBuffer input) {
        return new DoubleList(Support.readDoublesAndSize(input));
    }
}