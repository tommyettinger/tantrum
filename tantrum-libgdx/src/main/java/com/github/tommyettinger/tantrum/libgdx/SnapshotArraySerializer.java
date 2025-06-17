/*
 * Copyright (c) 2022-2024 See AUTHORS file.
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

package com.github.tommyettinger.tantrum.libgdx;

import com.badlogic.gdx.utils.SnapshotArray;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link SnapshotArray}s.
 */
public class SnapshotArraySerializer extends Serializer<SnapshotArray> {
    public SnapshotArraySerializer(Fory fory) {
        super(fory, SnapshotArray.class);
    }

    @Override
    public void write(final MemoryBuffer output, final SnapshotArray data) {
        final int len = data.size;
        output.writeBoolean(data.ordered);
        output.writeVarUint32(len);
        for (Object item : data) {
            fory.writeRef(output, item);
        }
    }

    @Override
    public SnapshotArray<?> read(MemoryBuffer input) {
        final boolean ordered = input.readBoolean();
        final int len = input.readVarUint32();
        SnapshotArray data = new SnapshotArray(ordered, len);
        for (int i = 0; i < len; i++) {
            data.add(fory.readRef(input));
        }
        return data;
    }
}
