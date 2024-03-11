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

import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;
import com.github.tommyettinger.random.EnhancedRandom;
import com.github.tommyettinger.random.distribution.PoissonDistribution;

public class PoissonDistributionSerializer extends Serializer<PoissonDistribution> {
    public PoissonDistributionSerializer(Fury fury) {
        super(fury, PoissonDistribution.class);
    }
    @Override
    public void write(final MemoryBuffer output, PoissonDistribution object) {
        fury.writeRef(output, object.generator);
        output.writeDouble(object.getParameterA());
    }

    @Override
    public PoissonDistribution read(MemoryBuffer input) {
        return new PoissonDistribution((EnhancedRandom) fury.readRef(input), input.readDouble());
    }
}
