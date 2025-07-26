package net.mahiron47.mathlib.utils;

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


}
