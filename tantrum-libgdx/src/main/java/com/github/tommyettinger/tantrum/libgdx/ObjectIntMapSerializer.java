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

import com.badlogic.gdx.utils.ObjectIntMap;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link ObjectIntMap}s.
 */
public class ObjectIntMapSerializer extends Serializer<ObjectIntMap> {
    public ObjectIntMapSerializer(org.apache.fory.Fory fory) {
        super(fory.getConfig(), ObjectIntMap.class);
    }
    public ObjectIntMapSerializer(org.apache.fory.config.Config fory) {
        super(fory, ObjectIntMap.class);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final ObjectIntMap data) {
        final int len = data.size;
        fory.writeVarUint32(len);
        for (Object item : data.keys()) {
            fory.writeRef(item);
            fory.writeInt32(data.get(item, 0));
        }
    }

    @Override
    public ObjectIntMap<?> read(final org.apache.fory.context.ReadContext fory) {
        final int len = fory.readVarUint32();
        ObjectIntMap data = new ObjectIntMap(len);
        for (int i = 0; i < len; i++) {
            data.put(fory.readRef(), fory.readInt32());
        }
        return data;
    }
}
