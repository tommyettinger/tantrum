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
import com.github.tommyettinger.ds.FilteredStringMap;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.serializer.collection.MapSerializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link FilteredStringMap}s.
 */
@SuppressWarnings("rawtypes")
public class FilteredStringMapSerializer extends MapSerializer<FilteredStringMap> {

    public FilteredStringMapSerializer(org.apache.fory.Fory fory) {
        super(fory.getTypeResolver(), FilteredStringMap.class, true);
    }
    public FilteredStringMapSerializer(org.apache.fory.resolver.TypeResolver resolver) {
        super(resolver, FilteredStringMap.class, true);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final FilteredStringMap data) {
        fory.writeString(data.getFilter().getName());
        fory.writeVarUint32(data.size());
        for(Object k : data.keySet()){
            fory.writeRef(k);
        }
        for(Object v : data.values()){
            fory.writeRef(v);
        }
        fory.writeRef(data.getDefaultValue());
    }

    @Override
    public FilteredStringMap<?> read(org.apache.fory.context.ReadContext fory) {
        CharFilter filter = CharFilter.get(fory.readString());
        final int len = fory.readVarUint32();
        String[] ks = new String[len];
        Object[] vs = new Object[len];
        for (int i = 0; i < len; i++) {
            ks[i] = (String) fory.readRef();
        }
        for (int i = 0; i < len; i++) {
            vs[i] = fory.readRef();
        }
        FilteredStringMap data = new FilteredStringMap<>(filter, ks, vs);
        data.setDefaultValue(fory.readRef());
        return data;

    }
}