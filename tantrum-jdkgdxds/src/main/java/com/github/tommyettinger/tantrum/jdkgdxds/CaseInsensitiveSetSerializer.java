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

import com.github.tommyettinger.ds.CaseInsensitiveSet;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.serializer.collection.CollectionSerializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link CaseInsensitiveSet}s.
 */
public class CaseInsensitiveSetSerializer extends CollectionSerializer<CaseInsensitiveSet> {

    public CaseInsensitiveSetSerializer(Fory fory) {
        super(fory, CaseInsensitiveSet.class);
    }

    @Override
    public void write(final MemoryBuffer output, final CaseInsensitiveSet data) {
        final int len = data.size();
        output.writeVarUint32(len);
        for (Object item : data) {
            fory.writeRef(output, item);
        }
    }

    @Override
    public CaseInsensitiveSet read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        CaseInsensitiveSet data = new CaseInsensitiveSet(len);
        for (int i = 0; i < len; i++) {
            data.add((CharSequence) fory.readRef(input));
        }
        return data;
    }
}