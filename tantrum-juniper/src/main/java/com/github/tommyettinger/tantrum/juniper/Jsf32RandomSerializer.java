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
import com.github.tommyettinger.random.Jsf32Random;

/**
 * Fury {@link Serializer} for juniper {@link Jsf32Random}s.
 */
public class Jsf32RandomSerializer extends Serializer<Jsf32Random> {

    public Jsf32RandomSerializer(Fury fury) {
        super(fury, Jsf32Random.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Jsf32Random data) {
        output.writeInt((int)data.getStateA());
        output.writeInt((int)data.getStateB());
        output.writeInt((int)data.getStateC());
        output.writeInt((int)data.getStateD());
    }

    @Override
    public Jsf32Random read(MemoryBuffer input) {
        return new Jsf32Random(input.readInt(), input.readInt(),
                input.readInt(), input.readInt());
    }
}