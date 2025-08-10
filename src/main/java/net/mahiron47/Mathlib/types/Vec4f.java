package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec4f implements IVector {
    private float x;
    private float y;
    private float z;
    private float w;

    public Vec4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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
        
        return vec.getf(0) == this.x && vec.getf(1) == this.y && 
               vec.getf(2) == this.z && vec.getf(3) == this.w;
    }

    @Override
    public int hashCode() {
        int result;
        result = Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        result = 31 * result + Float.floatToIntBits(z);
        result = 31 * result + Float.floatToIntBits(w);
        return result;
    }

    @Override
    public String toString() {
        return "Vec4f{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w=" + w +
                '}';
    }

    @Override
    public int geti(int i) {
        switch (i) {
            case 0: return (int) x;
            case 1: return (int) y;
            case 2: return (int) z;
            case 3: return (int) w;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4f");
        }
    }

    @Override
    public long getl(int i) {
        switch (i) {
            case 0: return (long) x;
            case 1: return (long) y;
            case 2: return (long) z;
            case 3: return (long) w;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4f");
        }
    }

    @Override
    public float getf(int i) {
        switch (i) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            case 3: return w;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4f");
        }
    }

    @Override
    public double getd(int i) {
        switch (i) {
            case 0: return (double) x;
            case 1: return (double) y;
            case 2: return (double) z;
            case 3: return (double) w;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4f");
        }
    }

    @Override
    public void set(int i, int a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            case 3: w = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4f");
        }
    }

    @Override
    public void set(int i, long a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            case 3: w = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4f");
        }
    }

    @Override
    public void set(int i, float a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            case 3: w = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4f");
        }
    }

    @Override
    public void set(int i, double a_i) {
        switch (i) {
            case 0: x = (float) a_i; break;
            case 1: y = (float) a_i; break;
            case 2: z = (float) a_i; break;
            case 3: w = (float) a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4f");
        }
    }

    @Override
    public int getDimension() {
        return 4;
    }

    @Override
    public Vec4f copy() {
        return new Vec4f(x, y, z, w);
    }

    @Override
    public Mat convert() {
        float[][] matrixData = {
            {this.x},
            {this.y},
            {this.z},
            {this.w}
        };

        return new Mat(matrixData, ITensor.TYPE_FLOAT);
    }

    @Override
    public double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }

    @Override
    public Vec4f getNormal() {
        double length = getLength();
        
        assert length != 0 : "Vec4f:getNormal: Cannot normalize a zero-length vector";
        
        return new Vec4f((float)(x / length), (float)(y / length), (float)(z / length), (float)(w / length));
    }

    @Override
    public Vec4f add(IVector other) {
        assert other != null : "Vec4f:add: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4f:add: Other vector must be of dimension 4";
        
        return new Vec4f(
            this.x + other.getf(0),
            this.y + other.getf(1),
            this.z + other.getf(2),
            this.w + other.getf(3)
        );
    }

    @Override
    public Vec4f subtract(IVector other) {
        assert other != null : "Vec4f:subtract: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4f:subtract: Other vector must be of dimension 4";
        
        return new Vec4f(
            this.x - other.getf(0),
            this.y - other.getf(1),
            this.z - other.getf(2),
            this.w - other.getf(3)
        );
    }

    @Override
    public Vec4f multiply(int scalar) {
        return new Vec4f(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar,
            this.w * scalar
        );
    }

    @Override
    public Vec4f multiply(long scalar) {
        return new Vec4f(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar,
            this.w * scalar
        );
    }

    @Override
    public Vec4f multiply(float scalar) {
        return new Vec4f(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar,
            this.w * scalar
        );
    }

    @Override
    public Vec4f multiply(double scalar) {
        return new Vec4f(
            (float) (this.x * scalar),
            (float) (this.y * scalar),
            (float) (this.z * scalar),
            (float) (this.w * scalar)
        );
    }

    @Override
    public int doti(IVector other) {
        assert other != null : "Vec4f:doti: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4f:doti: Other vector must be of dimension 4";

        return (int) (this.x * other.geti(0) + this.y * other.geti(1) + 
                      this.z * other.geti(2) + this.w * other.geti(3));
    }

    @Override
    public long dotl(IVector other) {
        assert other != null : "Vec4f:dotl: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4f:dotl: Other vector must be of dimension 4";

        return (long) (this.x * other.getl(0) + this.y * other.getl(1) + 
                       this.z * other.getl(2) + this.w * other.getl(3));
    }

    @Override
    public float dotf(IVector other) {
        assert other != null : "Vec4f:dotf: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4f:dotf: Other vector must be of dimension 4";

        return this.x * other.getf(0) + this.y * other.getf(1) + 
               this.z * other.getf(2) + this.w * other.getf(3);
    }

    @Override
    public double dotd(IVector other) {
        assert other != null : "Vec4f:dotd: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4f:dotd: Other vector must be of dimension 4";

        return (double) (this.x * other.getd(0) + this.y * other.getd(1) + 
                         this.z * other.getd(2) + this.w * other.getd(3));
    }

    @Override
    public Vec4f cross(IVector other) {
        assert other != null : "Vec4f:cross: Other vector cannot be null";

        switch (other.getDimension()) {
            case 2:
                return new Vec4f(
                    -this.z * other.getf(1),
                    this.z * other.getf(0), 
                    this.x * other.getf(1) - this.y * other.getf(0),
                    this.w
                );
            case 3:
                return new Vec4f(
                    this.y * other.getf(2) - this.z * other.getf(1),
                    this.z * other.getf(0) - this.x * other.getf(2),
                    this.x * other.getf(1) - this.y * other.getf(0),
                    this.w
                );
            case 4:
                return new Vec4f(
                    this.y * other.getf(2) - this.z * other.getf(1),
                    this.z * other.getf(0) - this.x * other.getf(2),
                    this.x * other.getf(1) - this.y * other.getf(0),
                    this.w * other.getf(3)
                );
            default:
                throw new IllegalArgumentException("Vec4f:cross: Other vector must be of dimension 3 or 4");
        }
    }
}
