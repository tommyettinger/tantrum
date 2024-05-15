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
import com.github.tommyettinger.random.Crand64Random;

/**
 * Fury {@link Serializer} for juniper {@link Crand64Random}s.
 */
public class Crand64RandomSerializer extends Serializer<Crand64Random> {

    public Crand64RandomSerializer(Fury fury) {
        super(fury, Crand64Random.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Crand64Random data) {
        output.writeInt64(data.getStateA());
        output.writeInt64(data.getStateB());
        output.writeInt64(data.getStateC());
        output.writeInt64(data.getStateD());
        output.writeInt64(data.getStateE());
    }

    @Override
    public Crand64Random read(MemoryBuffer input) {
        return new Crand64Random(input.readInt64(), input.readInt64(),
                input.readInt64(), input.readInt64(), input.readInt64());
    }
}