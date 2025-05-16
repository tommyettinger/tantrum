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

import com.github.tommyettinger.ds.ByteDeque;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;
import org.apache.fury.memory.Platform;

/**
 * Fury {@link Serializer} for jdkgdxds {@link ByteDeque}s.
 */
public class ByteDequeSerializer extends Serializer<ByteDeque> {

    public ByteDequeSerializer(Fury fury) {
        super(fury, ByteDeque.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ByteDeque data) {
        output.writePrimitiveArrayWithSize(data.toArray(), Platform.BYTE_ARRAY_OFFSET, data.size());
        output.writeByte(data.getDefaultValue());
    }

    @Override
    public ByteDeque read(MemoryBuffer input) {
        ByteDeque data = new ByteDeque(input.readBytesAndSize());
        data.setDefaultValue(input.readByte());
        return data;
    }
}