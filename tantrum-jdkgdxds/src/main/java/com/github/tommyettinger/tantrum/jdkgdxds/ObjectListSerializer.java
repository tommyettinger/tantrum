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

import com.github.tommyettinger.ds.ObjectList;
import org.apache.fory.resolver.TypeResolver;
import org.apache.fory.serializer.Serializer;
import org.apache.fory.serializer.collection.CollectionSerializer;

/**
 * Fory {@link Serializer} for jdkgdxds {@link ObjectList}s.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ObjectListSerializer extends CollectionSerializer<ObjectList> {

    public ObjectListSerializer(TypeResolver resolver) {
        super(resolver, ObjectList.class, true);
    }

    @Override
    public void write(final org.apache.fory.context.WriteContext fory, final ObjectList data) {
        final int len = data.size();
        fory.writeVarUint32(len);
        for (int i = 0; i < len; i++) {
            fory.writeRef(data.get(i));
        }
    }

    @Override
    public ObjectList read(org.apache.fory.context.ReadContext fory) {
        final int len = fory.readVarUint32();
        ObjectList data = new ObjectList(len);
        for (int i = 0; i < len; i++) {
            data.add(fory.readRef());
        }
        return data;
    }
}