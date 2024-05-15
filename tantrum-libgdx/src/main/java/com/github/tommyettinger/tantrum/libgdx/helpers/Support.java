package com.github.tommyettinger.tantrum.libgdx.helpers;

import org.apache.fury.memory.BoundsChecking;
import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.memory.Platform;

public final class Support {
    private Support() {
    }

    /**
     * This method should be used to read data written by
     * {@link MemoryBuffer#writePrimitiveArrayWithSize(Object, int, int)}.
     */
    public static boolean[] readBooleansAndSize(MemoryBuffer buffer) {
        final int numBytes = buffer.readVarUint32();
        int readerIdx = buffer.readerIndex();
        final int size = buffer.size();
        // use subtract to avoid overflow
        if (BoundsChecking.BOUNDS_CHECKING_ENABLED && readerIdx > size - numBytes) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "readerIdx(%d) + length(%d) exceeds size(%d): %s", readerIdx, numBytes, size, buffer));
        }
        final boolean[] booleans = new boolean[numBytes];
        Platform.copyMemory(
                buffer.getHeapMemory(), buffer.getUnsafeAddress() + readerIdx, booleans, Platform.BOOLEAN_ARRAY_OFFSET, numBytes);
        buffer._increaseReaderIndexUnsafe(numBytes);
        return booleans;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writePrimitiveArrayWithSize(Object, int, int)}.
     * It delegates to {@link MemoryBuffer#readBytesAndSize()}.
     */
    public static byte[] readBytesAndSize(MemoryBuffer buffer) {
        return buffer.readBytesAndSize();
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writePrimitiveArrayWithSize(Object, int, int)}.
     */
    public static short[] readShortsAndSize(MemoryBuffer buffer) {
        final int numBytes = buffer.readVarUint32();
        int readerIdx = buffer.readerIndex();
        final int size = buffer.size();
        // use subtract to avoid overflow
        if (BoundsChecking.BOUNDS_CHECKING_ENABLED && readerIdx > size - numBytes) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "readerIdx(%d) + length(%d) exceeds size(%d): %s", readerIdx, numBytes, size, buffer));
        }
        final short[] shorts = new short[numBytes >>> 1];
        Platform.copyMemory(
                buffer.getHeapMemory(), buffer.getUnsafeAddress() + readerIdx, shorts, Platform.SHORT_ARRAY_OFFSET, numBytes);
        buffer._increaseReaderIndexUnsafe(numBytes);
        return shorts;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writePrimitiveArrayWithSize(Object, int, int)}.
     * It delegates to {@link MemoryBuffer#readCharsAndSize()}.
     */
    public static char[] readCharsAndSize(MemoryBuffer buffer) {
        return buffer.readCharsAndSize();
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writePrimitiveArrayWithSize(Object, int, int)}.
     */
    public static int[] readIntsAndSize(MemoryBuffer buffer) {
        final int numBytes = buffer.readVarUint32();
        int readerIdx = buffer.readerIndex();
        final int size = buffer.size();
        // use subtract to avoid overflow
        if (BoundsChecking.BOUNDS_CHECKING_ENABLED && readerIdx > size - numBytes) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "readerIdx(%d) + length(%d) exceeds size(%d): %s", readerIdx, numBytes, size, buffer));
        }
        final int[] ints = new int[numBytes >>> 2];
        Platform.copyMemory(
                buffer.getHeapMemory(), buffer.getUnsafeAddress() + readerIdx, ints, Platform.INT_ARRAY_OFFSET, numBytes);
        buffer._increaseReaderIndexUnsafe(numBytes);
        return ints;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writePrimitiveArrayWithSize(Object, int, int)}.
     */
    public static float[] readFloatsAndSize(MemoryBuffer buffer) {
        final int numBytes = buffer.readVarUint32();
        int readerIdx = buffer.readerIndex();
        final int size = buffer.size();
        // use subtract to avoid overflow
        if (BoundsChecking.BOUNDS_CHECKING_ENABLED && readerIdx > size - numBytes) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "readerIdx(%d) + length(%d) exceeds size(%d): %s", readerIdx, numBytes, size, buffer));
        }
        final float[] floats = new float[numBytes >>> 2];
        Platform.copyMemory(
                buffer.getHeapMemory(), buffer.getUnsafeAddress() + readerIdx, floats, Platform.FLOAT_ARRAY_OFFSET, numBytes);
        buffer._increaseReaderIndexUnsafe(numBytes);
        return floats;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writePrimitiveArrayWithSize(Object, int, int)}.
     */
    public static long[] readLongsAndSize(MemoryBuffer buffer) {
        final int numBytes = buffer.readVarUint32();
        int readerIdx = buffer.readerIndex();
        final int size = buffer.size();
        // use subtract to avoid overflow
        if (BoundsChecking.BOUNDS_CHECKING_ENABLED && readerIdx > size - numBytes) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "readerIdx(%d) + length(%d) exceeds size(%d): %s", readerIdx, numBytes, size, buffer));
        }
        final long[] longs = new long[numBytes >>> 3];
        Platform.copyMemory(
                buffer.getHeapMemory(), buffer.getUnsafeAddress() + readerIdx, longs, Platform.LONG_ARRAY_OFFSET, numBytes);
        buffer._increaseReaderIndexUnsafe(numBytes);
        return longs;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writePrimitiveArrayWithSize(Object, int, int)}.
     */
    public static double[] readDoublesAndSize(MemoryBuffer buffer) {
        final int numBytes = buffer.readVarUint32();
        int readerIdx = buffer.readerIndex();
        final int size = buffer.size();
        // use subtract to avoid overflow
        if (BoundsChecking.BOUNDS_CHECKING_ENABLED && readerIdx > size - numBytes) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "readerIdx(%d) + length(%d) exceeds size(%d): %s", readerIdx, numBytes, size, buffer));
        }
        final double[] doubles = new double[numBytes >>> 3];
        Platform.copyMemory(
                buffer.getHeapMemory(), buffer.getUnsafeAddress() + readerIdx, doubles, Platform.DOUBLE_ARRAY_OFFSET, numBytes);
        buffer._increaseReaderIndexUnsafe(numBytes);
        return doubles;
    }
}
