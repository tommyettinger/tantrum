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

package com.github.tommyettinger.tantrum.juniper.distribution;

import com.github.tommyettinger.digital.Base;
import com.github.tommyettinger.random.Deserializer;
import com.github.tommyettinger.random.distribution.Distribution;
import com.github.tommyettinger.tantrum.juniper.helpers.BufferHelper;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;

/**
 * Fury {@link Serializer} for juniper {@link Distribution}s.
 */
public class DistributionSerializer extends Serializer<Distribution> {

    public DistributionSerializer(Fury fury) {
        super(fury, Distribution.class);
    }

    @Override
    public void write(final MemoryBuffer output, final Distribution data) {
        BufferHelper.writeString(output, data.stringSerialize(Base.BASE86));
    }

    @Override
    public Distribution read(MemoryBuffer input) {
        return Deserializer.deserializeDistribution(BufferHelper.readString(input), Base.BASE86);
    }
}