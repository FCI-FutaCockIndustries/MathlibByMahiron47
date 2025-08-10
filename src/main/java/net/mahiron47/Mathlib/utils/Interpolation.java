package net.mahiron47.mathlib.utils;

import net.mahiron47.mathlib.types.Vec2d;
import net.mahiron47.mathlib.types.Vec3d;
import net.mahiron47.mathlib.types.Vec4d;
import net.mahiron47.mathlib.types.Mat2d;
import net.mahiron47.mathlib.types.Mat4d;

/**
 * Utility class for performing linear interpolation between values and vectors.
 * 
 * <h2>Methods:</h2>
 * <ul>
 * <li>{@link #linerInterpolation(double, double, double)}: Interpolates between two double
 * values.</li>
 * <li>{@link #linerInterpolation(IVector, IVector, double)}: Interpolates between two vectors
 * of the same type and dimension.</li>
 * </ul>
 */
public class Interpolation {
	private Interpolation() {
		// Private constructor to prevent instantiation
	}

	public static double linearI(Vec2d vertexes, double t) {
		return vertexes.getd(0) + (vertexes.getd(1) - vertexes.getd(0)) * t; // a * (1 - t) + b * t
	}

	public static double bilinearI(Mat2d vertexes, Vec2d t) {
		double first_linear_interpolation = vertexes.getd(0, 0) + (vertexes.getd(0, 1) - vertexes.getd(0, 0)) * t.getd(0);
		double second_linear_interpolation = vertexes.getd(1, 0) + (vertexes.getd(1, 1) - vertexes.getd(1, 0)) * t.getd(0);

		return first_linear_interpolation + (second_linear_interpolation - first_linear_interpolation) * t.getd(1);
	}

	public static double trilinearI(Mat2d up_vertexes, Mat2d down_vertexes, Vec3d t) {
		double bilinear_interpolation_up = bilinearI(up_vertexes, new Vec2d(t.getd(0), t.getd(1)));
		double bilinear_interpolation_down = bilinearI(down_vertexes, new Vec2d(t.getd(0), t.getd(1)));

		return bilinear_interpolation_up + (bilinear_interpolation_down - bilinear_interpolation_up) * t.getd(2);
	}

	public static double cubicI(Vec4d vertexes, double t) {
		double a = vertexes.getd(0);
		double b = vertexes.getd(1);
		double c = vertexes.getd(2);
		double d = vertexes.getd(3);

		return b + 0.5 * (c - a + (2.0 * a - 5.0 * b + 4.0 * c - d + (3.0 * (b - c) + (d - a)) * t) * t) * t;
	}

	public static double bicubicI(Mat4d vertexes, Vec2d t) {
		Vec4d cubics = new Vec4d(0.0, 0.0, 0.0, 0.0);
		for (int i = 0; i < 4; i++) {
			cubics.set(i, cubicI(new Vec4d(
				vertexes.getd(i, 0),
				vertexes.getd(i, 1),
				vertexes.getd(i, 2),
				vertexes.getd(i, 3)
			), t.getd(0)));
		}

		return cubicI(cubics, t.getd(1));
	}

	public static double tricubicI(Mat4d up_vertexes, Mat4d up_center_vertexes, Mat4d down_center_vertexes, Mat4d down_vertexes, Vec3d t) {
		Vec4d bicubics = new Vec4d(0.0, 0.0, 0.0, 0.0);
		for (int i = 0; i < 4; i++) {
			bicubics.set(i, bicubicI(new Mat4d(
				up_vertexes.getd(i, 0), up_vertexes.getd(i, 1), up_vertexes.getd(i, 2), up_vertexes.getd(i, 3),
				up_center_vertexes.getd(i, 0), up_center_vertexes.getd(i, 1), up_center_vertexes.getd(i, 2), up_center_vertexes.getd(i, 3),
				down_center_vertexes.getd(i, 0), down_center_vertexes.getd(i, 1), down_center_vertexes.getd(i, 2), down_center_vertexes.getd(i, 3),
				down_vertexes.getd(i, 0), down_vertexes.getd(i, 1), down_vertexes.getd(i, 2), down_vertexes.getd(i, 3)
			), new Vec2d(t.getd(0), t.getd(2))));
		}

		return cubicI(bicubics, t.getd(1));
	}
}