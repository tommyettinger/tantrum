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

package com.github.tommyettinger.tantrum.jdkgdxds;

import com.github.tommyettinger.ds.*;
import io.fury.Fury;
import io.fury.config.Language;
import org.junit.Assert;
import org.junit.Test;

public class MapTest {
    @Test
    public void testLongObjectMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongObjectMap.class, new LongObjectMapSerializer(fury));

        LongObjectMap<Float> data = LongObjectMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongObjectMap<?> data2 = fury.deserializeJavaObject(bytes, LongObjectMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongObjectOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongObjectOrderedMap.class, new LongObjectOrderedMapSerializer(fury));

        LongObjectOrderedMap<Float> data = LongObjectOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongObjectOrderedMap<?> data2 = fury.deserializeJavaObject(bytes, LongObjectOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongFloatMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongFloatMap.class, new LongFloatMapSerializer(fury));

        LongFloatMap data = LongFloatMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongFloatMap data2 = fury.deserializeJavaObject(bytes, LongFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongFloatOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongFloatOrderedMap.class, new LongFloatOrderedMapSerializer(fury));

        LongFloatOrderedMap data = LongFloatOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongFloatOrderedMap data2 = fury.deserializeJavaObject(bytes, LongFloatOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testLongIntMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongIntMap.class, new LongIntMapSerializer(fury));

        LongIntMap data = LongIntMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongIntMap data2 = fury.deserializeJavaObject(bytes, LongIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongIntOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongIntOrderedMap.class, new LongIntOrderedMapSerializer(fury));

        LongIntOrderedMap data = LongIntOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongIntOrderedMap data2 = fury.deserializeJavaObject(bytes, LongIntOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }
    @Test
    public void testLongLongMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongLongMap.class, new LongLongMapSerializer(fury));

        LongLongMap data = LongLongMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongLongMap data2 = fury.deserializeJavaObject(bytes, LongLongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongLongOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongLongOrderedMap.class, new LongLongOrderedMapSerializer(fury));

        LongLongOrderedMap data = LongLongOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongLongOrderedMap data2 = fury.deserializeJavaObject(bytes, LongLongOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testIntObjectMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntObjectMap.class, new IntObjectMapSerializer(fury));

        IntObjectMap<Float> data = IntObjectMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntObjectMap<?> data2 = fury.deserializeJavaObject(bytes, IntObjectMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntObjectOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntObjectOrderedMap.class, new IntObjectOrderedMapSerializer(fury));

        IntObjectOrderedMap<Float> data = IntObjectOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntObjectOrderedMap<?> data2 = fury.deserializeJavaObject(bytes, IntObjectOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntFloatMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntFloatMap.class, new IntFloatMapSerializer(fury));

        IntFloatMap data = IntFloatMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntFloatMap data2 = fury.deserializeJavaObject(bytes, IntFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntFloatOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntFloatOrderedMap.class, new IntFloatOrderedMapSerializer(fury));

        IntFloatOrderedMap data = IntFloatOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntFloatOrderedMap data2 = fury.deserializeJavaObject(bytes, IntFloatOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testIntIntMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntIntMap.class, new IntIntMapSerializer(fury));

        IntIntMap data = IntIntMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntIntMap data2 = fury.deserializeJavaObject(bytes, IntIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntIntOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntIntOrderedMap.class, new IntIntOrderedMapSerializer(fury));

        IntIntOrderedMap data = IntIntOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntIntOrderedMap data2 = fury.deserializeJavaObject(bytes, IntIntOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testIntLongMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntLongMap.class, new IntLongMapSerializer(fury));

        IntLongMap data = IntLongMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntLongMap data2 = fury.deserializeJavaObject(bytes, IntLongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntLongOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntLongOrderedMap.class, new IntLongOrderedMapSerializer(fury));

        IntLongOrderedMap data = IntLongOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntLongOrderedMap data2 = fury.deserializeJavaObject(bytes, IntLongOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testObjectObjectMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectObjectMap.class, new ObjectObjectMapSerializer(fury));

        ObjectObjectMap<String, Integer> data = ObjectObjectMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectObjectMap<?,?> data2 = fury.deserializeJavaObject(bytes, ObjectObjectMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectObjectOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectObjectOrderedMap.class, new ObjectObjectOrderedMapSerializer(fury));

        ObjectObjectOrderedMap<String, Integer> data = ObjectObjectOrderedMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectObjectOrderedMap<?,?> data2 = fury.deserializeJavaObject(bytes, ObjectObjectOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectIntMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectIntMap.class, new ObjectIntMapSerializer(fury));

        ObjectIntMap<String> data = ObjectIntMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectIntMap<?> data2 = fury.deserializeJavaObject(bytes, ObjectIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectIntOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectIntOrderedMap.class, new ObjectIntOrderedMapSerializer(fury));

        ObjectIntOrderedMap<String> data = ObjectIntOrderedMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectIntOrderedMap<?> data2 = fury.deserializeJavaObject(bytes, ObjectIntOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testObjectLongMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectLongMap.class, new ObjectLongMapSerializer(fury));

        ObjectLongMap<String> data = ObjectLongMap.with("Cthulhu", -1234567890L, "lies", 0L, "deep",
                4567890123456789L, "in", 0, "Rl'yeh", 1L, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectLongMap<?> data2 = fury.deserializeJavaObject(bytes, ObjectLongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectLongOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectLongOrderedMap.class, new ObjectLongOrderedMapSerializer(fury));

        ObjectLongOrderedMap<String> data = ObjectLongOrderedMap.with("Cthulhu", -1234567890L, "lies", 0L, "deep",
                4567890123456789L, "in", 0, "Rl'yeh", 1L, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectLongOrderedMap<?> data2 = fury.deserializeJavaObject(bytes, ObjectLongOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testObjectFloatMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectFloatMap.class, new ObjectFloatMapSerializer(fury));

        ObjectFloatMap<String> data = ObjectFloatMap.with("Cthulhu", -123456.789f, "lies", 0f, "deep",
                4.56789f, "in", 0.0001f, "Rl'yeh", 1f, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectFloatMap<?> data2 = fury.deserializeJavaObject(bytes, ObjectFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectFloatOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectFloatOrderedMap.class, new ObjectFloatOrderedMapSerializer(fury));

        ObjectFloatOrderedMap<String> data = ObjectFloatOrderedMap.with("Cthulhu", -123456.789f, "lies", 0f, "deep",
                4.56789f, "in", 0.0001f, "Rl'yeh", 1f, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectFloatOrderedMap<?> data2 = fury.deserializeJavaObject(bytes, ObjectFloatOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testCaseInsensitiveMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(CaseInsensitiveMap.class, new CaseInsensitiveMapSerializer(fury));

        CaseInsensitiveMap<Integer> data = CaseInsensitiveMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            CaseInsensitiveMap<?> data2 = fury.deserializeJavaObject(bytes, CaseInsensitiveMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCaseInsensitiveOrderedMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(CaseInsensitiveOrderedMap.class, new CaseInsensitiveOrderedMapSerializer(fury));

        CaseInsensitiveOrderedMap<Integer> data = CaseInsensitiveOrderedMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            CaseInsensitiveOrderedMap<?> data2 = fury.deserializeJavaObject(bytes, CaseInsensitiveOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testFilteredStringMap() {
        CharFilter filter = CharFilter.getOrCreate("LettersOnlyIgnoreCase", Character::isLetter, Character::toUpperCase);
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(FilteredStringMap.class, new FilteredStringMapSerializer(fury));

        FilteredStringMap<Integer> data = FilteredStringMap.with(filter, "Hello", -123456, "World", Integer.MIN_VALUE,
                "!", 456789012, "YES", 0, "HELLO", 1111, "WORLD", 1, "!", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            FilteredStringMap<?> data2 = fury.deserializeJavaObject(bytes, FilteredStringMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testFilteredStringOrderedMap() {
        CharFilter filter = CharFilter.getOrCreate("LettersOnlyIgnoreCase", Character::isLetter, Character::toUpperCase);
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(FilteredStringOrderedMap.class, new FilteredStringOrderedMapSerializer(fury));

        FilteredStringOrderedMap<Integer> data = FilteredStringOrderedMap.with(filter, "Hello", -123456, "World", Integer.MIN_VALUE,
                "!", 456789012, "YES", 0, "HELLO", 1111, "WORLD", 1, "!", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            FilteredStringOrderedMap<?> data2 = fury.deserializeJavaObject(bytes, FilteredStringOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.register(Character.UnicodeScript.class);
        fury.registerSerializer(EnumMap.class, new EnumMapSerializer(fury));

        EnumMap<Integer> data = EnumMap.with(Character.UnicodeScript.LATIN, -123456, Character.UnicodeScript.ARABIC, Integer.MIN_VALUE,
                Character.UnicodeScript.LAO, 456789012, Character.UnicodeScript.ARMENIAN, 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            EnumMap<?> data2 = fury.deserializeJavaObject(bytes, EnumMap.class);
            Assert.assertEquals(data, data2);
        }
    }

//    @Test
//    public void testFilteredIterableMap() {
//        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        kryo.register(String.class);
//        kryo.register(ObjPredicate.class);
//        kryo.register(ObjToSameFunction.class);
//        fury.registerSerializer(ObjectList.class, new ObjectListSerializer(fury));
//        fury.registerSerializer(FilteredIterableMap.class, new FilteredIterableMapSerializer(fury));
//
//        FilteredIterableMap<String, ObjectList<String>, Integer> data = FilteredIterableMap.with(
//                (String s) -> s.length() > 3, String::toUpperCase,
//                ObjectList.with("zzz", "bee", "binturong"), 1234,
//                ObjectList.with("hm?", "bee", "BINTURONG"), -5678,
//                ObjectList.with(":D", "bee", "Aardvark", "bandicoot"), Integer.MIN_VALUE
//        );
//
//        byte[] bytes = fury.serializeJavaObject(data); {
//            FilteredIterableMap<?,?,?> data2 = fury.deserializeJavaObject(bytes, FilteredIterableMap.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testFilteredIterableOrderedMap() {
//        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        kryo.register(String.class);
//        kryo.register(ObjPredicate.class);
//        kryo.register(ObjToSameFunction.class);
//        fury.registerSerializer(ObjectList.class, new ObjectListSerializer(fury));
//        fury.registerSerializer(FilteredIterableOrderedMap.class, new FilteredIterableOrderedMapSerializer(fury));
//
//        FilteredIterableOrderedMap<String, ObjectList<String>, Integer> data = FilteredIterableOrderedMap.with(
//                (String s) -> s.length() > 3, String::toUpperCase,
//                ObjectList.with("zzz", "bee", "binturong"), 1234,
//                ObjectList.with("hm?", "bee", "BINTURONG"), -5678,
//                ObjectList.with(":D", "bee", "Aardvark", "bandicoot"), Integer.MIN_VALUE
//        );
//
//        byte[] bytes = fury.serializeJavaObject(data); {
//            FilteredIterableOrderedMap<?,?,?> data2 = fury.deserializeJavaObject(bytes, FilteredIterableOrderedMap.class);
//            Assert.assertEquals(data, data2);
//        }
//    }

}
