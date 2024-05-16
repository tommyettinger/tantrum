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

import com.badlogic.gdx.math.Matrix3;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link Matrix3}s.
 */
public class Matrix3Serializer extends Serializer<Matrix3> {
    public Matrix3Serializer(Fury fury) {
        super(fury, Matrix3.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Matrix3 data) {
        for (int i = 0; i < 9; i++) {
            output.writeFloat32(data.val[i]);
        }
    }

    @Override
    public Matrix3 read(MemoryBuffer input) {
        Matrix3 data = new Matrix3();
        for (int i = 0; i < 9; i++) {
            data.val[i] = input.readFloat32();
        }
        return data;
    }
}
