package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec3l implements IVector {
    private long x;
    private long y;
    private long z;

    public Vec3l(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IVector)) return false;

        IVector vec = (IVector) obj;
        
        return vec.getl(0) == this.x && vec.getl(1) == this.y && vec.getl(2) == this.z;
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(x);
        result = 31 * result + Long.hashCode(y);
        result = 31 * result + Long.hashCode(z);
        return result;
    }

    @Override
    public String toString() {
        return "Vec3l{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public int geti(int i) {
        switch (i) {
            case 0: return (int) x;
            case 1: return (int) y;
            case 2: return (int) z;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3l");
        }
    }

    @Override
    public long getl(int i) {
        switch (i) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3l");
        }
    }

    @Override
    public float getf(int i) {
        switch (i) {
            case 0: return (float) x;
            case 1: return (float) y;
            case 2: return (float) z;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3l");
        }
    }

    @Override
    public double getd(int i) {
        switch (i) {
            case 0: return (double) x;
            case 1: return (double) y;
            case 2: return (double) z;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3l");
        }
    }

    @Override
    public void set(int i, int a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3l");
        }
    }

    @Override
    public void set(int i, long a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3l");
        }
    }

    @Override
    public void set(int i, float a_i) {
        switch (i) {
            case 0: x = (long) a_i; break;
            case 1: y = (long) a_i; break;
            case 2: z = (long) a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3l");
        }
    }

    @Override
    public void set(int i, double a_i) {
        switch (i) {
            case 0: x = (long) a_i; break;
            case 1: y = (long) a_i; break;
            case 2: z = (long) a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3l");
        }
    }

    @Override
    public int getDimension() {
        return 3;
    }

    @Override
    public Vec3l copy() {
        return new Vec3l(x, y, z);
    }

    @Override
    public Mat convert() {
        long[][] matrixData = {
            {this.x},
            {this.y},
            {this.z}
        };

        return new Mat(matrixData, ITensor.TYPE_LONG);
    }

    @Override
    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public Vec3l getNormal() {
        double length = getLength();
        
        assert length != 0 : "Vec3l:getNormal: Cannot normalize a zero-length vector";
        
        return new Vec3l((long)(x / length), (long)(y / length), (long)(z / length));
    }

    @Override
    public Vec3l add(IVector other) {
        assert other != null : "Vec3l:add: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3l:add: Other vector must be of dimension 3";
        
        return new Vec3l(
            this.x + other.getl(0),
            this.y + other.getl(1),
            this.z + other.getl(2)
        );
    }

    @Override
    public Vec3l subtract(IVector other) {
        assert other != null : "Vec3l:subtract: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3l:subtract: Other vector must be of dimension 3";
        
        return new Vec3l(
            this.x - other.getl(0),
            this.y - other.getl(1),
            this.z - other.getl(2)
        );
    }

    @Override
    public Vec3l multiply(int scalar) {
        return new Vec3l(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar
        );
    }

    @Override
    public Vec3l multiply(long scalar) {
        return new Vec3l(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar
        );
    }

    @Override
    public Vec3l multiply(float scalar) {
        return new Vec3l(
            (long) (this.x * scalar),
            (long) (this.y * scalar),
            (long) (this.z * scalar)
        );
    }

    @Override
    public Vec3l multiply(double scalar) {
        return new Vec3l(
            (long) (this.x * scalar),
            (long) (this.y * scalar),
            (long) (this.z * scalar)
        );
    }

    @Override
    public int doti(IVector other) {
        assert other != null : "Vec3l:doti: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3l:doti: Other vector must be of dimension 3";

        return (int) (this.x * other.geti(0) + this.y * other.geti(1) + this.z * other.geti(2));
    }

    @Override
    public long dotl(IVector other) {
        assert other != null : "Vec3l:dotl: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3l:dotl: Other vector must be of dimension 3";

        return this.x * other.getl(0) + this.y * other.getl(1) + this.z * other.getl(2);
    }

    @Override
    public float dotf(IVector other) {
        assert other != null : "Vec3l:dotf: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3l:dotf: Other vector must be of dimension 3";

        return (float) (this.x * other.getf(0) + this.y * other.getf(1) + this.z * other.getf(2));
    }

    @Override
    public double dotd(IVector other) {
        assert other != null : "Vec3l:dotd: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3l:dotd: Other vector must be of dimension 3";

        return (double) (this.x * other.getd(0) + this.y * other.getd(1) + this.z * other.getd(2));
    }

    @Override
    public Vec3l cross(IVector other) {
        assert other != null : "Vec3l:cross: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3l:cross: Other vector must be of dimension 3";

        return new Vec3l(
            this.y * other.getl(2) - this.z * other.getl(1),
            this.z * other.getl(0) - this.x * other.getl(2),
            this.x * other.getl(1) - this.y * other.getl(0)
        );
    }
}
