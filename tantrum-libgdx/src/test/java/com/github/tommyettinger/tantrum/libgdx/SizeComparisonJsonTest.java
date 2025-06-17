package com.github.tommyettinger.tantrum.libgdx;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Queue;
import org.apache.fory.Fory;
import org.apache.fory.config.Language;
import org.apache.fory.logging.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class SizeComparisonJsonTest {
    @Test
    public void testSmallStringArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        fory.registerSerializer(Array.class, new ArraySerializer(fory));
        fory.register(Array.class);

        Json json = new Json();

        Array<String> data = Array.with("Hello", "World", "!", "I", "am", "a", "test", "!", "yay");

        byte[] bytes = fory.serializeJavaObject(data);
        {
            Array<?> data2 = fory.deserializeJavaObject(bytes, Array.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Array.class, String.class);
        {
            Array<?> data2 = json.fromJson(Array.class, String.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Small Array<String>");
        System.out.println("Fory bytes length : " + bytes.length);
        System.out.println("Fory String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testLargeStringArray() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA)
                .requireClassRegistration(true)
                .build();
//        fory.registerSerializer(Array.class, new ArraySerializer(fory));
        fory.register(Array.class);

        Json json = new Json();

        Array<String> data = new Array<>(1024);

        for (int i = 0; i < 1024; i++) {
            data.add(i + " " + i);
        }

        byte[] bytes = fory.serializeJavaObject(data);
        {
            Array<?> data2 = fory.deserializeJavaObject(bytes, Array.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Array.class, String.class);
        {
            Array<?> data2 = json.fromJson(Array.class, String.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Large Array<String>");
        System.out.println("Fory bytes length : " + bytes.length);
        System.out.println("Fory String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testSmallVector3Array() {
        MathUtils.random.setSeed(1234567890L);
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).withRefTracking(true).build();
//        fory.registerSerializer(Array.class, new ArraySerializer(fory));
        fory.register(Array.class);
        fory.register(Array.ArrayIterable.class);
        fory.register(Array.ArrayIterator.class);
        fory.registerSerializer(Vector3.class, new Vector3Serializer(fory));

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

        byte[] bytes = fory.serializeJavaObject(data);
        {
            Array<?> data2 = fory.deserializeJavaObject(bytes, Array.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Array.class, Vector3.class);
        {
            Array<?> data2 = json.fromJson(Array.class, Vector3.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Small Array<Vector3>");
        System.out.println("Fory bytes length : " + bytes.length);
        System.out.println("Fory String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testLargeVector3Array() {
        MathUtils.random.setSeed(1234567890L);
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).withRefTracking(true).build();
//        fory.registerSerializer(Array.class, new ArraySerializer(fory));
        fory.register(Array.class);
        fory.register(Array.ArrayIterable.class);
        fory.register(Array.ArrayIterator.class);
        fory.registerSerializer(Vector3.class, new Vector3Serializer(fory));

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

        byte[] bytes = fory.serializeJavaObject(data);
        {
            Array<?> data2 = fory.deserializeJavaObject(bytes, Array.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Array.class, Vector3.class);
        {
            Array<?> data2 = json.fromJson(Array.class, Vector3.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Large Array<Vector3>");
        System.out.println("Fory bytes length : " + bytes.length);
        System.out.println("Fory String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }
    @Test
    public void testSmallStringQueue() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        fory.registerSerializer(Queue.class, new ArraySerializer(fory));
        fory.register(Queue.class);

        Json json = new Json();

        Queue<String> data = new Queue<>(9);
        for(String s : new String[]{"Hello", "World", "!", "I", "am", "a", "test", "!", "yay"}) {
            data.addLast(s);
        }

        byte[] bytes = fory.serializeJavaObject(data);
        {
            Queue<?> data2 = fory.deserializeJavaObject(bytes, Queue.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Queue.class, String.class);
        {
            Queue<?> data2 = json.fromJson(Queue.class, String.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Small Queue<String>");
        System.out.println("Fory bytes length : " + bytes.length);
        System.out.println("Fory String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testLargeStringQueue() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA)
                .requireClassRegistration(true)
                .build();
//        fory.registerSerializer(Queue.class, new ArraySerializer(fory));
        fory.register(Queue.class);

        Json json = new Json();

        Queue<String> data = new Queue<>(1024);

        for (int i = 0; i < 1024; i++) {
            data.addLast(i + " " + i);
        }

        byte[] bytes = fory.serializeJavaObject(data);
        {
            Queue<?> data2 = fory.deserializeJavaObject(bytes, Queue.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Queue.class, String.class);
        {
            Queue<?> data2 = json.fromJson(Queue.class, String.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Large Queue<String>");
        System.out.println("Fory bytes length : " + bytes.length);
        System.out.println("Fory String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testSmallVector3Queue() {
        MathUtils.random.setSeed(1234567890L);
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        fory.registerSerializer(Queue.class, new ArraySerializer(fory));
        fory.register(Queue.class);
        fory.registerSerializer(Vector3.class, new Vector3Serializer(fory));

        Json json = new Json();

        Queue<Vector3> data = new Queue<>(9);
        for (int i = 0; i < 9; i++) {
            data.addLast(new Vector3(MathUtils.random(), MathUtils.random(), MathUtils.random()));
        }

        byte[] bytes = fory.serializeJavaObject(data);
        {
            Queue<?> data2 = fory.deserializeJavaObject(bytes, Queue.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Queue.class, Vector3.class);
        {
            Queue<?> data2 = json.fromJson(Queue.class, Vector3.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Small Queue<Vector3>");
        System.out.println("Fory bytes length : " + bytes.length);
        System.out.println("Fory String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testLargeVector3Queue() {
        MathUtils.random.setSeed(1234567890L);
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
//        fory.registerSerializer(Queue.class, new ArraySerializer(fory));
        fory.register(Queue.class);
        fory.registerSerializer(Vector3.class, new Vector3Serializer(fory));

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

        byte[] bytes = fory.serializeJavaObject(data);
        {
            Queue<?> data2 = fory.deserializeJavaObject(bytes, Queue.class);
            Assert.assertEquals(data, data2);
        }

        String text = json.toJson(data, Queue.class, Vector3.class);
        {
            Queue<?> data2 = json.fromJson(Queue.class, Vector3.class, text);;
            Assert.assertEquals(data, data2);
        }

        System.out.println("Large Queue<Vector3>");
        System.out.println("Fory bytes length : " + bytes.length);
        System.out.println("Fory String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length : " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }
}
