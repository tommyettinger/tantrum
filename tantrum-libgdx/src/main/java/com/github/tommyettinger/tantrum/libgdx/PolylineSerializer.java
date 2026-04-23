/*
 * Copyright (c) 2024 See AUTHORS file.
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

import com.badlogic.gdx.math.Polyline;
import com.github.tommyettinger.tantrum.libgdx.helpers.Support;
import org.apache.fory.memory.Platform;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link Polyline}s.
 */
public class PolylineSerializer extends Serializer<Polyline> {

    public PolylineSerializer(org.apache.fory.config.Config fory) {
        super(fory,Polyline.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final Polyline data) {
        fory.getBuffer().writePrimitiveArrayWithSize(data.getVertices(), Platform.FLOAT_ARRAY_OFFSET, data.getVertices().length << 2);
        fory.writeFloat32(data.getOriginX());
        fory.writeFloat32(data.getOriginY());
        fory.writeFloat32(data.getX());
        fory.writeFloat32(data.getY());
        fory.writeFloat32(data.getRotation());
        fory.writeFloat32(data.getScaleX());
        fory.writeFloat32(data.getScaleY());
    }

    @Override
    public Polyline read(final org.apache.fory.context.ReadContext fory) {
        Polyline data = new Polyline(Support.readFloatsAndSize(fory.getBuffer()));
        data.setOrigin(fory.readFloat32(), fory.readFloat32());
        data.setPosition(fory.readFloat32(), fory.readFloat32());
        data.setRotation(fory.readFloat32());
        data.setScale(fory.readFloat32(), fory.readFloat32());
        return data;
    }
}