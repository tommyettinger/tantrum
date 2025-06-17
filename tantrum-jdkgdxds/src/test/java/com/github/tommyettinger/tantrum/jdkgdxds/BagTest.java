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

public class BagTest {
    @Test
    public void testObjectBag() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectBag.class, new ObjectBagSerializer(fory));

        ObjectBag<String> data = ObjectBag.with("-123.123", "0", "Four-Fifty Six", "0", "1.0", "-1.0", "0.000001");

        byte[] bytes = fory.serializeJavaObject(data);
        ObjectBag<?> data2 = fory.deserializeJavaObject(bytes, ObjectBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testIntBag() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntBag.class, new IntBagSerializer(fory));

        IntBag data = IntBag.with(-123, 0, 456, 0, 1, -1, 0x80000000);

        byte[] bytes = fory.serializeJavaObject(data);
        IntBag data2 = fory.deserializeJavaObject(bytes, IntBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testLongBag() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongBag.class, new LongBagSerializer(fory));

        LongBag data = LongBag.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fory.serializeJavaObject(data);
        LongBag data2 = fory.deserializeJavaObject(bytes, LongBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testShortBag() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ShortBag.class, new ShortBagSerializer(fory));

        ShortBag data = ShortBag.with(new short[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fory.serializeJavaObject(data);
        ShortBag data2 = fory.deserializeJavaObject(bytes, ShortBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testByteBag() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ByteBag.class, new ByteBagSerializer(fory));

        ByteBag data = ByteBag.with(new byte[]{-123, 0, 45, 0, 1, -1, 0});

        byte[] bytes = fory.serializeJavaObject(data);
        ByteBag data2 = fory.deserializeJavaObject(bytes, ByteBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testFloatBag() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(FloatBag.class, new FloatBagSerializer(fory));

        FloatBag data = FloatBag.with(-123.123f, 0f, 456.456f, 0, 1f, -1f, 0.000001f);

        byte[] bytes = fory.serializeJavaObject(data);
        FloatBag data2 = fory.deserializeJavaObject(bytes, FloatBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testDoubleBag() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(DoubleBag.class, new DoubleBagSerializer(fory));

        DoubleBag data = DoubleBag.with(-123.123, 0, 456.456, 0, 1.0, -1.0, 0.000001);

        byte[] bytes = fory.serializeJavaObject(data);
        DoubleBag data2 = fory.deserializeJavaObject(bytes, DoubleBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testBooleanBag() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(BooleanBag.class, new BooleanBagSerializer(fory));

        BooleanBag data = BooleanBag.with(true, false, false, true, false, true, false);

        byte[] bytes = fory.serializeJavaObject(data);
        BooleanBag data2 = fory.deserializeJavaObject(bytes, BooleanBag.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testCharBag() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CharBag.class, new CharBagSerializer(fory));

        CharBag data = CharBag.with("Hello, World!".toCharArray());


        byte[] bytes = fory.serializeJavaObject(data);
        CharBag data2 = fory.deserializeJavaObject(bytes, CharBag.class);
        Assert.assertEquals(data, data2);
    }
}
