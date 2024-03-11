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
import com.github.tommyettinger.random.distribution.ArcsineDistribution;

public class ArcsineDistributionSerializer extends Serializer<ArcsineDistribution> {
    public ArcsineDistributionSerializer(Fury fury) {
        super(fury, ArcsineDistribution.class);
    }

    @Override
    public void write(MemoryBuffer output, ArcsineDistribution object) {
        fury.writeRef(output, object.generator);
        output.writeDouble(object.getParameterA());
        output.writeDouble(object.getParameterB());
    }

    @Override
    public ArcsineDistribution read(MemoryBuffer input) {
        return new ArcsineDistribution((EnhancedRandom)fury.readRef(input),
                input.readDouble(), input.readDouble());
    }
}
