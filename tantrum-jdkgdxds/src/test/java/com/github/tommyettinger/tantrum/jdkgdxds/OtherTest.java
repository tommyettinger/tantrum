package com.github.tommyettinger.tantrum.jdkgdxds;

import com.github.tommyettinger.ds.Junction;
import com.github.tommyettinger.ds.ObjectList;
import org.apache.fury.Fury;
import org.apache.fury.config.Language;
import org.apache.fury.logging.LoggerFactory;
import org.apache.fury.serializer.collection.CollectionSerializer;
import org.junit.Assert;
import org.junit.Test;

public class OtherTest {

    @Test
    public void testJunction() {
//        LoggerFactory.disableLogging();
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(ObjectList.class, new ObjectListSerializer(fury));
//        fury.registerSerializer(ObjectList.class, new CollectionSerializer<>(fury, ObjectList.class));
//        fury.register(ObjectList.class);
        fury.register(Junction.class);
        fury.register(Junction.Any.class);
        fury.register(Junction.All.class);
        fury.register(Junction.One.class);
        fury.register(Junction.Not.class);
        fury.register(Junction.Leaf.class);

        Junction<String> data = Junction.parse("(foo|bar|baz)^QUUX^woop woop");

        byte[] bytes = fury.serializeJavaObject(data); {
            Junction<?> data2 = fury.deserializeJavaObject(bytes, Junction.class);
            Assert.assertEquals(data, data2);
        }

    }
}
