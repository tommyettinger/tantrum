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
import org.apache.fory.Fory;
import org.apache.fory.config.Language;
import org.apache.fory.logging.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;

public class SetTest {
    @Test
    public void testIntSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntSet.class, new IntSetSerializer(fory));

        IntSet data = IntSet.with(-123, 0, 456, 0, 1, -1, 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            IntSet data2 = fory.deserializeJavaObject(bytes, IntSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntOrderedSet.class, new IntOrderedSetSerializer(fory));

        IntOrderedSet data = IntOrderedSet.with(-123, 0, 456, 0, 1, -1, 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            IntOrderedSet data2 = fory.deserializeJavaObject(bytes, IntOrderedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testLongSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongSet.class, new LongSetSerializer(fory));

        LongSet data = LongSet.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            LongSet data2 = fory.deserializeJavaObject(bytes, LongSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongOrderedSet.class, new LongOrderedSetSerializer(fory));

        LongOrderedSet data = LongOrderedSet.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            LongOrderedSet data2 = fory.deserializeJavaObject(bytes, LongOrderedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testObjectSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectSet.class, new ObjectSetSerializer(fory));

        ObjectSet<String> data = ObjectSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serializeJavaObject(data); {
            ObjectSet<?> data2 = fory.deserializeJavaObject(bytes, ObjectSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectOrderedSet.class, new ObjectOrderedSetSerializer(fory));

        ObjectOrderedSet<String> data = ObjectOrderedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serializeJavaObject(data); {
            ObjectOrderedSet<?> data2 = fory.deserializeJavaObject(bytes, ObjectOrderedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testCaseInsensitiveSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CaseInsensitiveSet.class, new CaseInsensitiveSetSerializer(fory));

        CaseInsensitiveSet data = CaseInsensitiveSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serializeJavaObject(data); {
            CaseInsensitiveSet data2 = fory.deserializeJavaObject(bytes, CaseInsensitiveSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCaseInsensitiveOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CaseInsensitiveOrderedSet.class, new CaseInsensitiveOrderedSetSerializer(fory));

        CaseInsensitiveOrderedSet data = CaseInsensitiveOrderedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serializeJavaObject(data); {
            CaseInsensitiveOrderedSet data2 = fory.deserializeJavaObject(bytes, CaseInsensitiveOrderedSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testOffsetBitSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(OffsetBitSet.class, new OffsetBitSetSerializer(fory));

        OffsetBitSet data = new OffsetBitSet(-123, 500);
        data.addAll(new int[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fory.serializeJavaObject(data); {
            OffsetBitSet data2 = fory.deserializeJavaObject(bytes, OffsetBitSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCharBitSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CharBitSet.class, new CharBitSetSerializer(fory));

        CharBitSet data = new CharBitSet(Character::isDigit);
        data.add('Z');

        byte[] bytes = fory.serializeJavaObject(data); {
            CharBitSet data2 = fory.deserializeJavaObject(bytes, CharBitSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCharBitSetResizable() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CharBitSetResizable.class, new CharBitSetResizableSerializer(fory));

        CharBitSetResizable data = new CharBitSetResizable("abcdefghijklmnopqrstuvwxyz".toCharArray());
        data.add('Z');

        byte[] bytes = fory.serializeJavaObject(data); {
            CharBitSetResizable data2 = fory.deserializeJavaObject(bytes, CharBitSetResizable.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testNumberedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(NumberedSet.class, new NumberedSetSerializer(fory));

        NumberedSet<String> data = NumberedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serializeJavaObject(data); {
            NumberedSet<?> data2 = fory.deserializeJavaObject(bytes, NumberedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }
//
//    @Test
//    public void testHolderSet() {
//        LoggerFactory.disableLogging();
//        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        kryo.register(String.class);
//        kryo.register(ObjToObjFunction.class);
//        fory.registerSerializer(HolderSet.class, new HolderSetSerializer(fory));
//
//        ObjToObjFunction<String, String> f = s -> s.split("\\s+")[0];
//        HolderSet<String, String> data = HolderSet.with(f, "Hello World!", "I am", "a test!", "Yippee yay wahoo!");
//
//        byte[] bytes = fory.serializeJavaObject(data); {
//            HolderSet<?, ?> data2 = fory.deserializeJavaObject(bytes, HolderSet.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testHolderOrderedSet() {
//        LoggerFactory.disableLogging();
//        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        kryo.register(String.class);
//        kryo.register(ObjToObjFunction.class);
//        fory.registerSerializer(HolderOrderedSet.class, new HolderOrderedSetSerializer(fory));
//
//        ObjToObjFunction<String, String> f = s -> s.split("\\s+")[0];
//        HolderOrderedSet<String, String> data = HolderOrderedSet.with(f, "Hello World!", "I am", "a test!", "Yippee yay wahoo!");
//
//        byte[] bytes = fory.serializeJavaObject(data); {
//            HolderOrderedSet<?, ?> data2 = fory.deserializeJavaObject(bytes, HolderOrderedSet.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//

    @Test
    public void testFilteredStringSet() {
        CharFilter filter = CharFilter.getOrCreate("LettersOnlyIgnoreCase", Character::isLetter, Character::toUpperCase);
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(FilteredStringSet.class, new FilteredStringSetSerializer(fory));

        FilteredStringSet data = FilteredStringSet.with(filter, "Hello", "World", "!", "YES", "HELLO", "WORLD", "!");

        byte[] bytes = fory.serializeJavaObject(data); {
            FilteredStringSet data2 = fory.deserializeJavaObject(bytes, FilteredStringSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testFilteredStringOrderedSet() {
        CharFilter filter = CharFilter.getOrCreate("LettersOnlyIgnoreCase", Character::isLetter, Character::toUpperCase);
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(FilteredStringOrderedSet.class, new FilteredStringOrderedSetSerializer(fory));

        FilteredStringOrderedSet data = FilteredStringOrderedSet.with(filter, "Hello", "World", "!", "YES", "HELLO", "WORLD", "!");

        byte[] bytes = fory.serializeJavaObject(data); {
            FilteredStringOrderedSet data2 = fory.deserializeJavaObject(bytes, FilteredStringOrderedSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumSet.class, new EnumSetSerializer(fory));

        EnumSet data = EnumSet.with(Character.UnicodeScript.LATIN, Character.UnicodeScript.ARABIC, Character.UnicodeScript.LAO, Character.UnicodeScript.ARMENIAN);

        byte[] bytes = fory.serializeJavaObject(data); {
            EnumSet data2 = fory.deserializeJavaObject(bytes, EnumSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumOrderedSet.class, new EnumOrderedSetSerializer(fory));

        EnumOrderedSet data = EnumOrderedSet.with(Character.UnicodeScript.LATIN, Character.UnicodeScript.ARABIC, Character.UnicodeScript.LAO, Character.UnicodeScript.ARMENIAN);

        byte[] bytes = fory.serializeJavaObject(data); {
            EnumOrderedSet data2 = fory.deserializeJavaObject(bytes, EnumOrderedSet.class);
            Assert.assertEquals(data, data2);
        }
    }

//    @Test
//    public void testFilteredIterableSet() {
//        LoggerFactory.disableLogging();
//        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        fory.register(ObjPredicate.class);
//        fory.register(ObjToSameFunction.class);
//        fory.registerSerializer(ObjectList.class, new ObjectListSerializer(fory));
//        fory.registerSerializer(FilteredIterableSet.class, new FilteredIterableSetSerializer(fory));
//
//        FilteredIterableSet<String, Iterable<String>> data = FilteredIterableSet.with(
//                (String s) -> s.length() > 3, String::toUpperCase,
//                ObjectList.with("zzz", "bee", "binturong"),
//                ObjectList.with("hm?", "bee", "BINTURONG"),
//                ObjectList.with(":D", "bee", "Aardvark", "bandicoot")
//        );
//
//        byte[] bytes = fory.serializeJavaObject(data); {
//            FilteredIterableSet<?, ?> data2 = fory.deserializeJavaObject(bytes, FilteredIterableSet.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testFilteredIterableOrderedSet() {
//        LoggerFactory.disableLogging();
//        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        fory.register(ObjPredicate.class);
//        fory.register(ObjToSameFunction.class);
//        fory.registerSerializer(ObjectList.class, new ObjectListSerializer(fory));
//        fory.registerSerializer(FilteredIterableOrderedSet.class, new FilteredIterableOrderedSetSerializer(fory));
//
//        FilteredIterableOrderedSet<String, Iterable<String>> data = FilteredIterableOrderedSet.with(
//                (String s) -> s.length() > 3, String::toUpperCase,
//                ObjectList.with("zzz", "bee", "binturong"),
//                ObjectList.with("hm?", "bee", "BINTURONG"),
//                ObjectList.with(":D", "bee", "Aardvark", "bandicoot")
//        );
//
//        byte[] bytes = fory.serializeJavaObject(data); {
//            FilteredIterableOrderedSet<?, ?> data2 = fory.deserializeJavaObject(bytes, FilteredIterableOrderedSet.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
}
