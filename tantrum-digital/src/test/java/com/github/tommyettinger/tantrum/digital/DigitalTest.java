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

package com.github.tommyettinger.tantrum.digital;

import com.github.tommyettinger.digital.*;
import io.fury.Fury;
import io.fury.config.Language;
import io.fury.memory.MemoryBuffer;
import org.junit.Assert;
import org.junit.Test;

public class DigitalTest {
//    @Test
//    public void testBase() {
//        Kryo kryo = new Kryo();
//        kryo.register(Base.class, new BaseSerializer());
//
//        Base data = Base.scrambledBase(new Random(123456789L));
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//        Output output = new Output(baos);
//        kryo.writeObject(output, data);
//        byte[] bytes = output.toBytes();
//        try (Input input = new Input(bytes)) {
//            Base data2 = kryo.readObject(input, Base.class);
//            Assert.assertEquals(data.signed(0xFEDCBA9876543210L), data2.signed(0xFEDCBA9876543210L));
//            Assert.assertEquals(data.unsigned(0xFEDCBA9876543210L), data.unsigned(0xFEDCBA9876543210L));
//            Assert.assertEquals(data, data2);
//        }
//    }

    @Test
    public void testAlternateRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(AlternateRandom.class, new AlternateRandomSerializer(fury));

        AlternateRandom data = new AlternateRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        AlternateRandom data2 = fury.deserializeJavaObject(bytes, AlternateRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data.serializeToString(), data2.serializeToString());
        // equals() not implemented yet

    }
    @Test
    public void testInterpolator() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Interpolations.Interpolator.class, new InterpolatorSerializer(fury));

        MemoryBuffer buffer = MemoryBuffer.newHeapBuffer(256);
        for (Interpolations.Interpolator data : Interpolations.getInterpolatorArray()) {

            fury.serializeJavaObject(buffer, data);
            Interpolations.Interpolator data2 = fury.deserializeJavaObject(buffer, Interpolations.Interpolator.class);
            Assert.assertEquals(data.apply(0.1f), data2.apply(0.1f), MathTools.FLOAT_ROUNDING_ERROR);
            Assert.assertEquals(data.apply(0.2f), data2.apply(0.2f), MathTools.FLOAT_ROUNDING_ERROR);
            Assert.assertEquals(data.apply(0.7f), data2.apply(0.7f), MathTools.FLOAT_ROUNDING_ERROR);
            Assert.assertEquals(data.apply(0.8f), data2.apply(0.8f), MathTools.FLOAT_ROUNDING_ERROR);
            Assert.assertEquals(data, data2);
        }
    }
}
