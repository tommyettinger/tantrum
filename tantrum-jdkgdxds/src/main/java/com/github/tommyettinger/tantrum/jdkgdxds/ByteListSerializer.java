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

import com.github.tommyettinger.ds.ByteList;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link ByteList}s.
 */
public class ByteListSerializer extends Serializer<ByteList> {

    public ByteListSerializer(Fory fory) {
        super(fory, ByteList.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ByteList data) {
        output.writePrimitiveArrayWithSize(data.items, Platform.BYTE_ARRAY_OFFSET, data.size());
    }

    @Override
    public ByteList read(MemoryBuffer input) {
        return new ByteList(input.readBytesAndSize());
    }
}