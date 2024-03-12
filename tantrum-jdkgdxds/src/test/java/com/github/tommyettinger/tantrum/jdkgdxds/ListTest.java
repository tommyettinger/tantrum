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

public class ListTest {
//    @Test
//    public void testObjectList() {
//        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        kryo.register(ObjectList.class, new ObjectListSerializer());
//
//        ObjectList<String> data = ObjectList.with("-123.123", "0", "Four-Fifty Six", "0", "1.0", "-1.0", "0.000001");
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//        Output output = new Output(baos);
//        kryo.writeObject(output, data);
//        byte[] bytes = output.toBytes();
//        try (Input input = new Input(bytes)) {
//            ObjectList data2 = kryo.readObject(input, ObjectList.class);
//            Assert.assertEquals(data, data2);
//        }
//    }

    @Test
    public void testIntList() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntList.class, new IntListSerializer(fury));
        
        IntList data = IntList.with(-123, 0, 456, 0, 1, -1, 0x80000000);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            IntList data2 = fury.deserializeJavaObject(bytes, IntList.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongList() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongList.class, new LongListSerializer(fury));

        LongList data = LongList.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            LongList data2 = fury.deserializeJavaObject(bytes, LongList.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testShortList() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ShortList.class, new ShortListSerializer(fury));

        ShortList data = ShortList.with(new short[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data);
        {
            ShortList data2 = fury.deserializeJavaObject(bytes, ShortList.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testByteList() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ByteList.class, new ByteListSerializer(fury));

        ByteList data = ByteList.with(new byte[]{-123, 0, 45, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data);
        {
            ByteList data2 = fury.deserializeJavaObject(bytes, ByteList.class);
            Assert.assertEquals(data, data2);
        }
    }

//    @Test
//    public void testFloatList() {
//        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        kryo.register(FloatList.class, new FloatListSerializer());
//
//        FloatList data = FloatList.with(-123.123f, 0f, 456.456f, 0, 1f, -1f, 0.000001f);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//        Output output = new Output(baos);
//        kryo.writeObject(output, data);
//        byte[] bytes = output.toBytes();
//        try (Input input = new Input(bytes)) {
//            FloatList data2 = kryo.readObject(input, FloatList.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testDoubleList() {
//        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        kryo.register(DoubleList.class, new DoubleListSerializer());
//
//        DoubleList data = DoubleList.with(-123.123, 0, 456.456, 0, 1.0, -1.0, 0.000001);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//        Output output = new Output(baos);
//        kryo.writeObject(output, data);
//        byte[] bytes = output.toBytes();
//        try (Input input = new Input(bytes)) {
//            DoubleList data2 = kryo.readObject(input, DoubleList.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
//
    @Test
    public void testBooleanList() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(BooleanList.class, new BooleanListSerializer(fury));

        BooleanList data = BooleanList.with(true, false, false, true, false, true, false);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            BooleanList data2 = fury.deserializeJavaObject(bytes, BooleanList.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCharList() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(CharList.class, new CharListSerializer(fury));

        CharList data = CharList.with("Hello, World!".toCharArray());


        byte[] bytes = fury.serializeJavaObject(data);
        {
            CharList data2 = fury.deserializeJavaObject(bytes, CharList.class);
            Assert.assertEquals(data, data2);
        }
    }
}
