package com.github.tommyettinger.tantrum.juniper.helpers;

import io.fury.memory.MemoryBuffer;

import java.nio.charset.StandardCharsets;

public final class BufferHelper {
    private BufferHelper() {}

    public static void writeString(MemoryBuffer buffer, String s) {
        buffer.writeBytesWithSizeEmbedded(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String readString(MemoryBuffer buffer){
        return new String(buffer.readBytesWithSizeEmbedded(), StandardCharsets.UTF_8);
    }
}
