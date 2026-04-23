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

import com.github.tommyettinger.ds.IntFloatOrderedMap;
import com.github.tommyettinger.ds.OrderType;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link IntFloatOrderedMap}s.
 */
public class IntFloatOrderedMapSerializer extends Serializer<IntFloatOrderedMap> {

    public IntFloatOrderedMapSerializer(org.apache.fory.Fory fory) {
        super(fory.getConfig(), IntFloatOrderedMap.class);
    }
    public IntFloatOrderedMapSerializer(org.apache.fory.config.Config fory) {
        super(fory, IntFloatOrderedMap.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final IntFloatOrderedMap data) {
        fory.getBuffer().writePrimitiveArrayWithSize(data.keySet().toArray(), Platform.INT_ARRAY_OFFSET, data.size() << 2);
        fory.getBuffer().writePrimitiveArrayWithSize(data.values().toArray(), Platform.FLOAT_ARRAY_OFFSET, data.size() << 2);
        fory.writeString(data.getOrderType().name());
        fory.writeFloat32(data.getDefaultValue());
    }

    @Override
    public IntFloatOrderedMap read(org.apache.fory.context.ReadContext fory) {
        IntFloatOrderedMap data = new IntFloatOrderedMap(Support.readIntsAndSize(fory.getBuffer()), Support.readFloatsAndSize(fory.getBuffer()), OrderType.valueOf(fory.readString()));
        data.setDefaultValue(fory.readFloat32());
        return data;

    }
}