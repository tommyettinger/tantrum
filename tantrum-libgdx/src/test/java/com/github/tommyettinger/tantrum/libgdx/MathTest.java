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

package com.github.tommyettinger.tantrum.libgdx;

import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.*;
import org.apache.fury.Fury;
import org.apache.fury.config.Language;
import org.junit.Assert;
import org.junit.Test;

public class MathTest {
    @Test
    public void testGridPoint2() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(GridPoint2.class, new GridPoint2Serializer(fury));

        GridPoint2[] testing = {new GridPoint2(0, 0), new GridPoint2(1, 0), new GridPoint2(0, 1),
                new GridPoint2(-1, -1), new GridPoint2(9999, 9999), new GridPoint2(9999, -9999),
                new GridPoint2(0x7FFFFFFF, 0x7FFFFFFF), new GridPoint2(0x80000000, 0x80000000)};

        for (GridPoint2 data : testing) {
            byte[] bytes = fury.serializeJavaObject(data);
            GridPoint2 data2 = fury.deserializeJavaObject(bytes, GridPoint2.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testGridPoint3() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(GridPoint3.class, new GridPoint3Serializer(fury));

        GridPoint3[] testing = {new GridPoint3(0, 0, 0), new GridPoint3(1, 0, 0), new GridPoint3(0, 1, 0),
                new GridPoint3(0, 0, 1), new GridPoint3(1, 1, 1),
                new GridPoint3(-1, -1, -1), new GridPoint3(9999, 9999, 9999), new GridPoint3(9999, -9999, 0),
                new GridPoint3(0x7FFFFFFF, 0x7FFFFFFF, 0x7FFFFFFF), new GridPoint3(0x80000000, 0x80000000, 0x80000000)};

        for (GridPoint3 data : testing) {
            byte[] bytes = fury.serializeJavaObject(data);
            GridPoint3 data2 = fury.deserializeJavaObject(bytes, GridPoint3.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testVector2() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Vector2.class, new Vector2Serializer(fury));

        Vector2[] testing = {new Vector2(0, 0), new Vector2(-0f, -0f), new Vector2(1, 0), new Vector2(0, 1),
                new Vector2(-1, -1), new Vector2(9999.9f, 9999.9f), new Vector2(9999.9f, -9999.9f),
                new Vector2(Float.NaN, Float.NaN), new Vector2(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY),
                new Vector2(Float.MIN_VALUE, Float.MIN_VALUE), new Vector2(-Float.MIN_VALUE, -Float.MIN_VALUE),
                new Vector2(0x7FF.FFp-5f, 0x7FF.FFp-5f), new Vector2(-0x7FF.FFp-5f, -0x7FF.FFp-5f)};

        for (Vector2 data : testing) {
            byte[] bytes = fury.serializeJavaObject(data);
            Vector2 data2 = fury.deserializeJavaObject(bytes, Vector2.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testVector3() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Vector3.class, new Vector3Serializer(fury));

        Vector3[] testing = {
                new Vector3(0, 0, 0),
                new Vector3(-0f, -0f, -0f),
                new Vector3(1, 0, 0),
                new Vector3(0, 1, 0),
                new Vector3(0, 0, 1),
                new Vector3(1, 1, 1),
                new Vector3(-1, -1, -1),
                new Vector3(9999.9f, 9999.9f, 9999.9f),
                new Vector3(9999.9f, -9999.9f, 0),
                new Vector3(Float.NaN, Float.NaN, Float.NaN),
                new Vector3(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN),
                new Vector3(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE),
                new Vector3(-Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE),
                new Vector3(0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f), new Vector3(-0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f)};

        for (Vector3 data : testing) {
            byte[] bytes = fury.serializeJavaObject(data);
            Vector3 data2 = fury.deserializeJavaObject(bytes, Vector3.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testVector4() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Vector4.class, new Vector4Serializer(fury));

        Vector4[] testing = {
                new Vector4(0, 0, 0, 0),
                new Vector4(-0f, -0f, -0f, -0f),
                new Vector4(1, 0, 0, 0),
                new Vector4(0, 1, 0, 0),
                new Vector4(0, 0, 1, 0),
                new Vector4(0, 0, 0, 1),
                new Vector4(1, 1, 1, 1),
                new Vector4(-1, -1, -1, -1),
                new Vector4(9999.9f, 9999.9f, 9999.9f, 9999.9f),
                new Vector4(9999.9f, -9999.9f, 0, -0f),
                new Vector4(Float.NaN, Float.NaN, Float.NaN, Float.NaN),
                new Vector4(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE),
                new Vector4(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE),
                new Vector4(-Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE),
                new Vector4(0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f),
                new Vector4(-0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f)};

        for (Vector4 data : testing) {
            byte[] bytes = fury.serializeJavaObject(data);
            Vector4 data2 = fury.deserializeJavaObject(bytes, Vector4.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testQuaternion() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Quaternion.class, new QuaternionSerializer(fury));

        Quaternion[] testing = {
                new Quaternion(0, 0, 0, 0),
                new Quaternion(-0f, -0f, -0f, -0f),
                new Quaternion(1, 0, 0, 0),
                new Quaternion(0, 1, 0, 0),
                new Quaternion(0, 0, 1, 0),
                new Quaternion(0, 0, 0, 1),
                new Quaternion(1, 1, 1, 1),
                new Quaternion(-1, -1, -1, -1),
                new Quaternion(9999.9f, 9999.9f, 9999.9f, 9999.9f),
                new Quaternion(9999.9f, -9999.9f, 0, -0f),
                new Quaternion(Float.NaN, Float.NaN, Float.NaN, Float.NaN),
                new Quaternion(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE),
                new Quaternion(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE),
                new Quaternion(-Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE),
                new Quaternion(0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f),
                new Quaternion(-0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f)};

        for (Quaternion data : testing) {
            byte[] bytes = fury.serializeJavaObject(data);
            Quaternion data2 = fury.deserializeJavaObject(bytes, Quaternion.class);
            Assert.assertEquals(data, data2);
        }
    }

    @Test
    public void testRandomXS128() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(RandomXS128.class, new RandomXS128Serializer(fury));

        RandomXS128 data = new RandomXS128(-12345L);

        byte[] bytes = fury.serializeJavaObject(data);
        RandomXS128 data2 = fury.deserializeJavaObject(bytes, RandomXS128.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        // RandomXS128 does not implement equals().
//        Assert.assertEquals(data, data2);
        Assert.assertEquals(data.getState(0), data2.getState(0));
        Assert.assertEquals(data.getState(1), data2.getState(1));

    }

    @Test
    public void testMatrix3() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Matrix3.class, new Matrix3Serializer(fury));

        Matrix3 data = new Matrix3().scale(2.1f, 3.3f).rotateRad(2f);

        byte[] bytes = fury.serializeJavaObject(data);
        Matrix3 data2 = fury.deserializeJavaObject(bytes, Matrix3.class);
        // Matrix3 does not implement equals().
//        Assert.assertEquals(data, data2);
        Assert.assertArrayEquals(data.val, data2.val, 0.00001f);
    }

    @Test
    public void testMatrix4() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Matrix4.class, new Matrix4Serializer(fury));

        Matrix4 data = new Matrix4().scale(2.1f, 3.3f, 4.6f).rotateRad(-1.1f, -2.2f, -3.3f, 99.9f);

        byte[] bytes = fury.serializeJavaObject(data);
        Matrix4 data2 = fury.deserializeJavaObject(bytes, Matrix4.class);
        // Matrix4 does not implement equals().
//        Assert.assertEquals(data, data2);
        Assert.assertArrayEquals(data.val, data2.val, 0.00001f);
    }
}
