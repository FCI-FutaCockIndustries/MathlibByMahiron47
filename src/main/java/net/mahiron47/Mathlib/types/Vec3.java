package net.mahiron47.mathlib.types;

public class Vec3<NumT extends Number> {
	private NumT x;
	private NumT y;
	private NumT z;

	public Vec3(NumT x, NumT y, NumT z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
