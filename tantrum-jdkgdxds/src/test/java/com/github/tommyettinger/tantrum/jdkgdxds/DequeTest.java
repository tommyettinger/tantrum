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

public class DequeTest {
    @Test
    public void testObjectDeque() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectDeque.class, new ObjectDequeSerializer(fory));

        ObjectDeque<String> data = ObjectDeque.with("-123.123", "0", "Four-Fifty Six", "0", "1.0", "-1.0", "0.000001");

        byte[] bytes = fory.serializeJavaObject(data); {
            ObjectDeque<?> data2 = fory.deserializeJavaObject(bytes, ObjectDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntDeque() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(IntDeque.class, new IntDequeSerializer(fory));

        IntDeque data = IntDeque.with(-123, 0, 456, 0, 1, -1, 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            IntDeque data2 = fory.deserializeJavaObject(bytes, IntDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongDeque() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(LongDeque.class, new LongDequeSerializer(fory));

        LongDeque data = LongDeque.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fory.serializeJavaObject(data); {
            LongDeque data2 = fory.deserializeJavaObject(bytes, LongDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testShortDeque() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ShortDeque.class, new ShortDequeSerializer(fory));

        ShortDeque data = ShortDeque.with(new short[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fory.serializeJavaObject(data); {
            ShortDeque data2 = fory.deserializeJavaObject(bytes, ShortDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testByteDeque() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ByteDeque.class, new ByteDequeSerializer(fory));

        ByteDeque data = ByteDeque.with(new byte[]{-123, 0, 45, 0, 1, -1, 0});

        byte[] bytes = fory.serializeJavaObject(data); {
            ByteDeque data2 = fory.deserializeJavaObject(bytes, ByteDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testFloatDeque() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(FloatDeque.class, new FloatDequeSerializer(fory));

        FloatDeque data = FloatDeque.with(-123.123f, 0f, 456.456f, 0, 1f, -1f, 0.000001f);

        byte[] bytes = fory.serializeJavaObject(data); {
            FloatDeque data2 = fory.deserializeJavaObject(bytes, FloatDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testDoubleDeque() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(DoubleDeque.class, new DoubleDequeSerializer(fory));

        DoubleDeque data = DoubleDeque.with(-123.123, 0, 456.456, 0, 1.0, -1.0, 0.000001);

        byte[] bytes = fory.serializeJavaObject(data); {
            DoubleDeque data2 = fory.deserializeJavaObject(bytes, DoubleDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testBooleanDeque() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(BooleanDeque.class, new BooleanDequeSerializer(fory));

        BooleanDeque data = BooleanDeque.with(true, false, false, true, false, true, false);

        byte[] bytes = fory.serializeJavaObject(data); {
            BooleanDeque data2 = fory.deserializeJavaObject(bytes, BooleanDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCharDeque() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(CharDeque.class, new CharDequeSerializer(fory));

        CharDeque data = CharDeque.with("Hello, World!".toCharArray());

        byte[] bytes = fory.serializeJavaObject(data); {
            CharDeque data2 = fory.deserializeJavaObject(bytes, CharDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

}
