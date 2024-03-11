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

import com.github.tommyettinger.random.AceRandom;
import com.github.tommyettinger.random.DistinctRandom;
import com.github.tommyettinger.random.DistributedRandom;
import com.github.tommyettinger.random.EnhancedRandom;
import com.github.tommyettinger.random.distribution.*;
import com.github.tommyettinger.random.distribution.Distribution;
import com.github.tommyettinger.tantrum.juniper.distribution.*;
import com.github.tommyettinger.tantrum.juniper.distribution.DistributionSerializer;
import io.fury.Fury;
import io.fury.config.Language;
import io.fury.serializer.Serializer;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Function;

public class DistributionTest {
    @Test
    public void testDistributions() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(AceRandom.class, new AceRandomSerializer(fury));

        IdentityHashMap<Class<? extends Distribution>, Function<Fury, ? extends Serializer<? extends Distribution>>>
                mapping = new IdentityHashMap<>();
        mapping.put(ArcsineDistribution.class, ArcsineDistributionSerializer::new);
        mapping.put(BernoulliDistribution.class, BernoulliDistributionSerializer::new);
        mapping.put(BetaDistribution.class, BetaDistributionSerializer::new);
        mapping.put(BetaPrimeDistribution.class, BetaPrimeDistributionSerializer::new);
        mapping.put(BinomialDistribution.class, BinomialDistributionSerializer::new);
        mapping.put(CauchyDistribution.class, CauchyDistributionSerializer::new);
        mapping.put(ChiDistribution.class, ChiDistributionSerializer::new);
        mapping.put(ChiSquareDistribution.class, ChiSquareDistributionSerializer::new);
        mapping.put(ContinuousUniformDistribution.class, ContinuousUniformDistributionSerializer::new);
        mapping.put(DiscreteUniformDistribution.class, DiscreteUniformDistributionSerializer::new);
        mapping.put(ErlangDistribution.class, ErlangDistributionSerializer::new);
        mapping.put(ExponentialDistribution.class, ExponentialDistributionSerializer::new);
        mapping.put(FisherSnedecorDistribution.class, FisherSnedecorDistributionSerializer::new);
        mapping.put(FisherTippettDistribution.class, FisherTippettDistributionSerializer::new);
        mapping.put(GammaDistribution.class, GammaDistributionSerializer::new);
        mapping.put(GeometricDistribution.class, GeometricDistributionSerializer::new);
        mapping.put(KnobDistribution.class, KnobDistributionSerializer::new);
        mapping.put(KumaraswamyDistribution.class, KumaraswamyDistributionSerializer::new);
        mapping.put(LaplaceDistribution.class, LaplaceDistributionSerializer::new);
        mapping.put(LogCauchyDistribution.class, LogCauchyDistributionSerializer::new);
        mapping.put(LogisticDistribution.class, LogisticDistributionSerializer::new);
        mapping.put(LogNormalDistribution.class, LogNormalDistributionSerializer::new);
        mapping.put(LumpDistribution.class, LumpDistributionSerializer::new);
        mapping.put(NormalDistribution.class, NormalDistributionSerializer::new);
        mapping.put(ParetoDistribution.class, ParetoDistributionSerializer::new);
        mapping.put(PoissonDistribution.class, PoissonDistributionSerializer::new);
        mapping.put(PowerDistribution.class, PowerDistributionSerializer::new);
        mapping.put(RayleighDistribution.class, RayleighDistributionSerializer::new);
        mapping.put(StudentsTDistribution.class, StudentsTDistributionSerializer::new);
        mapping.put(TriangularDistribution.class, TriangularDistributionSerializer::new);
        mapping.put(WeibullDistribution.class, WeibullDistributionSerializer::new);
        mapping.put(ZipfianDistribution.class, ZipfianDistributionSerializer::new);

//        fury.registerSerializer(EnhancedRandom.class, new EnhancedRandomSerializer(fury));

        for (Map.Entry<Class<? extends Distribution>, Function<Fury, ? extends Serializer<? extends Distribution>>> ent : mapping.entrySet()) {
            fury.registerSerializer(ent.getKey(), ent.getValue().apply(fury));

            Distribution data = ent.getKey().getDeclaredConstructor().newInstance();

            byte[] bytes = fury.serializeJavaObject(data);
            Distribution data2 = fury.deserializeJavaObject(bytes, ent.getKey());
            Assert.assertEquals(data.nextDouble(), data2.nextDouble(), 0.0000001);
            Assert.assertEquals(data.nextDouble(), data2.nextDouble(), 0.0000001);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testDistribution() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(AceRandom.class, new AceRandomSerializer(fury));
        fury.registerSerializer(ArcsineDistribution.class, new DistributionSerializer(fury));
        fury.registerSerializer(Distribution.class, new DistributionSerializer(fury));

        Distribution data = new ArcsineDistribution(new DistinctRandom(123L), 0.5, 0.9);

        byte[] bytes = fury.serializeJavaObject(data);
        Distribution data2 = fury.deserializeJavaObject(bytes, Distribution.class);
        Assert.assertEquals(data.nextDouble(), data2.nextDouble(), 0x1p-32);
        Assert.assertEquals(data.nextDouble(), data2.nextDouble(), 0x1p-32);
        Assert.assertEquals(data, data2);
    }

    @Test
    public void testDistributedRandom() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(DistributedRandom.class, new DistributedRandomSerializer(fury));


        DistributedRandom data = new DistributedRandom(
                new KumaraswamyDistribution(new DistinctRandom(123L), 2.5, 2.0), DistributedRandom.ReductionMode.FRACTION);

        byte[] bytes = fury.serializeJavaObject(data);
        DistributedRandom data2 = fury.deserializeJavaObject(bytes, DistributedRandom.class);
        Assert.assertEquals(data.nextDouble(), data2.nextDouble(), 0x1p-32);
        Assert.assertEquals(data.nextDouble(), data2.nextDouble(), 0x1p-32);
        Assert.assertTrue(EnhancedRandom.areEqual(data, data2));
    }
}
