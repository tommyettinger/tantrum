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

import com.badlogic.gdx.utils.OrderedMap;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;

/**
 * Fory {@link Serializer} for libGDX {@link OrderedMap}s.
 */
public class OrderedMapSerializer extends Serializer<OrderedMap> {
    public OrderedMapSerializer(Fory fory) {
        super(fory, OrderedMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final OrderedMap data) {
        final int len = data.size;
        output.writeVarUint32(len);
        for (Object item : data.orderedKeys()) {
            fory.writeRef(output, item);
            fory.writeRef(output, data.get(item));
        }
    }

    @Override
    public OrderedMap<?, ?> read(MemoryBuffer input) {
        final int len = input.readVarUint32();
        OrderedMap data = new OrderedMap(len);
        for (int i = 0; i < len; i++) {
            data.put(fory.readRef(input), fory.readRef(input));
        }
        return data;
    }
}
