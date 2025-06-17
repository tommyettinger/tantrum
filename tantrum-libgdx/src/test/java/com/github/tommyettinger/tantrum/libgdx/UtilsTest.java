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

import com.badlogic.gdx.utils.*;
import org.apache.fory.Fory;
import org.apache.fory.config.Language;
import org.apache.fory.logging.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
    @Test
    public void testArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Array.class, new ArraySerializer(fory));

        Array<String> data = Array.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serializeJavaObject(data); {
            Array<?> data2 = fory.deserializeJavaObject(bytes, Array.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testSnapshotArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(SnapshotArray.class, new SnapshotArraySerializer(fory));

        SnapshotArray<String> data = SnapshotArray.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serializeJavaObject(data); {
            SnapshotArray<?> data2 = fory.deserializeJavaObject(bytes, SnapshotArray.class);
            Assert.assertEquals(data, data2);
        }
    }
    
    @Test
    public void testDelayedRemovalArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(DelayedRemovalArray.class, new DelayedRemovalArraySerializer(fory));

        DelayedRemovalArray<String> data = DelayedRemovalArray.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serializeJavaObject(data); {
            DelayedRemovalArray<?> data2 = fory.deserializeJavaObject(bytes, DelayedRemovalArray.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testArrayMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ArrayMap.class, new ArrayMapSerializer(fory));

        ArrayMap<String, Integer> data = new ArrayMap<>();
        data.put("Cthulhu", -123456);
        data.put("lies", Integer.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", 0);
        data.put("Rl'yeh", 1111);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fory.serializeJavaObject(data);
        {
            ArrayMap<?, ?> data2 = fory.deserializeJavaObject(bytes, ArrayMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testQueue() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Queue.class, new QueueSerializer(fory));

        Queue<String> data = new Queue<>(9);
        for (String s : new String[]{"Hello", "World", "!", "I", "am", "a", "test", "!", "yay"}) {
            data.addLast(s);
        }

        byte[] bytes = fory.serializeJavaObject(data); {
            Queue<?> data2 = fory.deserializeJavaObject(bytes, Queue.class);
            Assert.assertEquals(data, data2);
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
    public void testOrderedSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(OrderedSet.class, new OrderedSetSerializer(fory));

        OrderedSet<String> data = OrderedSet.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serializeJavaObject(data); {
            OrderedSet<?> data2 = fory.deserializeJavaObject(bytes, OrderedSet.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectMap.class, new ObjectMapSerializer(fory));

        ObjectMap<String, Integer> data = new ObjectMap<>();
        data.put("Cthulhu", -123456);
        data.put("lies", Integer.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", 0);
        data.put("Rl'yeh", 1111);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            ObjectMap<?,?> data2 = fory.deserializeJavaObject(bytes, ObjectMap.class);
            Assert.assertEquals(data, data2);
        }
    }
    
    @Test
    public void testOrderedMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(OrderedMap.class, new OrderedMapSerializer(fory));

        OrderedMap<String, Integer> data = new OrderedMap<>();
        data.put("Cthulhu", -123456);
        data.put("lies", Integer.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", 0);
        data.put("Rl'yeh", 1111);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            OrderedMap<?,?> data2 = fory.deserializeJavaObject(bytes, OrderedMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectFloatMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectFloatMap.class, new ObjectFloatMapSerializer(fory));

        ObjectFloatMap<String> data = new ObjectFloatMap<>();
        data.put("Cthulhu", -123456.1f);
        data.put("lies", Float.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", Float.NEGATIVE_INFINITY);
        data.put("Rl'yeh", Float.POSITIVE_INFINITY);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            ObjectFloatMap<?> data2 = fory.deserializeJavaObject(bytes, ObjectFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectLongMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectLongMap.class, new ObjectLongMapSerializer(fory));

        ObjectLongMap<String> data = new ObjectLongMap<>();
        data.put("Cthulhu", -123456);
        data.put("lies", Long.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", Long.MAX_VALUE);
        data.put("Rl'yeh", 1111111111111111L);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            ObjectLongMap<?> data2 = fory.deserializeJavaObject(bytes, ObjectLongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectIntMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectIntMap.class, new ObjectIntMapSerializer(fory));

        ObjectIntMap<String> data = new ObjectIntMap<>();
        data.put("Cthulhu", -123456);
        data.put("lies", Integer.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", Integer.MAX_VALUE);
        data.put("Rl'yeh", 1111111111);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            ObjectIntMap<?> data2 = fory.deserializeJavaObject(bytes, ObjectIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }
    
    @Test
    public void testBooleanArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(BooleanArray.class, new BooleanArraySerializer(fory));

        BooleanArray data = BooleanArray.with(true, false, false, true, false, true, false);

        byte[] bytes = fory.serializeJavaObject(data);
        BooleanArray data2 = fory.deserializeJavaObject(bytes, BooleanArray.class);
        Assert.assertEquals(data, data2);
    }
    
    @Test
    public void testByteArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ByteArray.class, new ByteArraySerializer(fory));

        ByteArray data = ByteArray.with(new byte[]{-123, 0, 45, 0, 1, -1, 0});

        byte[] bytes = fory.serializeJavaObject(data);
        ByteArray data2 = fory.deserializeJavaObject(bytes, ByteArray.class);
        Assert.assertEquals(data, data2);
    }
    
    @Test
    public void testCharArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CharArray.class, new CharArraySerializer(fory));

        CharArray data = CharArray.with("Hello, World!".toCharArray());

        byte[] bytes = fory.serializeJavaObject(data);
        CharArray data2 = fory.deserializeJavaObject(bytes, CharArray.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testFloatArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(FloatArray.class, new FloatArraySerializer(fory));

        FloatArray data = FloatArray.with(-123.123f, 0f, 456.456f, 0, 1f, -1f, 0.000001f);

        byte[] bytes = fory.serializeJavaObject(data);
        FloatArray data2 = fory.deserializeJavaObject(bytes, FloatArray.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testIntArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntArray.class, new IntArraySerializer(fory));

        IntArray data = IntArray.with(-123, 0, 456, 0, 1, -1, 0x80000000);

        byte[] bytes = fory.serializeJavaObject(data);
        IntArray data2 = fory.deserializeJavaObject(bytes, IntArray.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testIntSet() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntSet.class, new IntSetSerializer(fory));

        IntSet data = IntSet.with(-123, 0, 456, 0, 1, -1, 0x80000000);

        byte[] bytes = fory.serializeJavaObject(data);
        IntSet data2 = fory.deserializeJavaObject(bytes, IntSet.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testIntMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntMap.class, new IntMapSerializer(fory));

        IntMap<Float> data = new IntMap<>();
        data.put(-1234567890, 1.2f);
        data.put(0, 2.3f);
        data.put(4567890, -3.4f);
        data.put(0, -4.5f);
        data.put(1, -5.6f);
        data.put(1, 6.7f);
        data.put(-1, -7.8f);
        data.put(0, 8.9f);

        byte[] bytes = fory.serializeJavaObject(data);
        {
            IntMap<?> data2 = fory.deserializeJavaObject(bytes, IntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntFloatMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntFloatMap.class, new IntFloatMapSerializer(fory));

        IntFloatMap data = new IntFloatMap();
        data.put(-1234567890, 1.2f);
        data.put(0, 2.3f);
        data.put(4567890, -3.4f);
        data.put(0, -4.5f);
        data.put(1, -5.6f);
        data.put(1, Float.POSITIVE_INFINITY);
        data.put(-1, Float.NEGATIVE_INFINITY);
        data.put(0, Float.MIN_VALUE);

        byte[] bytes = fory.serializeJavaObject(data);
        {
            IntFloatMap data2 = fory.deserializeJavaObject(bytes, IntFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntIntMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntIntMap.class, new IntIntMapSerializer(fory));

        IntIntMap data = new IntIntMap();
        data.put(-1234567890, 12);
        data.put(0, 23);
        data.put(4567890, -34);
        data.put(0, -45);
        data.put(1, -56);
        data.put(1, 67);
        data.put(-1, -78);
        data.put(0, 89);

        byte[] bytes = fory.serializeJavaObject(data);
        {
            IntIntMap data2 = fory.deserializeJavaObject(bytes, IntIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongArray.class, new LongArraySerializer(fory));

        LongArray data = LongArray.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fory.serializeJavaObject(data);
        LongArray data2 = fory.deserializeJavaObject(bytes, LongArray.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testLongQueue() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongQueue.class, new LongQueueSerializer(fory));

        LongQueue data = new LongQueue();
        for(long item : new long[]{-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0}) {
            data.addLast(item);
        }

        byte[] bytes = fory.serializeJavaObject(data);
        LongQueue data2 = fory.deserializeJavaObject(bytes, LongQueue.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testLongMap() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongMap.class, new LongMapSerializer(fory));

        LongMap<Float> data = new LongMap<>();
        data.put(-1234567890L, 1.2f);
        data.put(0L, 2.3f);
        data.put(4567890123456789L, -3.4f);
        data.put(0, -4.5f);
        data.put(1L, -5.6f);
        data.put(1, 6.7f);
        data.put(-1, -7.8f);
        data.put(0, 8.9f);

        byte[] bytes = fory.serializeJavaObject(data);
        {
            LongMap<?> data2 = fory.deserializeJavaObject(bytes, LongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testShortArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ShortArray.class, new ShortArraySerializer(fory));

        ShortArray data = ShortArray.with(new short[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fory.serializeJavaObject(data);
        ShortArray data2 = fory.deserializeJavaObject(bytes, ShortArray.class);
        Assert.assertEquals(data, data2);
    }
}
