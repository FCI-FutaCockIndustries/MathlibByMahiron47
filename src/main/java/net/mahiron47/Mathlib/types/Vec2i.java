package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec2i implements IVector {
	private int x;
	private int y;

	public Vec2i(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public byte getType() {
		return ITensor.TYPE_INT;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof IVector)) return false;

		IVector vec = (IVector) obj;

		return this.x == vec.geti(0) && this.y == vec.geti(1);
	}

	@Override
	public int hashCode() {
		int result = Integer.hashCode(x);
		result = 31 * result + Integer.hashCode(y);
		return result;
	}

	@Override
	public String toString() {
		return "Vec2i{" +
				"x=" + x +
				", y=" + y +
				'}';
	}

	@Override
	public int geti(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2i");
		}
	}

	@Override
	public long getl(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2i");
		}
	}

	@Override
	public float getf(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2i");
		}
	}

	@Override
	public double getd(int i) {
		switch (i) {
			case 0: return x;
			case 1: return y;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2i");
		}
	}

	@Override
	public void set(int i, int a_i) {
		switch (i) {
			case 0: x = a_i; break;
			case 1: y = a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2i");
		}
	}

	@Override
	public void set(int i, long a_i) {
		switch (i) {
			case 0: x = (int) a_i; break;
			case 1: y = (int) a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2i");
		}
	}

	@Override
	public void set(int i, float a_i) {
		switch (i) {
			case 0: x = (int) a_i; break;
			case 1: y = (int) a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2i");
		}
	}

	@Override
	public void set(int i, double a_i) {
		switch (i) {
			case 0: x = (int) a_i; break;
			case 1: y = (int) a_i; break;
			default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Vec2i");
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
	public Vec2i getNormal() {
		double length = getLength();
		
		assert length != 0 : "Vec2i:getNormal: Length is zero, cannot normalize a zero vector.";

		return new Vec2i((int) (this.x / length), (int) (this.y / length));
	}

	@Override
	public Vec2i copy() {
		return new Vec2i(this.x, this.y);
	}

	@Override
	public Mat convert() {
		return new Mat(new int[][] {
			{this.x},
			{this.y}
		}, ITensor.TYPE_INT);
	}

	@Override
	public Vec2i add(IVector other) {
		return new Vec2i(this.x + other.geti(0), this.y + other.geti(1));
	}

	@Override
	public Vec2i subtract(IVector other) {
		return new Vec2i(this.x - other.geti(0), this.y - other.geti(1));
	}

	@Override
	public Vec2i multiply(int scalar) {
		return new Vec2i(this.x * scalar, this.y * scalar);
	}

	@Override
	public Vec2i multiply(long scalar) {
		return new Vec2i((int) (this.x * scalar), (int) (this.y * scalar));
	}

	@Override
	public Vec2i multiply(float scalar) {
		return new Vec2i((int) (this.x * scalar), (int) (this.y * scalar));
	}

	@Override
	public Vec2i multiply(double scalar) {
		return new Vec2i((int) (this.x * scalar), (int) (this.y * scalar));
	}

	@Override
	public int doti(IVector other) {
		return this.x * other.geti(0) + this.y * other.geti(1);
	}

	@Override
	public long dotl(IVector other) {
		return (long) this.x * other.getl(0) + (long) this.y * other.getl(1);
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
	public Vec3i cross(IVector other) {
		int z = this.x * other.geti(1) - this.y * other.geti(0);
		return new Vec3i(0, 0, z);
	}
}
