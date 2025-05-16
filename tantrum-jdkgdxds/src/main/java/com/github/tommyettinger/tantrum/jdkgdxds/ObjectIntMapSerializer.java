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

import com.github.tommyettinger.ds.ObjectIntMap;
import com.github.tommyettinger.ds.ObjectIntOrderedMap;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;
import org.apache.fury.memory.Platform;

/**
 * Fury {@link Serializer} for jdkgdxds {@link ObjectIntMap}s.
 */
@SuppressWarnings("rawtypes")
public class ObjectIntMapSerializer extends Serializer<ObjectIntMap> {

    public ObjectIntMapSerializer(Fury fury) {
        super(fury, ObjectIntMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ObjectIntMap data) {
        output.writePrimitiveArrayWithSize(data.values().toArray(), Platform.INT_ARRAY_OFFSET, data.size() << 2);
        for(Object v : data.keySet()){
            fury.writeRef(output, v);
        }
        output.writeInt32(data.getDefaultValue());
    }

    @Override
    public ObjectIntMap<?> read(MemoryBuffer input) {
        int[] vs = Support.readIntsAndSize(input);
        final int len = vs.length;
        Object[] ks = new Object[len];
        for (int i = 0; i < len; i++) {
            ks[i] = fury.readRef(input);
        }

        ObjectIntMap<?> data = new ObjectIntMap<>(ks, vs);
        data.setDefaultValue(input.readInt32());
        return data;
    }
}