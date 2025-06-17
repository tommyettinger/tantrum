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

import com.github.tommyettinger.ds.IntFloatMap;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link IntFloatMap}s.
 */
public class IntFloatMapSerializer extends Serializer<IntFloatMap> {

    public IntFloatMapSerializer(Fory fory) {
        super(fory, IntFloatMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final IntFloatMap data) {
        output.writePrimitiveArrayWithSize(data.keySet().toArray(), Platform.INT_ARRAY_OFFSET, data.size() << 2);
        output.writePrimitiveArrayWithSize(data.values().toArray(), Platform.FLOAT_ARRAY_OFFSET, data.size() << 2);
        output.writeFloat32(data.getDefaultValue());
    }

    @Override
    public IntFloatMap read(MemoryBuffer input) {
        IntFloatMap data = new IntFloatMap(Support.readIntsAndSize(input), Support.readFloatsAndSize(input));
        data.setDefaultValue(input.readFloat32());
        return data;
    }
}