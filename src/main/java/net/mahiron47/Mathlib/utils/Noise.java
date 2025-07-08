/**
 * Utility class for generating pseudo-random noise values using sine functions.
 * 
 * <p>This class provides methods to generate 1D, 2D, 3D, and 4D noise values
 * based on sine functions. The noise values are deterministic and depend on
 * the input coordinates. The fractional part of the sine computation is used
 * to produce values between 0.0 and 1.0.</p>
 * 
 * <p>Note: This class is not intended for instantiation.</p>
 * 
 * <h2>Methods:</h2>
 * <ul>
 *   <li>{@link #fract(double)}: Computes the fractional part of a double value.</li>
 *   <li>{@link #sinoise(double)}: Generates 1D sine noise based on a single input.</li>
 *   <li>{@link #sinoise(double, double)}: Generates 2D sine noise based on two inputs.</li>
 *   <li>{@link #sinoise(double, double, double)}: Generates 3D sine noise based on three inputs.</li>
 *   <li>{@link #sinoise(double, double, double, double)}: Generates 4D sine noise based on four inputs.</li>
 * </ul>
 * 
 * <h2>Usage:</h2>
 * <p>Use the static methods provided by this class to generate noise values
 * for various dimensions. These methods are useful for procedural generation
 * tasks such as terrain generation, texture creation, or other applications
 * requiring pseudo-random values.</p>
 * 
 * <h2>Example:</h2>
 * <pre>
 * double noise1D = Noise.sinoise(42.0);
 * double noise2D = Noise.sinoise(42.0, 24.0);
 * double noise3D = Noise.sinoise(42.0, 24.0, 12.0);
 * double noise4D = Noise.sinoise(42.0, 24.0, 12.0, 6.0);
 * </pre>
 * 
 * <p>All methods return values between 0.0 and 1.0.</p>
 */
package net.mahiron47.Mathlib.utils;


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

	/**
	 * Generates a 1D sin noise value based on the input x.
	 *
	 * @param x The input value.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static double sinoise(double x) {
		return fract(Math.sin(x * 495119) * 499509);
	}

	/**
	 * Generates a 2D sin noise value based on the input x and y.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static double sinoise(double x, double y) {
		return fract(Math.sin(x * 495119 + y * 494109) * 499509);
	}

	/**
	 * Generates a 3D sin noise value based on the input x, y, and z.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param z The z coordinate.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static double sinoise(double x, double y, double z) {
		return fract(Math.sin(x * 495119 + y * 494109 + z * 549161) * 499509);
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
	public static double sinoise(double x, double y, double z, double w) {
		return fract(Math.sin(x * 495119 + y * 494109 + z * 549161 + w * 547967) * 499509);
	}
}
