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

import com.github.tommyettinger.ds.ObjectOrderedSet;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;
import org.apache.fury.serializer.collection.CollectionSerializer;

/**
 * Fury {@link Serializer} for jdkgdxds {@link ObjectOrderedSet}s.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ObjectOrderedSetSerializer extends CollectionSerializer<ObjectOrderedSet> {

    public ObjectOrderedSetSerializer(Fury fury) {
        super(fury, ObjectOrderedSet.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ObjectOrderedSet data) {
        final int len = data.size();
        output.writeVarUint32(len);
        for (int i = 0; i < len; i++) {
            fury.writeRef(output, data.getAt(i));
        }
    }

    @Override
    public ObjectOrderedSet read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        ObjectOrderedSet data = new ObjectOrderedSet(len);
        for (int i = 0; i < len; i++) {
            data.add(fury.readRef(input));
        }
        return data;
    }
}