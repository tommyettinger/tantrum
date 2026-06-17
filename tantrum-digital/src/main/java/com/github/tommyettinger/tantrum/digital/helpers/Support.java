package com.github.tommyettinger.tantrum.digital.helpers;

import org.apache.fory.memory.MemoryBuffer;

public final class Support {
    private Support() {
    }

    /**
     * This method should be used to read data written by
     * {@link MemoryBuffer#writeBooleansWithSize(boolean[])}
     */
    public static boolean[] readBooleansAndSize(MemoryBuffer buffer) {
        final int numElements = buffer.readBinarySize();
        boolean[] values = new boolean[numElements];
        buffer.readBooleans(values, 0, numElements);
        return values;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writeBytesWithSize(byte[])}.
     * It delegates to {@link MemoryBuffer#readBytesAndSize()}.
     */
    public static byte[] readBytesAndSize(MemoryBuffer buffer) {
        return buffer.readBytesAndSize();
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writeShortsWithSize(short[])}.
     */
    public static short[] readShortsAndSize(MemoryBuffer buffer) {
        final int numElements = buffer.readVarUInt32();
        short[] values = new short[numElements];
        buffer.readShorts(values, 0, numElements);
        return values;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writeCharsWithSize(char[])}.
     * It delegates to {@link MemoryBuffer#readCharsAndSize()}.
     */
    public static char[] readCharsAndSize(MemoryBuffer buffer) {
        final int numElements = buffer.readVarUInt32();
        char[] values = new char[numElements];
        buffer.readCharArrayBytes(values, numElements << 1);
        return values;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writeIntsWithSize(int[])}.
     */
    public static int[] readIntsAndSize(MemoryBuffer buffer) {
        final int numElements = buffer.readVarUInt32();
        int[] values = new int[numElements];
        buffer.readInts(values, 0, numElements);
        return values;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writeFloatsWithSize(float[])}.
     */
    public static float[] readFloatsAndSize(MemoryBuffer buffer) {
        final int numElements = buffer.readVarUInt32();
        float[] values = new float[numElements];
        buffer.readFloats(values, 0, numElements);
        return values;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writeLongsWithSize(long[])}.
     */
    public static long[] readLongsAndSize(MemoryBuffer buffer) {
        final int numElements = buffer.readVarUInt32();
        long[] values = new long[numElements];
        buffer.readLongs(values, 0, numElements);
        return values;
    }

    /**
     * This method should be used to read data written by 
     * {@link MemoryBuffer#writeDoublesWithSize(double[])}.
     */
    public static double[] readDoublesAndSize(MemoryBuffer buffer) {
        final int numElements = buffer.readVarUInt32();
        double[] values = new double[numElements];
        buffer.readDoubles(values, 0, numElements);
        return values;
    }
}
