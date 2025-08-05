package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec3d implements IVector {
    private double x;
    private double y;
    private double z;

    public Vec3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
        
        return vec.getd(0) == this.x && vec.getd(1) == this.y && vec.getd(2) == this.z;
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
        return result;
    }

    @Override
    public String toString() {
        return "Vec3d{" +
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
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3d");
        }
    }

    @Override
    public long getl(int i) {
        switch (i) {
            case 0: return (long) x;
            case 1: return (long) y;
            case 2: return (long) z;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3d");
        }
    }

    @Override
    public float getf(int i) {
        switch (i) {
            case 0: return (float) x;
            case 1: return (float) y;
            case 2: return (float) z;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3d");
        }
    }

    @Override
    public double getd(int i) {
        switch (i) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3d");
        }
    }

    @Override
    public void set(int i, int a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3d");
        }
    }

    @Override
    public void set(int i, long a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3d");
        }
    }

    @Override
    public void set(int i, float a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3d");
        }
    }

    @Override
    public void set(int i, double a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            case 2: z = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3d");
        }
    }

    @Override
    public int getDimension() {
        return 3;
    }

    @Override
    public Vec3d copy() {
        return new Vec3d(x, y, z);
    }

    @Override
    public Mat convert() {
        double[][] matrixData = {
            {x},
            {y},
            {z}
        };

        return new Mat(matrixData, ITensor.TYPE_DOUBLE);
    }

    @Override
    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public Vec3d getNormal() {
        double length = getLength();
        
        assert length != 0 : "Vec3d:getNormal: Cannot normalize a zero-length vector";
        
        return new Vec3d(x / length, y / length, z / length);
    }

    @Override
    public Vec3d add(IVector other) {
        assert other != null : "Vec3d:add: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3d:add: Other vector must be of dimension 3";
        
        return new Vec3d(
            this.x + other.getd(0),
            this.y + other.getd(1),
            this.z + other.getd(2)
        );
    }

    @Override
    public Vec3d subtract(IVector other) {
        assert other != null : "Vec3d:subtract: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3d:subtract: Other vector must be of dimension 3";
        
        return new Vec3d(
            this.x - other.getd(0),
            this.y - other.getd(1),
            this.z - other.getd(2)
        );
    }

    @Override
    public Vec3d multiply(int scalar) {
        return new Vec3d(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar
        );
    }

    @Override
    public Vec3d multiply(long scalar) {
        return new Vec3d(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar
        );
    }

    @Override
    public Vec3d multiply(float scalar) {
        return new Vec3d(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar
        );
    }

    @Override
    public Vec3d multiply(double scalar) {
        return new Vec3d(
            this.x * scalar,
            this.y * scalar,
            this.z * scalar
        );
    }

    @Override
    public int doti(IVector other) {
        assert other != null : "Vec3d:doti: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3d:doti: Other vector must be of dimension 3";

        return (int) (this.x * other.geti(0) + this.y * other.geti(1) + this.z * other.geti(2));
    }

    @Override
    public long dotl(IVector other) {
        assert other != null : "Vec3d:dotl: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3d:dotl: Other vector must be of dimension 3";

        return (long) (this.x * other.getl(0) + this.y * other.getl(1) + this.z * other.getl(2));
    }

    @Override
    public float dotf(IVector other) {
        assert other != null : "Vec3d:dotf: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3d:dotf: Other vector must be of dimension 3";

        return (float) (this.x * other.getf(0) + this.y * other.getf(1) + this.z * other.getf(2));
    }

    @Override
    public double dotd(IVector other) {
        assert other != null : "Vec3d:dotd: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3d:dotd: Other vector must be of dimension 3";

        return this.x * other.getd(0) + this.y * other.getd(1) + this.z * other.getd(2);
    }

    @Override
    public Vec3d cross(IVector other) {
        assert other != null : "Vec3d:cross: Other vector cannot be null";
        assert other.getDimension() == 3 : "Vec3d:cross: Other vector must be of dimension 3";

        return new Vec3d(
            this.y * other.getd(2) - this.z * other.getd(1),
            this.z * other.getd(0) - this.x * other.getd(2),
            this.x * other.getd(1) - this.y * other.getd(0)
        );
    }
}
