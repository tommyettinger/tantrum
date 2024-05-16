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

import com.badlogic.gdx.math.Matrix4;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link Matrix4}s.
 */
public class Matrix4Serializer extends Serializer<Matrix4> {
    public Matrix4Serializer(Fury fury) {
        super(fury, Matrix4.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Matrix4 data) {
        for (int i = 0; i < 16; i++) {
            output.writeFloat32(data.val[i]);
        }
    }

    @Override
    public Matrix4 read(MemoryBuffer input) {
        Matrix4 data = new Matrix4();
        for (int i = 0; i < 16; i++) {
            data.val[i] = input.readFloat32();
        }
        return data;
    }
}
