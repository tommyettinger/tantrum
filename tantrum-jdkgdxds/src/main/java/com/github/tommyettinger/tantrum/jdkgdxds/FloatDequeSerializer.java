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

import com.github.tommyettinger.ds.FloatDeque;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link FloatDeque}s.
 */
public class FloatDequeSerializer extends Serializer<FloatDeque> {

    public FloatDequeSerializer(Fory fory) {
        super(fory, FloatDeque.class);
    }

    @Override
    public void write(final MemoryBuffer output, final FloatDeque data) {
        output.writePrimitiveArrayWithSize(data.toArray(), Platform.FLOAT_ARRAY_OFFSET, data.size() << 2);
        output.writeFloat32(data.getDefaultValue());
    }

    @Override
    public FloatDeque read(MemoryBuffer input) {
        FloatDeque data = new FloatDeque(Support.readFloatsAndSize(input));
        data.setDefaultValue(input.readFloat32());
        return data;
    }
}