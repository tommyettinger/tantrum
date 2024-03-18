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

import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.OrderedMap;
import com.badlogic.gdx.utils.OrderedSet;
import io.fury.Fury;
import io.fury.config.Language;
import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
    @Test
    public void testObjectSet() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectSet.class, new ObjectSetSerializer(fury));

        ObjectSet<String> data = ObjectSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectSet<?> data2 = fury.deserializeJavaObject(bytes, ObjectSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testOrderedSet() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(OrderedSet.class, new OrderedSetSerializer(fury));

        OrderedSet<String> data = OrderedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data); {
            OrderedSet<?> data2 = fury.deserializeJavaObject(bytes, OrderedSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectMap.class, new ObjectMapSerializer(fury));

        ObjectMap<String, Integer> data = new ObjectMap<>();
        data.put("Cthulhu", -123456);
        data.put("lies", Integer.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", 0);
        data.put("Rl'yeh", 1111);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectMap<?,?> data2 = fury.deserializeJavaObject(bytes, ObjectMap.class);
            Assert.assertEquals(data, data2);
        }
    }
    
    @Test
    public void testOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(OrderedMap.class, new OrderedMapSerializer(fury));

        OrderedMap<String, Integer> data = new OrderedMap<>();
        data.put("Cthulhu", -123456);
        data.put("lies", Integer.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", 0);
        data.put("Rl'yeh", 1111);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            OrderedMap<?,?> data2 = fury.deserializeJavaObject(bytes, OrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

}
