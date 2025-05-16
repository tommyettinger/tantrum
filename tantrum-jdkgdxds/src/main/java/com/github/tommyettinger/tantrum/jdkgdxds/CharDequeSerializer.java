/*
 * Copyright (c) 2024 See AUTHORS file.
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

import com.github.tommyettinger.ds.CharDeque;
import org.apache.fury.Fury;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;
import org.apache.fury.memory.Platform;

/**
 * Fury {@link Serializer} for jdkgdxds {@link CharDeque}s.
 */
public class CharDequeSerializer extends Serializer<CharDeque> {

    public CharDequeSerializer(Fury fury) {
        super(fury, CharDeque.class);
    }

    @Override
    public void write(final MemoryBuffer output, final CharDeque data) {
        output.writePrimitiveArrayWithSize(data.toArray(), Platform.CHAR_ARRAY_OFFSET, data.size() << 1);
        output.writeChar(data.getDefaultValue());
    }

    @Override
    public CharDeque read(MemoryBuffer input) {
        CharDeque data = new CharDeque(input.readCharsAndSize());
        data.setDefaultValue(input.readChar());
        return data;
    }
}