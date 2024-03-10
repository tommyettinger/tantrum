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

package com.github.tommyettinger.tantrum.juniper;

import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;
import com.github.tommyettinger.random.LaserRandom;

/**
 * Fury {@link Serializer} for juniper {@link LaserRandom}s.
 */
public class LaserRandomSerializer extends Serializer<LaserRandom> {

    public LaserRandomSerializer(Fury fury) {
        super(fury, LaserRandom.class);
    }

    @Override
    public void write(final MemoryBuffer output, final LaserRandom data) {
        output.writeLong(data.getStateA());
        output.writeLong(data.getStateB());
    }

    @Override
    public LaserRandom read(MemoryBuffer input) {
        return new LaserRandom(input.readLong(), input.readLong());
    }
}