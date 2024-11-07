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

public class DequeTest {
    @Test
    public void testObjectDeque() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectDeque.class, new ObjectDequeSerializer(fury));

        ObjectDeque<String> data = ObjectDeque.with("-123.123", "0", "Four-Fifty Six", "0", "1.0", "-1.0", "0.000001");

        byte[] bytes = fury.serializeJavaObject(data); {
            ObjectDeque<?> data2 = fury.deserializeJavaObject(bytes, ObjectDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testIntDeque() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(IntDeque.class, new IntDequeSerializer(fury));

        IntDeque data = IntDeque.with(-123, 0, 456, 0, 1, -1, 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            IntDeque data2 = fury.deserializeJavaObject(bytes, IntDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testLongDeque() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LongDeque.class, new LongDequeSerializer(fury));

        LongDeque data = LongDeque.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);

        byte[] bytes = fury.serializeJavaObject(data); {
            LongDeque data2 = fury.deserializeJavaObject(bytes, LongDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testShortDeque() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ShortDeque.class, new ShortDequeSerializer(fury));

        ShortDeque data = ShortDeque.with(new short[]{-123, 0, 456, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data); {
            ShortDeque data2 = fury.deserializeJavaObject(bytes, ShortDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testByteDeque() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ByteDeque.class, new ByteDequeSerializer(fury));

        ByteDeque data = ByteDeque.with(new byte[]{-123, 0, 45, 0, 1, -1, 0});

        byte[] bytes = fury.serializeJavaObject(data); {
            ByteDeque data2 = fury.deserializeJavaObject(bytes, ByteDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testFloatDeque() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(FloatDeque.class, new FloatDequeSerializer(fury));

        FloatDeque data = FloatDeque.with(-123.123f, 0f, 456.456f, 0, 1f, -1f, 0.000001f);

        byte[] bytes = fury.serializeJavaObject(data); {
            FloatDeque data2 = fury.deserializeJavaObject(bytes, FloatDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testDoubleDeque() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(DoubleDeque.class, new DoubleDequeSerializer(fury));

        DoubleDeque data = DoubleDeque.with(-123.123, 0, 456.456, 0, 1.0, -1.0, 0.000001);

        byte[] bytes = fury.serializeJavaObject(data); {
            DoubleDeque data2 = fury.deserializeJavaObject(bytes, DoubleDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testBooleanDeque() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(BooleanDeque.class, new BooleanDequeSerializer(fury));

        BooleanDeque data = BooleanDeque.with(true, false, false, true, false, true, false);

        byte[] bytes = fury.serializeJavaObject(data); {
            BooleanDeque data2 = fury.deserializeJavaObject(bytes, BooleanDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testCharDeque() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(CharDeque.class, new CharDequeSerializer(fury));

        CharDeque data = CharDeque.with("Hello, World!".toCharArray());

        byte[] bytes = fury.serializeJavaObject(data); {
            CharDeque data2 = fury.deserializeJavaObject(bytes, CharDeque.class);
            Assert.assertEquals(data, data2);
        }
    }

}
