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

import com.badlogic.gdx.utils.IntMap;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link IntMap}s.
 */
public class IntMapSerializer extends Serializer<IntMap> {
    public IntMapSerializer(org.apache.fory.Fory fory) {
        super(fory.getConfig(), IntMap.class);
    }
    public IntMapSerializer(org.apache.fory.config.Config fory) {
        super(fory, IntMap.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final IntMap data) {
        final int len = data.size;
        fory.writeVarUint32(len);
        IntMap.Keys keys = data.keys();
        for (int item; keys.hasNext;) {
            item = keys.next();
            fory.writeInt32(item);
            fory.writeRef(data.get(item));
        }
    }

    @Override
    public IntMap<?> read(final org.apache.fory.context.ReadContext fory) {
        final int len = fory.readVarUint32();
        IntMap data = new IntMap(len);
        for (int i = 0; i < len; i++) {
            data.put(fory.readInt32(), fory.readRef());
        }
        return data;
    }
}
