package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec4d implements IVector {
    private double x;
    private double y;
    private double z;
    private double w;

    public Vec4d(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public byte getType() {
        return ITensor.TYPE_DOUBLE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IVector)) return false;

        IVector vec = (IVector) obj;
        
        return vec.getd(0) == this.x && vec.getd(1) == this.y && 
               vec.getd(2) == this.z && vec.getd(3) == this.w;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(w);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Vec4d{" +
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
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4d");
        }
    }

    @Override
    public long getl(int i) {
        switch (i) {
            case 0: return (long) x;
            case 1: return (long) y;
            case 2: return (long) z;
            case 3: return (long) w;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4d");
        }
    }

    @Override
    public float getf(int i) {
        switch (i) {
            case 0: return (float) x;
            case 1: return (float) y;
            case 2: return (float) z;
            case 3: return (float) w;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4d");
        }
    }

    @Override
    public double getd(int i) {
        switch (i) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            case 3: return w;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4d");
        }
    }

    @Override
    public void set(int i, int a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            case 3: w = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4d");
        }
    }

    @Override
    public void set(int i, long a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            case 3: w = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4d");
        }
    }

    @Override
    public void set(int i, float a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            case 3: w = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4d");
        }
    }

    @Override
    public void set(int i, double a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            case 3: w = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4d");
        }
    }

    @Override
    public int getDimension() {
        return 4;
    }

    @Override
    public Vec4d copy() {
        return new Vec4d(x, y, z, w);
    }

    @Override
    public Mat convert() {
        double[][] matrixData = {
            {x},
            {y},
            {z},
            {w}
        };

        return new Mat(matrixData, ITensor.TYPE_DOUBLE);
    }

    @Override
    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public Vec4d getNormal() {
        double length = getLength();
        
        assert length != 0 : "Vec4d:getNormal: Cannot normalize a zero-length vector";
        
        return new Vec4d(x / length, y / length, z / length, w / length);
    }

    @Override
    public Vec4d add(IVector other) {
        assert other != null : "Vec4d:add: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4d:add: Other vector must be of dimension 4";
        
        return new Vec4d(
            this.x + other.getd(0),
            this.y + other.getd(1),
            this.z + other.getd(2),
            this.w + other.getd(3)
        );
    }

    @Override
    public Vec4d subtract(IVector other) {
        assert other != null : "Vec4d:subtract: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4d:subtract: Other vector must be of dimension 4";
        
        return new Vec4d(
            this.x - other.getd(0),
            this.y - other.getd(1),
            this.z - other.getd(2),
            this.w - other.getd(3)
        );
    }

    @Override
    public Vec4d multiply(int scalar) {
        return new Vec4d(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar,
            this.w * scalar
        );
    }

    @Override
    public Vec4d multiply(long scalar) {
        return new Vec4d(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar,
            this.w * scalar
        );
    }

    @Override
    public Vec4d multiply(float scalar) {
        return new Vec4d(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar,
            this.w * scalar
        );
    }

    @Override
    public Vec4d multiply(double scalar) {
        return new Vec4d(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar,
            this.w * scalar
        );
    }

    @Override
    public int doti(IVector other) {
        assert other != null : "Vec4d:doti: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4d:doti: Other vector must be of dimension 4";

        return (int) (this.x * other.geti(0) + this.y * other.geti(1) + 
                      this.z * other.geti(2) + this.w * other.geti(3));
    }

    @Override
    public long dotl(IVector other) {
        assert other != null : "Vec4d:dotl: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4d:dotl: Other vector must be of dimension 4";

        return (long) (this.x * other.getl(0) + this.y * other.getl(1) + 
                       this.z * other.getl(2) + this.w * other.getl(3));
    }

    @Override
    public float dotf(IVector other) {
        assert other != null : "Vec4d:dotf: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4d:dotf: Other vector must be of dimension 4";

        return (float) (this.x * other.getf(0) + this.y * other.getf(1) + 
                        this.z * other.getf(2) + this.w * other.getf(3));
    }

    @Override
    public double dotd(IVector other) {
        assert other != null : "Vec4d:dotd: Other vector cannot be null";
        assert other.getDimension() == 4 : "Vec4d:dotd: Other vector must be of dimension 4";

        return this.x * other.getd(0) + this.y * other.getd(1) + 
               this.z * other.getd(2) + this.w * other.getd(3);
    }

    @Override
    public Vec4d cross(IVector other) {
        assert other != null : "Vec4d:cross: Other vector cannot be null";

        switch (other.getDimension()) {
            case 2:
                return new Vec4d(
                    -this.z * other.getd(1),
                    this.z * other.getd(0), 
                    this.x * other.getd(1) - this.y * other.getd(0),
                    this.w
                );
            case 3:
                return new Vec4d(
                    this.y * other.getd(2) - this.z * other.getd(1),
                    this.z * other.getd(0) - this.x * other.getd(2),
                    this.x * other.getd(1) - this.y * other.getd(0),
                    this.w
                );
            case 4:
                return new Vec4d(
                    this.y * other.getd(2) - this.z * other.getd(1),
                    this.z * other.getd(0) - this.x * other.getd(2),
                    this.x * other.getd(1) - this.y * other.getd(0),
                    this.w * other.getd(3)
                );
            default:
                throw new IllegalArgumentException("Vec4d:cross: Other vector must be of dimension 3 or 4");
        }
    }
}
