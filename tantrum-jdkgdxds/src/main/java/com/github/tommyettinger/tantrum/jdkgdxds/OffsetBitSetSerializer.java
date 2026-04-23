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

import com.github.tommyettinger.ds.OffsetBitSet;
import com.github.tommyettinger.tantrum.digital.helpers.Support;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.memory.Platform;

/**
 * Fory {@link Serializer} for jdkgdxds {@link OffsetBitSet}s.
 */
public class OffsetBitSetSerializer extends Serializer<OffsetBitSet> {

    public OffsetBitSetSerializer(org.apache.fory.Fory fory) {
        super(fory.getConfig(), OffsetBitSet.class);
    }
    public OffsetBitSetSerializer(org.apache.fory.config.Config fory) {
        super(fory, OffsetBitSet.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final OffsetBitSet data) {
        final int[] bits = data.getRawBits();
        fory.getBuffer().writePrimitiveArrayWithSize(bits, Platform.INT_ARRAY_OFFSET, bits.length << 2);
        fory.writeInt32(data.getOffset());
    }

    @Override
    public OffsetBitSet read(org.apache.fory.context.ReadContext fory) {
        final OffsetBitSet obs = new OffsetBitSet();
        obs.setRawBits(Support.readIntsAndSize(fory.getBuffer()));
        obs.setOffset(fory.readInt32());
        return obs;
    }
}