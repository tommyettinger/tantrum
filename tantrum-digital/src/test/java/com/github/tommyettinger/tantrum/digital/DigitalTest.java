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
import org.apache.fory.Fory;
import org.apache.fory.config.Language;
import org.apache.fory.logging.LoggerFactory;
import org.apache.fory.memory.MemoryBuffer;
import org.junit.Assert;
import org.junit.Test;

public class DigitalTest {
    @Test
    public void testBase() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Base.class, new BaseSerializer(fory));

        Base data = Base.scrambledBase(new AlternateRandom(123456789L));

        byte[] bytes = fory.serializeJavaObject(data);
        Base data2 = fory.deserializeJavaObject(bytes, Base.class);
        Assert.assertEquals(data.signed(0xFEDCBA9876543210L), data2.signed(0xFEDCBA9876543210L));
        Assert.assertEquals(data.unsigned(0xFEDCBA9876543210L), data.unsigned(0xFEDCBA9876543210L));
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testAlternateRandom() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(AlternateRandom.class, new AlternateRandomSerializer(fory));

        AlternateRandom data = new AlternateRandom(-12345L);

        byte[] bytes = fory.serializeJavaObject(data);
        AlternateRandom data2 = fory.deserializeJavaObject(bytes, AlternateRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data.serializeToString(), data2.serializeToString());
        // equals() not implemented yet
    }

    @Test
    public void testHasher() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Hasher.class, new HasherSerializer(fory));

        long seed = Hasher.randomize3(System.nanoTime());
        Hasher data = new Hasher(seed);

        byte[] bytes = fory.serializeJavaObject(data);
        Hasher data2 = fory.deserializeJavaObject(bytes, Hasher.class);
        Assert.assertEquals(data.hash("0xFEDCBA9876543210L"), data2.hash("0xFEDCBA9876543210L"));
        Assert.assertEquals(data.hash64("0xFEDCBA9876543210L"), data2.hash64("0xFEDCBA9876543210L"));
    }


    @Test
    public void testInterpolator() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Interpolations.Interpolator.class, new InterpolatorSerializer(fory));

        MemoryBuffer buffer = MemoryBuffer.newHeapBuffer(256);
        for (Interpolations.Interpolator data : Interpolations.getInterpolatorArray()) {

            fory.serializeJavaObject(buffer, data);
            Interpolations.Interpolator data2 = fory.deserializeJavaObject(buffer, Interpolations.Interpolator.class);
            Assert.assertEquals(data.apply(0.1f), data2.apply(0.1f), MathTools.FLOAT_ROUNDING_ERROR);
            Assert.assertEquals(data.apply(0.2f), data2.apply(0.2f), MathTools.FLOAT_ROUNDING_ERROR);
            Assert.assertEquals(data.apply(0.7f), data2.apply(0.7f), MathTools.FLOAT_ROUNDING_ERROR);
            Assert.assertEquals(data.apply(0.8f), data2.apply(0.8f), MathTools.FLOAT_ROUNDING_ERROR);
            Assert.assertEquals(data, data2);
        }
    }
}
