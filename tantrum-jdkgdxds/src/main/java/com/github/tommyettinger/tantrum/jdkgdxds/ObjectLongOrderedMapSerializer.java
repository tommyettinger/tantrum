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

import com.github.tommyettinger.ds.ObjectLongMap;
import com.github.tommyettinger.ds.ObjectLongOrderedMap;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;
import com.github.tommyettinger.tantrum.digital.helpers.Support;

/**
 * Fory {@link Serializer} for jdkgdxds {@link ObjectLongOrderedMap}s.
 */
@SuppressWarnings("rawtypes")
public class ObjectLongOrderedMapSerializer extends Serializer<ObjectLongOrderedMap> {

    public ObjectLongOrderedMapSerializer(Fory fory) {
        super(fory, ObjectLongOrderedMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ObjectLongOrderedMap data) {
        output.writePrimitiveArrayWithSize(data.values().toArray(), Platform.LONG_ARRAY_OFFSET, data.size() << 3);
        for(Object v : data.keySet()){
            fory.writeRef(output, v);
        }
        output.writeInt64(data.getDefaultValue());
    }

    @Override
    public ObjectLongOrderedMap<?> read(MemoryBuffer input) {
        long[] vs = Support.readLongsAndSize(input);
        final int len = vs.length;
        Object[] ks = new Object[len];
        for (int i = 0; i < len; i++) {
            ks[i] = fory.readRef(input);
        }

        ObjectLongOrderedMap<?> data = new ObjectLongOrderedMap<>(ks, vs);
        data.setDefaultValue(input.readInt64());
        return data;
    }
}