package net.mahiron47.mathlib.utils;

import net.mahiron47.mathlib.types.Vec2d;
import net.mahiron47.mathlib.types.Vec3d;
import net.mahiron47.mathlib.types.Vec2f;
import net.mahiron47.mathlib.types.Vec3f;

/**
 * Utility class for generating pseudo-random noise values using sine functions.
 * 
 * <h2>Methods:</h2>
 * <ul>
 * <li>{@link #fract(double)}: Computes the fractional part of a double
 * value.</li>
 * <li>{@link #sinoise(double)}: Generates 1D sine noise based on a single
 * input.</li>
 * <li>{@link #sinoise(double, double)}: Generates 2D sine noise based on two
 * inputs.</li>
 * <li>{@link #sinoise(double, double, double)}: Generates 3D sine noise based
 * on three inputs.</li>
 * <li>{@link #sinoise(double, double, double, double)}: Generates 4D sine noise
 * based on four inputs.</li>
 * </ul>
 */
public class Noise {
	private Noise() {
		// Private constructor to prevent instantiation
	}

	/**
	 * Returns the fractional part of a double value.
	 *
	 * @param x The input value.
	 * @return The fractional part of x.
	 */
	public static double fract(double x) {
		if (x >= 0) {
			return x - Math.floor(x);
		} else {
			return 1.0 + (x - Math.floor(x));
		}
	}

	public static float fract(float x) {
		if (x >= 0) {
			return x - (float) Math.floor(x);
		} else {
			return 1.0f + (x - (float) Math.floor(x));
		}
	}

	private static Vec2d hash(Vec2d x) {
		Vec2d p = new Vec2d(Math.floor(x.getd(0) * 0.5), Math.floor(x.getd(1) * 0.5));
		p = new Vec2d(p.dotd(new Vec2d(127.1, 311.7)), p.dotd(new Vec2d(269.5, 183.3)));

		return new Vec2d(
			-1.0 + 2.0 * fract(Math.sin(p.getd(0)) * 43758.5453123),
			-1.0 + 2.0 * fract(Math.sin(p.getd(1)) * 43758.5453123)
		);
	}

	private static Vec2f hash(Vec2f x) {
		Vec2f p = new Vec2f((float) Math.floor(x.getf(0) * 0.5f), (float) Math.floor(x.getf(1) * 0.5f));
		p = new Vec2f(p.dotf(new Vec2f(127.1f, 311.7f)), p.dotf(new Vec2f(269.5f, 183.3f)));

		return new Vec2f(
			-1.0f + 2.0f * fract((float) Math.sin(p.getf(0)) * 43758.5453123f),
			-1.0f + 2.0f * fract((float) Math.sin(p.getf(1)) * 43758.5453123f)
		);
	}

	private static double step(double edge, double x) {
		return x < edge ? 0.0 : 1.0;
	}

	private static float step(float edge, float x) {
		return x < edge ? 0.0f : 1.0f;
	}

	private static Vec3d max(Vec3d v, double value) {
		return new Vec3d(
			Math.max(v.getd(0), value),
			Math.max(v.getd(1), value),
			Math.max(v.getd(2), value)
		);
	}

	private static Vec3f max(Vec3f v, float value) {
		return new Vec3f(
			Math.max(v.getf(0), value),
			Math.max(v.getf(1), value),
			Math.max(v.getf(2), value)
		);
	}

	/**
	 * Generates a 1D sin noise value based on the input x.
	 *
	 * @param p The input value.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static double sinoise(double p) {
		return fract(Math.sin(p * 495119) * 499509);
	}

	/**
	 * Generates a 2D sin noise value based on the input x and y.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static double sinoise(Vec2d p) {
		return fract(Math.sin(p.getd(0) * 495119 + p.getd(1) * 494109) * 499509);
	}

	/**
	 * Generates a 3D sin noise value based on the input x, y, and z.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param z The z coordinate.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static double sinoise(Vec3d p) {
		return fract(Math.sin(p.getd(0) * 495119 + p.getd(1) * 494109 + p.getd(2) * 549161) * 499509);
	}

	/**
	 * Generates a 4D sin noise value based on the input x, y, z, and w.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param z The z coordinate.
	 * @param w The w coordinate.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static double sinoise(Vec3d p, double w) {
		return fract(Math.sin(p.getd(0) * 495119 + p.getd(1) * 494109 + p.getd(2) * 549161 + w * 547967) * 499509);
	}

	public static double simplexNoise(Vec2d p) {
		double K1 = 0.366025404; // (sqrt(3)-1)/2;
		double K2 = 0.211324865; // (3-sqrt(3))/6;

		Vec2d i = new Vec2d(
			Math.floor(p.getd(0) + (p.getd(0) + p.getd(1)) * K1),
			Math.floor(p.getd(1) + (p.getd(0) + p.getd(1)) * K1)
		);
		Vec2d a = p.subtract(i).add(new Vec2d((i.getd(0) + i.getd(1)) * K2, (i.getd(0) + i.getd(1)) * K2));
		double m = step(a.getd(1), a.getd(0));
		Vec2d o = new Vec2d(m, 1.0 - m);
		Vec2d b = a.subtract(o).add(new Vec2d(K2, K2));
		Vec2d c = a.subtract(new Vec2d(
			1.0 + 2.0 * K2,
			1.0 + 2.0 * K2)
		);
		Vec3d h = max(new Vec3d(0.5, 0.5, 0.5).subtract(o), 0.0);
		Vec3d n = h.cross(h).cross(h).cross(h).cross(new Vec3d(
			a.dotd(hash(i)),
			b.dotd(hash(i.add(o))),
			c.dotd(hash(i.add(new Vec2d(1.0, 1.0))))
		));

		return n.dotd(new Vec3d(70.0, 70.0, 70.0));
	}

	public static float simplexNoise(Vec2f p) {
		float K1 = 0.366025404f; // (sqrt(3)-1)/2;
		float K2 = 0.211324865f; // (3-sqrt(3))/6;

		Vec2f i = new Vec2f(
			(float) Math.floor(p.getf(0) + (p.getf(0) + p.getf(1)) * K1),
			(float) Math.floor(p.getf(1) + (p.getf(0) + p.getf(1)) * K1)
		);
		Vec2f a = p.subtract(i).add(new Vec2f((i.getf(0) + i.getf(1)) * K2, (i.getf(0) + i.getf(1)) * K2));
		float m = step(a.getf(1), a.getf(0));
		Vec2f o = new Vec2f(m, 1.0f - m);
		Vec2f b = a.subtract(o).add(new Vec2f(K2, K2));
		Vec2f c = a.subtract(new Vec2f(
			1.0f + 2.0f * K2,
			1.0f + 2.0f * K2
		));
		Vec3f h = max(new Vec3f(0.5f, 0.5f, 0.5f).subtract(o), 0.0f);
		Vec3f n = h.cross(h).cross(h).cross(h).cross(new Vec3f(
			a.dotf(hash(i)),
			b.dotf(hash(i.add(o))),
			c.dotf(hash(i.add(new Vec2f(1.0f, 1.0f))))
		));

		return n.dotf(new Vec3f(70.0f, 70.0f, 70.0f));
	}
}
