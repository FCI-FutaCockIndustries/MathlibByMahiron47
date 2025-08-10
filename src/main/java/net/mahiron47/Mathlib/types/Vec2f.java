package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec2f implements IVector {
    private float x;
    private float y;

    public Vec2f(float x, float y) {
        this.x = x;
        this.y = y;
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
        
        return vec.getf(0) == this.x && vec.getf(1) == this.y;
    }

    @Override
    public int hashCode() {
        int result;
        result = Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        return result;
    }

    @Override
    public String toString() {
        return "Vec2f{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int geti(int i) {
        switch (i) {
            case 0: return (int) x;
            case 1: return (int) y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2f");
        }
    }

    @Override
    public long getl(int i) {
        switch (i) {
            case 0: return (long) x;
            case 1: return (long) y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2f");
        }
    }

    @Override
    public float getf(int i) {
        switch (i) {
            case 0: return x;
            case 1: return y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2f");
        }
    }

    @Override
    public double getd(int i) {
        switch (i) {
            case 0: return (double) x;
            case 1: return (double) y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2f");
        }
    }

    @Override
    public void set(int i, int a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2f");
        }
    }

    @Override
    public void set(int i, long a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2f");
        }
    }

    @Override
    public void set(int i, float a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2f");
        }
    }

    @Override
    public void set(int i, double a_i) {
        switch (i) {
            case 0: x = (float) a_i; break;
            case 1: y = (float) a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2f");
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
    public Vec2f getNormal() {
        double length = getLength();
        
        assert length != 0 : "Vec2f:getNormal: Cannot normalize a zero-length vector";

        return new Vec2f((float) (this.x / length), (float) (this.y / length));
    }

    @Override
    public Vec2f copy() {
        return new Vec2f(this.x, this.y);
    }

    @Override
    public Mat convert() {
        return new Mat(new float[][] {
            {this.x},
            {this.y}
        }, ITensor.TYPE_FLOAT);
    }

    @Override
    public Vec2f add(IVector other) {
        return new Vec2f(this.x + other.getf(0), this.y + other.getf(1));
    }

    @Override
    public Vec2f subtract(IVector other) {
        return new Vec2f(this.x - other.getf(0), this.y - other.getf(1));
    }

    @Override
    public Vec2f multiply(int scalar) {
        return new Vec2f(this.x * scalar, this.y * scalar);
    }

    @Override
    public Vec2f multiply(long scalar) {
        return new Vec2f(this.x * scalar, this.y * scalar);
    }

    @Override
    public Vec2f multiply(float scalar) {
        return new Vec2f(this.x * scalar, this.y * scalar);
    }

    @Override
    public Vec2f multiply(double scalar) {
        return new Vec2f((float) (this.x * scalar), (float) (this.y * scalar));
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
        return this.x * other.getf(0) + this.y * other.getf(1);
    }

    @Override
    public double dotd(IVector other) {
        return this.x * other.getd(0) + this.y * other.getd(1);
    }

    @Override
    public IVector cross(IVector other) {
        assert other != null : "Vec2f:cross: Other vector cannot be null";
        
        switch (other.getDimension()) {
            case 2:
                return new Vec3f(
                    0,
                    0,
                    this.x * other.getf(1) - this.y * other.getf(0)
                );
            case 3:
                return new Vec3f(
                    this.y * other.getf(2),
                    -this.x * other.getf(2),
                    this.x * other.getf(1) - this.y * other.getf(0)
                );
            case 4:
                return new Vec4f(
                    this.y * other.getf(2),
                    -this.x * other.getf(2),
                    this.x * other.getf(1) - this.y * other.getf(0),
                    other.getf(3)
                );
            default:
                throw new IllegalArgumentException("Vec2f:cross: Other vector must be of dimension 2 or 3");
        }
    }
}
