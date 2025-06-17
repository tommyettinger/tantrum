/*
 * Copyright (c) 2022-2024 See AUTHORS file.
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

package com.github.tommyettinger.tantrum.libgdx;

import com.badlogic.gdx.utils.ObjectLongMap;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link ObjectLongMap}s.
 */
public class ObjectLongMapSerializer extends Serializer<ObjectLongMap> {
    public ObjectLongMapSerializer(Fory fory) {
        super(fory, ObjectLongMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ObjectLongMap data) {
        final int len = data.size;
        output.writeVarUint32(len);
        for (Object item : data.keys()) {
            fory.writeRef(output, item);
            output.writeInt64(data.get(item, 0));
        }
    }

    @Override
    public ObjectLongMap<?> read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        ObjectLongMap data = new ObjectLongMap(len);
        for (int i = 0; i < len; i++) {
            data.put(fory.readRef(input), input.readInt64());
        }
        return data;
    }
}
