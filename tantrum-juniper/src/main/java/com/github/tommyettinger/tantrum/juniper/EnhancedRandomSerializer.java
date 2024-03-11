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

import com.github.tommyettinger.digital.Base;
import com.github.tommyettinger.random.Deserializer;
import com.github.tommyettinger.random.EnhancedRandom;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for juniper {@link EnhancedRandom}s.
 */
public class EnhancedRandomSerializer extends Serializer<EnhancedRandom> {

    public EnhancedRandomSerializer(Fury fury) {
        super(fury, EnhancedRandom.class);
    }

    @Override
    public void write(final MemoryBuffer output, final EnhancedRandom data) {
        fury.writeString(output, data.stringSerialize(Base.BASE86));
    }

    @Override
    public EnhancedRandom read(MemoryBuffer input) {
        return Deserializer.deserialize(fury.readString(input), Base.BASE86);
    }
}