package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec3i implements IVector {
	private int x;
	private int y;
	private int z;

	public Vec3i(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
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
		
		return this.x == other.geti(0) && this.y == other.geti(1) && this.z == other.geti(2);
	}

	@Override
	public int hashCode() {
		int result = Integer.hashCode(x);
		result = 31 * result + Integer.hashCode(y);
		result = 31 * result + Integer.hashCode(z);
		return result;
	}

	@Override
	public String toString() {
		return "Vec3i{" +
				"x=" + x +
				", y=" + y +
				", z=" + z +
				'}';
	}

	@Override
	public int geti(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			case 2: return z;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3i");
		}
	}

	@Override
	public long getl(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			case 2: return z;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3i");
		}
	}

	@Override
	public float getf(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			case 2: return z;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3i");
		}
	}

	@Override
	public double getd(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			case 2: return z;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3i");
		}
	}

	@Override
	public void set(int i, int a_i) {
		switch (i) {
			case 0: x = a_i; break;
			case 1: y = a_i; break;
			case 2: z = a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3i");
		}
	}

	@Override
	public void set(int i, long a_i) {
		switch (i) {
			case 0: x = (int) a_i; break;
			case 1: y = (int) a_i; break;
			case 2: z = (int) a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3i");
		}
	}

	@Override
	public void set(int i, float a_i) {
		switch (i) {
			case 0: x = (int) a_i; break;
			case 1: y = (int) a_i; break;
			case 2: z = (int) a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3i");
		}
	}

	@Override
	public void set(int i, double a_i) {
		switch (i) {
			case 0: x = (int) a_i; break;
			case 1: y = (int) a_i; break;
			case 2: z = (int) a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec3i");
		}
	}

	@Override
	public int getDimension() {
		return 3; 
	}

	@Override
	public Vec3i copy() {
		return new Vec3i(x, y, z);
	}

	@Override
	public Mat convert() {
		int[][] matrixData = {
			{x},
			{y},
			{z}
		};

		return new Mat(matrixData, ITensor.TYPE_INT);
	}

	@Override
	public double getLength() {
		return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	@Override
	public Vec3i getNormal() {
		double length = getLength();
		
		assert length != 0 : "Vec3i:getNormal: Cannot normalize a zero-length vector";
		
		return new Vec3i((int)(x / length), (int)(y / length), (int)(z / length));
	}

	@Override
	public Vec3i add(IVector other) {
		assert other != null : "Vec3i:add: Other vector cannot be null";
		assert other.getDimension() == 3 : "Vec3i:add: Other vector must be of dimension 3";
		
		return new Vec3i(
			this.x + other.geti(0),
			this.y + other.geti(1),
			this.z + other.geti(2)
		);
	}

	@Override
	public Vec3i subtract(IVector other) {
		assert other != null : "Vec3i:subtract: Other vector cannot be null";
		assert other.getDimension() == 3 : "Vec3i:subtract: Other vector must be of dimension 3";
		
		return new Vec3i(
			this.x - other.geti(0),
			this.y - other.geti(1),
			this.z - other.geti(2)
		);
	}

	@Override
	public Vec3i multiply(int scalar) {
		return new Vec3i(
			this.x * scalar,
			this.y * scalar,
			this.z * scalar
		);
	}

	@Override
	public Vec3i multiply(long scalar) {
		return new Vec3i(
			this.x * (int) scalar,
			this.y * (int) scalar,
			this.z * (int) scalar
		);
	}

	@Override
	public Vec3i multiply(float scalar) {
		return new Vec3i(
			(int) (this.x * scalar),
			(int) (this.y * scalar),
			(int) (this.z * scalar)
		);
	}

	@Override
	public Vec3i multiply(double scalar) {
		return new Vec3i(
			(int) (this.x * scalar),
			(int) (this.y * scalar),
			(int) (this.z * scalar)
		);
	}

	@Override
	public int doti(IVector other) {
		assert other != null : "Vec3i:doti: Other vector cannot be null";
		assert other.getDimension() == 3 : "Vec3i:doti: Other vector must be of dimension 3";

		return this.x * other.geti(0) + this.y * other.geti(1) + this.z * other.geti(2);
	}

	@Override
	public long dotl(IVector other) {
		assert other != null : "Vec3i:dotl: Other vector cannot be null";
		assert other.getDimension() == 3 : "Vec3i:dotl: Other vector must be of dimension 3";

		return (long) this.x * other.getl(0) + (long) this.y * other.getl(1) + (long) this.z * other.getl(2);
	}

	@Override
	public float dotf(IVector other) {
		assert other != null : "Vec3i:dotf: Other vector cannot be null";
		assert other.getDimension() == 3 : "Vec3i:dotf: Other vector must be of dimension 3";

		return (float) (this.x * other.getf(0) + this.y * other.getf(1) + this.z * other.getf(2));
	}

	@Override
	public double dotd(IVector other) {
		assert other != null : "Vec3i:dotd: Other vector cannot be null";
		assert other.getDimension() == 3 : "Vec3i:dotd: Other vector must be of dimension 3";

		return (double) (this.x * other.getd(0) + this.y * other.getd(1) + this.z * other.getd(2));
	}

	@Override
	public IVector cross(IVector other) {
        assert other != null : "Vec3i:cross: Other vector cannot be null";

        switch (other.getDimension()) {
            case 2:
                return new Vec3i(
                    -this.z * other.geti(1),
                    this.z * other.geti(0),
                    this.x * other.geti(1) - this.y * other.geti(0)
                );
            case 3:
                return new Vec3i(
                    this.y * other.geti(2) - this.z * other.geti(1),
                    this.z * other.geti(0) - this.x * other.geti(2),
                    this.x * other.geti(1) - this.y * other.geti(0)
                );
            case 4:
                return new Vec4i(
                    this.y * other.geti(2) - this.z * other.geti(1),
                    this.z * other.geti(0) - this.x * other.geti(2),
                    this.x * other.geti(1) - this.y * other.geti(0),
                    other.geti(3)
                );
            default:
                throw new IllegalArgumentException("Vec3i:cross: Other vector must be of dimension 2 or 3");
        }
    }
}
