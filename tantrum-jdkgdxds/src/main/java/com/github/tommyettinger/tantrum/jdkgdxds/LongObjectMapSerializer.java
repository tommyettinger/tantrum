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

import com.github.tommyettinger.ds.LongObjectMap;
import com.github.tommyettinger.ds.LongObjectOrderedMap;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;
import org.apache.fury.memory.Platform;
import com.github.tommyettinger.tantrum.digital.helpers.Support;

/**
 * Fury {@link Serializer} for jdkgdxds {@link LongObjectMap}s.
 */
@SuppressWarnings("rawtypes")
public class LongObjectMapSerializer extends Serializer<LongObjectMap> {

    public LongObjectMapSerializer(Fury fury) {
        super(fury, LongObjectMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final LongObjectMap data) {
        output.writePrimitiveArrayWithSize(data.keySet().toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
        for(Object v : data.values()){
            fury.writeRef(output, v);
        }
        fury.writeRef(output, data.getDefaultValue());
    }

    @Override
    public LongObjectMap<?> read(MemoryBuffer input) {
        long[] ks = Support.readLongsAndSize(input);
        final int len = ks.length;
        Object[] vs = new Object[len];
        for (int i = 0; i < len; i++) {
            vs[i] = fury.readRef(input);
        }

        LongObjectMap data = new LongObjectMap<>(ks, vs);
        data.setDefaultValue(fury.readRef(input));
        return data;
    }
}