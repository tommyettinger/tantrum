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

import com.badlogic.gdx.graphics.Color;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link Color}s.
 */
public class ColorSerializer extends Serializer<Color> {
    public ColorSerializer(Fory fory) {
        super(fory, Color.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Color data) {
        output.writeFloat32(data.r);
        output.writeFloat32(data.g);
        output.writeFloat32(data.b);
        output.writeFloat32(data.a);
    }

    @Override
    public Color read(MemoryBuffer input) {
        return new Color(input.readFloat32(), input.readFloat32(), input.readFloat32(), input.readFloat32());
    }
}
