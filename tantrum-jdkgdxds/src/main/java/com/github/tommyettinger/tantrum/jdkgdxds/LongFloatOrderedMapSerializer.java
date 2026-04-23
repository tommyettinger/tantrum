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

import com.github.tommyettinger.ds.LongFloatOrderedMap;
import com.github.tommyettinger.ds.OrderType;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link LongFloatOrderedMap}s.
 */
public class LongFloatOrderedMapSerializer extends Serializer<LongFloatOrderedMap> {

    public LongFloatOrderedMapSerializer(org.apache.fory.Fory fory) {
        super(fory.getConfig(), LongFloatOrderedMap.class);
    }
    public LongFloatOrderedMapSerializer(org.apache.fory.config.Config fory) {
        super(fory, LongFloatOrderedMap.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final LongFloatOrderedMap data) {
        fory.getBuffer().writePrimitiveArrayWithSize(data.keySet().toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
        fory.getBuffer().writePrimitiveArrayWithSize(data.values().toArray(), Platform.FLOAT_ARRAY_OFFSET, data.size() << 2);
        fory.writeString(data.getOrderType().name());
        fory.writeFloat32(data.getDefaultValue());
    }

    @Override
    public LongFloatOrderedMap read(org.apache.fory.context.ReadContext fory) {
        LongFloatOrderedMap data = new LongFloatOrderedMap(Support.readLongsAndSize(fory.getBuffer()), Support.readFloatsAndSize(fory.getBuffer()), OrderType.valueOf(fory.readString()));
        data.setDefaultValue(fory.readFloat32());
        return data;
    }
}