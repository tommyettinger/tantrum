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

import com.badlogic.gdx.math.Affine2;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link Affine2}s.
 */
public class Affine2Serializer extends Serializer<Affine2> {
    public Affine2Serializer(Fury fury) {
        super(fury, Affine2.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Affine2 data) {
        output.writeFloat32(data.m00);
        output.writeFloat32(data.m01);
        output.writeFloat32(data.m02);
        output.writeFloat32(data.m10);
        output.writeFloat32(data.m11);
        output.writeFloat32(data.m12);
    }

    @Override
    public Affine2 read(MemoryBuffer input) {
        Affine2 data = new Affine2();
        data.m00 = input.readFloat32();
        data.m01 = input.readFloat32();
        data.m02 = input.readFloat32();
        data.m10 = input.readFloat32();
        data.m11 = input.readFloat32();
        data.m12 = input.readFloat32();
        return data;
    }
}
