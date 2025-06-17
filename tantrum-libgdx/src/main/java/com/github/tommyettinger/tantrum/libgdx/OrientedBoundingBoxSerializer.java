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
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.OrientedBoundingBox;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link OrientedBoundingBox}s.
 */
public class OrientedBoundingBoxSerializer extends Serializer<OrientedBoundingBox> {
    public OrientedBoundingBoxSerializer(Fory fory) {
        super(fory, OrientedBoundingBox.class);
    }

    @Override
    public void write(final MemoryBuffer output, final OrientedBoundingBox data) {
        final BoundingBox bb = data.getBounds();
        output.writeFloat32(bb.min.x);
        output.writeFloat32(bb.min.y);
        output.writeFloat32(bb.min.z);
        output.writeFloat32(bb.max.x);
        output.writeFloat32(bb.max.y);
        output.writeFloat32(bb.max.z);
        float[] val = data.transform.val;
        for (int i = 0; i < 16; i++) {
            output.writeFloat32(val[i]);
        }
    }

    @Override
    public OrientedBoundingBox read(MemoryBuffer input) {
        final BoundingBox bb = new BoundingBox(new Vector3(input.readFloat32(), input.readFloat32(), input.readFloat32()),
                new Vector3(input.readFloat32(), input.readFloat32(), input.readFloat32()));
        final Matrix4 tr = new Matrix4();
        final float[] val = tr.val;
        for (int i = 0; i < 16; i++) {
            val[i] = input.readFloat32();
        }

        return new OrientedBoundingBox(bb, tr);
    }
}
