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

import com.github.tommyettinger.ds.NumberedSet;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;
import org.apache.fury.serializer.collection.CollectionSerializer;

/**
 * Fury {@link Serializer} for jdkgdxds {@link NumberedSet}s.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class NumberedSetSerializer extends CollectionSerializer<NumberedSet> {

    public NumberedSetSerializer(Fury fury) {
        super(fury, NumberedSet.class);
    }

    @Override
    public void write(final MemoryBuffer output, final NumberedSet data) {
        final int len = data.size();
        output.writeVarUint32(len);
        for (Object item : data) {
            fury.writeRef(output, item);
        }
    }

    @Override
    public NumberedSet read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        NumberedSet data = new NumberedSet(len);
        for (int i = 0; i < len; i++) {
            data.add(fury.readRef(input));
        }
        return data;
    }
}