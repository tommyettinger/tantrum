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
import com.github.tommyettinger.random.FourWheelRandom;

/**
 * Fury {@link Serializer} for juniper {@link FourWheelRandom}s.
 */
public class FourWheelRandomSerializer extends Serializer<FourWheelRandom> {

    public FourWheelRandomSerializer(Fury fury) {
        super(fury, FourWheelRandom.class);
    }

    @Override
    public void write(final MemoryBuffer output, final FourWheelRandom data) {
        output.writeLong(data.getStateA());
        output.writeLong(data.getStateB());
        output.writeLong(data.getStateC());
        output.writeLong(data.getStateD());
    }

    @Override
    public FourWheelRandom read(MemoryBuffer input) {
        return new FourWheelRandom(input.readLong(), input.readLong(),
                input.readLong(), input.readLong());
    }
}