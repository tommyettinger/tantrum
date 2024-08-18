package com.github.tommyettinger.tantrum.libgdx;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import org.apache.fury.Fury;
import org.apache.fury.config.Language;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class SizeComparisonJsonTest {
    @Test
    public void testSmallArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Array.class, new ArraySerializer(fury));

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

        System.out.println("Fury bytes length : " + bytes.length);
        System.out.println("Fury String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }

    @Test
    public void testLargeArray() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA)
                .requireClassRegistration(true)
                .build();
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

        System.out.println("Fury bytes length : " + bytes.length);
        System.out.println("Fury String length: " + new String(bytes, StandardCharsets.ISO_8859_1).length());
        System.out.println("JSON bytes length: " + text.getBytes(StandardCharsets.ISO_8859_1).length);
        System.out.println("JSON String length: " + text.length());
        System.out.println("JSON data: " + text);
    }
}
