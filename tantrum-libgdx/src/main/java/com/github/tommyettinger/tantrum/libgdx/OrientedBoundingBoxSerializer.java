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
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link OrientedBoundingBox}s.
 */
public class OrientedBoundingBoxSerializer extends Serializer<OrientedBoundingBox> {
    public OrientedBoundingBoxSerializer(org.apache.fory.config.Config fory) {
        super(fory,OrientedBoundingBox.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final OrientedBoundingBox data) {
        final BoundingBox bb = data.getBounds();
        fory.writeFloat32(bb.min.x);
        fory.writeFloat32(bb.min.y);
        fory.writeFloat32(bb.min.z);
        fory.writeFloat32(bb.max.x);
        fory.writeFloat32(bb.max.y);
        fory.writeFloat32(bb.max.z);
        float[] val = data.transform.val;
        for (int i = 0; i < 16; i++) {
            fory.writeFloat32(val[i]);
        }
    }

    @Override
    public OrientedBoundingBox read(final org.apache.fory.context.ReadContext fory) {
        final BoundingBox bb = new BoundingBox(new Vector3(fory.readFloat32(), fory.readFloat32(), fory.readFloat32()),
                new Vector3(fory.readFloat32(), fory.readFloat32(), fory.readFloat32()));
        final Matrix4 tr = new Matrix4();
        final float[] val = tr.val;
        for (int i = 0; i < 16; i++) {
            val[i] = fory.readFloat32();
        }

        return new OrientedBoundingBox(bb, tr);
    }
}
