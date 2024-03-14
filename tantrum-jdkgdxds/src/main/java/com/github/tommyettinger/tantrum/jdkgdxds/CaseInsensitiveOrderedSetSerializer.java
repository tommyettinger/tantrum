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

import com.github.tommyettinger.ds.CaseInsensitiveOrderedSet;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for jdkgdxds {@link CaseInsensitiveOrderedSet}s.
 */
public class CaseInsensitiveOrderedSetSerializer extends Serializer<CaseInsensitiveOrderedSet> {

    public CaseInsensitiveOrderedSetSerializer(Fury fury) {
        super(fury, CaseInsensitiveOrderedSet.class);
    }

    @Override
    public void write(final MemoryBuffer output, final CaseInsensitiveOrderedSet data) {
        final int len = data.size();
        output.writePositiveVarInt(len);
        for (Object item : data) {
            fury.writeRef(output, item);
        }
    }

    @Override
    public CaseInsensitiveOrderedSet read(MemoryBuffer input) {
        final int len = input.readPositiveVarInt();
        CaseInsensitiveOrderedSet data = new CaseInsensitiveOrderedSet(len);
        for (int i = 0; i < len; i++) {
            data.add((CharSequence) fury.readRef(input));
        }
        return data;
    }
}