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

import com.badlogic.gdx.math.Vector4;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link Vector4}s.
 */
public class Vector4Serializer extends Serializer<Vector4> {
    public Vector4Serializer(Fury fury) {
        super(fury, Vector4.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Vector4 data) {
        output.writeFloat32(data.x);
        output.writeFloat32(data.y);
        output.writeFloat32(data.z);
        output.writeFloat32(data.w);
    }

    @Override
    public Vector4 read(MemoryBuffer input) {
        return new Vector4(input.readFloat32(), input.readFloat32(), input.readFloat32(), input.readFloat32());
    }
}
