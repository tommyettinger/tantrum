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

import com.badlogic.gdx.utils.ObjectMap;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link ObjectMap}s.
 */
public class ObjectMapSerializer extends Serializer<ObjectMap> {
    public ObjectMapSerializer(Fory fory) {
        super(fory, ObjectMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ObjectMap data) {
        final int len = data.size;
        output.writeVarUint32(len);
        for (Object item : data.keys()) {
            fory.writeRef(output, item);
            fory.writeRef(output, data.get(item));
        }
    }

    @Override
    public ObjectMap<?, ?> read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        ObjectMap data = new ObjectMap(len);
        for (int i = 0; i < len; i++) {
            data.put(fory.readRef(input), fory.readRef(input));
        }
        return data;
    }
}
