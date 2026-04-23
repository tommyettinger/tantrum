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

public class MapTest {
    @Test
    public void testLongObjectMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongObjectMap.class, new LongObjectMapSerializer(fory));

        LongObjectMap<Float> data = LongObjectMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            LongObjectMap<?> data2 = fory.deserialize(bytes, LongObjectMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongObjectOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongObjectOrderedMap.class, new LongObjectOrderedMapSerializer(fory));

        LongObjectOrderedMap<Float> data = LongObjectOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            LongObjectOrderedMap<?> data2 = fory.deserialize(bytes, LongObjectOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongFloatMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongFloatMap.class, new LongFloatMapSerializer(fory));

        LongFloatMap data = LongFloatMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            LongFloatMap data2 = fory.deserialize(bytes, LongFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongFloatOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongFloatOrderedMap.class, new LongFloatOrderedMapSerializer(fory));

        LongFloatOrderedMap data = LongFloatOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            LongFloatOrderedMap data2 = fory.deserialize(bytes, LongFloatOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testLongIntMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongIntMap.class, new LongIntMapSerializer(fory));

        LongIntMap data = LongIntMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            LongIntMap data2 = fory.deserialize(bytes, LongIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongIntOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongIntOrderedMap.class, new LongIntOrderedMapSerializer(fory));

        LongIntOrderedMap data = LongIntOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            LongIntOrderedMap data2 = fory.deserialize(bytes, LongIntOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }
    @Test
    public void testLongLongMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongLongMap.class, new LongLongMapSerializer(fory));

        LongLongMap data = LongLongMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            LongLongMap data2 = fory.deserialize(bytes, LongLongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongLongOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongLongOrderedMap.class, new LongLongOrderedMapSerializer(fory));

        LongLongOrderedMap data = LongLongOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            LongLongOrderedMap data2 = fory.deserialize(bytes, LongLongOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testIntObjectMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntObjectMap.class, new IntObjectMapSerializer(fory));

        IntObjectMap<Float> data = IntObjectMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            IntObjectMap<?> data2 = fory.deserialize(bytes, IntObjectMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntObjectOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntObjectOrderedMap.class, new IntObjectOrderedMapSerializer(fory));

        IntObjectOrderedMap<Float> data = IntObjectOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            IntObjectOrderedMap<?> data2 = fory.deserialize(bytes, IntObjectOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntFloatMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntFloatMap.class, new IntFloatMapSerializer(fory));

        IntFloatMap data = IntFloatMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            IntFloatMap data2 = fory.deserialize(bytes, IntFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntFloatOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntFloatOrderedMap.class, new IntFloatOrderedMapSerializer(fory));

        IntFloatOrderedMap data = IntFloatOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            IntFloatOrderedMap data2 = fory.deserialize(bytes, IntFloatOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testIntIntMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntIntMap.class, new IntIntMapSerializer(fory));

        IntIntMap data = IntIntMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            IntIntMap data2 = fory.deserialize(bytes, IntIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntIntOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntIntOrderedMap.class, new IntIntOrderedMapSerializer(fory));

        IntIntOrderedMap data = IntIntOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            IntIntOrderedMap data2 = fory.deserialize(bytes, IntIntOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testIntLongMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntLongMap.class, new IntLongMapSerializer(fory));

        IntLongMap data = IntLongMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            IntLongMap data2 = fory.deserialize(bytes, IntLongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntLongOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntLongOrderedMap.class, new IntLongOrderedMapSerializer(fory));

        IntLongOrderedMap data = IntLongOrderedMap.with(-1234567890L, 1.2f, 0L, 2.3f, 4567890123456789L, -3.4f, 0, -4.5f, 1L, -5.6f, 1, 6.7f, -1, -7.8f, 0, 8.9f);

        byte[] bytes = fory.serialize(data); {
            IntLongOrderedMap data2 = fory.deserialize(bytes, IntLongOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testObjectObjectMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectObjectMap.class, new ObjectObjectMapSerializer(fory));

        ObjectObjectMap<String, Integer> data = ObjectObjectMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fory.serialize(data); {
            ObjectObjectMap<?,?> data2 = fory.deserialize(bytes, ObjectObjectMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    public static class Inte {
        public int n;

        public Inte() {
            n = 0;
        }

        public Inte(int n) {
            this.n = n;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        @Override
        public final boolean equals(Object o) {
            if (!(o instanceof Inte)) return false;

            Inte inte = (Inte) o;
            return n == inte.n;
        }

        @Override
        public int hashCode() {
            return n;
        }

        @Override
        public String toString() {
            return "Inte{" +
                    "n=" + n +
                    '}';
        }
    }

    @Test
    public void testObjectObjectOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectObjectOrderedMap.class, new ObjectObjectOrderedMapSerializer(fory));
        fory.register(Inte.class);

        {
            ObjectObjectOrderedMap<String, Integer> data = ObjectObjectOrderedMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                    "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

            byte[] bytes = fory.serialize(data);
            {
                ObjectObjectOrderedMap<?, ?> data2 = fory.deserialize(bytes, ObjectObjectOrderedMap.class);
                Assert.assertEquals(data, data2);
            }
        }
        {
            ObjectObjectOrderedMap<String, Inte> data = ObjectObjectOrderedMap.with("Cthulhu", new Inte(-123456), "lies", new Inte(Integer.MIN_VALUE),
                    "deep", new Inte(456789012), "in", new Inte(0), "Rl'yeh", new Inte(1111), "dreaming", new Inte(1), "of", new Inte(-1), "waffles", new Inte(0));

            byte[] bytes = fory.serialize(data);
            {
                ObjectObjectOrderedMap<?, ?> data2 = fory.deserialize(bytes, ObjectObjectOrderedMap.class);
                Assert.assertEquals(data, data2);
            }

        }
    }

    @Test
    public void testObjectIntMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectIntMap.class, new ObjectIntMapSerializer(fory));

        ObjectIntMap<String> data = ObjectIntMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fory.serialize(data); {
            ObjectIntMap<?> data2 = fory.deserialize(bytes, ObjectIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectIntOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectIntOrderedMap.class, new ObjectIntOrderedMapSerializer(fory));

        ObjectIntOrderedMap<String> data = ObjectIntOrderedMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fory.serialize(data); {
            ObjectIntOrderedMap<?> data2 = fory.deserialize(bytes, ObjectIntOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testObjectLongMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectLongMap.class, new ObjectLongMapSerializer(fory));

        ObjectLongMap<String> data = ObjectLongMap.with("Cthulhu", -1234567890L, "lies", 0L, "deep",
                4567890123456789L, "in", 0, "Rl'yeh", 1L, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fory.serialize(data); {
            ObjectLongMap<?> data2 = fory.deserialize(bytes, ObjectLongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectLongOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectLongOrderedMap.class, new ObjectLongOrderedMapSerializer(fory));

        ObjectLongOrderedMap<String> data = ObjectLongOrderedMap.with("Cthulhu", -1234567890L, "lies", 0L, "deep",
                4567890123456789L, "in", 0, "Rl'yeh", 1L, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fory.serialize(data); {
            ObjectLongOrderedMap<?> data2 = fory.deserialize(bytes, ObjectLongOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testObjectFloatMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectFloatMap.class, new ObjectFloatMapSerializer(fory));

        ObjectFloatMap<String> data = ObjectFloatMap.with("Cthulhu", -123456.789f, "lies", 0f, "deep",
                4.56789f, "in", 0.0001f, "Rl'yeh", 1f, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fory.serialize(data); {
            ObjectFloatMap<?> data2 = fory.deserialize(bytes, ObjectFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectFloatOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectFloatOrderedMap.class, new ObjectFloatOrderedMapSerializer(fory));

        ObjectFloatOrderedMap<String> data = ObjectFloatOrderedMap.with("Cthulhu", -123456.789f, "lies", 0f, "deep",
                4.56789f, "in", 0.0001f, "Rl'yeh", 1f, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fory.serialize(data); {
            ObjectFloatOrderedMap<?> data2 = fory.deserialize(bytes, ObjectFloatOrderedMap.class);
            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.order(), data2.order());
        }
    }

    @Test
    public void testCaseInsensitiveMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CaseInsensitiveMap.class, new CaseInsensitiveMapSerializer(fory));

        CaseInsensitiveMap<Integer> data = CaseInsensitiveMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fory.serialize(data); {
            CaseInsensitiveMap<?> data2 = fory.deserialize(bytes, CaseInsensitiveMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCaseInsensitiveOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CaseInsensitiveOrderedMap.class, new CaseInsensitiveOrderedMapSerializer(fory));

        CaseInsensitiveOrderedMap<Integer> data = CaseInsensitiveOrderedMap.with("Cthulhu", -123456, "lies", Integer.MIN_VALUE,
                "deep", 456789012, "in", 0, "Rl'yeh", 1111, "dreaming", 1, "of", -1, "waffles", 0);

        byte[] bytes = fory.serialize(data); {
            CaseInsensitiveOrderedMap<?> data2 = fory.deserialize(bytes, CaseInsensitiveOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testFilteredStringMap() {
        CharFilter filter = CharFilter.getOrCreate("LettersOnlyIgnoreCase", Character::isLetter, Character::toUpperCase);
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(FilteredStringMap.class, new FilteredStringMapSerializer(fory));

        FilteredStringMap<Integer> data = FilteredStringMap.with(filter, "Hello", -123456, "World", Integer.MIN_VALUE,
                "!", 456789012, "YES", 0, "HELLO", 1111, "WORLD", 1, "!", 0);

        byte[] bytes = fory.serialize(data); {
            FilteredStringMap<?> data2 = fory.deserialize(bytes, FilteredStringMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testFilteredStringOrderedMap() {
        CharFilter filter = CharFilter.getOrCreate("LettersOnlyIgnoreCase", Character::isLetter, Character::toUpperCase);
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(FilteredStringOrderedMap.class, new FilteredStringOrderedMapSerializer(fory));

        FilteredStringOrderedMap<Integer> data = FilteredStringOrderedMap.with(filter, "Hello", -123456, "World", Integer.MIN_VALUE,
                "!", 456789012, "YES", 0, "HELLO", 1111, "WORLD", 1, "!", 0);

        byte[] bytes = fory.serialize(data); {
            FilteredStringOrderedMap<?> data2 = fory.deserialize(bytes, FilteredStringOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumMap.class, new EnumMapSerializer(fory));

        EnumMap<Integer> data = EnumMap.with(Character.UnicodeScript.LATIN, -123456, Character.UnicodeScript.ARABIC, Integer.MIN_VALUE,
                Character.UnicodeScript.LAO, 456789012, Character.UnicodeScript.ARMENIAN, 0);

        byte[] bytes = fory.serialize(data); {
            EnumMap<?> data2 = fory.deserialize(bytes, EnumMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumOrderedMap.class, new EnumOrderedMapSerializer(fory));

        EnumOrderedMap<Integer> data = EnumOrderedMap.with(Character.UnicodeScript.LATIN, -123456, Character.UnicodeScript.ARABIC, Integer.MIN_VALUE,
                Character.UnicodeScript.LAO, 456789012, Character.UnicodeScript.ARMENIAN, 0);

        byte[] bytes = fory.serialize(data); {
            EnumOrderedMap<?> data2 = fory.deserialize(bytes, EnumOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumIntMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumIntMap.class, new EnumIntMapSerializer(fory));

        EnumIntMap data = EnumIntMap.with(Character.UnicodeScript.LATIN, -123456, Character.UnicodeScript.ARABIC, Integer.MIN_VALUE,
                Character.UnicodeScript.LAO, 456789012, Character.UnicodeScript.ARMENIAN, 0);

        byte[] bytes = fory.serialize(data); {
            EnumIntMap data2 = fory.deserialize(bytes, EnumIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumIntOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumIntOrderedMap.class, new EnumIntOrderedMapSerializer(fory));

        EnumIntOrderedMap data = EnumIntOrderedMap.with(Character.UnicodeScript.LATIN, -123456, Character.UnicodeScript.ARABIC, Integer.MIN_VALUE,
                Character.UnicodeScript.LAO, 456789012, Character.UnicodeScript.ARMENIAN, 0);

        byte[] bytes = fory.serialize(data); {
            EnumIntOrderedMap data2 = fory.deserialize(bytes, EnumIntOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumLongMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumLongMap.class, new EnumLongMapSerializer(fory));

        EnumLongMap data = EnumLongMap.with(Character.UnicodeScript.LATIN, -123456, Character.UnicodeScript.ARABIC, Integer.MIN_VALUE,
                Character.UnicodeScript.LAO, 456789012, Character.UnicodeScript.ARMENIAN, 0);

        byte[] bytes = fory.serialize(data); {
            EnumLongMap data2 = fory.deserialize(bytes, EnumLongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumLongOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumLongOrderedMap.class, new EnumLongOrderedMapSerializer(fory));

        EnumLongOrderedMap data = EnumLongOrderedMap.with(Character.UnicodeScript.LATIN, -123456, Character.UnicodeScript.ARABIC, Integer.MIN_VALUE,
                Character.UnicodeScript.LAO, 456789012, Character.UnicodeScript.ARMENIAN, 0);

        byte[] bytes = fory.serialize(data); {
            EnumLongOrderedMap data2 = fory.deserialize(bytes, EnumLongOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumFloatMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumFloatMap.class, new EnumFloatMapSerializer(fory));

        EnumFloatMap data = EnumFloatMap.with(Character.UnicodeScript.LATIN, -123456, Character.UnicodeScript.ARABIC, Integer.MIN_VALUE,
                Character.UnicodeScript.LAO, 456789012, Character.UnicodeScript.ARMENIAN, 0);

        byte[] bytes = fory.serialize(data); {
            EnumFloatMap data2 = fory.deserialize(bytes, EnumFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testEnumFloatOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.register(Character.UnicodeScript.class);
        fory.registerSerializer(EnumFloatOrderedMap.class, new EnumFloatOrderedMapSerializer(fory));

        EnumFloatOrderedMap data = EnumFloatOrderedMap.with(Character.UnicodeScript.LATIN, -123456, Character.UnicodeScript.ARABIC, Integer.MIN_VALUE,
                Character.UnicodeScript.LAO, 456789012, Character.UnicodeScript.ARMENIAN, 0);

        byte[] bytes = fory.serialize(data); {
            EnumFloatOrderedMap data2 = fory.deserialize(bytes, EnumFloatOrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

//    @Test
//    public void testFilteredIterableMap() {
//        LoggerFactory.disableLogging();
//        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        kryo.register(String.class);
//        kryo.register(ObjPredicate.class);
//        kryo.register(ObjToSameFunction.class);
//        fory.registerSerializer(ObjectList.class, new ObjectListSerializer(fory));
//        fory.registerSerializer(FilteredIterableMap.class, new FilteredIterableMapSerializer(fory));
//
//        FilteredIterableMap<String, ObjectList<String>, Integer> data = FilteredIterableMap.with(
//                (String s) -> s.length() > 3, String::toUpperCase,
//                ObjectList.with("zzz", "bee", "binturong"), 1234,
//                ObjectList.with("hm?", "bee", "BINTURONG"), -5678,
//                ObjectList.with(":D", "bee", "Aardvark", "bandicoot"), Integer.MIN_VALUE
//        );
//
//        byte[] bytes = fory.serialize(data); {
//            FilteredIterableMap<?,?,?> data2 = fory.deserialize(bytes, FilteredIterableMap.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testFilteredIterableOrderedMap() {
//        LoggerFactory.disableLogging();
//        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        kryo.register(String.class);
//        kryo.register(ObjPredicate.class);
//        kryo.register(ObjToSameFunction.class);
//        fory.registerSerializer(ObjectList.class, new ObjectListSerializer(fory));
//        fory.registerSerializer(FilteredIterableOrderedMap.class, new FilteredIterableOrderedMapSerializer(fory));
//
//        FilteredIterableOrderedMap<String, ObjectList<String>, Integer> data = FilteredIterableOrderedMap.with(
//                (String s) -> s.length() > 3, String::toUpperCase,
//                ObjectList.with("zzz", "bee", "binturong"), 1234,
//                ObjectList.with("hm?", "bee", "BINTURONG"), -5678,
//                ObjectList.with(":D", "bee", "Aardvark", "bandicoot"), Integer.MIN_VALUE
//        );
//
//        byte[] bytes = fory.serialize(data); {
//            FilteredIterableOrderedMap<?,?,?> data2 = fory.deserialize(bytes, FilteredIterableOrderedMap.class);
//            Assert.assertEquals(data, data2);
//        }
//    }

}
