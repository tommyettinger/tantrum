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
import org.apache.fury.Fury;
import org.apache.fury.config.Language;
import org.junit.Assert;
import org.junit.Test;

public class SetTest {
    @Test
    public void testIntSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntSet.class, new IntSetSerializer(fury));

        IntSet data = IntSet.with(-123, 0, 456, 0, 1, -1, 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntSet data2 = fury.deserializeJavaObject(bytes, IntSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntOrderedSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntOrderedSet.class, new IntOrderedSetSerializer(fury));

        IntOrderedSet data = IntOrderedSet.with(-123, 0, 456, 0, 1, -1, 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntOrderedSet data2 = fury.deserializeJavaObject(bytes, IntOrderedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testLongSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongSet.class, new LongSetSerializer(fury));

        LongSet data = LongSet.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongSet data2 = fury.deserializeJavaObject(bytes, LongSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongOrderedSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongOrderedSet.class, new LongOrderedSetSerializer(fury));

        LongOrderedSet data = LongOrderedSet.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongOrderedSet data2 = fury.deserializeJavaObject(bytes, LongOrderedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testObjectSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectSet.class, new ObjectSetSerializer(fury));

        ObjectSet<String> data = ObjectSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectSet<?> data2 = fury.deserializeJavaObject(bytes, ObjectSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectOrderedSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectOrderedSet.class, new ObjectOrderedSetSerializer(fury));

        ObjectOrderedSet<String> data = ObjectOrderedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectOrderedSet<?> data2 = fury.deserializeJavaObject(bytes, ObjectOrderedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testCaseInsensitiveSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(CaseInsensitiveSet.class, new CaseInsensitiveSetSerializer(fury));

        CaseInsensitiveSet data = CaseInsensitiveSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data); {
            CaseInsensitiveSet data2 = fury.deserializeJavaObject(bytes, CaseInsensitiveSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCaseInsensitiveOrderedSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(CaseInsensitiveOrderedSet.class, new CaseInsensitiveOrderedSetSerializer(fury));

        CaseInsensitiveOrderedSet data = CaseInsensitiveOrderedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data); {
            CaseInsensitiveOrderedSet data2 = fury.deserializeJavaObject(bytes, CaseInsensitiveOrderedSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testOffsetBitSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(OffsetBitSet.class, new OffsetBitSetSerializer(fury));

        OffsetBitSet data = new OffsetBitSet(-123, 500);
        data.addAll(new int[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data); {
            OffsetBitSet data2 = fury.deserializeJavaObject(bytes, OffsetBitSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testNumberedSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(NumberedSet.class, new NumberedSetSerializer(fury));

        NumberedSet<String> data = NumberedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data); {
            NumberedSet<?> data2 = fury.deserializeJavaObject(bytes, NumberedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }
//
//    @Test
//    public void testHolderSet() {
//        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        kryo.register(String.class);
//        kryo.register(ObjToObjFunction.class);
//        fury.registerSerializer(HolderSet.class, new HolderSetSerializer(fury));
//
//        ObjToObjFunction<String, String> f = s -> s.split("\\s+")[0];
//        HolderSet<String, String> data = HolderSet.with(f, "Hello World!", "I am", "a test!", "Yippee yay wahoo!");
//
//        byte[] bytes = fury.serializeJavaObject(data); {
//            HolderSet<?, ?> data2 = fury.deserializeJavaObject(bytes, HolderSet.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testHolderOrderedSet() {
//        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        kryo.register(String.class);
//        kryo.register(ObjToObjFunction.class);
//        fury.registerSerializer(HolderOrderedSet.class, new HolderOrderedSetSerializer(fury));
//
//        ObjToObjFunction<String, String> f = s -> s.split("\\s+")[0];
//        HolderOrderedSet<String, String> data = HolderOrderedSet.with(f, "Hello World!", "I am", "a test!", "Yippee yay wahoo!");
//
//        byte[] bytes = fury.serializeJavaObject(data); {
//            HolderOrderedSet<?, ?> data2 = fury.deserializeJavaObject(bytes, HolderOrderedSet.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//

    @Test
    public void testFilteredStringSet() {
        CharFilter filter = CharFilter.getOrCreate("LettersOnlyIgnoreCase", Character::isLetter, Character::toUpperCase);
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(FilteredStringSet.class, new FilteredStringSetSerializer(fury));

        FilteredStringSet data = FilteredStringSet.with(filter, "Hello", "World", "!", "YES", "HELLO", "WORLD", "!");

        byte[] bytes = fury.serializeJavaObject(data); {
            FilteredStringSet data2 = fury.deserializeJavaObject(bytes, FilteredStringSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testFilteredStringOrderedSet() {
        CharFilter filter = CharFilter.getOrCreate("LettersOnlyIgnoreCase", Character::isLetter, Character::toUpperCase);
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(FilteredStringOrderedSet.class, new FilteredStringOrderedSetSerializer(fury));

        FilteredStringOrderedSet data = FilteredStringOrderedSet.with(filter, "Hello", "World", "!", "YES", "HELLO", "WORLD", "!");

        byte[] bytes = fury.serializeJavaObject(data); {
            FilteredStringOrderedSet data2 = fury.deserializeJavaObject(bytes, FilteredStringOrderedSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumSet() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.register(Character.UnicodeScript.class);
        fury.registerSerializer(EnumSet.class, new EnumSetSerializer(fury));

        EnumSet data = EnumSet.with(Character.UnicodeScript.LATIN, Character.UnicodeScript.ARABIC, Character.UnicodeScript.LAO, Character.UnicodeScript.ARMENIAN);

        byte[] bytes = fury.serializeJavaObject(data); {
            EnumSet data2 = fury.deserializeJavaObject(bytes, EnumSet.class);
            Assert.assertEquals(data, data2);
        }
    }

//    @Test
//    public void testFilteredIterableSet() {
//        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        fury.register(ObjPredicate.class);
//        fury.register(ObjToSameFunction.class);
//        fury.registerSerializer(ObjectList.class, new ObjectListSerializer(fury));
//        fury.registerSerializer(FilteredIterableSet.class, new FilteredIterableSetSerializer(fury));
//
//        FilteredIterableSet<String, Iterable<String>> data = FilteredIterableSet.with(
//                (String s) -> s.length() > 3, String::toUpperCase,
//                ObjectList.with("zzz", "bee", "binturong"),
//                ObjectList.with("hm?", "bee", "BINTURONG"),
//                ObjectList.with(":D", "bee", "Aardvark", "bandicoot")
//        );
//
//        byte[] bytes = fury.serializeJavaObject(data); {
//            FilteredIterableSet<?, ?> data2 = fury.deserializeJavaObject(bytes, FilteredIterableSet.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testFilteredIterableOrderedSet() {
//        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        fury.register(ObjPredicate.class);
//        fury.register(ObjToSameFunction.class);
//        fury.registerSerializer(ObjectList.class, new ObjectListSerializer(fury));
//        fury.registerSerializer(FilteredIterableOrderedSet.class, new FilteredIterableOrderedSetSerializer(fury));
//
//        FilteredIterableOrderedSet<String, Iterable<String>> data = FilteredIterableOrderedSet.with(
//                (String s) -> s.length() > 3, String::toUpperCase,
//                ObjectList.with("zzz", "bee", "binturong"),
//                ObjectList.with("hm?", "bee", "BINTURONG"),
//                ObjectList.with(":D", "bee", "Aardvark", "bandicoot")
//        );
//
//        byte[] bytes = fury.serializeJavaObject(data); {
//            FilteredIterableOrderedSet<?, ?> data2 = fury.deserializeJavaObject(bytes, FilteredIterableOrderedSet.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
}
