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
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.serializer.collection.CollectionSerializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link NumberedSet}s.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class NumberedSetSerializer extends CollectionSerializer<NumberedSet> {

    public NumberedSetSerializer(Fory fory) {
        super(fory, NumberedSet.class);
    }

    @Override
    public void write(final MemoryBuffer output, final NumberedSet data) {
        final int len = data.size();
        output.writeVarUint32(len);
        for (Object item : data) {
            fory.writeRef(output, item);
        }
        output.writeInt32(data.getDefaultValue());
    }

    @Override
    public NumberedSet read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        NumberedSet data = new NumberedSet(len);
        for (int i = 0; i < len; i++) {
            data.add(fory.readRef(input));
        }
        data.setDefaultValue(input.readInt32());
        return data;
    }
}