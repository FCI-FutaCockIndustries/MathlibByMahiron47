package net.mahiron47.mathlib.utils;

import net.mahiron47.mathlib.types.Vec2d;
import net.mahiron47.mathlib.types.Vec2f;
import net.mahiron47.mathlib.types.Vec2i;
import net.mahiron47.mathlib.types.Vec2l;
import net.mahiron47.mathlib.types.Vec3d;
import net.mahiron47.mathlib.types.Vec3f;
import net.mahiron47.mathlib.types.Vec3i;
import net.mahiron47.mathlib.types.Vec3l;
import net.mahiron47.mathlib.types.Vec4d;
import net.mahiron47.mathlib.types.Vec4f;
import net.mahiron47.mathlib.types.Vec4i;
import net.mahiron47.mathlib.types.Vec4l;

/**
 * Utility class providing mathematical functions and operations.
 */
public class Math {
	private Math() {
		// Private constructor to prevent instantiation
	}

	/**
	 * Calculates the sine of a double value using Taylor series approximation.
	 * @param x The input angle in radians.
	 * @return The sine of x.
	 */
	public static double sin(double x) {
		// Normalize x to the range [-2π, 2π] for better accuracy
		// This is done to avoid large values that can lead to inaccuracies in the Taylor series
		final double TWO_PI = 2.0 * 3.141592653589793;
		x = x - ((long) (x / TWO_PI)) * TWO_PI;

		// Taylor series: x - x^3/6 + x^5/120 - x^7/5040
		double x2 = x * x;
		double x3 = x * x2;
		double x5 = x3 * x2;
		double x7 = x5 * x2;
		return x - (x3 / 6.0) + (x5 / 120.0) - (x7 / 5040.0);
	}
	
	/**
	 * Calculates the sine of a float value using Taylor series approximation.
	 * @param x The input angle in radians.
	 * @return The sine of x.
	 */
	public static float sin(float x) {
		// Normalize x to the range [-2π, 2π] for better accuracy
		// This is done to avoid large values that can lead to inaccuracies in the Taylor series
		final float TWO_PI = 2.0f * 3.141592653589793f;
		x = x - ((long) (x / TWO_PI)) * TWO_PI;

		// Taylor series: x - x^3/6 + x^5/120 - x^7/5040
		float x2 = x * x;
		float x3 = x * x2;
		float x5 = x3 * x2;
		float x7 = x5 * x2;
		return x - (x3 / 6.0f) + (x5 / 120.0f) - (x7 / 5040.0f);
	}

	/**
	 * Calculates the cosine of a double value using Taylor series approximation.
	 * @param x The input angle in radians.
	 * @return The cosine of x.
	 */
	public static double cos(double x) {
		// Normalize x to the range [-2π, 2π] for better accuracy
		final double TWO_PI = 2.0 * 3.141592653589793;
		x = x - ((long) (x / TWO_PI)) * TWO_PI;

		// Taylor series: 1 - x^2/2 + x^4/24 - x^6/720
		double x2 = x * x;
		double x4 = x2 * x2;
		double x6 = x4 * x2;
		return 1.0 - (x2 / 2.0) + (x4 / 24.0) - (x6 / 720.0);
	}

	/**
	 * Calculates the cosine of a float value using Taylor series approximation.
	 * @param x The input angle in radians.
	 * @return The cosine of x.
	 */
	public static float cos(float x) {
		// Normalize x to the range [-2π, 2π] for better accuracy
		final float TWO_PI = 2.0f * 3.141592653589793f;
		x = x - ((long) (x / TWO_PI)) * TWO_PI;

		// Taylor series: 1 - x^2/2 + x^4/24 - x^6/720
		float x2 = x * x;
		float x4 = x2 * x2;
		float x6 = x4 * x2;
		return 1.0f - (x2 / 2.0f) + (x4 / 24.0f) - (x6 / 720.0f);
	}

	/**
	 * Calculates the tangent of a double value using Taylor series approximation.
	 * @param x The input angle in radians.
	 * @return The tangent of x.
	 */
	public static double tan(double x) {
		// Normalize x to the range [-2π, 2π] for better accuracy
		// This is done to avoid large values that can lead to inaccuracies in the Taylor series
		final double TWO_PI = 2.0 * 3.141592653589793;
		x = x - ((long) (x / TWO_PI)) * TWO_PI;

		// Taylor series: x + x^3/3 + 2x^5/15 + 17x^7/315
		double x2 = x * x;
		double x3 = x * x2;
		double x5 = x3 * x2;
		double x7 = x5 * x2;
		return x + (x3 / 3.0) + (2.0 * x5 / 15.0) + (17.0 * x7 / 315.0);
	}

	/**
	 * Calculates the tangent of a float value using Taylor series approximation.
	 * @param x The input angle in radians.
	 * @return The tangent of x.
	 */
	public static float tan(float x) {
		// Normalize x to the range [-2π, 2π] for better accuracy
		// This is done to avoid large values that can lead to inaccuracies in the Taylor series
		final float TWO_PI = 2.0f * 3.141592653589793f;
		x = x - ((long) (x / TWO_PI)) * TWO_PI;

		// Taylor series: x + x^3/3 + 2x^5/15 + 17x^7/315
		float x2 = x * x;
		float x3 = x * x2;
		float x5 = x3 * x2;
		float x7 = x5 * x2;
		return x + (x3 / 3.0f) + (2.0f * x5 / 15.0f) + (17.0f * x7 / 315.0f);
	}
	
	/**
	 * Calculates the cotangent of a double value using series approximation.
	 * @param x The input angle in radians.
	 * @return The cotangent of x.
	 */
	public static double cot(double x) {
		// Normalize x to the range [-2π, 2π] for better accuracy
		// This is done to avoid large values that can lead to inaccuracies in the Taylor series
		final double TWO_PI = 2.0 * 3.141592653589793;
		x = x - ((long) (x / TWO_PI)) * TWO_PI;

		// For small x: cot(x) ≈ 1/x - x/3 - x^3/45 - 2x^5/945
		double x2 = x * x;
		double x3 = x2 * x;
		double x5 = x3 * x2;
		// avoiding division by zero for small x
		assert Math.abs(x) > 1e-4 : "Math:cot: Division by zero for small x";

		return (1.0 / x) - (x / 3.0) - (x3 / 45.0) - (2.0 * x5 / 945.0);
	}

	/**
	 * Calculates the cotangent of a float value using series approximation.
	 * @param x The input angle in radians.
	 * @return The cotangent of x.
	 */
	public static float cot(float x) {
		final float TWO_PI = 2.0f * 3.141592653589793f;
		x = x - ((long) (x / TWO_PI)) * TWO_PI;

		// For small x: cot(x) ≈ 1/x - x/3 - x^3/45 - 2x^5/945
		float x2 = x * x;
		float x3 = x2 * x;
		float x5 = x3 * x2;
		// avoiding division by zero for small x
		assert Math.abs(x) > 1e-4f : "Math:cot: Division by zero for small x";

		return (1.0f / x) - (x / 3.0f) - (x3 / 45.0f) - (2.0f * x5 / 945.0f);
	}

	/**
	 * Returns the absolute value of a double.
	 * @param x The input value.
	 * @return The absolute value of x.
	 */
	public static double abs(double x) {
		return (x >= 0) ? x : -x;
	}

	/**
	 * Returns the absolute value of a float.
	 * @param x The input value.
	 * @return The absolute value of x.
	 */
	public static float abs(float x) {
		return (x >= 0) ? x : -x;
	}

	/**
	 * Returns the absolute value of an int.
	 * @param x The input value.
	 * @return The absolute value of x.
	 */
	public static int abs(int x) {
		return (x >= 0) ? x : -x;
	}

	/**
	 * Returns the absolute value of a long.
	 * @param x The input value.
	 * @return The absolute value of x.
	 */
	public static long abs(long x) {
		return (x >= 0) ? x : -x;
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec2d.
	 * @return Vec2d with absolute values.
	 */
	public static Vec2d abs(Vec2d v) {
		return new Vec2d(
			abs(v.getd(0)), 
			abs(v.getd(1))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec2f.
	 * @return Vec2f with absolute values.
	 */
	public static Vec2f abs(Vec2f v) {
		return new Vec2f(
			abs(v.getf(0)), 
			abs(v.getf(1))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec2i.
	 * @return Vec2i with absolute values.
	 */
	public static Vec2i abs(Vec2i v) {
		return new Vec2i(
			abs(v.geti(0)), 
			abs(v.geti(1))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec2l.
	 * @return Vec2l with absolute values.
	 */
	public static Vec2l abs(Vec2l v) {
		return new Vec2l(
			abs(v.getl(0)), 
			abs(v.getl(1))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec3d.
	 * @return Vec3d with absolute values.
	 */
	public static Vec3d abs(Vec3d v) {
		return new Vec3d(
			abs(v.getd(0)), 
			abs(v.getd(1)), 
			abs(v.getd(2))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec3f.
	 * @return Vec3f with absolute values.
	 */
	public static Vec3f abs(Vec3f v) {
		return new Vec3f(
			abs(v.getf(0)), 
			abs(v.getf(1)), 
			abs(v.getf(2))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec3i.
	 * @return Vec3i with absolute values.
	 */
	public static Vec3i abs(Vec3i v) {
		return new Vec3i(
			abs(v.geti(0)), 
			abs(v.geti(1)), 
			abs(v.geti(2))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec3l.
	 * @return Vec3l with absolute values.
	 */
	public static Vec3l abs(Vec3l v) {
		return new Vec3l(
			abs(v.getl(0)), 
			abs(v.getl(1)), 
			abs(v.getl(2))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec4d.
	 * @return Vec4d with absolute values.
	 */
	public static Vec4d abs(Vec4d v) {
		return new Vec4d(
			abs(v.getd(0)), 
			abs(v.getd(1)), 
			abs(v.getd(2)), 
			abs(v.getd(3))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec4f.
	 * @return Vec4f with absolute values.
	 */
	public static Vec4f abs(Vec4f v) {
		return new Vec4f(
			abs(v.getf(0)), 
			abs(v.getf(1)), 
			abs(v.getf(2)), 
			abs(v.getf(3))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec4i.
	 * @return Vec4i with absolute values.
	 */
	public static Vec4i abs(Vec4i v) {
		return new Vec4i(
			abs(v.geti(0)), 
			abs(v.geti(1)), 
			abs(v.geti(2)), 
			abs(v.geti(3))
		);
	}

	/**
	 * Returns a vector with the absolute values of each component.
	 * @param v The input Vec4l.
	 * @return Vec4l with absolute values.
	 */
	public static Vec4l abs(Vec4l v) {
		return new Vec4l(
			abs(v.getl(0)), 
			abs(v.getl(1)), 
			abs(v.getl(2)), 
			abs(v.getl(3))
		);
	}

	/**
	 * Returns the largest integer less than or equal to the double value.
	 * @param x The input value.
	 * @return The floored value.
	 */
	public static double floor(double x) {
		return (x >= 0) ? (int) x : ((int) x - ((x == (int) x) ? 0 : 1));
	}
	
	/**
	 * Returns the largest integer less than or equal to the float value.
	 * @param x The input value.
	 * @return The floored value.
	 */
	public static float floor(float x) {
		return (x >= 0) ? (int) x : ((int) x - ((x == (int) x) ? 0 : 1));
	}

	/**
	 * Returns a vector with floored components.
	 * @param v The input Vec2d.
	 * @return Vec2d with floored values.
	 */
	public static Vec2d floor(Vec2d v) {
		return new Vec2d(
			floor(v.getd(0)), 
			floor(v.getd(1))
		);
	}

	/**
	 * Returns a vector with floored components.
	 * @param v The input Vec2f.
	 * @return Vec2f with floored values.
	 */
	public static Vec2f floor(Vec2f v) {
		return new Vec2f(
			floor(v.getf(0)), 
			floor(v.getf(1))
		);
	}

	/**
	 * Returns a vector with floored components.
	 * @param v The input Vec3d.
	 * @return Vec3d with floored values.
	 */
	public static Vec3d floor(Vec3d v) {
		return new Vec3d(
			floor(v.getd(0)), 
			floor(v.getd(1)), 
			floor(v.getd(2))
		);
	}

	/**
	 * Returns a vector with floored components.
	 * @param v The input Vec3f.
	 * @return Vec3f with floored values.
	 */
	public static Vec3f floor(Vec3f v) {
		return new Vec3f(
			floor(v.getf(0)), 
			floor(v.getf(1)), 
			floor(v.getf(2))
		);
	}

	/**
	 * Returns a vector with floored components.
	 * @param v The input Vec4d.
	 * @return Vec4d with floored values.
	 */
	public static Vec4d floor(Vec4d v) {
		return new Vec4d(
			floor(v.getd(0)), 
			floor(v.getd(1)), 
			floor(v.getd(2)), 
			floor(v.getd(3))
		);
	}

	/**
	 * Returns a vector with floored components.
	 * @param v The input Vec4f.
	 * @return Vec4f with floored values.
	 */
	public static Vec4f floor(Vec4f v) {
		return new Vec4f(
			floor(v.getf(0)), 
			floor(v.getf(1)), 
			floor(v.getf(2)), 
			floor(v.getf(3))
		);
	}

	/**
	 * Returns the fractional part of a double value.
	 *
	 * @param x The input value.
	 * @return The fractional part of x.
	 */
	public static double fract(double x) {
		if (x >= 0) {
			return x - floor(x);
		} else {
			return 1.0 + (x - floor(x));
		}
	}

	/**
	 * Returns the fractional part of a float value.
	 *
	 * @param x The input value.
	 * @return The fractional part of x.
	 */
	public static float fract(float x) {
		if (x >= 0) {
			return x - floor(x);
		} else {
			return 1.0f + (x - floor(x));
		}
	}

	/**
	 * Returns a vector with the fractional part of each component.
	 * @param v The input Vec2d.
	 * @return Vec2d with fractional values.
	 */
	public static Vec2d fract(Vec2d v) {
		return new Vec2d(
			fract(v.getd(0)), 
			fract(v.getd(1))
		);
	}

	/**
	 * Returns a vector with the fractional part of each component.
	 * @param v The input Vec2f.
	 * @return Vec2f with fractional values.
	 */
	public static Vec2f fract(Vec2f v) {
		return new Vec2f(
			fract(v.getf(0)), 
			fract(v.getf(1))
		);
	}

	/**
	 * Returns a vector with the fractional part of each component.
	 * @param v The input Vec3d.
	 * @return Vec3d with fractional values.
	 */
	public static Vec3d fract(Vec3d v) {
		return new Vec3d(
			fract(v.getd(0)), 
			fract(v.getd(1)), 
			fract(v.getd(2))
		);
	}

	/**
	 * Returns a vector with the fractional part of each component.
	 * @param v The input Vec3f.
	 * @return Vec3f with fractional values.
	 */
	public static Vec3f fract(Vec3f v) {
		return new Vec3f(
			fract(v.getf(0)), 
			fract(v.getf(1)), 
			fract(v.getf(2))
		);
	}

	/**
	 * Returns a vector with the fractional part of each component.
	 * @param v The input Vec4d.
	 * @return Vec4d with fractional values.
	 */
	public static Vec4d fract(Vec4d v) {
		return new Vec4d(
			fract(v.getd(0)), 
			fract(v.getd(1)), 
			fract(v.getd(2)), 
			fract(v.getd(3))
		);
	}

	/**
	 * Returns a vector with the fractional part of each component.
	 * @param v The input Vec4f.
	 * @return Vec4f with fractional values.
	 */
	public static Vec4f fract(Vec4f v) {
		return new Vec4f(
			fract(v.getf(0)), 
			fract(v.getf(1)), 
			fract(v.getf(2)), 
			fract(v.getf(3))
		);
	}

	/**
	 * Returns the maximum of two double values.
	 * @param a First value.
	 * @param b Second value.
	 * @return The maximum value.
	 */
	public static double max(double a, double b) {
		return (a > b) ? a : b;
	}

	/**
	 * Returns the maximum of two float values.
	 * @param a First value.
	 * @param b Second value.
	 * @return The maximum value.
	 */
	public static float max(float a, float b) {
		return (a > b) ? a : b;
	}

	/**
	 * Returns the maximum of two int values.
	 * @param a First value.
	 * @param b Second value.
	 * @return The maximum value.
	 */
	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/**
	 * Returns the maximum of two long values.
	 * @param a First value.
	 * @param b Second value.
	 * @return The maximum value.
	 */
	public static long max(long a, long b) {
		return (a > b) ? a : b;
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec2d.
	 * @param b Second Vec2d.
	 * @return Vec2d with maximum values.
	 */
	public static Vec2d max(Vec2d a, Vec2d b) {
		return new Vec2d(
			max(a.getd(0), b.getd(0)), 
			max(a.getd(1), b.getd(1))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec2f.
	 * @param b Second Vec2f.
	 * @return Vec2f with maximum values.
	 */
	public static Vec2f max(Vec2f a, Vec2f b) {
		return new Vec2f(
			max(a.getf(0), b.getf(0)), 
			max(a.getf(1), b.getf(1))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec2i.
	 * @param b Second Vec2i.
	 * @return Vec2i with maximum values.
	 */
	public static Vec2i max(Vec2i a, Vec2i b) {
		return new Vec2i(
			max(a.geti(0), b.geti(0)), 
			max(a.geti(1), b.geti(1))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec2l.
	 * @param b Second Vec2l.
	 * @return Vec2l with maximum values.
	 */
	public static Vec2l max(Vec2l a, Vec2l b) {
		return new Vec2l(
			max(a.getl(0), b.getl(0)), 
			max(a.getl(1), b.getl(1))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec3d.
	 * @param b Second Vec3d.
	 * @return Vec3d with maximum values.
	 */
	public static Vec3d max(Vec3d a, Vec3d b) {
		return new Vec3d(
			max(a.getd(0), b.getd(0)), 
			max(a.getd(1), b.getd(1)), 
			max(a.getd(2), b.getd(2))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec3f.
	 * @param b Second Vec3f.
	 * @return Vec3f with maximum values.
	 */
	public static Vec3f max(Vec3f a, Vec3f b) {
		return new Vec3f(
			max(a.getf(0), b.getf(0)), 
			max(a.getf(1), b.getf(1)), 
			max(a.getf(2), b.getf(2))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec3i.
	 * @param b Second Vec3i.
	 * @return Vec3i with maximum values.
	 */
	public static Vec3i max(Vec3i a, Vec3i b) {
		return new Vec3i(
			max(a.geti(0), b.geti(0)), 
			max(a.geti(1), b.geti(1)), 
			max(a.geti(2), b.geti(2))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec3l.
	 * @param b Second Vec3l.
	 * @return Vec3l with maximum values.
	 */
	public static Vec3l max(Vec3l a, Vec3l b) {
		return new Vec3l(
			max(a.getl(0), b.getl(0)), 
			max(a.getl(1), b.getl(1)), 
			max(a.getl(2), b.getl(2))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec4d.
	 * @param b Second Vec4d.
	 * @return Vec4d with maximum values.
	 */
	public static Vec4d max(Vec4d a, Vec4d b) {
		return new Vec4d(
			max(a.getd(0), b.getd(0)), 
			max(a.getd(1), b.getd(1)), 
			max(a.getd(2), b.getd(2)), 
			max(a.getd(3), b.getd(3))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec4f.
	 * @param b Second Vec4f.
	 * @return Vec4f with maximum values.
	 */
	public static Vec4f max(Vec4f a, Vec4f b) {
		return new Vec4f(
			max(a.getf(0), b.getf(0)), 
			max(a.getf(1), b.getf(1)), 
			max(a.getf(2), b.getf(2)), 
			max(a.getf(3), b.getf(3))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec4i.
	 * @param b Second Vec4i.
	 * @return Vec4i with maximum values.
	 */
	public static Vec4i max(Vec4i a, Vec4i b) {
		return new Vec4i(
			max(a.geti(0), b.geti(0)), 
			max(a.geti(1), b.geti(1)), 
			max(a.geti(2), b.geti(2)), 
			max(a.geti(3), b.geti(3))
		);
	}

	/**
	 * Returns a vector with the maximum values of each component.
	 * @param a First Vec4l.
	 * @param b Second Vec4l.
	 * @return Vec4l with maximum values.
	 */
	public static Vec4l max(Vec4l a, Vec4l b) {
		return new Vec4l(
			max(a.getl(0), b.getl(0)), 
			max(a.getl(1), b.getl(1)), 
			max(a.getl(2), b.getl(2)), 
			max(a.getl(3), b.getl(3))
		);
	}

	/**
	 * Computes the gradient for 1D noise.
	 * @param hash Hash value.
	 * @param x Distance value.
	 * @return Gradient multiplied by distance.
	 */
	public static double grad(int hash, double x) {
		int h = hash & 15;
		double grad = 1.0 + (h & 7); // Gradient value 1.0, 2.0, ..., 8.0
		if ((h & 8) != 0)
			grad = -grad; // Set a random sign for the gradient
		return grad * x; // Multiply the gradient with the distance
	}

	/**
	 * Computes the gradient for 1D noise.
	 * @param hash Hash value.
	 * @param x Distance value.
	 * @return Gradient multiplied by distance.
	 */
	public static float grad(int hash, float x) {
		int h = hash & 15;
		float grad = 1.0f + (h & 7); // Gradient value 1.0f, 2.0f, ..., 8.0f
		if ((h & 8) != 0)
			grad = -grad; // Set a random sign for the gradient
		return grad * x; // Multiply the gradient with the distance
	}

	/**
	 * Computes the gradient for 2D noise.
	 * @param hash Hash value.
	 * @param p 2D vector.
	 * @return Gradient dot product.
	 */
	public static double grad(int hash, Vec2d p) {
		int h = hash & 7; // Convert low 3 bits of hash code
		double u = h < 4 ? p.getd(0) : p.getd(1); // into 8 simple gradient directions,
		double v = h < 4 ? p.getd(1) : p.getd(0); // and compute the dot product with (x,y).
		return ((h & 1) != 0 ? -u : u) + ((h & 2) != 0 ? -2.0 * v : 2.0 * v);
	}

	/**
	 * Computes the gradient for 2D noise.
	 * @param hash Hash value.
	 * @param p 2D vector.
	 * @return Gradient dot product.
	 */
	public static float grad(int hash, Vec2f p) {
		int h = hash & 7; // Convert low 3 bits of hash code
		float u = h < 4 ? p.getf(0) : p.getf(1); // into 8 simple gradient directions,
		float v = h < 4 ? p.getf(1) : p.getf(0); // and compute the dot product with (x,y).
		return ((h & 1) != 0 ? -u : u) + ((h & 2) != 0 ? -2.0f * v : 2.0f * v);
	}

	/**
	 * Computes the gradient for 3D noise.
	 * @param hash Hash value.
	 * @param p 3D vector.
	 * @return Gradient dot product.
	 */
	public static double grad(int hash, Vec3d p) {
		int h = hash & 15; // Convert low 4 bits of hash code into 12 simple
		double u = h < 8 ? p.getd(0) : p.getd(1); // gradient directions, and compute dot product.
		double v = h < 4 ? p.getd(1) : (h == 12 || h == 14 ? p.getd(0) : p.getd(2)); // Fix repeats at h = 12 to 15
		return ((h & 1) != 0 ? -u : u) + ((h & 2) != 0 ? -v : v);
	}

	/**
	 * Computes the gradient for 3D noise.
	 * @param hash Hash value.
	 * @param p 3D vector.
	 * @return Gradient dot product.
	 */
	public static float grad(int hash, Vec3f p) {
		int h = hash & 15; // Convert low 4 bits of hash code into 12 simple
		float u = h < 8 ? p.getf(0) : p.getf(1); // gradient directions, and compute dot product.
		float v = h < 4 ? p.getf(1) : (h == 12 || h == 14 ? p.getf(0) : p.getf(2)); // Fix repeats at h = 12 to 15
		return ((h & 1) != 0 ? -u : u) + ((h & 2) != 0 ? -v : v);
	}

	/**
	 * Computes the gradient for 4D noise.
	 * @param hash Hash value.
	 * @param p 4D vector.
	 * @return Gradient dot product.
	 */
	public static double grad(int hash, Vec4d p) {
		int h = hash & 31; // Convert low 5 bits of hash code into 32 simple
		double u = h < 24 ? p.getd(0) : p.getd(1); // gradient directions, and compute dot product.
		double v = h < 16 ? p.getd(1) : p.getd(2);
		double t = h < 8 ? p.getd(2) : p.getd(3);
		return ((h & 1) != 0 ? -u : u) + ((h & 2) != 0 ? -v : v) + ((h & 4) != 0 ? -t : t);
	}

	/**
	 * Computes the gradient for 4D noise.
	 * @param hash Hash value.
	 * @param p 4D vector.
	 * @return Gradient dot product.
	 */
	public static float grad(int hash, Vec4f p) {
		int h = hash & 31; // Convert low 5 bits of hash code into 32 simple
		float u = h < 24 ? p.getf(0) : p.getf(1); // gradient directions, and compute dot product.
		float v = h < 16 ? p.getf(1) : p.getf(2);
		float t = h < 8 ? p.getf(2) : p.getf(3);
		return ((h & 1) != 0 ? -u : u) + ((h & 2) != 0 ? -v : v) + ((h & 4) != 0 ? -t : t);
	}
}
