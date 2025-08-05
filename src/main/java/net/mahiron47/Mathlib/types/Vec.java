package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec implements IVector {
    private final int[]    Idata;
    private final long[]   Ldata;
    private final float[]  Fdata;
    private final double[] Ddata;
    private final byte     type ;

    public Vec(int... data) {
        assert data != null : "Vec:constructor:data == null";
        assert data.length > 0 : "Vec:constructor:data.length == 0";

        this.Idata = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            this.Idata[i] = data[i];
        }
        this.Ldata = null;
        this.Fdata = null;
        this.Ddata = null;
        this.type = ITensor.TYPE_INT;
    }

    public Vec(long... data) {
        assert data != null : "Vec:constructor:data == null";
        assert data.length > 0 : "Vec:constructor:data.length == 0";

        this.Idata = null;
        this.Ldata = new long[data.length];
        for (int i = 0; i < data.length; i++) {
            this.Ldata[i] = data[i];
        }
        this.Fdata = null;
        this.Ddata = null;
        this.type = ITensor.TYPE_LONG;
    }

    public Vec(float... data) {
        assert data != null : "Vec:constructor:data == null";
        assert data.length > 0 : "Vec:constructor:data.length == 0";

        this.Idata = null;
        this.Ldata = null;
        this.Fdata = new float[data.length];
        for (int i = 0; i < data.length; i++) {
            this.Fdata[i] = data[i];
        }
        this.Ddata = null;
        this.type = ITensor.TYPE_FLOAT;
    }

    public Vec(double... data) {
        assert data != null : "Vec:constructor:data == null";
        assert data.length > 0 : "Vec:constructor:data.length == 0";

        this.Idata = null;
        this.Ldata = null;
        this.Fdata = null;
        this.Ddata = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            this.Ddata[i] = data[i];
        }
        this.type = ITensor.TYPE_DOUBLE;
    }

    public Vec(int[] data, byte type) {
        assert data != null : "Vec:constructor:data == null";
        assert data.length > 0 : "Vec:constructor:data.length == 0";
        assert type != ITensor.TYPE_NULL : "Vec:constructor:type == ITensor.TYPE_NULL";

        switch (type) {
        case ITensor.TYPE_INT:
            this.Idata = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                this.Idata[i] = (int) data[i];
            }
            this.Ldata = null;
            this.Fdata = null;
            this.Ddata = null;
            break;
        default:
            throw new IllegalArgumentException("Vec:constructor:type is not supported: " + type);
        }

        this.type = type;
    }

    public Vec(long[] data, byte type) {
        assert data != null : "Vec:constructor:data == null";
        assert data.length > 0 : "Vec:constructor:data.length == 0";
        assert type != ITensor.TYPE_NULL : "Vec:constructor:type == ITensor.TYPE_NULL";

        switch (type) {
        case ITensor.TYPE_INT:
            this.Idata = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                this.Idata[i] = (int) data[i];
            }
            this.Ldata = null;
            this.Fdata = null;
            this.Ddata = null;
            break;
        case ITensor.TYPE_LONG:
            this.Idata = null;
            this.Ldata = new long[data.length];
            for (int i = 0; i < data.length; i++) {
                this.Ldata[i] = data[i];
            }
            this.Fdata = null;
            this.Ddata = null;
            break;
        default:
            throw new IllegalArgumentException("Vec:constructor:type is not supported: " + type);
        }

        this.type = type;
    }

    public Vec(float[] data, byte type) {
        assert data != null : "Vec:constructor:data == null";
        assert data.length > 0 : "Vec:constructor:data.length == 0";
        assert type != ITensor.TYPE_NULL : "Vec:constructor:type == ITensor.TYPE_NULL";

        switch (type) {
        case ITensor.TYPE_FLOAT:
            this.Idata = null;
            this.Ldata = null;
            this.Fdata = new float[data.length];
            for (int i = 0; i < data.length; i++) {
                this.Fdata[i] = (float) data[i];
            }
            this.Ddata = null;
            break;
        default:
            throw new IllegalArgumentException("Vec:constructor:type is not supported: " + type);
        }
        this.type = type;
    }

    public Vec(double[] data, byte type) {
        assert data != null : "Vec:constructor:data == null";
        assert data.length > 0 : "Vec:constructor:data.length == 0";
        assert type != ITensor.TYPE_NULL : "Vec:constructor:type == ITensor.TYPE_NULL";

        switch (type) {
        case ITensor.TYPE_FLOAT:
            this.Idata = null;
            this.Ldata = null;
            this.Fdata = new float[data.length];
            for (int i = 0; i < data.length; i++) {
                this.Fdata[i] = (float) data[i];
            }
            this.Ddata = null;
            break;
        case ITensor.TYPE_DOUBLE:
            this.Idata = null;
            this.Ldata = null;
            this.Fdata = null;
            this.Ddata = new double[data.length];
            for (int i = 0; i < data.length; i++) {
                this.Ddata[i] = data[i];
            }
            break;
        default:
            throw new IllegalArgumentException("Vec:constructor:type is not supported: " + type);
        }
        this.type = type;
    }

    @Override
    public byte getType() {
        return this.type;
    }

    @Override
    public int geti(int i) {
        assert i >= 0 && i < Idata.length : "Vec:get:i out of bounds";
        assert Idata != null : "Vec:get:Idata == null";

        return Idata[i];
    }

    @Override
    public long getl(int i) {
        assert i >= 0 && i < Ldata.length : "Vec:getl:i out of bounds";
        assert Ldata != null : "Vec:getl:Ldata == null";

        return Ldata[i];
    }

    @Override
    public float getf(int i) {
        assert i >= 0 && i < Fdata.length : "Vec:getf:i out of bounds";
        assert Fdata != null : "Vec:getf:Fdata == null";

        return Fdata[i];
    }

    @Override
    public double getd(int i) {
        assert i >= 0 && i < Ddata.length : "Vec:getd:i out of bounds";
        assert Ddata != null : "Vec:getd:Ddata == null";

        return Ddata[i];
    }

    @Override
    public void set(int i, int a_i) {
        assert i >= 0 && i < Idata.length : "Vec:set:i out of bounds";
        assert Idata != null : "Vec:set:Idata == null";

        Idata[i] = a_i;
    }

    @Override
    public void set(int i, long a_i) {
        assert i >= 0 && i < Ldata.length : "Vec:set:i out of bounds";
        assert Ldata != null : "Vec:set:Ldata == null";

        Ldata[i] = a_i;
    }

    @Override
    public void set(int i, float a_i) {
        assert i >= 0 && i < Fdata.length : "Vec:set:i out of bounds";
        assert Fdata != null : "Vec:set:Fdata == null";

        Fdata[i] = a_i;
    }

    @Override
    public void set(int i, double a_i) {
        assert i >= 0 && i < Ddata.length : "Vec:set:i out of bounds";
        assert Ddata != null : "Vec:set:Ddata == null";

        Ddata[i] = a_i;
    }

    @Override
    public int getDimension() {
        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Vec:getDimension:Idata == null";

            return Idata.length;
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Vec:getDimension:Ldata == null";

            return Ldata.length;
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Vec:getDimension:Fdata == null";

            return Fdata.length;
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Vec:getDimension:Ddata == null";

            return Ddata.length;
        default:
            throw new IllegalArgumentException("Vec:getDimension:type is not supported: " + this.type);
        }
    }

    @Override
    public Vec copy() {
        switch (this.type) {
        case ITensor.TYPE_INT:
            return new Vec(Idata.clone(), this.type);
        case ITensor.TYPE_LONG:
            return new Vec(Ldata.clone(), this.type);
        case ITensor.TYPE_FLOAT:
            return new Vec(Fdata.clone(), this.type);
        case ITensor.TYPE_DOUBLE:
            return new Vec(Ddata.clone(), this.type);
        default:
            throw new IllegalArgumentException("Vec:copy:type is not supported: " + this.type);
        }
    }

    @Override
    public Mat convert() {
        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Vec:convert:Idata == null";
            assert Idata.length > 0 : "Vec:convert:Idata.length == 0";

            int[][] intMatrixData = new int[Idata.length][1];
            for (int i = 0; i < Idata.length; i++) {
                intMatrixData[i][0] = Idata[i];
            }

            return new Mat(intMatrixData, this.type);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Vec:convert:Ldata == null";
            assert Ldata.length > 0 : "Vec:convert:Ldata.length == 0";

            long[][] longMatrixData = new long[Ldata.length][1];
            for (int i = 0; i < Ldata.length; i++) {
                longMatrixData[i][0] = Ldata[i];
            }

            return new Mat(longMatrixData, this.type);
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Vec:convert:Fdata == null";
            assert Fdata.length > 0 : "Vec:convert:Fdata.length == 0";

            float[][] floatMatrixData = new float[Fdata.length][1];
            for (int i = 0; i < Fdata.length; i++) {
                floatMatrixData[i][0] = Fdata[i];
            }

            return new Mat(floatMatrixData, this.type);
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Vec:convert:Ddata == null";
            assert Ddata.length > 0 : "Vec:convert:Ddata.length == 0";

            double[][] doubleMatrixData = new double[Ddata.length][1];
            for (int i = 0; i < Ddata.length; i++) {
                doubleMatrixData[i][0] = Ddata[i];
            }

            return new Mat(doubleMatrixData, this.type);
        default:
            throw new IllegalArgumentException("Vec:convert:type is not supported: " + this.type);
        }
    }

    @Override
    public double getLength() {
        double sum = 0.0;

        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Vec:getLength:Idata == null";

            for (int value : Idata) {
                sum += value * value;
            }
            break;
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Vec:getLength:Ldata == null";

            for (long value : Ldata) {
                sum += value * value;
            }
            break;
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Vec:getLength:Fdata == null";

            for (float value : Fdata) {
                sum += value * value;
            }
            break;
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Vec:getLength:Ddata == null";

            for (double value : Ddata) {
                sum += value * value;
            }
            break;
        default:
            throw new IllegalArgumentException("Vec:getLength:type is not supported: " + this.type);
        }

        return Math.sqrt(sum);
    }

    @Override
    public Vec getNormal() {
        double length = getLength();
        assert length != 0 : "Vec:getNormal:length == 0, cannot normalize a zero vector";
    
        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Vec:getNormal:Idata == null";

            int[] intNormalData = new int[Idata.length];

            for (int i = 0; i < Idata.length; i++) {
                intNormalData[i] = (int) (Idata[i] / length);
            }

            return new Vec(intNormalData, this.type);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Vec:getNormal:Ldata == null";

            long[] longNormalData = new long[Ldata.length];

            for (int i = 0; i < Ldata.length; i++) {
                longNormalData[i] = (long) (Ldata[i] / length);
            }
            
            return new Vec(longNormalData, this.type);
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Vec:getNormal:Fdata == null";

            float[] floatNormalData = new float[Fdata.length];

            for (int i = 0; i < Fdata.length; i++) {
                floatNormalData[i] = (float) (Fdata[i] / length);
            }

            return new Vec(floatNormalData, this.type);
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Vec:getNormal:Ddata == null";

            double[] normalData = new double[Ddata.length];

            for (int i = 0; i < Ddata.length; i++) {
                normalData[i] = Ddata[i] / length;
            }

            return new Vec(normalData, this.type);
        default:
            throw new IllegalArgumentException("Vec:getNormal:type is not supported: " + this.type);
        }
    }

    @Override
    public Vec add(IVector other) {
        assert other != null : "Vec:add:other == null";
        assert this.getDimension() == other.getDimension() : "Vec:add:dimensions do not match";

        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Vec:add:Idata == null";

            int[] intData = new int[Idata.length];
            for (int i = 0; i < Idata.length; i++) {
                intData[i] = Idata[i] + other.geti(i);
            }
            return new Vec(intData, ITensor.TYPE_INT);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Vec:add:Ldata == null";

            long[] longData = new long[Ldata.length];
            for (int i = 0; i < Ldata.length; i++) {
                longData[i] = Ldata[i] + other.getl(i);
            }
            return new Vec(longData, ITensor.TYPE_LONG);
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Vec:add:Fdata == null";

            float[] floatData = new float[Fdata.length];
            for (int i = 0; i < Fdata.length; i++) {
                floatData[i] = Fdata[i] + other.getf(i);
            }
            return new Vec(floatData, ITensor.TYPE_FLOAT);
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Vec:add:Ddata == null";

            double[] doubleData = new double[Ddata.length];
            for (int i = 0; i < Ddata.length; i++) {
                doubleData[i] = Ddata[i] + other.getd(i);
            }
            return new Vec(doubleData, ITensor.TYPE_DOUBLE);
        default:
            throw new IllegalArgumentException("Vec:add:type is not supported: " + this.type);
        }
    }

    @Override
    public Vec subtract(IVector other) {
        assert other != null : "Vec:subtract:other == null";
        assert this.getDimension() == other.getDimension() : "Vec:subtract:dimensions do not match";

        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Vec:subtract:Idata == null";

            int[] intData = new int[Idata.length];
            for (int i = 0; i < Idata.length; i++) {
                intData[i] = Idata[i] - other.geti(i);
            }
            return new Vec(intData, ITensor.TYPE_INT);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Vec:subtract:Ldata == null";

            long[] longData = new long[Ldata.length];
            for (int i = 0; i < Ldata.length; i++) {
                longData[i] = Ldata[i] - other.getl(i);
            }
            return new Vec(longData, ITensor.TYPE_LONG);
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Vec:subtract:Fdata == null";

            float[] floatData = new float[Fdata.length];
            for (int i = 0; i < Fdata.length; i++) {
                floatData[i] = Fdata[i] - other.getf(i);
            }
            return new Vec(floatData, ITensor.TYPE_FLOAT);
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Vec:subtract:Ddata == null";

            double[] doubleData = new double[Ddata.length];
            for (int i = 0; i < Ddata.length; i++) {
                doubleData[i] = Ddata[i] - other.getd(i);
            }
            return new Vec(doubleData, ITensor.TYPE_DOUBLE);
        default:
            throw new IllegalArgumentException("Vec:subtract:type is not supported: " + this.type);
        }
    }

    @Override
    public Vec multiply(int scalar) {
        assert Idata != null : "Vec:multiply:Idata == null";

        int[] intData = new int[Idata.length];
        for (int i = 0; i < Idata.length; i++) {
            intData[i] = Idata[i] * scalar;
        }
        return new Vec(intData, ITensor.TYPE_INT);
    }

    @Override
    public Vec multiply(long scalar) {
        assert Ldata != null : "Vec:multiply:Ldata == null";

        long[] longData = new long[Ldata.length];
        for (int i = 0; i < Ldata.length; i++) {
            longData[i] = Ldata[i] * scalar;
        }
        return new Vec(longData, ITensor.TYPE_LONG);
    }

    @Override
    public Vec multiply(float scalar) {
        assert Fdata != null : "Vec:multiply:Fdata == null";

        float[] floatData = new float[Fdata.length];
        for (int i = 0; i < Fdata.length; i++) {
            floatData[i] = Fdata[i] * scalar;
        }
        return new Vec(floatData, ITensor.TYPE_FLOAT);
    }

    @Override
    public Vec multiply(double scalar) {
        assert Ddata != null : "Vec:multiply:Ddata == null";

        double[] doubleData = new double[Ddata.length];
        for (int i = 0; i < Ddata.length; i++) {
            doubleData[i] = Ddata[i] * scalar;
        }
        return new Vec(doubleData, ITensor.TYPE_DOUBLE);
    }

    @Override
    public int doti(IVector other) {
        assert other != null : "Vec:dot:other == null";
        assert Idata != null : "Vec:dot:Idata == null";
        assert this.getDimension() == other.getDimension() : "Vec:dot:dimensions do not match";

        int sum = 0;

        for (int i = 0; i < Idata.length; i++) {
            sum += Idata[i] * other.geti(i);
        }

        return sum;
    }

    @Override
    public long dotl(IVector other) {
        assert other != null : "Vec:dotl:other == null";
        assert Ldata != null : "Vec:dotl:Ldata == null";
        assert this.getDimension() == other.getDimension() : "Vec:dotl:dimensions do not match";

        long sum = 0;

        for (int i = 0; i < Ldata.length; i++) {
            sum += Ldata[i] * other.getl(i);
        }

        return sum;
    }

    @Override
    public float dotf(IVector other) {
        assert other != null : "Vec:dotf:other == null";
        assert Fdata != null : "Vec:dotf:Fdata == null";
        assert this.getDimension() == other.getDimension() : "Vec:dotf:dimensions do not match";

        float sum = 0.0f;

        for (int i = 0; i < Fdata.length; i++) {
            sum += Fdata[i] * other.getf(i);
        }

        return sum;
    }

    @Override
    public double dotd(IVector other) {
        assert other != null : "Vec:dotd:other == null";
        assert Ddata != null : "Vec:dotd:Ddata == null";
        assert this.getDimension() == other.getDimension() : "Vec:dotd:dimensions do not match";

        double sum = 0.0;

        for (int i = 0; i < Ddata.length; i++) {
            sum += Ddata[i] * other.getd(i);
        }

        return sum;
    }

    @Override
    public Vec cross(IVector other) {
        assert this.getDimension() == 3  : "Vec:cross: this vector must be 3D";
        assert other.getDimension() == 3 : "Vec:cross: other vector must be 3D";

        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Vec:cross: Idata is null";

            int[] intResult = new int[3];
            int i1 = Idata[0], i2 = Idata[1], i3 = Idata[2];
            int ib1 = other.geti(0);
            int ib2 = other.geti(1);
            int ib3 = other.geti(2);

            intResult[0] = i2 * ib3 - i3 * ib2;
            intResult[1] = i3 * ib1 - i1 * ib3;
            intResult[2] = i1 * ib2 - i2 * ib1;

            return new Vec(intResult, ITensor.TYPE_INT);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Vec:cross: Ldata is null";

            long[] longResult = new long[3];
            long l1 = Ldata[0], l2 = Ldata[1], l3 = Ldata[2];
            long lb1 = other.getl(0);
            long lb2 = other.getl(1);
            long lb3 = other.getl(2);

            longResult[0] = l2 * lb3 - l3 * lb2;
            longResult[1] = l3 * lb1 - l1 * lb3;
            longResult[2] = l1 * lb2 - l2 * lb1;

            return new Vec(longResult, ITensor.TYPE_LONG);
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Vec:cross: Fdata is null";

            float[] floatResult = new float[3];
            float f1 = Fdata[0], f2 = Fdata[1], f3 = Fdata[2];
            float fb1 = other.getf(0);
            float fb2 = other.getf(1);
            float fb3 = other.getf(2);

            floatResult[0] = f2 * fb3 - f3 * fb2;
            floatResult[1] = f3 * fb1 - f1 * fb3;
            floatResult[2] = f1 * fb2 - f2 * fb1;

            return new Vec(floatResult, ITensor.TYPE_FLOAT);
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Vec:cross: Ddata is null";

            double[] doubleResult = new double[3];
            double d1 = Ddata[0], d2 = Ddata[1], d3 = Ddata[2];
            double db1 = other.getd(0);
            double db2 = other.getd(1);
            double db3 = other.getd(2);

            doubleResult[0] = d2 * db3 - d3 * db2;
            doubleResult[1] = d3 * db1 - d1 * db3;
            doubleResult[2] = d1 * db2 - d2 * db1;

            return new Vec(doubleResult, ITensor.TYPE_DOUBLE);
        default:
            throw new UnsupportedOperationException("Vec:cross: unsupported type: " + this.type);
        }
    }
}
