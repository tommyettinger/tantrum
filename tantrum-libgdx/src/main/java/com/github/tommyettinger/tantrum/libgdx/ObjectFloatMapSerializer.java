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
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link ObjectFloatMap}s.
 */
public class ObjectFloatMapSerializer extends Serializer<ObjectFloatMap> {
    public ObjectFloatMapSerializer(Fury fury) {
        super(fury, ObjectFloatMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ObjectFloatMap data) {
        final int len = data.size;
        output.writePositiveVarInt(len);
        for (Object item : data.keys()) {
            fury.writeRef(output, item);
            output.writeFloat(data.get(item, 0));
        }
    }

    @Override
    public ObjectFloatMap<?> read(MemoryBuffer input) {
        final int len = input.readPositiveVarInt();
        ObjectFloatMap data = new ObjectFloatMap(len);
        for (int i = 0; i < len; i++) {
            data.put(fury.readRef(input), input.readFloat());
        }
        return data;
    }
}
