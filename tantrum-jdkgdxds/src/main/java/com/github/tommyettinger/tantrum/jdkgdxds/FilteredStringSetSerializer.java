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
import com.github.tommyettinger.ds.FilteredStringSet;
import org.apache.fory.resolver.TypeResolver;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.serializer.collection.CollectionSerializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link FilteredStringSet}s.
 */
public class FilteredStringSetSerializer extends CollectionSerializer<FilteredStringSet> {

    public FilteredStringSetSerializer(TypeResolver resolver) {
        super(resolver, FilteredStringSet.class, true);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final FilteredStringSet data) {
        fory.writeString(data.getFilter().getName());
        final int len = data.size();
        fory.writeVarUint32(len);
        for (String item : data) {
            fory.writeRef(item);
        }
    }

    @Override
    public FilteredStringSet read(org.apache.fory.context.ReadContext fory) {
        CharFilter filter = CharFilter.get(fory.readString());
        final int len = fory.readVarUint32();
        FilteredStringSet data = new FilteredStringSet(filter, len);
        for (int i = 0; i < len; i++) {
            data.add((String) fory.readRef());
        }
        return data;
    }
}