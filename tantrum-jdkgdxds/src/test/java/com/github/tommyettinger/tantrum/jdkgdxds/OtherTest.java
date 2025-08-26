package com.github.tommyettinger.tantrum.jdkgdxds;

import com.github.tommyettinger.ds.Junction;
import com.github.tommyettinger.ds.ObjectList;
import org.apache.fory.Fory;
import org.apache.fory.config.Language;
import org.apache.fory.logging.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class OtherTest {

    @Test
    public void testJunction() {
        LoggerFactory.disableLogging();
        Fory fory = Fory.builder().withLanguage(Language.JAVA).build();
        fory.registerSerializer(ObjectList.class, new ObjectListSerializer(fory));
//        fory.registerSerializer(ObjectList.class, new CollectionSerializer<>(fory, ObjectList.class));
//        fory.register(ObjectList.class);
        fory.register(Junction.class);
        fory.register(Junction.Any.class);
        fory.register(Junction.All.class);
        fory.register(Junction.One.class);
        fory.register(Junction.Not.class);
        fory.register(Junction.Leaf.class);

        String jstr = "(foo|bar|baz)^QUUX^woop woop";
        Junction<String> data = Junction.parse(jstr);

        byte[] bytes = fory.serializeJavaObject(data); {
            System.out.println("Fory bytes length     : " + bytes.length);
            System.out.println("Original UTF8 length  : " + jstr.getBytes(StandardCharsets.UTF_8).length);
            System.out.println("Original UTF16 length : " + jstr.getBytes(StandardCharsets.UTF_16).length);
            Junction<?> data2 = fory.deserializeJavaObject(bytes, Junction.class);
            Assert.assertEquals(data, data2);
        }

    }
}
