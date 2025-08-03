package net.mahiron47.mathlib.types.interfaces;

public interface IMatrix extends ITensor {
	/**
	 * @param i the row index
	 * @param j the column index
	 * @return the value at the specified position in the matrix as a Integer type
	 */
	int geti(int i, int j);

	/**
	 * @param i the row index
	 * @param j the column index
	 * @return the value at the specified position in the matrix as a Long type
	 */
	long getl(int i, int j);

	/**
	 * @param i the row index
	 * @param j the column index
	 * @return the value at the specified position in the matrix as a Float type
	 */
	float getf(int i, int j);

	/**
	 * @param i the row index
	 * @param j the column index
	 * @return the value at the specified position in the matrix as a Double type
	 */
	double getd(int i, int j);

	/**
	 * Sets the value at the specified row and column in the matrix.
	 *
	 * @param i the row index
	 * @param j the column index
	 * @param a_ij the value to set
	 */
	void set(int i, int j, int a_ij);

	/**
	 * Sets the value at the specified row and column in the matrix.
	 *
	 * @param i the row index
	 * @param j the column index
	 * @param a_ij the value to set
	 */
	void set(int i, int j, long a_ij);

	/**
	 * Sets the value at the specified row and column in the matrix.
	 *
	 * @param i the row index
	 * @param j the column index
	 * @param a_ij the value to set
	 */
	void set(int i, int j, float a_ij);

	/**
	 * Sets the value at the specified row and column in the matrix.
	 *
	 * @param i the row index
	 * @param j the column index
	 * @param a_ij the value to set
	 */
	void set(int i, int j, double a_ij);

	/**
	 * @return the number of rows and columns
	 */
	int[] getDimensions();

	/**
	 * @return the copy of this matrix
	 */
	IMatrix copy();

	/**
	 * @return the matrix in vector form, which is a i-column vector 
	 */
	IVector convert(int i);

	/**
	 * @return the transposed matrix
	 */
	IMatrix getTranspose();

	/**
	 * @return the determinant of the matrix as an Integer type
	 */
	int deti();

	/**
	 * @return the determinant of the matrix as a Long type
	 */
	long detl();

	/**
	 * @return the determinant of the matrix as a Float type
	 */
	float detf();

	/**
	 * @return the determinant of the matrix as a Double type
	 */
	double detd();
	
	/**
	 * @return the sum of two matrix
	 */
	IMatrix add(IMatrix other);

	/**
	 * @return the difference of two matrix
	 */
	IMatrix subtract(IMatrix other);

	/**
	 * @param scalar the scalar to multiply by
	 * @return the multiplied by scalar matrix
	 */
	IMatrix multiply(int scalar);

	/**
	 * @param scalar the scalar to multiply by
	 * @return the multiplied by scalar matrix
	 */
	IMatrix multiply(long scalar);

	/**
	 * @param scalar the scalar to multiply by
	 * @return the multiplied by scalar matrix
	 */
	IMatrix multiply(float scalar);

	/**
	 * @param scalar the scalar to multiply by
	 * @return the multiplied by scalar matrix
	 */
	IMatrix multiply(double scalar);

	/**
	 * Matrix multiplication operation C_mk = A_mn &times; B_nk, where A_mn is this matrix.
	 * 
	 * @param other the matrix B_nk
	 * @return the C_mk matrix
	 */
	IMatrix multiply(IMatrix other);
}