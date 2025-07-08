package net.mahiron47.Mathlib.types.Interfaces;

public interface IMatrix<T extends Number & IVector> {
	/**
	 * Returns the value at the specified row and column in the matrix.
	 *
	 * @param i the row index
	 * @param j the column index
	 * @return the value at the specified position
	 */
	T get(int i, int j);

	/**
	 * Sets the value at the specified row and column in the matrix.
	 *
	 * @param i the row index
	 * @param j the column index
	 * @param a the value to set
	 */
	void set(int i, int j, T a);

	/**
	 * Returns the number of rows in the matrix.
	 *
	 * @return the number of rows
	 */
	int[] getDimensions();

	/**
	 * Returns the rows in the matrix.
	 *
	 * @return the rows
	 */
	T[] getRows();

	/**
	 * Returns the columns in the matrix.
	 *
	 * @return the columns
	 */
	T[] getCols();

	/**
	 * Returns the data of the matrix as a 2D array.
	 *
	 * @return the data of the matrix
	 */
	T[][] getData();

	/**
	 * Returns the transpose of the matrix.
	 *
	 * @return the transposed matrix
	 */
	IMatrix<T> transpose();

	/**
	 * Returns the sum of matrixes.
	 *
	 * @return the resulting matrix
	 */
	IMatrix<T> add(IMatrix<T> other);

	/**
	 * Returns the difference of matrixes.
	 *
	 * @return the resulting matrix
	 */
	IMatrix<T> subtract(IMatrix<T> other);

	/**
	 * Returns the product of the matrix and a scalar.
	 *
	 * @param scalar the scalar to multiply by
	 * @return the resulting matrix
	 */
	IMatrix<T> multiply(T scalar);

	/**
	 * Returns the product of this matrix and another matrix.
	 * * @param other the matrix to multiply with
	 * 
	 * @return the resulting matrix
	 */
	IMatrix<T> multiply(IMatrix<T> other);
}
