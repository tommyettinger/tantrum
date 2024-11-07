package com.github.tommyettinger.tantrum.libgdx;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Queue;
import org.apache.fury.Fury;
import org.apache.fury.config.Language;
import org.apache.fury.logging.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class SizeComparisonJsonTest {
    @Test
    public void testSmallStringArray() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        fury.registerSerializer(Array.class, new ArraySerializer(fury));
        fury.register(Array.class);

        Json json = new Json();

        Array<String> data = Array.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fury.serializeJavaObject(data);
        {
            Array<?> data2 = fury.deserializeJavaObject(bytes, Array.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Array.class, String.class);
        {
            Array<?> data2 = json.fromJson(Array.class, String.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Small Array<String>");
        System.out.println("Fury bytes length : " + bytes.length);
        System.out.println("Fury String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testLargeStringArray() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA)
                .requireClassRegistration(true)
                .build();
//        fury.registerSerializer(Array.class, new ArraySerializer(fury));
        fury.register(Array.class);

        Json json = new Json();

        Array<String> data = new Array<>(1024);

        for (int i = 0; i < 1024; i++) {
            data.add(i + " " + i);
        }

        byte[] bytes = fury.serializeJavaObject(data);
        {
            Array<?> data2 = fury.deserializeJavaObject(bytes, Array.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Array.class, String.class);
        {
            Array<?> data2 = json.fromJson(Array.class, String.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Large Array<String>");
        System.out.println("Fury bytes length : " + bytes.length);
        System.out.println("Fury String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testSmallVector3Array() {
        MathUtils.random.setSeed(1234567890L);
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).withRefTracking(true).build();
//        fury.registerSerializer(Array.class, new ArraySerializer(fury));
        fury.register(Array.class);
        fury.register(Array.ArrayIterable.class);
        fury.register(Array.ArrayIterator.class);
        fury.registerSerializer(Vector3.class, new Vector3Serializer(fury));

        Json json = new Json();

        Array<Vector3> data = new Array<>(9);
        Vector3 sum = new Vector3();
        for (int i = 0; i < 9; i++) {
            data.add(new Vector3(MathUtils.random(), MathUtils.random(), MathUtils.random()));
        }
        for(Vector3 d : data){
            sum.add(d);
        }
        data.add(sum);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            Array<?> data2 = fury.deserializeJavaObject(bytes, Array.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Array.class, Vector3.class);
        {
            Array<?> data2 = json.fromJson(Array.class, Vector3.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Small Array<Vector3>");
        System.out.println("Fury bytes length : " + bytes.length);
        System.out.println("Fury String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testLargeVector3Array() {
        MathUtils.random.setSeed(1234567890L);
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).withRefTracking(true).build();
//        fury.registerSerializer(Array.class, new ArraySerializer(fury));
        fury.register(Array.class);
        fury.register(Array.ArrayIterable.class);
        fury.register(Array.ArrayIterator.class);
        fury.registerSerializer(Vector3.class, new Vector3Serializer(fury));

        Json json = new Json();

        Array<Vector3> data = new Array<>(1024);
        Vector3 sum = new Vector3();
        for (int i = 0; i < 1024; i++) {
            data.add(new Vector3(MathUtils.random(), MathUtils.random(), MathUtils.random()));
        }
        for(Vector3 d : data){
            sum.add(d);
        }
        data.add(sum);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            Array<?> data2 = fury.deserializeJavaObject(bytes, Array.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Array.class, Vector3.class);
        {
            Array<?> data2 = json.fromJson(Array.class, Vector3.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Large Array<Vector3>");
        System.out.println("Fury bytes length : " + bytes.length);
        System.out.println("Fury String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }
    @Test
    public void testSmallStringQueue() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        fury.registerSerializer(Queue.class, new ArraySerializer(fury));
        fury.register(Queue.class);

        Json json = new Json();

        Queue<String> data = new Queue<>(9);
        for(String s : new String[]{"Hello", "World", "!", "I", "am", "a", "test", "!", "yay"}) {
            data.addLast(s);
        }

        byte[] bytes = fury.serializeJavaObject(data);
        {
            Queue<?> data2 = fury.deserializeJavaObject(bytes, Queue.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Queue.class, String.class);
        {
            Queue<?> data2 = json.fromJson(Queue.class, String.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Small Queue<String>");
        System.out.println("Fury bytes length : " + bytes.length);
        System.out.println("Fury String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testLargeStringQueue() {
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA)
                .requireClassRegistration(true)
                .build();
//        fury.registerSerializer(Queue.class, new ArraySerializer(fury));
        fury.register(Queue.class);

        Json json = new Json();

        Queue<String> data = new Queue<>(1024);

        for (int i = 0; i < 1024; i++) {
            data.addLast(i + " " + i);
        }

        byte[] bytes = fury.serializeJavaObject(data);
        {
            Queue<?> data2 = fury.deserializeJavaObject(bytes, Queue.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Queue.class, String.class);
        {
            Queue<?> data2 = json.fromJson(Queue.class, String.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Large Queue<String>");
        System.out.println("Fury bytes length : " + bytes.length);
        System.out.println("Fury String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testSmallVector3Queue() {
        MathUtils.random.setSeed(1234567890L);
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        fury.registerSerializer(Queue.class, new ArraySerializer(fury));
        fury.register(Queue.class);
        fury.registerSerializer(Vector3.class, new Vector3Serializer(fury));

        Json json = new Json();

        Queue<Vector3> data = new Queue<>(9);
        for (int i = 0; i < 9; i++) {
            data.addLast(new Vector3(MathUtils.random(), MathUtils.random(), MathUtils.random()));
        }

        byte[] bytes = fury.serializeJavaObject(data);
        {
            Queue<?> data2 = fury.deserializeJavaObject(bytes, Queue.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Queue.class, Vector3.class);
        {
            Queue<?> data2 = json.fromJson(Queue.class, Vector3.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Small Queue<Vector3>");
        System.out.println("Fury bytes length : " + bytes.length);
        System.out.println("Fury String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testLargeVector3Queue() {
        MathUtils.random.setSeed(1234567890L);
        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
//        fury.registerSerializer(Queue.class, new ArraySerializer(fury));
        fury.register(Queue.class);
        fury.registerSerializer(Vector3.class, new Vector3Serializer(fury));

        Json json = new Json();

        Queue<Vector3> data = new Queue<>(1024);
        Vector3 sum = new Vector3();
        for (int i = 0; i < 1024; i++) {
            data.addLast(new Vector3(MathUtils.random(), MathUtils.random(), MathUtils.random()));
        }
        for(Vector3 d : data){
            sum.add(d);
        }
        data.addLast(sum);

        byte[] bytes = fury.serializeJavaObject(data);
        {
            Queue<?> data2 = fury.deserializeJavaObject(bytes, Queue.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Queue.class, Vector3.class);
        {
            Queue<?> data2 = json.fromJson(Queue.class, Vector3.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Large Queue<Vector3>");
        System.out.println("Fury bytes length : " + bytes.length);
        System.out.println("Fury String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }
}
