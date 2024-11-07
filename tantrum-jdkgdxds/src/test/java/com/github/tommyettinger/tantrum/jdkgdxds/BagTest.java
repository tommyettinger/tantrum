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

public class BagTest {
    @Test
    public void testObjectBag() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectBag.class, new ObjectBagSerializer(fury));

        ObjectBag<String> data = ObjectBag.with("-123.123", "0", "Four-Fifty Six", "0", "1.0", "-1.0", "0.000001");

        byte[] bytes = fury.serializeJavaObject(data);
        ObjectBag<?> data2 = fury.deserializeJavaObject(bytes, ObjectBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testIntBag() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntBag.class, new IntBagSerializer(fury));

        IntBag data = IntBag.with(-123, 0, 456, 0, 1, -1, 0x80000000);

        byte[] bytes = fury.serializeJavaObject(data);
        IntBag data2 = fury.deserializeJavaObject(bytes, IntBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testLongBag() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongBag.class, new LongBagSerializer(fury));

        LongBag data = LongBag.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fury.serializeJavaObject(data);
        LongBag data2 = fury.deserializeJavaObject(bytes, LongBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testShortBag() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ShortBag.class, new ShortBagSerializer(fury));

        ShortBag data = ShortBag.with(new short[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data);
        ShortBag data2 = fury.deserializeJavaObject(bytes, ShortBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testByteBag() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ByteBag.class, new ByteBagSerializer(fury));

        ByteBag data = ByteBag.with(new byte[]{-123, 0, 45, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data);
        ByteBag data2 = fury.deserializeJavaObject(bytes, ByteBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testFloatBag() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(FloatBag.class, new FloatBagSerializer(fury));

        FloatBag data = FloatBag.with(-123.123f, 0f, 456.456f, 0, 1f, -1f, 0.000001f);

        byte[] bytes = fury.serializeJavaObject(data);
        FloatBag data2 = fury.deserializeJavaObject(bytes, FloatBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testDoubleBag() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(DoubleBag.class, new DoubleBagSerializer(fury));

        DoubleBag data = DoubleBag.with(-123.123, 0, 456.456, 0, 1.0, -1.0, 0.000001);

        byte[] bytes = fury.serializeJavaObject(data);
        DoubleBag data2 = fury.deserializeJavaObject(bytes, DoubleBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testBooleanBag() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(BooleanBag.class, new BooleanBagSerializer(fury));

        BooleanBag data = BooleanBag.with(true, false, false, true, false, true, false);

        byte[] bytes = fury.serializeJavaObject(data);
        BooleanBag data2 = fury.deserializeJavaObject(bytes, BooleanBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testCharBag() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(CharBag.class, new CharBagSerializer(fury));

        CharBag data = CharBag.with("Hello, World!".toCharArray());


        byte[] bytes = fury.serializeJavaObject(data);
        CharBag data2 = fury.deserializeJavaObject(bytes, CharBag.class);
        Assert.assertEquals(data, data2);
    }
}
