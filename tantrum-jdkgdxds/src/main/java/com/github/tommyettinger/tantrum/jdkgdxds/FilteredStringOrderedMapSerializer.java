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

import com.github.tommyettinger.ds.CharFilter;
import com.github.tommyettinger.ds.FilteredStringOrderedMap;
import org.apache.fory.Fory;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.serializer.collection.MapSerializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link FilteredStringOrderedMap}s.
 */
@SuppressWarnings("rawtypes")
public class FilteredStringOrderedMapSerializer extends MapSerializer<FilteredStringOrderedMap> {

    public FilteredStringOrderedMapSerializer(Fory fory) {
        super(fory, FilteredStringOrderedMap.class);
    }

    @Override
    public void write(final MemoryBuffer output, final FilteredStringOrderedMap data) {
        fory.writeString(output, data.getFilter().getName());
        output.writeVarUint32(data.size());
        for(Object k : data.keySet()){
            fory.writeRef(output, k);
        }
        for(Object v : data.values()){
            fory.writeRef(output, v);
        }
        fory.writeRef(output, data.getDefaultValue());
    }

    @Override
    public FilteredStringOrderedMap<?> read(MemoryBuffer input) {
        CharFilter filter = CharFilter.get(fory.readString(input));
        final int len = input.readVarUint32();
        String[] ks = new String[len];
        Object[] vs = new Object[len];
        for (int i = 0; i < len; i++) {
            ks[i] = (String) fory.readRef(input);
        }
        for (int i = 0; i < len; i++) {
            vs[i] = fory.readRef(input);
        }
        FilteredStringOrderedMap data = new FilteredStringOrderedMap<>(filter, ks, vs);
        data.setDefaultValue(fory.readRef(input));
        return data;

    }
}