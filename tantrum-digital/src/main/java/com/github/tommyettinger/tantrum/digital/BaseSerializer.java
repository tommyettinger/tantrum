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

import com.github.tommyettinger.digital.Base;
import io.fury.Fury;
import io.fury.memory.MemoryBuffer;
import io.fury.serializer.Serializer;

import java.nio.charset.StandardCharsets;

/**
 * Fury {@link Serializer} for digital {@link Base}s.
 */
public class BaseSerializer extends Serializer<Base> {

    public BaseSerializer(Fury fury) {
        super(fury, Base.class);
    }

    @Override
    public void write(MemoryBuffer buffer, final Base data) {
        buffer.writeBytesWithSizeEmbedded(data.serializeToString().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public Base read(MemoryBuffer buffer) {
        return Base.deserializeFromString(new String(buffer.readBytesWithSizeEmbedded(), StandardCharsets.UTF_8));
    }
}