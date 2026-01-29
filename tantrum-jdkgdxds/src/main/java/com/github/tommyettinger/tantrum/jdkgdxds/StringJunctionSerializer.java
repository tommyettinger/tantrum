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

package com.github.tommyettinger.tantrum.jdkgdxds;

import com.github.tommyettinger.ds.StringJunction;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for Regexodus {@link StringJunction}s.
 */
public class StringJunctionSerializer extends Serializer<StringJunction> {
    public StringJunctionSerializer(Fory fory) {
        super(fory, StringJunction.class);
    }

    @Override
    public void write(MemoryBuffer buffer, final StringJunction data) {
        fory.writeString(buffer, data.toString());
    }

    @Override
    public StringJunction read(MemoryBuffer buffer) {
        return StringJunction.parse(fory.readString(buffer));
    }
}
