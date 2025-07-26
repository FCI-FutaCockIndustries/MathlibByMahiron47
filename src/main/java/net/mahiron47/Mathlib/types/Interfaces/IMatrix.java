package net.mahiron47.mathlib.types.interfaces;

public interface IMatrix<NumT extends Number,
		VecT extends IVector<NumT, VecT, MatT>,
		MatT extends IMatrix<NumT, VecT, MatT>> {
	static final byte TYPE_NO_TYPE = 0b00000000;
	static final byte TYPE_NUM_MAT = 0b00000001;
	static final byte TYPE_VEC_MAT = 0b00000010;
	static final byte TYPE_MAT_MAT = 0b00000100;

    static final byte TYPE_ELEMENT_END = 0b00; //null type
    static final byte TYPE_ELEMENT_NUM = 0b01;
    static final byte TYPE_ELEMENT_VEC = 0b10;
    static final byte TYPE_ELEMENT_MAT = 0b11;

	/**
	 * @param i the row index
	 * @param j the column index
	 * @return the value at the specified position
	 */
	Object get(int i, int j);

	/**
	 * Sets the value at the specified row and column in the matrix.
	 *
	 * @param i the row index
	 * @param j the column index
	 * @param a_ij the value to set
	 */
	void set(int i, int j, NumT a_ij);

	/**
	 * Sets the value at the specified row and column in the matrix.
	 *
	 * @param i the row index
	 * @param j the column index
	 * @param a_ij the value to set
	 */
	void set(int i, int j, VecT a_ij);

	/**
	 * Sets the value at the specified row and column in the matrix.
	 *
	 * @param i the row index
	 * @param j the column index
	 * @param a_ij the value to set
	 */
	void set(int i, int j, MatT a_ij);

	/**
	 * @return the number of rows and columns
	 */
	int[] getDimensions();

	/**
	 * @return the copy of this matrix
	 */
	IMatrix<NumT, VecT, MatT> copy();

	/**
	 * @return the matrix in vector form, which is a i-column vector 
	 */
	IVector<NumT, VecT, MatT> convert(int i);

	/**
	 * @return the transposed matrix
	 */
	IMatrix<NumT, VecT, MatT> getTranspose();

	/**
	 * @return the length of the matrix, which is the square root of the sum of squares of all elements
	 */
	double getLength();

	/**
	 * @return the normalized matrix, which has a length of 1 or matrix of other types which is normalized
	 */
	IMatrix<Number, VecT, MatT> getNormal();

	/**
	 * @return the determinant of the matrix
	 */
	NumT getDeterminant();
	
	/**
	 * @return the sum of two matrix
	 */
	IMatrix<NumT, VecT, MatT> add(IMatrix<NumT, VecT, MatT> other);

	/**
	 * @return the difference of two matrix
	 */
	IMatrix<NumT, VecT, MatT> subtract(IMatrix<NumT, VecT, MatT> other);

	/**
	 * @param scalar the scalar to multiply by
	 * @return the multiplied by scalar matrix
	 */
	IMatrix<NumT, VecT, MatT> multiply(NumT scalar);

	/**
	 * Matrix multiplication operation C<sub>ml</sub> = A<sub>mn</sub> *
	 * B<sub>nl</sub>, where A<sub>mn</sub> is this matrix
	 * 
	 * @param other the matrix B<sub>nl</sub>
	 * @return the C<sub>ml</sub> matrix
	 */
	IMatrix<NumT, VecT, MatT> multiply(IMatrix<NumT, VecT, MatT> other);
}
