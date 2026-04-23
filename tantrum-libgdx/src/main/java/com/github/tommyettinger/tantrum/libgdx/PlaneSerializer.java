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

import com.badlogic.gdx.math.Plane;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link Plane}s.
 */
public class PlaneSerializer extends Serializer<Plane> {
    public PlaneSerializer(org.apache.fory.config.Config fory) {
        super(fory,Plane.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final Plane data) {
        fory.writeFloat32(data.normal.x);
        fory.writeFloat32(data.normal.y);
        fory.writeFloat32(data.normal.z);
        fory.writeFloat32(data.d);
    }

    @Override
    public Plane read(final org.apache.fory.context.ReadContext fory) {
        Plane data = new Plane();
        data.set(fory.readFloat32(), fory.readFloat32(), fory.readFloat32(), fory.readFloat32());
        return data;
    }
}
