package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec3f implements IVector {
    private float x;
    private float y;
    private float z;

    public Vec3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public byte getType() {
        return ITensor.TYPE_FLOAT;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IVector)) return false;

        IVector vec = (IVector) obj;
        
        return vec.getf(0) == this.x && vec.getf(1) == this.y && vec.getf(2) == this.z;
    }

    @Override
    public int hashCode() {
        int result;
        result = Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        result = 31 * result + Float.floatToIntBits(z);
        return result;
    }

    @Override
    public String toString() {
        return "Vec3f{" +
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
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3f");
        }
    }

    @Override
    public long getl(int i) {
        switch (i) {
            case 0: return (long) x;
            case 1: return (long) y;
            case 2: return (long) z;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3f");
        }
    }

    @Override
    public float getf(int i) {
        switch (i) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3f");
        }
    }

    @Override
    public double getd(int i) {
        switch (i) {
            case 0: return (double) x;
            case 1: return (double) y;
            case 2: return (double) z;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3f");
        }
    }

    @Override
    public void set(int i, int a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3f");
        }
    }

    @Override
    public void set(int i, long a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3f");
        }
    }

    @Override
    public void set(int i, float a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3f");
        }
    }

    @Override
    public void set(int i, double a_i) {
        switch (i) {
            case 0: x = (float) a_i; break;
            case 1: y = (float) a_i; break;
            case 2: z = (float) a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3f");
        }
    }

    @Override
    public int getDimension() {
        return 3;
    }

    @Override
    public Vec3f copy() {
        return new Vec3f(x, y, z);
    }

    @Override
    public Mat convert() {
        float[][] matrixData = {
            {this.x},
            {this.y},
            {this.z}
        };

        return new Mat(matrixData, ITensor.TYPE_FLOAT);
    }

    @Override
    public double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    @Override
    public Vec3f getNormal() {
        double length = getLength();
        
        assert length != 0 : "Vec3f:getNormal: Cannot normalize a zero-length vector";
        
        return new Vec3f((float)(x / length), (float)(y / length), (float)(z / length));
    }

    @Override
    public Vec3f add(IVector other) {
        assert other != null : "Vec3f:add: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3f:add: Other vector must be of dimension 3";
        
        return new Vec3f(
            this.x + other.getf(0),
            this.y + other.getf(1),
            this.z + other.getf(2)
        );
    }

    @Override
    public Vec3f subtract(IVector other) {
        assert other != null : "Vec3f:subtract: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3f:subtract: Other vector must be of dimension 3";
        
        return new Vec3f(
            this.x - other.getf(0),
            this.y - other.getf(1),
            this.z - other.getf(2)
        );
    }

    @Override
    public Vec3f multiply(int scalar) {
        return new Vec3f(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar
        );
    }

    @Override
    public Vec3f multiply(long scalar) {
        return new Vec3f(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar
        );
    }

    @Override
    public Vec3f multiply(float scalar) {
        return new Vec3f(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar
        );
    }

    @Override
    public Vec3f multiply(double scalar) {
        return new Vec3f(
            (float) (this.x * scalar),
            (float) (this.y * scalar),
            (float) (this.z * scalar)
        );
    }

    @Override
    public int doti(IVector other) {
        assert other != null : "Vec3f:doti: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3f:doti: Other vector must be of dimension 3";

        return (int) (this.x * other.geti(0) + this.y * other.geti(1) + this.z * other.geti(2));
    }

    @Override
    public long dotl(IVector other) {
        assert other != null : "Vec3f:dotl: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3f:dotl: Other vector must be of dimension 3";

        return (long) (this.x * other.getl(0) + this.y * other.getl(1) + this.z * other.getl(2));
    }

    @Override
    public float dotf(IVector other) {
        assert other != null : "Vec3f:dotf: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3f:dotf: Other vector must be of dimension 3";

        return this.x * other.getf(0) + this.y * other.getf(1) + this.z * other.getf(2);
    }

    @Override
    public double dotd(IVector other) {
        assert other != null : "Vec3f:dotd: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3f:dotd: Other vector must be of dimension 3";

        return (double) (this.x * other.getd(0) + this.y * other.getd(1) + this.z * other.getd(2));
    }

    @Override
    public IVector cross(IVector other) {
        assert other != null : "Vec3f:cross: Other vector cannot be null";

        switch (other.getDimension()) {
            case 2:
                return new Vec3f(
                    -this.z * other.getf(1),
                    this.z * other.getf(0),
                    this.x * other.getf(1) - this.y * other.getf(0)
                );
            case 3:
                return new Vec3f(
                    this.y * other.getf(2) - this.z * other.getf(1),
                    this.z * other.getf(0) - this.x * other.getf(2),
                    this.x * other.getf(1) - this.y * other.getf(0)
                );
            case 4:
                return new Vec4f(
                    this.y * other.getf(2) - this.z * other.getf(1),
                    this.z * other.getf(0) - this.x * other.getf(2),
                    this.x * other.getf(1) - this.y * other.getf(0),
                    other.getf(3)
                );
            default:
                throw new IllegalArgumentException("Vec3f:cross: Other vector must be of dimension 2 or 3");
        }
    }
}
