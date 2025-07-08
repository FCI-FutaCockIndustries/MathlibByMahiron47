package net.mahiron47.Mathlib.types;

import net.mahiron47.Mathlib.types.Interfaces.IQuadMatrix;
import net.mahiron47.Mathlib.types.Interfaces.IVector;

public class Mat2<T extends Number & IVector> /*implements IQuadMatrix<T>*/ {
	T[][] data;

	public Mat2(T[][] data) {
		if (data.length != 2 || data[0].length != 2 || data[1].length != 2) {
			throw new IllegalArgumentException("Matrix must be 2x2.");
		}
		this.data = data;
	}

	public Mat2(Number a11, Number a12, Number a21, Number a22) {
		this.data = (T[][]) new Number[2][2];
		this.data[0][0] = (T) a11;
		this.data[0][1] = (T) a12;
		this.data[1][0] = (T) a21;
		this.data[1][1] = (T) a22;
	}

	public Mat2(IVector a11, IVector a12, IVector a21, IVector a22) {
		this.data = (T[][]) new IVector[2][2];
		this.data[0][0] = (T) a11;
		this.data[0][1] = (T) a12;
		this.data[1][0] = (T) a21;
		this.data[1][1] = (T) a22;
	}
}
