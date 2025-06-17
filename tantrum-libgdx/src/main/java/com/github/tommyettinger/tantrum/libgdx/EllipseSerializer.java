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

import com.badlogic.gdx.math.Ellipse;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link Ellipse}s.
 */
public class EllipseSerializer extends Serializer<Ellipse> {
    public EllipseSerializer(Fory fory) {
        super(fory, Ellipse.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Ellipse data) {
        output.writeFloat32(data.x);
        output.writeFloat32(data.y);
        output.writeFloat32(data.width);
        output.writeFloat32(data.height);
    }

    @Override
    public Ellipse read(MemoryBuffer input) {
        return new Ellipse(input.readFloat32(), input.readFloat32(), input.readFloat32(), input.readFloat32());
    }
}
