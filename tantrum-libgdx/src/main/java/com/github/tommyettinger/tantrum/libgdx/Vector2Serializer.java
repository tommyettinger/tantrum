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

import com.badlogic.gdx.math.Vector2;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link Vector2}s.
 */
public class Vector2Serializer extends Serializer<Vector2> {
    public Vector2Serializer(org.apache.fory.Fory fory) {
        super(fory.getConfig(), Vector2.class);
    }
    public Vector2Serializer(org.apache.fory.config.Config fory) {
        super(fory, Vector2.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final Vector2 data) {
        fory.writeFloat32(data.x);
        fory.writeFloat32(data.y);
    }

    @Override
    public Vector2 read(final org.apache.fory.context.ReadContext fory) {
        return new Vector2(fory.readFloat32(), fory.readFloat32());
    }
}
