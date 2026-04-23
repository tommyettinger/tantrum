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
        fory.registerSerializer(IntSet.class, new IntSetSerializer(fory.getConfig()));

        IntSet data = IntSet.with(-123, 0, 456, 0, 1, -1, 0);

        byte[] bytes = fory.serialize(data); {
            IntSet data2 = fory.deserialize(bytes, IntSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntOrderedSet.class, new IntOrderedSetSerializer(fory.getConfig()));

        IntOrderedSet data = IntOrderedSet.with(-123, 0, 456, 0, 1, -1, 0);

        byte[] bytes = fory.serialize(data); {
            IntOrderedSet data2 = fory.deserialize(bytes, IntOrderedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testLongSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongSet.class, new LongSetSerializer(fory.getConfig()));

        LongSet data = LongSet.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fory.serialize(data); {
            LongSet data2 = fory.deserialize(bytes, LongSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongOrderedSet.class, new LongOrderedSetSerializer(fory.getConfig()));

        LongOrderedSet data = LongOrderedSet.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fory.serialize(data); {
            LongOrderedSet data2 = fory.deserialize(bytes, LongOrderedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testObjectSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectSet.class, new ObjectSetSerializer(fory.getTypeResolver()));

        ObjectSet<String> data = ObjectSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serialize(data); {
            ObjectSet<?> data2 = fory.deserialize(bytes, ObjectSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectOrderedSet.class, new ObjectOrderedSetSerializer(fory.getTypeResolver()));

        ObjectOrderedSet<String> data = ObjectOrderedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serialize(data); {
            ObjectOrderedSet<?> data2 = fory.deserialize(bytes, ObjectOrderedSet.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testCaseInsensitiveSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CaseInsensitiveSet.class, new CaseInsensitiveSetSerializer(fory.getTypeResolver()));

        CaseInsensitiveSet data = CaseInsensitiveSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serialize(data); {
            CaseInsensitiveSet data2 = fory.deserialize(bytes, CaseInsensitiveSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCaseInsensitiveOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CaseInsensitiveOrderedSet.class, new CaseInsensitiveOrderedSetSerializer(fory.getTypeResolver()));

        CaseInsensitiveOrderedSet data = CaseInsensitiveOrderedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serialize(data); {
            CaseInsensitiveOrderedSet data2 = fory.deserialize(bytes, CaseInsensitiveOrderedSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testOffsetBitSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(OffsetBitSet.class, new OffsetBitSetSerializer(fory.getConfig()));

        OffsetBitSet data = new OffsetBitSet(-123, 500);
        data.addAll(new int[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fory.serialize(data); {
            OffsetBitSet data2 = fory.deserialize(bytes, OffsetBitSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCharBitSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CharBitSet.class, new CharBitSetSerializer(fory.getConfig()));

        CharBitSet data = new CharBitSet(Character::isDigit);
        data.add('Z');

        byte[] bytes = fory.serialize(data); {
            CharBitSet data2 = fory.deserialize(bytes, CharBitSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCharBitSetFixedSize() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CharBitSetFixedSize.class, new CharBitSetFixedSizeSerializer(fory.getConfig()));

        CharBitSetFixedSize data = new CharBitSetFixedSize(Character::isDigit);
        data.add('Z');

        byte[] bytes = fory.serialize(data); {
            CharBitSetFixedSize data2 = fory.deserialize(bytes, CharBitSetFixedSize.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testNumberedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(NumberedSet.class, new NumberedSetSerializer(fory.getTypeResolver()));

        NumberedSet<String> data = NumberedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serialize(data); {
            NumberedSet<?> data2 = fory.deserialize(bytes, NumberedSet.class);
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
//        fory.registerSerializer(HolderSet.class, new HolderSetSerializer(fory.getConfig()));
//
//        ObjToObjFunction<String, String> f = s -> s.split("\\s+")[0];
//        HolderSet<String, String> data = HolderSet.with(f, "Hello World!", "I am", "a test!", "Yippee yay wahoo!");
//
//        byte[] bytes = fory.serialize(data); {
//            HolderSet<?, ?> data2 = fory.deserialize(bytes, HolderSet.class);
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
//        fory.registerSerializer(HolderOrderedSet.class, new HolderOrderedSetSerializer(fory.getConfig()));
//
//        ObjToObjFunction<String, String> f = s -> s.split("\\s+")[0];
//        HolderOrderedSet<String, String> data = HolderOrderedSet.with(f, "Hello World!", "I am", "a test!", "Yippee yay wahoo!");
//
//        byte[] bytes = fory.serialize(data); {
//            HolderOrderedSet<?, ?> data2 = fory.deserialize(bytes, HolderOrderedSet.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//

    @Test
    public void testFilteredStringSet() {
        CharFilter filter = CharFilter.getOrCreate("LettersOnlyIgnoreCase", Character::isLetter, Character::toUpperCase);
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(FilteredStringSet.class, new FilteredStringSetSerializer(fory.getTypeResolver()));

        FilteredStringSet data = FilteredStringSet.with(filter, "Hello", "World", "!", "YES", "HELLO", "WORLD", "!");

        byte[] bytes = fory.serialize(data); {
            FilteredStringSet data2 = fory.deserialize(bytes, FilteredStringSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testFilteredStringOrderedSet() {
        CharFilter filter = CharFilter.getOrCreate("LettersOnlyIgnoreCase", Character::isLetter, Character::toUpperCase);
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(FilteredStringOrderedSet.class, new FilteredStringOrderedSetSerializer(fory.getTypeResolver()));

        FilteredStringOrderedSet data = FilteredStringOrderedSet.with(filter, "Hello", "World", "!", "YES", "HELLO", "WORLD", "!");

        byte[] bytes = fory.serialize(data); {
            FilteredStringOrderedSet data2 = fory.deserialize(bytes, FilteredStringOrderedSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumSet.class, new EnumSetSerializer(fory.getTypeResolver()));

        EnumSet data = EnumSet.with(Character.UnicodeScript.LATIN, Character.UnicodeScript.ARABIC, Character.UnicodeScript.LAO, Character.UnicodeScript.ARMENIAN);

        byte[] bytes = fory.serialize(data); {
            EnumSet data2 = fory.deserialize(bytes, EnumSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumOrderedSet.class, new EnumOrderedSetSerializer(fory.getTypeResolver()));

        EnumOrderedSet data = EnumOrderedSet.with(Character.UnicodeScript.LATIN, Character.UnicodeScript.ARABIC, Character.UnicodeScript.LAO, Character.UnicodeScript.ARMENIAN);

        byte[] bytes = fory.serialize(data); {
            EnumOrderedSet data2 = fory.deserialize(bytes, EnumOrderedSet.class);
            Assert.assertEquals(data, data2);
        }
    }

//    @Test
//    public void testFilteredIterableSet() {
//        LoggerFactory.disableLogging();
//        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        fory.register(ObjPredicate.class);
//        fory.register(ObjToSameFunction.class);
//        fory.registerSerializer(ObjectList.class, new ObjectListSerializer(fory.getConfig()));
//        fory.registerSerializer(FilteredIterableSet.class, new FilteredIterableSetSerializer(fory.getConfig()));
//
//        FilteredIterableSet<String, Iterable<String>> data = FilteredIterableSet.with(
//                (String s) -> s.length() > 3, String::toUpperCase,
//                ObjectList.with("zzz", "bee", "binturong"),
//                ObjectList.with("hm?", "bee", "BINTURONG"),
//                ObjectList.with(":D", "bee", "Aardvark", "bandicoot")
//        );
//
//        byte[] bytes = fory.serialize(data); {
//            FilteredIterableSet<?, ?> data2 = fory.deserialize(bytes, FilteredIterableSet.class);
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
//        fory.registerSerializer(ObjectList.class, new ObjectListSerializer(fory.getConfig()));
//        fory.registerSerializer(FilteredIterableOrderedSet.class, new FilteredIterableOrderedSetSerializer(fory.getConfig()));
//
//        FilteredIterableOrderedSet<String, Iterable<String>> data = FilteredIterableOrderedSet.with(
//                (String s) -> s.length() > 3, String::toUpperCase,
//                ObjectList.with("zzz", "bee", "binturong"),
//                ObjectList.with("hm?", "bee", "BINTURONG"),
//                ObjectList.with(":D", "bee", "Aardvark", "bandicoot")
//        );
//
//        byte[] bytes = fory.serialize(data); {
//            FilteredIterableOrderedSet<?, ?> data2 = fory.deserialize(bytes, FilteredIterableOrderedSet.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
}
