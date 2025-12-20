package com.github.tommyettinger.tantrum.regexodus;

import org.apache.fory.Fory;
import org.apache.fory.memory.BoundsChecking;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.memory.Platform;
import org.apache.fory.serializer.Serializer;
import regexodus.ds.CharBitSet;

public class CharBitSetSerializer extends Serializer<CharBitSet> {
    public CharBitSetSerializer(Fory fory) {
        super(fory, CharBitSet.class, false);
    }

    @Override
    public void write(final MemoryBuffer output, final CharBitSet data) {
        final int[] bits = data.getRawBits();
        output.writePrimitiveArrayWithSize(bits, Platform.INT_ARRAY_OFFSET, bits.length << 2);
    }

    @Override
    public CharBitSet read(MemoryBuffer input) {
        final CharBitSet obs = new CharBitSet();
        obs.setRawBits(readIntsAndSize(input));
        return obs;
    }

    /**
     * This method should be used to read data written by
     * {@link MemoryBuffer#writePrimitiveArrayWithSize(Object, int, int)}.
     */
    private static int[] readIntsAndSize(MemoryBuffer buffer) {
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

}
