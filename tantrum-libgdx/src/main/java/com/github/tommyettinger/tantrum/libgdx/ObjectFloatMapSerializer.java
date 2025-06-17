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

import com.badlogic.gdx.utils.ObjectFloatMap;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link ObjectFloatMap}s.
 */
public class ObjectFloatMapSerializer extends Serializer<ObjectFloatMap> {
    public ObjectFloatMapSerializer(Fory fory) {
        super(fory, ObjectFloatMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ObjectFloatMap data) {
        final int len = data.size;
        output.writeVarUint32(len);
        for (Object item : data.keys()) {
            fory.writeRef(output, item);
            output.writeFloat32(data.get(item, 0));
        }
    }

    @Override
    public ObjectFloatMap<?> read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        ObjectFloatMap data = new ObjectFloatMap(len);
        for (int i = 0; i < len; i++) {
            data.put(fory.readRef(input), input.readFloat32());
        }
        return data;
    }
}
