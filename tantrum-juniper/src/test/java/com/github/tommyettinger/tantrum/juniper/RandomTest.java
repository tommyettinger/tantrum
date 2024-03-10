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

package com.github.tommyettinger.tantrum.juniper;

//import com.github.tommyettinger.digital.Interpolations;

import com.github.tommyettinger.random.*;
import io.fury.Fury;
import io.fury.config.Language;
import org.junit.Assert;
import org.junit.Test;

public class RandomTest {
    @Test
    public void testDistinctRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(DistinctRandom.class, new DistinctRandomSerializer(fury));

        DistinctRandom data = new DistinctRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        DistinctRandom data2 = fury.deserializeJavaObject(bytes, DistinctRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }
    @Test
    public void testVanDerCorputQuasiRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(VanDerCorputQuasiRandom.class, new VanDerCorputQuasiRandomSerializer(fury));

        VanDerCorputQuasiRandom data = new VanDerCorputQuasiRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        VanDerCorputQuasiRandom data2 = fury.deserializeJavaObject(bytes, VanDerCorputQuasiRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testGoldenQuasiRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(GoldenQuasiRandom.class, new GoldenQuasiRandomSerializer(fury));

        GoldenQuasiRandom data = new GoldenQuasiRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        GoldenQuasiRandom data2 = fury.deserializeJavaObject(bytes, GoldenQuasiRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testLowChangeQuasiRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LowChangeQuasiRandom.class, new LowChangeQuasiRandomSerializer(fury));

        LowChangeQuasiRandom data = new LowChangeQuasiRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        LowChangeQuasiRandom data2 = fury.deserializeJavaObject(bytes, LowChangeQuasiRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testTupleQuasiRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(TupleQuasiRandom.class, new TupleQuasiRandomSerializer(fury));

        TupleQuasiRandom data = new TupleQuasiRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        TupleQuasiRandom data2 = fury.deserializeJavaObject(bytes, TupleQuasiRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testLaserRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(LaserRandom.class, new LaserRandomSerializer(fury));

        LaserRandom data = new LaserRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        LaserRandom data2 = fury.deserializeJavaObject(bytes, LaserRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testMizuchiRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(MizuchiRandom.class, new MizuchiRandomSerializer(fury));

        MizuchiRandom data = new MizuchiRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        MizuchiRandom data2 = fury.deserializeJavaObject(bytes, MizuchiRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testFlowRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(FlowRandom.class, new FlowRandomSerializer(fury));

        FlowRandom data = new FlowRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        FlowRandom data2 = fury.deserializeJavaObject(bytes, FlowRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testRomuTrioRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(RomuTrioRandom.class, new RomuTrioRandomSerializer(fury));

        RomuTrioRandom data = new RomuTrioRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        RomuTrioRandom data2 = fury.deserializeJavaObject(bytes, RomuTrioRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testTricycleRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(TricycleRandom.class, new TricycleRandomSerializer(fury));

        TricycleRandom data = new TricycleRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        TricycleRandom data2 = fury.deserializeJavaObject(bytes, TricycleRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testFourWheelRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(FourWheelRandom.class, new FourWheelRandomSerializer(fury));

        FourWheelRandom data = new FourWheelRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        FourWheelRandom data2 = fury.deserializeJavaObject(bytes, FourWheelRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testStrangerRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(StrangerRandom.class, new StrangerRandomSerializer(fury));

        StrangerRandom data = new StrangerRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        StrangerRandom data2 = fury.deserializeJavaObject(bytes, StrangerRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testTrimRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(TrimRandom.class, new TrimRandomSerializer(fury));

        TrimRandom data = new TrimRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        TrimRandom data2 = fury.deserializeJavaObject(bytes, TrimRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testWhiskerRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(WhiskerRandom.class, new WhiskerRandomSerializer(fury));

        WhiskerRandom data = new WhiskerRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        WhiskerRandom data2 = fury.deserializeJavaObject(bytes, WhiskerRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testScruffRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ScruffRandom.class, new ScruffRandomSerializer(fury));

        ScruffRandom data = new ScruffRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        ScruffRandom data2 = fury.deserializeJavaObject(bytes, ScruffRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testPouchRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(PouchRandom.class, new PouchRandomSerializer(fury));

        PouchRandom data = new PouchRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        PouchRandom data2 = fury.deserializeJavaObject(bytes, PouchRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testSfc64Random() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Sfc64Random.class, new Sfc64RandomSerializer(fury));

        Sfc64Random data = new Sfc64Random(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        Sfc64Random data2 = fury.deserializeJavaObject(bytes, Sfc64Random.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testPasarRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(PasarRandom.class, new PasarRandomSerializer(fury));

        PasarRandom data = new PasarRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        PasarRandom data2 = fury.deserializeJavaObject(bytes, PasarRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testCrand64Random() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Crand64Random.class, new Crand64RandomSerializer(fury));

        Crand64Random data = new Crand64Random(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        Crand64Random data2 = fury.deserializeJavaObject(bytes, Crand64Random.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testAceRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(AceRandom.class, new AceRandomSerializer(fury));

        AceRandom data = new AceRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        AceRandom data2 = fury.deserializeJavaObject(bytes, AceRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testXoshiro256StarStarRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Xoshiro256StarStarRandom.class, new Xoshiro256StarStarRandomSerializer(fury));

        Xoshiro256StarStarRandom data = new Xoshiro256StarStarRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        Xoshiro256StarStarRandom data2 = fury.deserializeJavaObject(bytes, Xoshiro256StarStarRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testXoshiro256MX3Random() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Xoshiro256MX3Random.class, new Xoshiro256MX3RandomSerializer(fury));

        Xoshiro256MX3Random data = new Xoshiro256MX3Random(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        Xoshiro256MX3Random data2 = fury.deserializeJavaObject(bytes, Xoshiro256MX3Random.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testXoroshiro128StarStarRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Xoroshiro128StarStarRandom.class, new Xoroshiro128StarStarRandomSerializer(fury));

        Xoroshiro128StarStarRandom data = new Xoroshiro128StarStarRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        Xoroshiro128StarStarRandom data2 = fury.deserializeJavaObject(bytes, Xoroshiro128StarStarRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testChopRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ChopRandom.class, new ChopRandomSerializer(fury));

        ChopRandom data = new ChopRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        ChopRandom data2 = fury.deserializeJavaObject(bytes, ChopRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testJsf32Random() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Jsf32Random.class, new Jsf32RandomSerializer(fury));

        Jsf32Random data = new Jsf32Random(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        Jsf32Random data2 = fury.deserializeJavaObject(bytes, Jsf32Random.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testXoshiro128PlusPlusRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Xoshiro128PlusPlusRandom.class, new Xoshiro128PlusPlusRandomSerializer(fury));

        Xoshiro128PlusPlusRandom data = new Xoshiro128PlusPlusRandom(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        Xoshiro128PlusPlusRandom data2 = fury.deserializeJavaObject(bytes, Xoshiro128PlusPlusRandom.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        Assert.assertEquals(data, data2);
    }

//    @Test
//    public void testInterpolatedRandom() {
//        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        fury.registerSerializer(InterpolatedRandom.class, new InterpolatedRandomSerializer(fury));
//
//        InterpolatedRandom random = new InterpolatedRandom(Interpolations.kumaraswamyExtremeB,
//                new DistinctRandom(123L));
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//        Output output = new Output(baos);
//        kryo.writeObject(output, random);
//        byte[] bytes = output.toBytes();
//        try (Input input = new Input(bytes)) {
//            InterpolatedRandom data2 = fury.deserializeJavaObject(bytes, InterpolatedRandom.class);
//            Assert.assertEquals(random.nextDouble(), data2.nextDouble(), 0x1p-32);
//            Assert.assertEquals(random.nextDouble(), data2.nextDouble(), 0x1p-32);
//            Assert.assertTrue(EnhancedRandom.areEqual(random, data2));
//        }
//    }
//
//
//    @Test
//    public void testKnownSequenceRandom() {
//        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        KnownSequenceRandomSerializer ser = new KnownSequenceRandomSerializer();
//        kryo.register(KnownSequenceRandom.class, ser);
//
//        KnownSequenceRandom data = new KnownSequenceRandom(LongSequence.with(0L, 1L, -2L, -3L, 4L, 5L));
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//        Output output = new Output(baos);
//        kryo.writeObject(output, data, ser);
//        byte[] bytes = output.toBytes();
//        try (Input input = new Input(bytes)) {
//            KnownSequenceRandom data2 = fury.deserializeJavaObject(bytes, KnownSequenceRandom.class);
//            Assert.assertEquals(data.nextInt(), data2.nextInt());
//            Assert.assertEquals(data.nextLong(), data2.nextLong());
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testReverseWrapper() {
//        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        ReverseWrapperSerializer ser = new ReverseWrapperSerializer();
//        kryo.register(ReverseWrapper.class, ser);
//
//        ReverseWrapper data = new ReverseWrapper(new DistinctRandom(-12345L));
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//        Output output = new Output(baos);
//        kryo.writeObject(output, data, ser);
//        byte[] bytes = output.toBytes();
//        try (Input input = new Input(bytes)) {
//            ReverseWrapper data2 = fury.deserializeJavaObject(bytes, ReverseWrapper.class);
//            Assert.assertEquals(data.nextInt(), data2.nextInt());
//            Assert.assertEquals(data.nextLong(), data2.nextLong());
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testArchivalWrapper() {
//        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        ArchivalWrapperSerializer ser = new ArchivalWrapperSerializer();
//        kryo.register(ArchivalWrapper.class, ser);
//
//        ArchivalWrapper data = new ArchivalWrapper(new DistinctRandom(-12345L));
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//        Output output = new Output(baos);
//        kryo.writeObject(output, data, ser);
//        byte[] bytes = output.toBytes();
//        try (Input input = new Input(bytes)) {
//            ArchivalWrapper data2 = fury.deserializeJavaObject(bytes, ArchivalWrapper.class);
////            System.out.println("data...");
////            System.out.println(data);
////            System.out.println("vs. data2...");
////            System.out.println(data2);
//            Assert.assertEquals(data.nextInt(), data2.nextInt());
//            Assert.assertEquals(data.nextLong(), data2.nextLong());
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testEnhancedRandom() {
//        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        EnhancedRandomSerializer ser = new EnhancedRandomSerializer();
//        kryo.register(EnhancedRandom.class, ser);
//
//        EnhancedRandom data = new Xoshiro128PlusPlusRandom(-12345L);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//        Output output = new Output(baos);
//        kryo.writeObject(output, data, ser);
//        byte[] bytes = output.toBytes();
//        try (Input input = new Input(bytes)) {
//            EnhancedRandom data2 = fury.deserializeJavaObject(bytes, EnhancedRandom.class);
//            Assert.assertEquals(data.nextInt(), data2.nextInt());
//            Assert.assertEquals(data.nextLong(), data2.nextLong());
//            Assert.assertEquals(data, data2);
//        }
//    }
//
//    @Test
//    public void testLongSequence() {
//        Kryo kryo = new Kryo();
//        kryo.register(LongSequence.class, new LongSequenceSerializer());
//
//        LongSequence data = LongSequence.with(-1234567890L, 0L, 4567890123456789L, 0, 1L, 1, -1, 0);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//        Output output = new Output(baos);
//        kryo.writeObject(output, data);
//        byte[] bytes = output.toBytes();
//        try (Input input = new Input(bytes)) {
//            LongSequence data2 = kryo.readObject(input, LongSequence.class);
//            Assert.assertEquals(data, data2);
//        }
//    }
}
