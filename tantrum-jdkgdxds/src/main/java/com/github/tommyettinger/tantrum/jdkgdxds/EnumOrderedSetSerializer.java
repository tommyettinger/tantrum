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

import com.github.tommyettinger.ds.EnumOrderedSet;
import com.github.tommyettinger.ds.OrderType;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.serializer.collection.CollectionSerializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link EnumOrderedSet}s.
 */
public class EnumOrderedSetSerializer extends CollectionSerializer<EnumOrderedSet> {

    public EnumOrderedSetSerializer(Fory fory) {
        super(fory, EnumOrderedSet.class);
    }

    @Override
    public void write(final MemoryBuffer output, final EnumOrderedSet data) {
        final int len = data.size();
        output.writeVarUint32(len);
        fory.writeJavaString(output, data.getOrderType().name());
        for (Enum<?> item : data) {
            fory.writeRef(output, item);
        }
    }

    @Override
    public EnumOrderedSet read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        EnumOrderedSet data = new EnumOrderedSet(OrderType.valueOf(fory.readJavaString(input)));
        for (int i = 0; i < len; i++) {
            data.add((Enum<?>)fory.readRef(input));
        }
        return data;
    }
}