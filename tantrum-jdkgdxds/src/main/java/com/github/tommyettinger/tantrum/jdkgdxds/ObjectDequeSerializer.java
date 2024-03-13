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

import com.github.tommyettinger.ds.ObjectDeque;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for jdkgdxds {@link ObjectDeque}s.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ObjectDequeSerializer extends Serializer<ObjectDeque> {

    public ObjectDequeSerializer(Fury fury) {
        super(fury, ObjectDeque.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ObjectDeque data) {
        final int len = data.size();
        output.writePositiveVarInt(len);
        for (int i = 0; i < len; i++) {
            fury.writeRef(output, data.get(i));
        }
    }

    @Override
    public ObjectDeque read(MemoryBuffer input) {
        final int len = input.readPositiveVarInt();
        ObjectDeque data = new ObjectDeque(len);
        for (int i = 0; i < len; i++)
            data.add(fury.readRef(input));
        return data;
    }
}