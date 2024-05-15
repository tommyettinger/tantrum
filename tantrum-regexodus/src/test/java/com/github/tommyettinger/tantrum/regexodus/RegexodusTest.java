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

package com.github.tommyettinger.tantrum.regexodus;

import org.apache.fury.Fury;
import org.apache.fury.config.Language;
import org.junit.Assert;
import org.junit.Test;
import regexodus.Pattern;
import regexodus.REFlags;

public class RegexodusTest {
    @Test
    public void testInterpolator() {
        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();
        fury.registerSerializer(Pattern.class, new PatternSerializer(fury));

        Pattern data = Pattern.compile("[a-z0-9_\\p{Sc}]+", REFlags.IGNORE_CASE | REFlags.UNICODE);

        byte[] bytes = fury.serializeJavaObject(data);
        Pattern data2 = fury.deserializeJavaObject(bytes, Pattern.class);
        Assert.assertEquals(data.matches("Meow€€€"), data2.matches("Meow€€€"));
        Assert.assertEquals(data.matches("Meow, baby, meow."), data2.matches("Meow, baby, meow."));
        Assert.assertEquals(data, data2);
    }
}
