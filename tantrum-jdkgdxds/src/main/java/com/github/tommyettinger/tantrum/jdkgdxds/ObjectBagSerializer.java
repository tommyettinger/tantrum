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

import com.github.tommyettinger.ds.ObjectBag;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for jdkgdxds {@link ObjectBag}s.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ObjectBagSerializer extends Serializer<ObjectBag> {

    public ObjectBagSerializer(Fury fury) {
        super(fury, ObjectBag.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ObjectBag data) {
        output.writePositiveVarInt(data.size());
        for(Object item : data)
            fury.writeRef(output, item);
    }

    @Override
    public ObjectBag read(MemoryBuffer input) {
        final int len = input.readPositiveVarInt();
        ObjectBag data = new ObjectBag(len);
        for (int i = 0; i < len; i++)
            data.add(fury.readRef(input));
        return data;
    }
}