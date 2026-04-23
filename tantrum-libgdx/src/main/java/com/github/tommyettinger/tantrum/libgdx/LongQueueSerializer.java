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

package com.github.tommyettinger.tantrum.libgdx;

import com.badlogic.gdx.utils.LongQueue;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link LongQueue}s.
 */
public class LongQueueSerializer extends Serializer<LongQueue> {
    public LongQueueSerializer(org.apache.fory.config.Config fory) {
        super(fory,LongQueue.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final LongQueue data) {
        final int len = data.size;
        fory.writeVarUint32(len);
        for (int i = 0; i < len; i++) {
            fory.writeInt64(data.get(i));
        }
    }

    @Override
    public LongQueue read(final org.apache.fory.context.ReadContext fory) {
        final int len = fory.readVarUint32();
        LongQueue data = new LongQueue(len);
        for (int i = 0; i < len; i++) {
            data.addLast(fory.readInt64());
        }
        return data;
    }
}
