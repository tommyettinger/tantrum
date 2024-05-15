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
import com.github.tommyettinger.random.PouchRandom;

/**
 * Fury {@link Serializer} for juniper {@link PouchRandom}s.
 */
public class PouchRandomSerializer extends Serializer<PouchRandom> {

    public PouchRandomSerializer(Fury fury) {
        super(fury, PouchRandom.class);
    }

    @Override
    public void write(final MemoryBuffer output, final PouchRandom data) {
        output.writeInt64(data.getStateA());
        output.writeInt64(data.getStateB());
        output.writeInt64(data.getStateC());
        output.writeInt64(data.getStateD());
    }

    @Override
    public PouchRandom read(MemoryBuffer input) {
        return new PouchRandom(input.readInt64(), input.readInt64(),
                input.readInt64(), input.readInt64());
    }
}