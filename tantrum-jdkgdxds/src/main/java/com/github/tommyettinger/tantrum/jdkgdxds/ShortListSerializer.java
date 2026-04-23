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

import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.serializer.Serializer;
import com.github.tommyettinger.ds.ShortList;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link ShortList}s.
 */
public class ShortListSerializer extends Serializer<ShortList> {

    public ShortListSerializer(org.apache.fory.Fory fory) {
        super(fory.getConfig(), ShortList.class);
    }
    public ShortListSerializer(org.apache.fory.config.Config fory) {
        super(fory, ShortList.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final ShortList data) {
        fory.getBuffer().writePrimitiveArrayWithSize(data.items, Platform.SHORT_ARRAY_OFFSET, data.size() << 1);
    }

    @Override
    public ShortList read(org.apache.fory.context.ReadContext fory) {
        return new ShortList(Support.readShortsAndSize(fory.getBuffer()));
    }
}