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

package com.github.tommyettinger.tantrum.regexodus;

import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import regexodus.Pattern;

/**
 * Fory {@link Serializer} for Regexodus {@link Pattern}s.
 */
public class PatternSerializer extends Serializer<Pattern> {
    public PatternSerializer(Fory fory) {
        super(fory, Pattern.class);
    }

    @Override
    public void write(MemoryBuffer buffer, final Pattern data) {
        fory.writeString(buffer, data.serializeToString());
    }

    @Override
    public Pattern read(MemoryBuffer buffer) {
        return Pattern.deserializeFromString(fory.readString(buffer));
    }
}
