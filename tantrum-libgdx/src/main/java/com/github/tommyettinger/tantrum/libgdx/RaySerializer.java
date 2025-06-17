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

import com.badlogic.gdx.math.collision.Ray;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link Ray}s.
 */
public class RaySerializer extends Serializer<Ray> {
    public RaySerializer(Fory fory) {
        super(fory, Ray.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Ray data) {
        output.writeFloat32(data.origin.x);
        output.writeFloat32(data.origin.y);
        output.writeFloat32(data.origin.z);
        output.writeFloat32(data.direction.x);
        output.writeFloat32(data.direction.y);
        output.writeFloat32(data.direction.z);
    }

    @Override
    public Ray read(MemoryBuffer input) {
        Ray data = new Ray().set(input.readFloat32(), input.readFloat32(), input.readFloat32(),
                input.readFloat32(), input.readFloat32(), input.readFloat32());
        System.out.println(data);
        return data;
    }
}
