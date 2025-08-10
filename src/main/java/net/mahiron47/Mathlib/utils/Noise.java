package net.mahiron47.mathlib.utils;

import net.mahiron47.mathlib.types.Vec2d;
import net.mahiron47.mathlib.types.Vec3d;
import net.mahiron47.mathlib.types.Vec2f;
import net.mahiron47.mathlib.types.Vec3f;
import net.mahiron47.mathlib.types.Vec4d;
import net.mahiron47.mathlib.types.Vec4f;

/**
 * Utility class for generating pseudo-random noise values using sine functions.
 */
public class Noise {
	private Noise() {
		// Private constructor to prevent instantiation
	}

	/**
	 * Generates a 1D sin noise value based on the input x.
	 *
	 * @param p The input value.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static double sinoise(double p) {
		return Math.fract(Math.sin(p * 495119) * 499509);
	}

	/**
	 * Generates a 1D sin noise value based on the input x.
	 * @param p The input value.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static float sinoise(float p) {
		return Math.fract(Math.sin(p * 495119) * 499509);
	}

	/**
	 * Generates a 2D sin noise value based on the input x and y.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static double sinoise(Vec2d p) {
		return Math.fract(Math.sin(p.getd(0) * 495119 + p.getd(1) * 494109) * 499509);
	}

	/**
	 * Generates a 2D sin noise value based on the input vector.
	 * @param p The input Vec2f.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static float sinoise(Vec2f p) {
		return Math.fract(Math.sin(p.getf(0) * 495119 + p.getf(1) * 494109) * 499509);
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
		return Math.fract(Math.sin(p.getd(0) * 495119 + p.getd(1) * 494109 + p.getd(2) * 549161) * 499509);
	}

	/**
	 * Generates a 3D sin noise value based on the input vector.
	 * @param p The input Vec3f.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static float sinoise(Vec3f p) {
		return Math.fract(Math.sin(p.getf(0) * 495119 + p.getf(1) * 494109 + p.getf(2) * 549161) * 499509);
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
	/**
	 * Generates a 4D sin noise value based on the input vector and w.
	 * @param p The input Vec3d.
	 * @param w The w coordinate.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static double sinoise(Vec3d p, double w) {
		return Math.fract(Math.sin(p.getd(0) * 495119 + p.getd(1) * 494109 + p.getd(2) * 549161 + w * 547967) * 499509);
	}

	/**
	 * Generates a 4D sin noise value based on the input vector and w.
	 * @param p The input Vec3f.
	 * @param w The w coordinate.
	 * @return A pseudo-random noise value between 0.0 and 1.0.
	 */
	public static float sinoise(Vec3f p, float w) {
		return Math.fract(Math.sin(p.getf(0) * 495119 + p.getf(1) * 494109 + p.getf(2) * 549161 + w * 547967) * 499509);
	}

	/**
	 * Generates a 2D simplex noise value based on the input vector.
	 *
	 * @param p The input vector.
	 * @return A pseudo-random noise value between -1.0 and 1.0.
	 */
	public static double simplexNoise(Vec2d p) {
		double F = 0.366025404; // (sqrt(2 + 1) - 1) / 2;
		double G = 0.211324865; // (3 - sqrt(3)) / 6;

		// Shift the input position to the simplex grid
		double pos_factor = (p.getd(0) + p.getd(1)) * F;
		Vec2d shift_pos = new Vec2d(
			p.getd(0) + pos_factor,
			p.getd(1) + pos_factor
		);
		// Skew the input space to determine which simplex cell we're in
		Vec2d cell_pos = Math.floor(shift_pos);

		// Unskew the cell origin back to (x,y) space
		double pos_refactor = (cell_pos.getd(0) + cell_pos.getd(1)) * G;
		Vec2d cell_origin_pos = new Vec2d (
			cell_pos.getd(0) - pos_refactor,
			cell_pos.getd(1) - pos_refactor
		);
		// Calculate the distances from the cell origin to the input position
		Vec2d first_offset_cell_origin_distances = p.subtract(cell_origin_pos);

		// For the 2D case, the simplex shape is an equilateral triangle.
		// Determine which simplex we are in.
		Vec2d simplex_vertex_indices;
		if (first_offset_cell_origin_distances.getd(0) > first_offset_cell_origin_distances.getd(1)) {
			simplex_vertex_indices = new Vec2d(1.0, 0.0);
		} else {
			simplex_vertex_indices = new Vec2d(0.0, 1.0);
		}

		// Calculate the distances from the cell origin to the simplex vertexes
		Vec2d second_offset_cell_origin_distances = first_offset_cell_origin_distances.subtract(simplex_vertex_indices).add(new Vec2d(G, G));
		double _const = 2.0 * G;
		Vec2d third_offset_cell_origin_distances = first_offset_cell_origin_distances.subtract(new Vec2d(1.0, 1.0)).add(new Vec2d(_const, _const));

		Vec3d simplex_factor = new Vec3d(0.5, 0.5, 0.5).subtract(new Vec3d(
			first_offset_cell_origin_distances.dotd(first_offset_cell_origin_distances), 
			second_offset_cell_origin_distances.dotd(second_offset_cell_origin_distances), 
			third_offset_cell_origin_distances.dotd(third_offset_cell_origin_distances)
		));
		// Noise contributions from the corners
		Vec3d vertexes_contribution = new Vec3d(0.0, 0.0, 0.0);
		// Calculate the contribution from the corners
		if (simplex_factor.getd(0) > 0.0) {
			simplex_factor.set(0, simplex_factor.getd(0) * simplex_factor.getd(0));
			vertexes_contribution.set(0, simplex_factor.getd(0) * simplex_factor.getd(0) * Math.grad((int) Math.floor(sinoise(cell_pos) * 1000), first_offset_cell_origin_distances));
		}
		if (simplex_factor.getd(1) > 0.0) {
			simplex_factor.set(1, simplex_factor.getd(1) * simplex_factor.getd(1));
			vertexes_contribution.set(1, simplex_factor.getd(1) * simplex_factor.getd(1) * Math.grad((int) Math.floor(sinoise(cell_pos.add(simplex_vertex_indices)) * 1000), second_offset_cell_origin_distances));
		}
		if (simplex_factor.getd(2) > 0.0) {
			simplex_factor.set(2, simplex_factor.getd(2) * simplex_factor.getd(2));
			vertexes_contribution.set(2, simplex_factor.getd(2) * simplex_factor.getd(2) * Math.grad((int) Math.floor(sinoise(cell_pos.add(new Vec2d(1.0, 1.0))) * 1000), third_offset_cell_origin_distances));
		}

		return vertexes_contribution.dotd(new Vec3d(40.0, 40.0, 40.0));
	}

	/**
	 * Generates a 2D simplex noise value based on the input vector.
	 *
	 * @param p The input vector.
	 * @return A pseudo-random noise value between -1.0 and 1.0.
	 */
	public static float simplexNoise(Vec2f p) {
		float F = 0.366025404f; // (sqrt(2 + 1) - 1) / 2;
		float G = 0.211324865f; // (3 - sqrt(3)) / 6;

		// Shift the input position to the simplex grid
		float pos_factor = (p.getf(0) + p.getf(1)) * F;
		Vec2f shift_pos = new Vec2f(
			p.getf(0) + pos_factor,
			p.getf(1) + pos_factor
		);
		// Skew the input space to determine which simplex cell we're in
		Vec2f cell_pos = Math.floor(shift_pos);

		// Unskew the cell origin back to (x,y) space
		float pos_refactor = (cell_pos.getf(0) + cell_pos.getf(1)) * G;
		Vec2f cell_origin_pos = new Vec2f (
			cell_pos.getf(0) - pos_refactor,
			cell_pos.getf(1) - pos_refactor
		);
		// Calculate the distances from the cell origin to the input position
		Vec2f first_offset_cell_origin_distances = p.subtract(cell_origin_pos);

		// For the 2D case, the simplex shape is an equilateral triangle.
		// Determine which simplex we are in.
		Vec2f simplex_vertex_indices;
		if (first_offset_cell_origin_distances.getf(0) > first_offset_cell_origin_distances.getf(1)) {
			simplex_vertex_indices = new Vec2f(1.0f, 0.0f);
		} else {
			simplex_vertex_indices = new Vec2f(0.0f, 1.0f);
		}

		// Calculate the distances from the cell origin to the simplex vertexes
		Vec2f second_offset_cell_origin_distances = first_offset_cell_origin_distances.subtract(simplex_vertex_indices).add(new Vec2f(G, G));
		float _const = 2.0f * G;
		Vec2f third_offset_cell_origin_distances = first_offset_cell_origin_distances.subtract(new Vec2f(1.0f, 1.0f)).add(new Vec2f(_const, _const));

		Vec3f simplex_factor = new Vec3f(0.5f, 0.5f, 0.5f).subtract(new Vec3f(
			first_offset_cell_origin_distances.dotf(first_offset_cell_origin_distances),
			second_offset_cell_origin_distances.dotf(second_offset_cell_origin_distances),
			third_offset_cell_origin_distances.dotf(third_offset_cell_origin_distances)
		));
		// Noise contributions from the corners
		Vec3f vertexes_contribution = new Vec3f(0.0f, 0.0f, 0.0f);
		// Calculate the contribution from the corners
		if (simplex_factor.getf(0) > 0.0f) {
			simplex_factor.set(0, simplex_factor.getf(0) * simplex_factor.getf(0));
			vertexes_contribution.set(0, simplex_factor.getf(0) * simplex_factor.getf(0) * Math.grad((int) Math.floor(sinoise(cell_pos) * 1000), first_offset_cell_origin_distances));
		}
		if (simplex_factor.getf(1) > 0.0f) {
			simplex_factor.set(1, simplex_factor.getf(1) * simplex_factor.getf(1));
			vertexes_contribution.set(1, simplex_factor.getf(1) * simplex_factor.getf(1) * Math.grad((int) Math.floor(sinoise(cell_pos.add(simplex_vertex_indices)) * 1000), second_offset_cell_origin_distances));
		}
		if (simplex_factor.getf(2) > 0.0f) {
			simplex_factor.set(2, simplex_factor.getf(2) * simplex_factor.getf(2));
			vertexes_contribution.set(2, simplex_factor.getf(2) * simplex_factor.getf(2) * Math.grad((int) Math.floor(sinoise(cell_pos.add(new Vec2f(1.0f, 1.0f))) * 1000), third_offset_cell_origin_distances));
		}

		return vertexes_contribution.dotf(new Vec3f(40.0f, 40.0f, 40.0f));
	}

	/**
	 * Generates a 3D simplex noise value based on the input vector.
	 * @param p The input Vec3d.
	 * @return A pseudo-random noise value between -1.0 and 1.0.
	 */
	public static double simplexNoise(Vec3d p) {
		double F = 0.333333333; // (sqrt(3 + 1) - 1) / 3;
		double G = 0.166666667; // (4 - sqrt(4)) / 12;

		// Shift the input position to the simplex grid
		double pos_factor = (p.getd(0) + p.getd(1) + p.getd(2)) * F;
		Vec3d shift_pos = new Vec3d(
			p.getd(0) + pos_factor,
			p.getd(1) + pos_factor,
			p.getd(2) + pos_factor
		);
		// Skew the input space to determine which simplex cell we're in
		Vec3d cell_pos = Math.floor(shift_pos);

		// Unskew the cell origin back to (x,y,z) space
		double pos_refactor = (cell_pos.getd(0) + cell_pos.getd(1) + cell_pos.getd(2)) * G;
		Vec3d cell_origin_pos = new Vec3d(
			cell_pos.getd(0) - pos_refactor,
			cell_pos.getd(1) - pos_refactor,
			cell_pos.getd(2) - pos_refactor
		);
		// Calculate the distances from the cell origin to the input position
		Vec3d first_offset_cell_origin_distances = p.subtract(cell_origin_pos);

		// For the 3D case, the simplex shape is a slightly irregular tetrahedron.
		// Determine which simplex we are in.
		Vec3d first_simplex_vertex_indices;
		Vec3d second_simplex_vertex_indices;
		if (first_offset_cell_origin_distances.getd(0) > first_offset_cell_origin_distances.getd(1)) {
			if (first_offset_cell_origin_distances.getd(0) > first_offset_cell_origin_distances.getd(2)) {
				first_simplex_vertex_indices = new Vec3d(1.0, 0.0, 0.0);
				if (first_offset_cell_origin_distances.getd(1) > first_offset_cell_origin_distances.getd(2)) {
					second_simplex_vertex_indices = new Vec3d(0.0, 1.0, 0.0);
				} else {
					second_simplex_vertex_indices = new Vec3d(0.0, 0.0, 1.0);
				}
			} else {
				first_simplex_vertex_indices = new Vec3d(0.0, 0.0, 1.0);
				if (first_offset_cell_origin_distances.getd(1) > first_offset_cell_origin_distances.getd(2)) {
					second_simplex_vertex_indices = new Vec3d(0.0, 1.0, 0.0);
				} else {
					second_simplex_vertex_indices = new Vec3d(0.0, 0.0, 1.0);
				}
			}
		} else {
			if (first_offset_cell_origin_distances.getd(1) > first_offset_cell_origin_distances.getd(2)) {
				first_simplex_vertex_indices = new Vec3d(0.0, 1.0, 0.0);
				if (first_offset_cell_origin_distances.getd(0) > first_offset_cell_origin_distances.getd(2)) {
					second_simplex_vertex_indices = new Vec3d(1.0, 0.0, 0.0);
				} else {
					second_simplex_vertex_indices = new Vec3d(0.0, 0.0, 1.0);
				}
			} else {
				first_simplex_vertex_indices = new Vec3d(0.0, 0.0, 1.0);
				if (first_offset_cell_origin_distances.getd(0) > first_offset_cell_origin_distances.getd(1)) {
					second_simplex_vertex_indices = new Vec3d(1.0, 0.0, 0.0);
				} else {
					second_simplex_vertex_indices = new Vec3d(0.0, 1.0, 0.0);
				}
			}
		}

		// Calculate the distances from the cell origin to the simplex vertexes
		Vec3d second_offset_cell_origin_distances = first_offset_cell_origin_distances.subtract(first_simplex_vertex_indices).add(new Vec3d(G, G, G));
		double first_const = 2.0 * G;
		Vec3d third_offset_cell_origin_distances = first_offset_cell_origin_distances.subtract(second_simplex_vertex_indices).add(new Vec3d(first_const, first_const, first_const));
		double second_const = 3.0 * G;
		Vec3d fourth_offset_cell_origin_distances = second_offset_cell_origin_distances.subtract(new Vec3d(1.0, 1.0, 1.0)).add(new Vec3d(second_const, second_const, second_const));

		Vec4d simplex_factor = new Vec4d(0.5, 0.5, 0.5, 0.5).subtract(new Vec4d(
			first_offset_cell_origin_distances.dotd(first_offset_cell_origin_distances),
			second_offset_cell_origin_distances.dotd(second_offset_cell_origin_distances),
			third_offset_cell_origin_distances.dotd(third_offset_cell_origin_distances),
			fourth_offset_cell_origin_distances.dotd(fourth_offset_cell_origin_distances)
		));
		// Noise contributions from the corners
		Vec4d vertexes_contribution = new Vec4d(0.0, 0.0, 0.0, 0.0);
		// Calculate the contribution from the corners
		if (simplex_factor.getd(0) > 0.0) {
			simplex_factor.set(0, simplex_factor.getd(0) * simplex_factor.getd(0));
			vertexes_contribution.set(0, simplex_factor.getd(0) * simplex_factor.getd(0) * Math.grad((int) Math.floor(sinoise(cell_pos) * 1000), first_offset_cell_origin_distances));
		}
		if (simplex_factor.getd(1) > 0.0) {
			simplex_factor.set(1, simplex_factor.getd(1) * simplex_factor.getd(1));
			vertexes_contribution.set(1, simplex_factor.getd(1) * simplex_factor.getd(1) * Math.grad((int) Math.floor(sinoise(cell_pos.add(first_simplex_vertex_indices)) * 1000), second_offset_cell_origin_distances));
		}
		if (simplex_factor.getd(2) > 0.0) {
			simplex_factor.set(2, simplex_factor.getd(2) * simplex_factor.getd(2));
			vertexes_contribution.set(2, simplex_factor.getd(2) * simplex_factor.getd(2) * Math.grad((int) Math.floor(sinoise(cell_pos.add(second_simplex_vertex_indices)) * 1000), third_offset_cell_origin_distances));
		}
		if (simplex_factor.getd(3) > 0.0) {
			simplex_factor.set(3, simplex_factor.getd(3) * simplex_factor.getd(3));
			vertexes_contribution.set(3, simplex_factor.getd(3) * simplex_factor.getd(3) * Math.grad((int) Math.floor(sinoise(cell_pos.add(new Vec3d(1.0, 1.0, 1.0))) * 1000), fourth_offset_cell_origin_distances));
		}

		return vertexes_contribution.dotd(new Vec4d(40.0, 40.0, 40.0, 40.0));
	}

	/**
	 * Generates a 3D simplex noise value based on the input vector.
	 * @param p The input Vec3f.
	 * @return A pseudo-random noise value between -1.0 and 1.0.
	 */
	public static float simplexNoise(Vec3f p) {
		float F = 0.333333333f; // (sqrt(3 + 1) - 1) / 3;
		float G = 0.166666667f; // (4 - sqrt(4)) / 12;

		// Shift the input position to the simplex grid
		float pos_factor = (p.getf(0) + p.getf(1) + p.getf(2)) * F;
		Vec3f shift_pos = new Vec3f(
			p.getf(0) + pos_factor,
			p.getf(1) + pos_factor,
			p.getf(2) + pos_factor
		);
		// Skew the input space to determine which simplex cell we're in
		Vec3f cell_pos = Math.floor(shift_pos);

		// Unskew the cell origin back to (x,y,z) space
		float pos_refactor = (cell_pos.getf(0) + cell_pos.getf(1) + cell_pos.getf(2)) * G;
		Vec3f cell_origin_pos = new Vec3f(
			cell_pos.getf(0) - pos_refactor,
			cell_pos.getf(1) - pos_refactor,
			cell_pos.getf(2) - pos_refactor
		);
		// Calculate the distances from the cell origin to the input position
		Vec3f first_offset_cell_origin_distances = p.subtract(cell_origin_pos);

		// For the 3D case, the simplex shape is a slightly irregular tetrahedron.
		// Determine which simplex we are in.
		Vec3f first_simplex_vertex_indices;
		Vec3f second_simplex_vertex_indices;
		if (first_offset_cell_origin_distances.getf(0) > first_offset_cell_origin_distances.getf(1)) {
			if (first_offset_cell_origin_distances.getf(0) > first_offset_cell_origin_distances.getf(2)) {
				first_simplex_vertex_indices = new Vec3f(1.0f, 0.0f, 0.0f);
				if (first_offset_cell_origin_distances.getf(1) > first_offset_cell_origin_distances.getf(2)) {
					second_simplex_vertex_indices = new Vec3f(0.0f, 1.0f, 0.0f);
				} else {
					second_simplex_vertex_indices = new Vec3f(0.0f, 0.0f, 1.0f);
				}
			} else {
				first_simplex_vertex_indices = new Vec3f(0.0f, 0.0f, 1.0f);
				if (first_offset_cell_origin_distances.getf(1) > first_offset_cell_origin_distances.getf(2)) {
					second_simplex_vertex_indices = new Vec3f(0.0f, 1.0f, 0.0f);
				} else {
					second_simplex_vertex_indices = new Vec3f(0.0f, 0.0f, 1.0f);
				}
			}
		}
		else {
			if (first_offset_cell_origin_distances.getf(1) > first_offset_cell_origin_distances.getf(2)) {
				first_simplex_vertex_indices = new Vec3f(0.0f, 1.0f, 0.0f);
				if (first_offset_cell_origin_distances.getf(0) > first_offset_cell_origin_distances.getf(2)) {
					second_simplex_vertex_indices = new Vec3f(1.0f, 0.0f, 0.0f);
				} else {
					second_simplex_vertex_indices = new Vec3f(0.0f, 0.0f, 1.0f);
				}
			} else {
				first_simplex_vertex_indices = new Vec3f(0.0f, 0.0f, 1.0f);
				if (first_offset_cell_origin_distances.getf(0) > first_offset_cell_origin_distances.getf(1)) {
					second_simplex_vertex_indices = new Vec3f(1.0f, 0.0f, 0.0f);
				} else {
					second_simplex_vertex_indices = new Vec3f(0.0f, 1.0f, 0.0f);
				}
			}
		}

		Vec3f second_offset_cell_origin_distances = first_offset_cell_origin_distances.subtract(first_simplex_vertex_indices).add(new Vec3f(G, G, G));
		float first_const = 2.0f * G;
		Vec3f third_offset_cell_origin_distances = first_offset_cell_origin_distances.subtract(second_simplex_vertex_indices).add(new Vec3f(first_const, first_const, first_const));
		float second_const = 3.0f * G;
		Vec3f fourth_offset_cell_origin_distances = first_offset_cell_origin_distances.subtract(new Vec3f(1.0f, 1.0f, 1.0f)).add(new Vec3f(second_const, second_const, second_const));

		Vec4f simplex_factor = new Vec4f(0.5f, 0.5f, 0.5f, 0.5f).subtract(new Vec4f(
			first_offset_cell_origin_distances.dotf(first_offset_cell_origin_distances),
			second_offset_cell_origin_distances.dotf(second_offset_cell_origin_distances),
			third_offset_cell_origin_distances.dotf(third_offset_cell_origin_distances),
			fourth_offset_cell_origin_distances.dotf(fourth_offset_cell_origin_distances)
		));
		// Noise contributions from the corners
		Vec4f vertexes_contribution = new Vec4f(0.0f, 0.0f, 0.0f, 0.0f);
		// Calculate the contribution from the corners
		if (simplex_factor.getf(0) > 0.0f) {
			simplex_factor.set(0, simplex_factor.getf(0) * simplex_factor.getf(0));
			vertexes_contribution.set(0, simplex_factor.getf(0) * simplex_factor.getf(0) * Math.grad((int) Math.floor(sinoise(cell_pos) * 1000), first_offset_cell_origin_distances));
		}
		if (simplex_factor.getf(1) > 0.0f) {
			simplex_factor.set(1, simplex_factor.getf(1) * simplex_factor.getf(1));
			vertexes_contribution.set(1, simplex_factor.getf(1) * simplex_factor.getf(1) * Math.grad((int) Math.floor(sinoise(cell_pos.add(first_simplex_vertex_indices)) * 1000), second_offset_cell_origin_distances));
		}
		if (simplex_factor.getf(2) > 0.0f) {
			simplex_factor.set(2, simplex_factor.getf(2) * simplex_factor.getf(2));
			vertexes_contribution.set(2, simplex_factor.getf(2) * simplex_factor.getf(2) * Math.grad((int) Math.floor(sinoise(cell_pos.add(second_simplex_vertex_indices)) * 1000), third_offset_cell_origin_distances));
		}
		if (simplex_factor.getf(3) > 0.0f) {
			simplex_factor.set(3, simplex_factor.getf(3) * simplex_factor.getf(3));
			vertexes_contribution.set(3, simplex_factor.getf(3) * simplex_factor.getf(3) * Math.grad((int) Math.floor(sinoise(cell_pos.add(new Vec3f(1.0f, 1.0f, 1.0f))) * 1000), fourth_offset_cell_origin_distances));
		}

		return vertexes_contribution.dotf(new Vec4f(40.0f, 40.0f, 40.0f, 40.0f));
	}
}
