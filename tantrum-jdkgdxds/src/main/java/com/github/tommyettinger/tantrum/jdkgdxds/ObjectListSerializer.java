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

import com.github.tommyettinger.ds.ObjectList;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for jdkgdxds {@link ObjectList}s.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ObjectListSerializer extends Serializer<ObjectList> {

    public ObjectListSerializer(Fury fury) {
        super(fury, ObjectList.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ObjectList data) {
        output.writePositiveVarInt(data.size());
        for(Object item : data)
            fury.writeRef(output, item);
    }

    @Override
    public ObjectList read(MemoryBuffer input) {
        final int len = input.readPositiveVarInt();
        ObjectList data = new ObjectList(len);
        for (int i = 0; i < len; i++)
            data.add(fury.readRef(input));
        return data;
    }
}