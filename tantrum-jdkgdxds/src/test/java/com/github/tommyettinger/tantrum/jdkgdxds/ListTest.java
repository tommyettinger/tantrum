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

public class ListTest {
    @Test
    public void testObjectList() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectList.class, new ObjectListSerializer(fory));

        ObjectList<String> data = ObjectList.with("-123.123", "0", "Four-Fifty Six", "0", "1.0", "-1.0", "0.000001");

        byte[] bytes = fory.serializeJavaObject(data);
        ObjectList<?> data2 = fory.deserializeJavaObject(bytes, ObjectList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testIntList() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntList.class, new IntListSerializer(fory));
        
        IntList data = IntList.with(-123, 0, 456, 0, 1, -1, 0x80000000);

        byte[] bytes = fory.serializeJavaObject(data);
        IntList data2 = fory.deserializeJavaObject(bytes, IntList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testLongList() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongList.class, new LongListSerializer(fory));

        LongList data = LongList.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fory.serializeJavaObject(data);
        LongList data2 = fory.deserializeJavaObject(bytes, LongList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testShortList() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ShortList.class, new ShortListSerializer(fory));

        ShortList data = ShortList.with(new short[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fory.serializeJavaObject(data);
        ShortList data2 = fory.deserializeJavaObject(bytes, ShortList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testByteList() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ByteList.class, new ByteListSerializer(fory));

        ByteList data = ByteList.with(new byte[]{-123, 0, 45, 0, 1, -1, 0});

        byte[] bytes = fory.serializeJavaObject(data);
        ByteList data2 = fory.deserializeJavaObject(bytes, ByteList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testFloatList() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(FloatList.class, new FloatListSerializer(fory));

        FloatList data = FloatList.with(-123.123f, 0f, 456.456f, 0, 1f, -1f, 0.000001f);
        
        byte[] bytes = fory.serializeJavaObject(data);
        FloatList data2 = fory.deserializeJavaObject(bytes, FloatList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testDoubleList() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(DoubleList.class, new DoubleListSerializer(fory));

        DoubleList data = DoubleList.with(-123.123, 0, 456.456, 0, 1.0, -1.0, 0.000001);

        byte[] bytes = fory.serializeJavaObject(data);
        DoubleList data2 = fory.deserializeJavaObject(bytes, DoubleList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testBooleanList() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(BooleanList.class, new BooleanListSerializer(fory));

        BooleanList data = BooleanList.with(true, false, false, true, false, true, false);

        byte[] bytes = fory.serializeJavaObject(data);
        BooleanList data2 = fory.deserializeJavaObject(bytes, BooleanList.class);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testCharList() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CharList.class, new CharListSerializer(fory));

        CharList data = CharList.with("Hello, World!".toCharArray());


        byte[] bytes = fory.serializeJavaObject(data);
        CharList data2 = fory.deserializeJavaObject(bytes, CharList.class);
        Assert.assertEquals(data, data2);
    }
}
