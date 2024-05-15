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

import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;
import com.github.tommyettinger.random.Respite32Random;

/**
 * Fury {@link Serializer} for juniper {@link Respite32Random}s.
 */
public class Respite32RandomSerializer extends Serializer<Respite32Random> {

    public Respite32RandomSerializer(Fury fury) {
        super(fury, Respite32Random.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Respite32Random data) {
        output.writeInt32((int)data.getStateA());
        output.writeInt32((int)data.getStateB());
        output.writeInt32((int)data.getStateC());
    }

    @Override
    public Respite32Random read(MemoryBuffer input) {
        return new Respite32Random(input.readInt32(), input.readInt32(),
                input.readInt32());
    }
}