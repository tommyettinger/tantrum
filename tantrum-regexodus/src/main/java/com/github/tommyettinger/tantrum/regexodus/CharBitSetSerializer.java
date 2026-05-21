package com.github.tommyettinger.tantrum.regexodus;

import org.apache.fory.Fory;
import org.apache.fory.config.Config;
import org.apache.fory.context.ReadContext;
import org.apache.fory.context.WriteContext;
import org.apache.fory.serializer.Serializer;
import regexodus.ds.CharBitSet;

public class CharBitSetSerializer extends Serializer<CharBitSet> {
    public CharBitSetSerializer(Fory fory) {
        super(fory.getConfig(), CharBitSet.class, false);
    }
    public CharBitSetSerializer(Config fory) {
        super(fory, CharBitSet.class, false);
    }

    @Override
    public void write(final WriteContext fory, final CharBitSet data) {
        final int[] bits = data.getRawBits();
        fory.getBuffer().writeIntsWithSize(bits);
    }

    @Override
    public CharBitSet read(ReadContext fory) {
        final CharBitSet obs = new CharBitSet();
        final int numElements = fory.getBuffer().readBinarySize() >>> 2;
        int[] values = new int[numElements];
        fory.getBuffer().readInts(values, 0, numElements);
        obs.setRawBits(values);
        return obs;
    }
}
