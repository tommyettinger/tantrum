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
import com.github.tommyettinger.ds.IntObjectOrderedMap;
import com.github.tommyettinger.ds.OrderType;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link IntObjectOrderedMap}s.
 */
@SuppressWarnings("rawtypes")
public class IntObjectOrderedMapSerializer extends Serializer<IntObjectOrderedMap> {

    public IntObjectOrderedMapSerializer(Fory fory) {
        super(fory, IntObjectOrderedMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final IntObjectOrderedMap data) {
        output.writePrimitiveArrayWithSize(data.keySet().toArray(), Platform.INT_ARRAY_OFFSET, data.size() << 2);
        for(Object v : data.values()){
            fory.writeRef(output, v);
        }
        fory.writeJavaString(output, data.getOrderType().name());
        fory.writeRef(output, data.getDefaultValue());
    }

    @Override
    public IntObjectOrderedMap<?> read(MemoryBuffer input) {
        int[] ks = Support.readIntsAndSize(input);
        final int len = ks.length;
        Object[] vs = new Object[len];
        for (int i = 0; i < len; i++) {
            vs[i] = fory.readRef(input);
        }

        IntObjectOrderedMap data = new IntObjectOrderedMap<>(ks, vs, OrderType.valueOf(fory.readJavaString(input)));
        data.setDefaultValue(fory.readRef(input));
        return data;

    }
}