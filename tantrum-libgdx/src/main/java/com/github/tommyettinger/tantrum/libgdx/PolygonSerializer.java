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

import com.badlogic.gdx.math.Polygon;
import com.github.tommyettinger.tantrum.libgdx.helpers.Support;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.memory.Platform;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link Polygon}s.
 */
public class PolygonSerializer extends Serializer<Polygon> {

    public PolygonSerializer(Fory fory) {
        super(fory, Polygon.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Polygon data) {
        output.writePrimitiveArrayWithSize(data.getVertices(), Platform.FLOAT_ARRAY_OFFSET, data.getVertexCount() << 3);
        output.writeFloat32(data.getOriginX());
        output.writeFloat32(data.getOriginY());
        output.writeFloat32(data.getX());
        output.writeFloat32(data.getY());
        output.writeFloat32(data.getRotation());
        output.writeFloat32(data.getScaleX());
        output.writeFloat32(data.getScaleY());
    }

    @Override
    public Polygon read(MemoryBuffer input) {
        Polygon data = new Polygon(Support.readFloatsAndSize(input));
        data.setOrigin(input.readFloat32(), input.readFloat32());
        data.setPosition(input.readFloat32(), input.readFloat32());
        data.setRotation(input.readFloat32());
        data.setScale(input.readFloat32(), input.readFloat32());
        return data;
    }
}