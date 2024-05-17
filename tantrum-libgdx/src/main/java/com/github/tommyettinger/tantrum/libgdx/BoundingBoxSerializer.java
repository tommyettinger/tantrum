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

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link BoundingBox}s.
 */
public class BoundingBoxSerializer extends Serializer<BoundingBox> {
    public BoundingBoxSerializer(Fury fury) {
        super(fury, BoundingBox.class);
    }

    @Override
    public void write(final MemoryBuffer output, final BoundingBox data) {
        output.writeFloat32(data.min.x);
        output.writeFloat32(data.min.y);
        output.writeFloat32(data.min.z);
        output.writeFloat32(data.max.x);
        output.writeFloat32(data.max.y);
        output.writeFloat32(data.max.z);
    }

    @Override
    public BoundingBox read(MemoryBuffer input) {
        return new BoundingBox(new Vector3(input.readFloat32(), input.readFloat32(), input.readFloat32()),
                new Vector3(input.readFloat32(), input.readFloat32(), input.readFloat32()));
    }
}
