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
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link Affine2}s.
 */
public class Affine2Serializer extends Serializer<Affine2> {
    public Affine2Serializer(org.apache.fory.Fory fory) {
        super(fory.getConfig(), Affine2.class);
    }
    public Affine2Serializer(org.apache.fory.config.Config fory) {
        super(fory, Affine2.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final Affine2 data) {
        fory.writeFloat32(data.m00);
        fory.writeFloat32(data.m01);
        fory.writeFloat32(data.m02);
        fory.writeFloat32(data.m10);
        fory.writeFloat32(data.m11);
        fory.writeFloat32(data.m12);
    }

    @Override
    public Affine2 read(final org.apache.fory.context.ReadContext fory) {
        Affine2 data = new Affine2();
        data.m00 = fory.readFloat32();
        data.m01 = fory.readFloat32();
        data.m02 = fory.readFloat32();
        data.m10 = fory.readFloat32();
        data.m11 = fory.readFloat32();
        data.m12 = fory.readFloat32();
        return data;
    }
}
