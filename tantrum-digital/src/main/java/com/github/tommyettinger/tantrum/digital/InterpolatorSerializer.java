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

package com.github.tommyettinger.tantrum.digital;

import com.github.tommyettinger.digital.Interpolations;
import com.github.tommyettinger.digital.Interpolations.Interpolator;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for digital {@link Interpolator}s.
 */
public class InterpolatorSerializer extends Serializer<Interpolator> {
    public InterpolatorSerializer(Fory fory) {
        super(fory, Interpolator.class);
    }

    @Override
    public void write(MemoryBuffer buffer, final Interpolator data) {
        fory.writeString(buffer, data.getTag());
    }

    @Override
    public Interpolator read(MemoryBuffer buffer) {
        return Interpolations.get(fory.readString(buffer));
    }
}
