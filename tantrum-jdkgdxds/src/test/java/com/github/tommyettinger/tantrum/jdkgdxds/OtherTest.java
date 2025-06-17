package com.github.tommyettinger.tantrum.jdkgdxds;

import com.github.tommyettinger.ds.Junction;
import com.github.tommyettinger.ds.ObjectList;
import org.apache.fory.Fory;
import org.apache.fory.config.Language;
import org.apache.fory.logging.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;

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

        Junction<String> data = Junction.parse("(foo|bar|baz)^QUUX^woop woop");

        byte[] bytes = fory.serializeJavaObject(data); {
            Junction<?> data2 = fory.deserializeJavaObject(bytes, Junction.class);
            Assert.assertEquals(data, data2);
        }

    }
}
