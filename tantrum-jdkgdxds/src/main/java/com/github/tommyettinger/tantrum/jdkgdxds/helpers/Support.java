package com.github.tommyettinger.tantrum.jdkgdxds.helpers;

import io.fury.memory.BoundsChecking;
import io.fury.memory.MemoryBuffer;
import io.fury.util.Platform;

public final class Support {
    private Support() {
    }
    /**
     * This method should be used to read data written by {@link
     * MemoryBuffer#writePrimitiveArrayWithSizeEmbedded}.
     */
    public static short[] readShortsWithSizeEmbedded(MemoryBuffer buffer) {
        final int numBytes = buffer.readPositiveVarInt();
        int readerIdx = buffer.readerIndex();
        final int size = buffer.size();
        // use subtract to avoid overflow
        if (BoundsChecking.BOUNDS_CHECKING_ENABLED && readerIdx > size - numBytes) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "readerIdx(%d) + length(%d) exceeds size(%d): %s", readerIdx, numBytes, size, buffer));
        }
        final short[] shorts = new short[numBytes / 2];
        Platform.copyMemory(
                buffer.getHeapMemory(), buffer.getUnsafeAddress() + readerIdx, shorts, Platform.SHORT_ARRAY_OFFSET, numBytes);
        buffer.increaseReaderIndexUnsafe(numBytes);
        return shorts;
    }

}
