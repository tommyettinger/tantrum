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

import com.github.tommyettinger.tantrum.jdkgdxds.helpers.Support;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;
import com.github.tommyettinger.ds.ShortList;
import io.fury.util.Platform;

/**
 * Fury {@link Serializer} for jdkgdxds {@link ShortList}s.
 */
public class ShortListSerializer extends Serializer<ShortList> {

    public ShortListSerializer(Fury fury) {
        super(fury, ShortList.class);
    }

    @Override
    public void write(final MemoryBuffer output, final ShortList data) {
        int length = data.size();
        output.writePrimitiveArrayWithSizeEmbedded(data.items, Platform.SHORT_ARRAY_OFFSET, length << 1);
    }

    @Override
    public ShortList read(MemoryBuffer input) {
        ShortList data = new ShortList(Support.readShortsWithSizeEmbedded(input));
        return data;
    }
}