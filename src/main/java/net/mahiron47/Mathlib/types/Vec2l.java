package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec2l implements IVector {
    private long x;
    private long y;

    public Vec2l(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public byte getType() {
        return ITensor.TYPE_LONG;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IVector)) return false;

        IVector vec = (IVector) obj;

        return vec.getl(0) == this.x && vec.getl(1) == this.y;
    }

    @Override
    public int geti(int i) {
        switch (i) {
            case 0: return (int) x;
            case 1: return (int) y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2l");
        }
    }

    @Override
    public long getl(int i) {
        switch (i) {
            case 0: return x;
            case 1: return y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2l");
        }
    }

    @Override
    public float getf(int i) {
        switch (i) {
            case 0: return (float) x;
            case 1: return (float) y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2l");
        }
    }

    @Override
    public double getd(int i) {
        switch (i) {
            case 0: return (double) x;
            case 1: return (double) y;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2l");
        }
    }

    @Override
    public void set(int i, int a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2l");
        }
    }

    @Override
    public void set(int i, long a_i) {
        switch (i) {
            case 0: x = a_i; break;
            case 1: y = a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2l");
        }
    }

    @Override
    public void set(int i, float a_i) {
        switch (i) {
            case 0: x = (long) a_i; break;
            case 1: y = (long) a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2l");
        }
    }

    @Override
    public void set(int i, double a_i) {
        switch (i) {
            case 0: x = (long) a_i; break;
            case 1: y = (long) a_i; break;
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2l");
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
    public Vec2l getNormal() {
        double length = getLength();
        
        assert length != 0 : "Vec2l:getNormal: Length cannot be zero when normalizing a vector.";

        return new Vec2l((long) (this.x / length), (long) (this.y / length));
    }

    @Override
    public Vec2l copy() {
        return new Vec2l(this.x, this.y);
    }

    @Override
    public Mat convert() {
        return new Mat(new long[][] {
            {this.x},
            {this.y}
        }, ITensor.TYPE_LONG);
    }

    @Override
    public Vec2l add(IVector other) {
        return new Vec2l(this.x + other.getl(0), this.y + other.getl(1));
    }

    @Override
    public Vec2l subtract(IVector other) {
        return new Vec2l(this.x - other.getl(0), this.y - other.getl(1));
    }

    @Override
    public Vec2l multiply(int scalar) {
        return new Vec2l(this.x * scalar, this.y * scalar);
    }

    @Override
    public Vec2l multiply(long scalar) {
        return new Vec2l(this.x * scalar, this.y * scalar);
    }

    @Override
    public Vec2l multiply(float scalar) {
        return new Vec2l((long) (this.x * scalar), (long) (this.y * scalar));
    }

    @Override
    public Vec2l multiply(double scalar) {
        return new Vec2l((long) (this.x * scalar), (long) (this.y * scalar));
    }

    @Override
    public int doti(IVector other) {
        return (int) (this.x * other.geti(0) + this.y * other.geti(1));
    }

    @Override
    public long dotl(IVector other) {
        return this.x * other.getl(0) + this.y * other.getl(1);
    }

    @Override
    public float dotf(IVector other) {
        return (float) (this.x * other.getf(0) + this.y * other.getf(1));
    }

    @Override
    public double dotd(IVector other) {
        return (double) (this.x * other.getd(0) + this.y * other.getd(1));
    }

    @Override
    public IVector cross(IVector other) {
        assert other != null : "Vec2l:cross: Other vector cannot be null";
        
        switch (other.getDimension()) {
            case 2:
                return new Vec3l(
                    0,
                    0,
                    this.x * other.getl(1) - this.y * other.getl(0)
                );
            case 3:
                return new Vec3l(
                    this.y * other.getl(2),
                    -this.x * other.getl(2),
                    this.x * other.getl(1) - this.y * other.getl(0)
                );
            case 4:
                return new Vec4l(
                    this.y * other.getl(2),
                    -this.x * other.getl(2),
                    this.x * other.getl(1) - this.y * other.getl(0),
                    other.getl(3)
                );
            default:
                throw new IllegalArgumentException("Vec2l:cross: Other vector must be of dimension 2 or 3");
        }
    }
}
