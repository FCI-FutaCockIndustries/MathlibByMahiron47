package net.mahiron47.Mathlib.types.Interfaces;

public interface IQuadMatrix<T extends Number & IVector> extends IMatrix<T> {
	/**
	 * @return the determinant of the matrix
	 */
	double getDeterminant();
}
