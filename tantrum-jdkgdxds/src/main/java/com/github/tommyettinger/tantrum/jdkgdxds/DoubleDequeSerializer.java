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

import com.github.tommyettinger.ds.DoubleDeque;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;
import org.apache.fury.memory.Platform;

/**
 * Fury {@link Serializer} for jdkgdxds {@link DoubleDeque}s.
 */
public class DoubleDequeSerializer extends Serializer<DoubleDeque> {

    public DoubleDequeSerializer(Fury fury) {
        super(fury, DoubleDeque.class);
    }

    @Override
    public void write(final MemoryBuffer output, final DoubleDeque data) {
        output.writePrimitiveArrayWithSize(data.toArray(), Platform.DOUBLE_ARRAY_OFFSET, data.size() << 3);
        output.writeFloat64(data.getDefaultValue());
    }

    @Override
    public DoubleDeque read(MemoryBuffer input) {
        DoubleDeque data = new DoubleDeque(Support.readDoublesAndSize(input));
        data.setDefaultValue(input.readFloat64());
        return data;
    }
}