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

import com.github.tommyettinger.ds.BooleanBag;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link BooleanBag}s.
 */
public class BooleanBagSerializer extends Serializer<BooleanBag> {

    public BooleanBagSerializer(org.apache.fory.config.Config fory) {
        super(fory, BooleanBag.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final BooleanBag data) {
        fory.getBuffer().writePrimitiveArrayWithSize(data.items, Platform.BOOLEAN_ARRAY_OFFSET, data.size());
    }

    @Override
    public BooleanBag read(org.apache.fory.context.ReadContext fory) {
        return new BooleanBag(Support.readBooleansAndSize(fory.getBuffer()));
    }
}