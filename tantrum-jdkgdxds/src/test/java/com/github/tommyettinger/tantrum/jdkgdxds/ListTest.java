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
import org.apache.fury.logging.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;

public class ListTest {
    @Test
    public void testObjectList() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectList.class, new ObjectListSerializer(fury));

        ObjectList<String> data = ObjectList.with("-123.123", "0", "Four-Fifty Six", "0", "1.0", "-1.0", "0.000001");

        byte[] bytes = fury.serializeJavaObject(data);
        ObjectList<?> data2 = fury.deserializeJavaObject(bytes, ObjectList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testIntList() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntList.class, new IntListSerializer(fury));
        
        IntList data = IntList.with(-123, 0, 456, 0, 1, -1, 0x80000000);

        byte[] bytes = fury.serializeJavaObject(data);
        IntList data2 = fury.deserializeJavaObject(bytes, IntList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testLongList() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongList.class, new LongListSerializer(fury));

        LongList data = LongList.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fury.serializeJavaObject(data);
        LongList data2 = fury.deserializeJavaObject(bytes, LongList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testShortList() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ShortList.class, new ShortListSerializer(fury));

        ShortList data = ShortList.with(new short[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data);
        ShortList data2 = fury.deserializeJavaObject(bytes, ShortList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testByteList() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ByteList.class, new ByteListSerializer(fury));

        ByteList data = ByteList.with(new byte[]{-123, 0, 45, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data);
        ByteList data2 = fury.deserializeJavaObject(bytes, ByteList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testFloatList() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(FloatList.class, new FloatListSerializer(fury));

        FloatList data = FloatList.with(-123.123f, 0f, 456.456f, 0, 1f, -1f, 0.000001f);
        
        byte[] bytes = fury.serializeJavaObject(data);
        FloatList data2 = fury.deserializeJavaObject(bytes, FloatList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testDoubleList() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(DoubleList.class, new DoubleListSerializer(fury));

        DoubleList data = DoubleList.with(-123.123, 0, 456.456, 0, 1.0, -1.0, 0.000001);

        byte[] bytes = fury.serializeJavaObject(data);
        DoubleList data2 = fury.deserializeJavaObject(bytes, DoubleList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testBooleanList() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(BooleanList.class, new BooleanListSerializer(fury));

        BooleanList data = BooleanList.with(true, false, false, true, false, true, false);

        byte[] bytes = fury.serializeJavaObject(data);
        BooleanList data2 = fury.deserializeJavaObject(bytes, BooleanList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testCharList() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(CharList.class, new CharListSerializer(fury));

        CharList data = CharList.with("Hello, World!".toCharArray());


        byte[] bytes = fury.serializeJavaObject(data);
        CharList data2 = fury.deserializeJavaObject(bytes, CharList.class);
        Assert.assertEquals(data, data2);
    }
}
