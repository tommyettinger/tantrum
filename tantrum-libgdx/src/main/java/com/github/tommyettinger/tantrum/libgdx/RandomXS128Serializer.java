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

import com.badlogic.gdx.math.RandomXS128;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for libGDX {@link RandomXS128}s.
 * A serializer must be used if you want to work with RandomXS128 in newer Java versions, because if you use the
 * default serialization created by {@code register()}, then Fury will try to use some internal fields in Random, the
 * superclass of RandomXS128, and that won't succeed. It might be possible to use {@code register()} in Java 8 only,
 * but it isn't worth the risk and limitation. Using this serializer is probably faster, too, since it has less that it
 * has to write.
 */
public class RandomXS128Serializer extends Serializer<RandomXS128> {
    public RandomXS128Serializer(Fury fury) {
        super(fury, RandomXS128.class);
    }

    @Override
    public void write(final MemoryBuffer output, final RandomXS128 data) {
        output.writeInt64(data.getState(0));
        output.writeInt64(data.getState(1));
    }

    @Override
    public RandomXS128 read(MemoryBuffer input) {
        return new RandomXS128(input.readInt64(), input.readInt64());
    }
}
