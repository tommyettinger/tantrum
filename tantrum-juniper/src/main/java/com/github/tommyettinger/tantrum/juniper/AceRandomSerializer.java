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
import com.github.tommyettinger.random.AceRandom;

/**
 * Fury {@link Serializer} for juniper {@link AceRandom}s.
 */
public class AceRandomSerializer extends Serializer<AceRandom> {

    public AceRandomSerializer(Fury fury) {
        super(fury, AceRandom.class);
    }

    @Override
    public void write(final MemoryBuffer output, final AceRandom data) {
        output.writeInt64(data.getStateA());
        output.writeInt64(data.getStateB());
        output.writeInt64(data.getStateC());
        output.writeInt64(data.getStateD());
        output.writeInt64(data.getStateE());
    }

    @Override
    public AceRandom read(MemoryBuffer input) {
        return new AceRandom(input.readInt64(), input.readInt64(),
                input.readInt64(), input.readInt64(), input.readInt64());
    }
}