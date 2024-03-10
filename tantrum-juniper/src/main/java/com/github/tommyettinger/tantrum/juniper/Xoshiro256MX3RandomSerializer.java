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
import com.github.tommyettinger.random.Xoshiro256MX3Random;

/**
 * Fury {@link Serializer} for juniper {@link Xoshiro256MX3Random}s.
 */
public class Xoshiro256MX3RandomSerializer extends Serializer<Xoshiro256MX3Random> {

    public Xoshiro256MX3RandomSerializer(Fury fury) {
        super(fury, Xoshiro256MX3Random.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Xoshiro256MX3Random data) {
        output.writeLong(data.getStateA());
        output.writeLong(data.getStateB());
        output.writeLong(data.getStateC());
        output.writeLong(data.getStateD());
    }

    @Override
    public Xoshiro256MX3Random read(MemoryBuffer input) {
        return new Xoshiro256MX3Random(input.readLong(), input.readLong(),
                input.readLong(), input.readLong());
    }
}