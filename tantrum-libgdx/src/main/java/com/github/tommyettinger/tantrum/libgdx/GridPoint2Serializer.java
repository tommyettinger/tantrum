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

import com.badlogic.gdx.math.GridPoint2;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link GridPoint2}s.
 */
public class GridPoint2Serializer extends Serializer<GridPoint2> {
    public GridPoint2Serializer(Fory fory) {
        super(fory, GridPoint2.class);
    }

    @Override
    public void write(final MemoryBuffer output, final GridPoint2 data) {
        output.writeInt32(data.x);
        output.writeInt32(data.y);
    }

    @Override
    public GridPoint2 read(MemoryBuffer input) {
        return new GridPoint2(input.readInt32(), input.readInt32());
    }
}
