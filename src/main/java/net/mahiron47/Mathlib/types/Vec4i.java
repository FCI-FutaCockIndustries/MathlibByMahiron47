package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec4i implements IVector {
	private int x;
	private int y;
	private int z;
	private int w;

	public Vec4i(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	@Override
	public byte getType() {
		return ITensor.TYPE_INT;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof IVector)) return false;

		IVector other = (IVector) obj;
		
		return this.x == other.geti(0) && this.y == other.geti(1) && 
			   this.z == other.geti(2) && this.w == other.geti(3);
	}

	@Override
	public int hashCode() {
		int result = Integer.hashCode(x);
		result = 31 * result + Integer.hashCode(y);
		result = 31 * result + Integer.hashCode(z);
		result = 31 * result + Integer.hashCode(w);
		return result;
	}

	@Override
	public String toString() {
		return "Vec4i{" +
				"x=" + x +
				", y=" + y +
				", z=" + z +
				", w=" + w +
				'}';
	}

	@Override
	public int geti(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			case 2: return z;
			case 3: return w;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4i");
		}
	}

	@Override
	public long getl(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			case 2: return z;
			case 3: return w;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4i");
		}
	}

	@Override
	public float getf(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			case 2: return z;
			case 3: return w;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4i");
		}
	}

	@Override
	public double getd(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			case 2: return z;
			case 3: return w;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4i");
		}
	}

	@Override
	public void set(int i, int a_i) {
		switch (i) {
			case 0: x = a_i; break;
			case 1: y = a_i; break;
			case 2: z = a_i; break;
			case 3: w = a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4i");
		}
	}

	@Override
	public void set(int i, long a_i) {
		switch (i) {
			case 0: x = (int) a_i; break;
			case 1: y = (int) a_i; break;
			case 2: z = (int) a_i; break;
			case 3: w = (int) a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4i");
		}
	}

	@Override
	public void set(int i, float a_i) {
		switch (i) {
			case 0: x = (int) a_i; break;
			case 1: y = (int) a_i; break;
			case 2: z = (int) a_i; break;
			case 3: w = (int) a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4i");
		}
	}

	@Override
	public void set(int i, double a_i) {
		switch (i) {
			case 0: x = (int) a_i; break;
			case 1: y = (int) a_i; break;
			case 2: z = (int) a_i; break;
			case 3: w = (int) a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec4i");
		}
	}

	@Override
	public int getDimension() {
		return 4; 
	}

	@Override
	public Vec4i copy() {
		return new Vec4i(x, y, z, w);
	}

	@Override
	public Mat convert() {
		int[][] matrixData = {
			{x},
			{y},
			{z},
			{w}
		};

		return new Mat(matrixData, ITensor.TYPE_INT);
	}

	@Override
	public double getLength() {
		return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
	}

	@Override
	public Vec4i getNormal() {
		double length = getLength();
		
		assert length != 0 : "Vec4i:getNormal: Cannot normalize a zero-length vector";
		
		return new Vec4i((int)(x / length), (int)(y / length), (int)(z / length), (int)(w / length));
	}

	@Override
	public Vec4i add(IVector other) {
		assert other != null : "Vec4i:add: Other vector cannot be null";
		assert other.getDimension() == 4 : "Vec4i:add: Other vector must be of dimension 4";
		
		return new Vec4i(
			this.x + other.geti(0),
			this.y + other.geti(1),
			this.z + other.geti(2),
			this.w + other.geti(3)
		);
	}

	@Override
	public Vec4i subtract(IVector other) {
		assert other != null : "Vec4i:subtract: Other vector cannot be null";
		assert other.getDimension() == 4 : "Vec4i:subtract: Other vector must be of dimension 4";
		
		return new Vec4i(
			this.x - other.geti(0),
			this.y - other.geti(1),
			this.z - other.geti(2),
			this.w - other.geti(3)
		);
	}

	@Override
	public Vec4i multiply(int scalar) {
		return new Vec4i(
			this.x * scalar,
			this.y * scalar,
			this.z * scalar,
			this.w * scalar
		);
	}

	@Override
	public Vec4i multiply(long scalar) {
		return new Vec4i(
			this.x * (int) scalar,
			this.y * (int) scalar,
			this.z * (int) scalar,
			this.w * (int) scalar
		);
	}

	@Override
	public Vec4i multiply(float scalar) {
		return new Vec4i(
			(int) (this.x * scalar),
			(int) (this.y * scalar),
			(int) (this.z * scalar),
			(int) (this.w * scalar)
		);
	}

	@Override
	public Vec4i multiply(double scalar) {
		return new Vec4i(
			(int) (this.x * scalar),
			(int) (this.y * scalar),
			(int) (this.z * scalar),
			(int) (this.w * scalar)
		);
	}

	@Override
	public int doti(IVector other) {
		assert other != null : "Vec4i:doti: Other vector cannot be null";
		assert other.getDimension() == 4 : "Vec4i:doti: Other vector must be of dimension 4";

		return this.x * other.geti(0) + this.y * other.geti(1) + 
			   this.z * other.geti(2) + this.w * other.geti(3);
	}

	@Override
	public long dotl(IVector other) {
		assert other != null : "Vec4i:dotl: Other vector cannot be null";
		assert other.getDimension() == 4 : "Vec4i:dotl: Other vector must be of dimension 4";

		return (long) this.x * other.getl(0) + (long) this.y * other.getl(1) + 
			   (long) this.z * other.getl(2) + (long) this.w * other.getl(3);
	}

	@Override
	public float dotf(IVector other) {
		assert other != null : "Vec4i:dotf: Other vector cannot be null";
		assert other.getDimension() == 4 : "Vec4i:dotf: Other vector must be of dimension 4";

		return (float) (this.x * other.getf(0) + this.y * other.getf(1) + 
						this.z * other.getf(2) + this.w * other.getf(3));
	}

	@Override
	public double dotd(IVector other) {
		assert other != null : "Vec4i:dotd: Other vector cannot be null";
		assert other.getDimension() == 4 : "Vec4i:dotd: Other vector must be of dimension 4";

		return (double) (this.x * other.getd(0) + this.y * other.getd(1) + 
						 this.z * other.getd(2) + this.w * other.getd(3));
	}

	@Override
	public Vec4i cross(IVector other) {
        assert other != null : "Vec4i:cross: Other vector cannot be null";

        switch (other.getDimension()) {
            case 2:
                return new Vec4i(
                    -this.z * other.geti(1),
                    this.z * other.geti(0), 
                    this.x * other.geti(1) - this.y * other.geti(0),
                    this.w
                );
            case 3:
                return new Vec4i(
                    this.y * other.geti(2) - this.z * other.geti(1),
                    this.z * other.geti(0) - this.x * other.geti(2),
                    this.x * other.geti(1) - this.y * other.geti(0),
                    this.w
                );
            case 4:
                return new Vec4i(
                    this.y * other.geti(2) - this.z * other.geti(1),
                    this.z * other.geti(0) - this.x * other.geti(2),
                    this.x * other.geti(1) - this.y * other.geti(0),
                    this.w * other.geti(3)
                );
            default:
                throw new IllegalArgumentException("Vec4i:cross: Other vector must be of dimension 3 or 4");
        }
    }
}
