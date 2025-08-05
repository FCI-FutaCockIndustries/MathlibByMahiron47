package net.mahiron47.mathlib.utils;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IVector;
import net.mahiron47.mathlib.types.Vec2i;
import net.mahiron47.mathlib.types.Vec2l;
import net.mahiron47.mathlib.types.Vec2f;
import net.mahiron47.mathlib.types.Vec2d;
import net.mahiron47.mathlib.types.Vec3i;
import net.mahiron47.mathlib.types.Vec3l;
import net.mahiron47.mathlib.types.Vec3f;
import net.mahiron47.mathlib.types.Vec3d;
import net.mahiron47.mathlib.types.Vec;

public class Interpolation {
	private Interpolation() {
		// Private constructor to prevent instantiation
	}

	/**
	 * Performs liner interpolation between two values.
	 *
	 * @param a The start value.
	 * @param b The end value.
	 * @param t The interpolation factor, typically between 0.0 and 1.0.
	 * @return The interpolated value between a and b.
	 */
	public static double mix(double a, double b, double t) {
		return a * (1 - t) + b * t;
	}

	/**
	 * Performs linear interpolation between two vectors.
	 *
	 * @param a The start vector.
	 * @param b The end vector.
	 * @param t The interpolation factor, typically between 0.0 and 1.0.
	 * @return A new vector that is the result of the interpolation.
	 */
	public static IVector mix(IVector a, IVector b, double t) {
		assert a.getDimension() == b.getDimension() : "Interpolation:mix: Dimension mismatch between vectors a and b";

		switch (a.getType()) {
		case ITensor.TYPE_INT:
			int[] intResult = new int[a.getDimension()];
			for (int i = 0; i < a.getDimension(); i++) {
				intResult[i] = (int) mix(a.getd(i), b.getd(i), t);
			}

			switch (a.getDimension()) {
			case 2:
				return new Vec2i(intResult[0], intResult[1]);
			case 3:
				return new Vec3i(intResult[0], intResult[1], intResult[2]);
			default:
				return new Vec(intResult, ITensor.TYPE_INT);
			}
		case ITensor.TYPE_LONG:
			long[] longResult = new long[a.getDimension()];
			for (int i = 0; i < a.getDimension(); i++) {
				longResult[i] = (long) mix(a.getd(i), b.getd(i), t);
			}

			switch (a.getDimension()) {
			case 2:
				return new Vec2l(longResult[0], longResult[1]);
			case 3:
				return new Vec3l(longResult[0], longResult[1], longResult[2]);
			default:
				return new Vec(longResult, ITensor.TYPE_LONG);
			}
		case ITensor.TYPE_FLOAT:
			float[] floatResult = new float[a.getDimension()];
			for (int i = 0; i < a.getDimension(); i++) {
				floatResult[i] = (float) mix(a.getd(i), b.getd(i), t);
			}

			switch (a.getDimension()) {
			case 2:
				return new Vec2f(floatResult[0], floatResult[1]);
			case 3:
				return new Vec3f(floatResult[0], floatResult[1], floatResult[2]);
			default:
				return new Vec(floatResult, ITensor.TYPE_FLOAT);
			}
		case ITensor.TYPE_DOUBLE:
			double[] doubleResult = new double[a.getDimension()];
			for (int i = 0; i < a.getDimension(); i++) {
				doubleResult[i] = mix(a.getd(i), b.getd(i), t);
			}

			switch (a.getDimension()) {
			case 2:
				return new Vec2d(doubleResult[0], doubleResult[1]);
			case 3:
				return new Vec3d(doubleResult[0], doubleResult[1], doubleResult[2]);
			default:
				return new Vec(doubleResult, ITensor.TYPE_DOUBLE);
			}
		default:
			throw new IllegalArgumentException("Interpolation:mix2: Unsupported vector type: " + a.getType());
		}
	}
}
