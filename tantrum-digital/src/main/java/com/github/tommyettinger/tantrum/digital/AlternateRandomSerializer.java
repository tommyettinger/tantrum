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

import com.github.tommyettinger.digital.AlternateRandom;
import org.apache.fory.config.Config;
import org.apache.fory.context.ReadContext;
import org.apache.fory.context.WriteContext;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for digital {@link AlternateRandom}s.
 */
public class AlternateRandomSerializer extends Serializer<AlternateRandom> {

    public AlternateRandomSerializer(Config fory) {
        super(fory, AlternateRandom.class);
    }

    @Override
    public void write(WriteContext fory, final AlternateRandom data) {
        fory.writeInt64(data.stateA);
        fory.writeInt64(data.stateB);
        fory.writeInt64(data.stateC);
        fory.writeInt64(data.stateD);
        fory.writeInt64(data.stateE);
    }

    @Override
    public AlternateRandom read(ReadContext fory) {
        return new AlternateRandom(fory.readInt64(), fory.readInt64(), fory.readInt64(),
                fory.readInt64(), fory.readInt64());
    }
}