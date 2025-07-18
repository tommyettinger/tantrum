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

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.OrientedBoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.*;
import org.apache.fory.Fory;
import org.apache.fory.config.Language;
import org.apache.fory.logging.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;

public class MathTest {
    @Test
    public void testGridPoint2() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(GridPoint2.class, new GridPoint2Serializer(fory));

        GridPoint2[] testing = {new GridPoint2(0, 0), new GridPoint2(1, 0), new GridPoint2(0, 1),
                new GridPoint2(-1, -1), new GridPoint2(9999, 9999), new GridPoint2(9999, -9999),
                new GridPoint2(0x7FFFFFFF, 0x7FFFFFFF), new GridPoint2(0x80000000, 0x80000000)};

        for (GridPoint2 data : testing) {
            byte[] bytes = fory.serializeJavaObject(data);
            GridPoint2 data2 = fory.deserializeJavaObject(bytes, GridPoint2.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testGridPoint3() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(GridPoint3.class, new GridPoint3Serializer(fory));

        GridPoint3[] testing = {new GridPoint3(0, 0, 0), new GridPoint3(1, 0, 0), new GridPoint3(0, 1, 0),
                new GridPoint3(0, 0, 1), new GridPoint3(1, 1, 1),
                new GridPoint3(-1, -1, -1), new GridPoint3(9999, 9999, 9999), new GridPoint3(9999, -9999, 0),
                new GridPoint3(0x7FFFFFFF, 0x7FFFFFFF, 0x7FFFFFFF), new GridPoint3(0x80000000, 0x80000000, 0x80000000)};

        for (GridPoint3 data : testing) {
            byte[] bytes = fory.serializeJavaObject(data);
            GridPoint3 data2 = fory.deserializeJavaObject(bytes, GridPoint3.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testVector2() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Vector2.class, new Vector2Serializer(fory));

        Vector2[] testing = {new Vector2(0, 0), new Vector2(-0f, -0f), new Vector2(1, 0), new Vector2(0, 1),
                new Vector2(-1, -1), new Vector2(9999.9f, 9999.9f), new Vector2(9999.9f, -9999.9f),
                new Vector2(Float.NaN, Float.NaN), new Vector2(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY),
                new Vector2(Float.MIN_VALUE, Float.MIN_VALUE), new Vector2(-Float.MIN_VALUE, -Float.MIN_VALUE),
                new Vector2(0x7FF.FFp-5f, 0x7FF.FFp-5f), new Vector2(-0x7FF.FFp-5f, -0x7FF.FFp-5f)};

        for (Vector2 data : testing) {
            byte[] bytes = fory.serializeJavaObject(data);
            Vector2 data2 = fory.deserializeJavaObject(bytes, Vector2.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testVector3() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Vector3.class, new Vector3Serializer(fory));

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
            byte[] bytes = fory.serializeJavaObject(data);
            Vector3 data2 = fory.deserializeJavaObject(bytes, Vector3.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testVector4() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Vector4.class, new Vector4Serializer(fory));

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
            byte[] bytes = fory.serializeJavaObject(data);
            Vector4 data2 = fory.deserializeJavaObject(bytes, Vector4.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testQuaternion() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Quaternion.class, new QuaternionSerializer(fory));

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
            byte[] bytes = fory.serializeJavaObject(data);
            Quaternion data2 = fory.deserializeJavaObject(bytes, Quaternion.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testEllipse() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Ellipse.class, new EllipseSerializer(fory));

        Ellipse[] testing = {
                new Ellipse(0, 0, 0, 0),
                new Ellipse(-0f, -0f, -0f, -0f),
                new Ellipse(1, 0, 0, 0),
                new Ellipse(0, 1, 0, 0),
                new Ellipse(0, 0, 1, 0),
                new Ellipse(0, 0, 0, 1),
                new Ellipse(1, 1, 1, 1),
                new Ellipse(-1, -1, -1, -1),
                new Ellipse(9999.9f, 9999.9f, 9999.9f, 9999.9f),
                new Ellipse(9999.9f, -9999.9f, 0, -0f),
                new Ellipse(Float.NaN, Float.NaN, Float.NaN, Float.NaN),
                new Ellipse(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE),
                new Ellipse(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE),
                new Ellipse(-Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE),
                new Ellipse(0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f),
                new Ellipse(-0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f)};

        for (Ellipse data : testing) {
            byte[] bytes = fory.serializeJavaObject(data);
            Ellipse data2 = fory.deserializeJavaObject(bytes, Ellipse.class);
            // Ellipse does not implement equals().
//            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.x, data2.x, 0.00001f);
            Assert.assertEquals(data.y, data2.y, 0.00001f);
            Assert.assertEquals(data.width, data2.width, 0.00001f);
            Assert.assertEquals(data.height, data2.height, 0.00001f);
        }
    }
    @Test
    public void testRectangle() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Rectangle.class, new RectangleSerializer(fory));

        Rectangle[] testing = {
                new Rectangle(0, 0, 0, 0),
                new Rectangle(-0f, -0f, -0f, -0f),
                new Rectangle(1, 0, 0, 0),
                new Rectangle(0, 1, 0, 0),
                new Rectangle(0, 0, 1, 0),
                new Rectangle(0, 0, 0, 1),
                new Rectangle(1, 1, 1, 1),
                new Rectangle(-1, -1, -1, -1),
                new Rectangle(9999.9f, 9999.9f, 9999.9f, 9999.9f),
                new Rectangle(9999.9f, -9999.9f, 0, -0f),
                new Rectangle(Float.NaN, Float.NaN, Float.NaN, Float.NaN),
                new Rectangle(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE),
                new Rectangle(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE),
                new Rectangle(-Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE),
                new Rectangle(0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f),
                new Rectangle(-0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f)};

        for (Rectangle data : testing) {
            byte[] bytes = fory.serializeJavaObject(data);
            Rectangle data2 = fory.deserializeJavaObject(bytes, Rectangle.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testCircle() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Circle.class, new CircleSerializer(fory));

        Circle[] testing = {
                new Circle(0, 0, 0),
                new Circle(-0f, -0f, -0f),
                new Circle(1, 0, 0),
                new Circle(0, 1, 0),
                new Circle(0, 0, 1),
                new Circle(1, 1, 1),
                new Circle(-1, -1, -1),
                new Circle(9999.9f, 9999.9f, 9999.9f),
                new Circle(9999.9f, -9999.9f, 0),
                new Circle(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE),
                new Circle(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE),
                new Circle(-Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE),
                new Circle(0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f), new Circle(-0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f)};

        for (Circle data : testing) {
            byte[] bytes = fory.serializeJavaObject(data);
            Circle data2 = fory.deserializeJavaObject(bytes, Circle.class);
            Assert.assertEquals(data, data2);
        }
    }
    @Test
    public void testPlane() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Plane.class, new PlaneSerializer(fory));

        Plane[] testing = {
                new Plane(new Vector3(0, 0, 0), 0),
                new Plane(new Vector3(-0f, -0f, -0f), -0f),
                new Plane(new Vector3(1, 0, 0), 0),
                new Plane(new Vector3(0, 1, 0), 0),
                new Plane(new Vector3(0, 0, 1), 0),
                new Plane(new Vector3(0, 0, 0), 1),
                new Plane(new Vector3(1, 1, 1), 1),
                new Plane(new Vector3(-1, -1, -1), -1),
                new Plane(new Vector3(9999.9f, 9999.9f, 9999.9f), 9999.9f),
                new Plane(new Vector3(9999.9f, -9999.9f, 0), -0f),
                new Plane(new Vector3(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, -Float.MIN_VALUE), Float.MIN_VALUE),
                new Plane(new Vector3(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE), Float.MIN_VALUE),
                new Plane(new Vector3(-Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE), -Float.MIN_VALUE),
                new Plane(new Vector3(0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f), 0x7FF.FFp-5f),
                new Plane(new Vector3(-0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f), -0x7FF.FFp-5f)};

        for (Plane data : testing) {
            byte[] bytes = fory.serializeJavaObject(data);
            Plane data2 = fory.deserializeJavaObject(bytes, Plane.class);
            // Plane does not implement equals().
//            Assert.assertEquals(data, data2);
            Assert.assertEquals(data.normal, data2.normal);
            Assert.assertEquals(data.d, data2.d, 0.00001f);
        }
    }

    @Test
    public void testRandomXS128() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(RandomXS128.class, new RandomXS128Serializer(fory));

        RandomXS128 data = new RandomXS128(-12345L);

        byte[] bytes = fory.serializeJavaObject(data);
        RandomXS128 data2 = fory.deserializeJavaObject(bytes, RandomXS128.class);
        Assert.assertEquals(data.nextInt(), data2.nextInt());
        Assert.assertEquals(data.nextLong(), data2.nextLong());
        // RandomXS128 does not implement equals().
//        Assert.assertEquals(data, data2);
        Assert.assertEquals(data.getState(0), data2.getState(0));
        Assert.assertEquals(data.getState(1), data2.getState(1));

    }

    @Test
    public void testMatrix3() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Matrix3.class, new Matrix3Serializer(fory));

        Matrix3 data = new Matrix3().scale(2.1f, 3.3f).rotateRad(2f);

        byte[] bytes = fory.serializeJavaObject(data);
        Matrix3 data2 = fory.deserializeJavaObject(bytes, Matrix3.class);
        // Matrix3 does not implement equals().
//        Assert.assertEquals(data, data2);
        Assert.assertArrayEquals(data.val, data2.val, 0.00001f);
    }

    @Test
    public void testMatrix4() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Matrix4.class, new Matrix4Serializer(fory));

        Matrix4 data = new Matrix4().scale(2.1f, 3.3f, 4.6f).rotateRad(-1.1f, -2.2f, -3.3f, 99.9f);

        byte[] bytes = fory.serializeJavaObject(data);
        Matrix4 data2 = fory.deserializeJavaObject(bytes, Matrix4.class);
        // Matrix4 does not implement equals().
//        Assert.assertEquals(data, data2);
        Assert.assertArrayEquals(data.val, data2.val, 0.00001f);
    }

    @Test
    public void testAffine2() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Affine2.class, new Affine2Serializer(fory));

        Affine2 data = new Affine2().scale(2.1f, 3.3f).rotateRad(2f);

        byte[] bytes = fory.serializeJavaObject(data);
        Affine2 data2 = fory.deserializeJavaObject(bytes, Affine2.class);
        // Affine2 does not implement equals().
//        Assert.assertEquals(data, data2);
        Assert.assertEquals(data.m00, data2.m00, 0.00001f);
        Assert.assertEquals(data.m01, data2.m01, 0.00001f);
        Assert.assertEquals(data.m02, data2.m02, 0.00001f);
        Assert.assertEquals(data.m10, data2.m10, 0.00001f);
        Assert.assertEquals(data.m11, data2.m11, 0.00001f);
        Assert.assertEquals(data.m12, data2.m12, 0.00001f);
    }

    @Test
    public void testPolygon() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Polygon.class, new PolygonSerializer(fory));

        Polygon data = new Polygon(new Matrix4().scale(2.1f, 3.3f, 4.6f).rotateRad(-1.1f, -2.2f, -3.3f, 99.9f).val);
        byte[] bytes = fory.serializeJavaObject(data);
        Polygon data2 = fory.deserializeJavaObject(bytes, Polygon.class);
        // Polygon does not implement equals().
//            Assert.assertEquals(data, data2);
        Assert.assertEquals(data.getCentroid(new Vector2()), data2.getCentroid(new Vector2()));
        Assert.assertEquals(data.area(), data2.area(), 0.00001f);
    }

    @Test
    public void testPolyline() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Polyline.class, new PolylineSerializer(fory));

        Polyline data = new Polyline(new float[]{0, 1, 2, 3, 2, 1, 0, -1, -2, -3, -1, -4});
        data.setOrigin(-1, -1);
        data.setPosition(10, 10);
        data.setScale(2, 3);
        data.setRotation(123);
        byte[] bytes = fory.serializeJavaObject(data);
        Polyline data2 = fory.deserializeJavaObject(bytes, Polyline.class);
        // Polyline does not implement equals().
//            Assert.assertEquals(data, data2);
        Assert.assertEquals(data.getScaledLength(), data2.getScaledLength(), 0.0001f);
        Assert.assertArrayEquals(data.getTransformedVertices(), data2.getTransformedVertices(), 0.0001f);
    }
    @Test
    public void testRay() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Ray.class, new RaySerializer(fory));

        Vector3[] testing = {
                new Vector3(0f, 0f, 0f),
                new Vector3(-0f, -0f, -0f),
                new Vector3(1f, 0f, 0f),
                new Vector3(0f, 1f, 0f),
                new Vector3(0f, 0f, 1f),
                new Vector3(1f, 1f, 1f),
                new Vector3(-1f, -1f, -1f),
                new Vector3(9999.9f, 9999.9f, 9999.9f),
                new Vector3(9999.9f, -9999.9f, 0),
                new Vector3(Float.NaN, Float.NaN, Float.NaN),
                new Vector3(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN),
                new Vector3(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE),
                new Vector3(-Float.MIN_VALUE, -Float.MIN_VALUE, -Float.MIN_VALUE),
                new Vector3(0x7FF.FFp-5f, 0x7FF.FFp-5f, 0x7FF.FFp-5f),
                new Vector3(-0x7FF.FFp-5f, -0x7FF.FFp-5f, -0x7FF.FFp-5f),
         };

        for (Vector3 origin : testing) {
            for (Vector3 direction : testing) {
                Ray data = new Ray(origin, direction);
                byte[] bytes = fory.serializeJavaObject(data);
                Ray data2 = fory.deserializeJavaObject(bytes, Ray.class);
                Assert.assertEquals(data, data2);
                Assert.assertTrue(data.origin.epsilonEquals(data2.origin, 0.00001f));
                Assert.assertTrue(data.direction.epsilonEquals(data2.direction, 0.00001f));
            }
        }
    }
    @Test
    public void testBoundingBox() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(BoundingBox.class, new BoundingBoxSerializer(fory));

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

        for (Vector3 origin : testing) {
            for (Vector3 direction : testing) {
                BoundingBox data = new BoundingBox(origin, direction);
                byte[] bytes = fory.serializeJavaObject(data);
                BoundingBox data2 = fory.deserializeJavaObject(bytes, BoundingBox.class);
                // BoundingBox does not implement equals().
//                Assert.assertEquals(data, data2);
                Assert.assertEquals(data.min, data2.min);
                Assert.assertEquals(data.max, data2.max);
            }
        }
    }

    @Test
    public void testOrientedBoundingBox() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(OrientedBoundingBox.class, new OrientedBoundingBoxSerializer(fory));

        BoundingBox bb = new BoundingBox(new Vector3(-1, -1, -1), new Vector3(5, 6, 7));
        Matrix4 m = new Matrix4().scale(2.1f, 3.3f, 4.6f).rotateRad(-1.1f, -2.2f, -3.3f, 99.9f);
        OrientedBoundingBox data = new OrientedBoundingBox(bb, m);
        byte[] bytes = fory.serializeJavaObject(data);
        OrientedBoundingBox data2 = fory.deserializeJavaObject(bytes, OrientedBoundingBox.class);
        // OrientedBoundingBox does not implement equals().
//        Assert.assertEquals(data, data2);
        Assert.assertTrue(data.getBounds().min.epsilonEquals(data2.getBounds().min));
        Assert.assertTrue(data.getBounds().max.epsilonEquals(data2.getBounds().max));
        Assert.assertArrayEquals(data.transform.val, data2.transform.val, 0.0001f);
    }

    @Test
    public void testColor() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(Color.class, new ColorSerializer(fory));

        for (Color data : Colors.getColors().values()) {
            byte[] bytes = fory.serializeJavaObject(data);
            Color data2 = fory.deserializeJavaObject(bytes, Color.class);
            Assert.assertEquals(data, data2);
        }
    }
}
