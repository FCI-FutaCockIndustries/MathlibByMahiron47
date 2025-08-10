package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec2d implements IVector {
    private double x;
    private double y;

    public Vec2d(double x, double y) {
        this.x = x;
        this.y = y;
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

        return vec.getd(0) == this.x && vec.getd(1) == this.y;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Vec2d{" +
                  "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int geti(int i) {
        switch (i) {
            case 0: return (int) x;
            case 1: return (int) y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2d");
        }
    }

    @Override
    public long getl(int i) {
        switch (i) {
            case 0: return (long) x;
            case 1: return (long) y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2d");
        }
    }

    @Override
    public float getf(int i) {
        switch (i) {
            case 0: return (float) x;
            case 1: return (float) y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2d");
        }
    }

    @Override
    public double getd(int i) {
        switch (i) {
            case 0: return x;
            case 1: return y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2d");
        }
    }

    @Override
    public void set(int i, int a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2d");
        }
    }

    @Override
    public void set(int i, long a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2d");
        }
    }

    @Override
    public void set(int i, float a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2d");
        }
    }

    @Override
    public void set(int i, double a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2d");
        }
    }

    @Override
    public int getDimension() {
        return 2;
    }

    @Override
    public double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    @Override
    public Vec2d getNormal() {
        double length = getLength();
        
        assert length != 0 : "Vec2d:getNormal: Length is zero, cannot normalize a zero vector.";

        return new Vec2d(this.x / length, this.y / length);
    }

    @Override
    public Vec2d copy() {
        return new Vec2d(this.x, this.y);
    }

    @Override
    public Mat convert() {
        return new Mat(new double[][] {
            {this.x},
            {this.y}
        }, ITensor.TYPE_DOUBLE);
    }

    @Override
    public Vec2d add(IVector other) {
        return new Vec2d(this.x + other.getd(0), this.y + other.getd(1));
    }

    @Override
    public Vec2d subtract(IVector other) {
        return new Vec2d(this.x - other.getd(0), this.y - other.getd(1));
    }

    @Override
    public Vec2d multiply(int scalar) {
        return new Vec2d(this.x * scalar, this.y * scalar);
    }

    @Override
    public Vec2d multiply(long scalar) {
        return new Vec2d(this.x * scalar, this.y * scalar);
    }

    @Override
    public Vec2d multiply(float scalar) {
        return new Vec2d(this.x * scalar, this.y * scalar);
    }

    @Override
    public Vec2d multiply(double scalar) {
        return new Vec2d(this.x * scalar, this.y * scalar);
    }

    @Override
    public int doti(IVector other) {
        return (int) (this.x * other.geti(0) + this.y * other.geti(1));
    }

    @Override
    public long dotl(IVector other) {
        return (long) (this.x * other.getl(0) + this.y * other.getl(1));
    }

    @Override
    public float dotf(IVector other) {
        return (float) (this.x * other.getf(0) + this.y * other.getf(1));
    }

    @Override
    public double dotd(IVector other) {
        return this.x * other.getd(0) + this.y * other.getd(1);
    }

    @Override
    public IVector cross(IVector other) {
        assert other != null : "Vec2d:cross: Other vector cannot be null";

        switch (other.getDimension()) {
            case 2:
                return new Vec3d(
                    0,
                    0,
                    this.x * other.getd(1) - this.y * other.getd(0)
                );
            case 3:
                return new Vec3d(
                    this.y * other.getd(2),
                    -this.x * other.getd(2),
                    this.x * other.getd(1) - this.y * other.getd(0)
                );
            case 4:
                return new Vec4d(
                    this.y * other.getd(2),
                    -this.x * other.getd(2),
                    this.x * other.getd(1) - this.y * other.getd(0),
                    other.getd(3)
                );
            default:
                throw new IllegalArgumentException("Vec2d:cross: Other vector must be of dimension 2 or 3");
        }
    }
}
