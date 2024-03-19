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
import io.fury.Fury;
import io.fury.config.Language;
import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
    @Test
    public void testArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Array.class, new ArraySerializer(fury));

        Array<String> data = Array.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data); {
            Array<?> data2 = fury.deserializeJavaObject(bytes, Array.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testSnapshotArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(SnapshotArray.class, new SnapshotArraySerializer(fury));

        SnapshotArray<String> data = SnapshotArray.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data); {
            SnapshotArray<?> data2 = fury.deserializeJavaObject(bytes, SnapshotArray.class);
            Assert.assertEquals(data, data2);
        }
    }
    
    @Test
    public void testDelayedRemovalArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(DelayedRemovalArray.class, new DelayedRemovalArraySerializer(fury));

        DelayedRemovalArray<String> data = DelayedRemovalArray.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data); {
            DelayedRemovalArray<?> data2 = fury.deserializeJavaObject(bytes, DelayedRemovalArray.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testArrayMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ArrayMap.class, new ArrayMapSerializer(fury));

        ArrayMap<String, Integer> data = new ArrayMap<>();
        data.put("Cthulhu", -123456);
        data.put("lies", Integer.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", 0);
        data.put("Rl'yeh", 1111);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            ArrayMap<?, ?> data2 = fury.deserializeJavaObject(bytes, ArrayMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testQueue() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Queue.class, new QueueSerializer(fury));

        Queue<String> data = new Queue<>(9);
        for (String s : new String[]{"Hello", "World", "!", "I", "am", "a", "test", "!", "yay"}) {
            data.addLast(s);
        }

        byte[] bytes = fury.serializeJavaObject(data); {
            Queue<?> data2 = fury.deserializeJavaObject(bytes, Queue.class);
            Assert.assertEquals(data, data2);
        }
    }

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

    @Test
    public void testObjectFloatMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectFloatMap.class, new ObjectFloatMapSerializer(fury));

        ObjectFloatMap<String> data = new ObjectFloatMap<>();
        data.put("Cthulhu", -123456.1f);
        data.put("lies", Float.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", Float.NEGATIVE_INFINITY);
        data.put("Rl'yeh", Float.POSITIVE_INFINITY);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectFloatMap<?> data2 = fury.deserializeJavaObject(bytes, ObjectFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectLongMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectLongMap.class, new ObjectLongMapSerializer(fury));

        ObjectLongMap<String> data = new ObjectLongMap<>();
        data.put("Cthulhu", -123456);
        data.put("lies", Long.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", Long.MAX_VALUE);
        data.put("Rl'yeh", 1111111111111111L);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectLongMap<?> data2 = fury.deserializeJavaObject(bytes, ObjectLongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testObjectIntMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectIntMap.class, new ObjectIntMapSerializer(fury));

        ObjectIntMap<String> data = new ObjectIntMap<>();
        data.put("Cthulhu", -123456);
        data.put("lies", Integer.MIN_VALUE);
        data.put("deep", 456789012);
        data.put("in", Integer.MAX_VALUE);
        data.put("Rl'yeh", 1111111111);
        data.put("dreaming", 1);
        data.put("of", -1);
        data.put("waffles", 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectIntMap<?> data2 = fury.deserializeJavaObject(bytes, ObjectIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }
    
    @Test
    public void testBooleanArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(BooleanArray.class, new BooleanArraySerializer(fury));

        BooleanArray data = BooleanArray.with(true, false, false, true, false, true, false);

        byte[] bytes = fury.serializeJavaObject(data);
        BooleanArray data2 = fury.deserializeJavaObject(bytes, BooleanArray.class);
        Assert.assertEquals(data, data2);
    }
    
    @Test
    public void testByteArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ByteArray.class, new ByteArraySerializer(fury));

        ByteArray data = ByteArray.with(new byte[]{-123, 0, 45, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data);
        ByteArray data2 = fury.deserializeJavaObject(bytes, ByteArray.class);
        Assert.assertEquals(data, data2);
    }
    
    @Test
    public void testCharArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(CharArray.class, new CharArraySerializer(fury));

        CharArray data = CharArray.with("Hello, World!".toCharArray());

        byte[] bytes = fury.serializeJavaObject(data);
        CharArray data2 = fury.deserializeJavaObject(bytes, CharArray.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testFloatArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(FloatArray.class, new FloatArraySerializer(fury));

        FloatArray data = FloatArray.with(-123.123f, 0f, 456.456f, 0, 1f, -1f, 0.000001f);

        byte[] bytes = fury.serializeJavaObject(data);
        FloatArray data2 = fury.deserializeJavaObject(bytes, FloatArray.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testIntArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntArray.class, new IntArraySerializer(fury));

        IntArray data = IntArray.with(-123, 0, 456, 0, 1, -1, 0x80000000);

        byte[] bytes = fury.serializeJavaObject(data);
        IntArray data2 = fury.deserializeJavaObject(bytes, IntArray.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testIntSet() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntSet.class, new IntSetSerializer(fury));

        IntSet data = IntSet.with(-123, 0, 456, 0, 1, -1, 0x80000000);

        byte[] bytes = fury.serializeJavaObject(data);
        IntSet data2 = fury.deserializeJavaObject(bytes, IntSet.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testIntMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntMap.class, new IntMapSerializer(fury));

        IntMap<Float> data = new IntMap<>();
        data.put(-1234567890, 1.2f);
        data.put(0, 2.3f);
        data.put(4567890, -3.4f);
        data.put(0, -4.5f);
        data.put(1, -5.6f);
        data.put(1, 6.7f);
        data.put(-1, -7.8f);
        data.put(0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            IntMap<?> data2 = fury.deserializeJavaObject(bytes, IntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntFloatMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntFloatMap.class, new IntFloatMapSerializer(fury));

        IntFloatMap data = new IntFloatMap();
        data.put(-1234567890, 1.2f);
        data.put(0, 2.3f);
        data.put(4567890, -3.4f);
        data.put(0, -4.5f);
        data.put(1, -5.6f);
        data.put(1, Float.POSITIVE_INFINITY);
        data.put(-1, Float.NEGATIVE_INFINITY);
        data.put(0, Float.MIN_VALUE);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            IntFloatMap data2 = fury.deserializeJavaObject(bytes, IntFloatMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntIntMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntIntMap.class, new IntIntMapSerializer(fury));

        IntIntMap data = new IntIntMap();
        data.put(-1234567890, 12);
        data.put(0, 23);
        data.put(4567890, -34);
        data.put(0, -45);
        data.put(1, -56);
        data.put(1, 67);
        data.put(-1, -78);
        data.put(0, 89);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            IntIntMap data2 = fury.deserializeJavaObject(bytes, IntIntMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongArray.class, new LongArraySerializer(fury));

        LongArray data = LongArray.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fury.serializeJavaObject(data);
        LongArray data2 = fury.deserializeJavaObject(bytes, LongArray.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testLongQueue() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongQueue.class, new LongQueueSerializer(fury));

        LongQueue data = new LongQueue();
        for(long item : new long[]{-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0}) {
            data.addLast(item);
        }

        byte[] bytes = fury.serializeJavaObject(data);
        LongQueue data2 = fury.deserializeJavaObject(bytes, LongQueue.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testLongMap() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongMap.class, new LongMapSerializer(fury));

        LongMap<Float> data = new LongMap<>();
        data.put(-1234567890L, 1.2f);
        data.put(0L, 2.3f);
        data.put(4567890123456789L, -3.4f);
        data.put(0, -4.5f);
        data.put(1L, -5.6f);
        data.put(1, 6.7f);
        data.put(-1, -7.8f);
        data.put(0, 8.9f);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            LongMap<?> data2 = fury.deserializeJavaObject(bytes, LongMap.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testShortArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ShortArray.class, new ShortArraySerializer(fury));

        ShortArray data = ShortArray.with(new short[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data);
        ShortArray data2 = fury.deserializeJavaObject(bytes, ShortArray.class);
        Assert.assertEquals(data, data2);
    }
}
