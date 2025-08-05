package net.mahiron47.mathlib.types.interfaces;

public interface IMatrix extends ITensor {
    /**
     * Gets the value at the specified position in the matrix as an integer.
     * 
     * @param i the row index (0-based)
     * @param j the column index (0-based)
     * @return the value at position (i,j) cast to int
     * @throws IndexOutOfBoundsException if indices are invalid
     */
    int geti(int i, int j);

    /**
     * Gets the value at the specified position in the matrix as a long.
     * 
     * @param i the row index (0-based)
     * @param j the column index (0-based)
     * @return the value at position (i,j) cast to long
     * @throws IndexOutOfBoundsException if indices are invalid
     */
    long getl(int i, int j);

    /**
     * Gets the value at the specified position in the matrix as a float.
     * 
     * @param i the row index (0-based)
     * @param j the column index (0-based)
     * @return the value at position (i,j) cast to float
     * @throws IndexOutOfBoundsException if indices are invalid
     */
    float getf(int i, int j);

    /**
     * Gets the value at the specified position in the matrix as a double.
     * 
     * @param i the row index (0-based)
     * @param j the column index (0-based)
     * @return the value at position (i,j) cast to double
     * @throws IndexOutOfBoundsException if indices are invalid
     */
    double getd(int i, int j);

    /**
     * Sets the value at the specified position in the matrix.
     *
     * @param i the row index (0-based)
     * @param j the column index (0-based)
     * @param a_ij the integer value to set at position (i,j)
     * @throws IndexOutOfBoundsException if indices are invalid
     */
    void set(int i, int j, int a_ij);

    /**
     * Sets the value at the specified position in the matrix.
     *
     * @param i the row index (0-based)
     * @param j the column index (0-based)
     * @param a_ij the long value to set at position (i,j)
     * @throws IndexOutOfBoundsException if indices are invalid
     */
    void set(int i, int j, long a_ij);

    /**
     * Sets the value at the specified position in the matrix.
     *
     * @param i the row index (0-based)
     * @param j the column index (0-based)
     * @param a_ij the float value to set at position (i,j)
     * @throws IndexOutOfBoundsException if indices are invalid
     */
    void set(int i, int j, float a_ij);

    /**
     * Sets the value at the specified position in the matrix.
     *
     * @param i the row index (0-based)
     * @param j the column index (0-based)
     * @param a_ij the double value to set at position (i,j)
     * @throws IndexOutOfBoundsException if indices are invalid
     */
    void set(int i, int j, double a_ij);

    /**
     * Gets the dimensions of the matrix.
     * 
     * @return an array where index 0 is the number of rows and index 1 is the number of columns
     */
    int[] getDimensions();

    /**
     * Creates a deep copy of this matrix.
     * 
     * @return a new IMatrix instance that is an independent copy of this matrix
     */
    IMatrix copy();

    /**
     * Converts the matrix to vector form by extracting the specified column.
     * 
     * @param i the column index to extract (0-based)
     * @return a column vector containing the values from column i
     * @throws IndexOutOfBoundsException if column index is invalid
     */
    IVector convert(int i);

    /**
     * Computes the transpose of this matrix.
     * For a matrix A<sub>m×n</sub>, returns A<sup>T</sup><sub>n×m</sub> where A<sup>T</sup>[i][j] = A[j][i].
     * 
     * @return a new IMatrix representing the transpose of this matrix
     */
    IMatrix getTranspose();

    /**
     * Calculates the determinant of the matrix as an integer.
     * Only valid for square matrices.
     * 
     * @return the determinant value cast to int
     * @throws IllegalStateException if the matrix is not square
     * @throws ArithmeticException if determinant calculation fails
     */
    int deti();

    /**
     * Calculates the determinant of the matrix as a long.
     * Only valid for square matrices.
     * 
     * @return the determinant value cast to long
     * @throws IllegalStateException if the matrix is not square
     * @throws ArithmeticException if determinant calculation fails
     */
    long detl();

    /**
     * Calculates the determinant of the matrix as a float.
     * Only valid for square matrices.
     * 
     * @return the determinant value cast to float
     * @throws IllegalStateException if the matrix is not square
     * @throws ArithmeticException if determinant calculation fails
     */
    float detf();

    /**
     * Calculates the determinant of the matrix as a double.
     * Only valid for square matrices.
     * 
     * @return the determinant value cast to double
     * @throws IllegalStateException if the matrix is not square
     * @throws ArithmeticException if determinant calculation fails
     */
    double detd();
    
    /**
     * Performs matrix addition with another matrix.
     * Both matrices must have the same dimensions.
     * 
     * @param other the matrix to add to this matrix
     * @return a new IMatrix representing the sum of this matrix and the other matrix
     * @throws IllegalArgumentException if matrices have incompatible dimensions
     * @throws NullPointerException if other is null
     */
    IMatrix add(IMatrix other);

    /**
     * Performs matrix subtraction with another matrix.
     * Both matrices must have the same dimensions.
     * 
     * @param other the matrix to subtract from this matrix
     * @return a new IMatrix representing the difference of this matrix and the other matrix
     * @throws IllegalArgumentException if matrices have incompatible dimensions
     * @throws NullPointerException if other is null
     */
    IMatrix subtract(IMatrix other);

    /**
     * Performs scalar multiplication with an integer value.
     * Each element of the matrix is multiplied by the scalar.
     * 
     * @param scalar the integer scalar to multiply by
     * @return a new IMatrix with all elements multiplied by the scalar
     */
    IMatrix multiply(int scalar);

    /**
     * Performs scalar multiplication with a long value.
     * Each element of the matrix is multiplied by the scalar.
     * 
     * @param scalar the long scalar to multiply by
     * @return a new IMatrix with all elements multiplied by the scalar
     */
    IMatrix multiply(long scalar);

    /**
     * Performs scalar multiplication with a float value.
     * Each element of the matrix is multiplied by the scalar.
     * 
     * @param scalar the float scalar to multiply by
     * @return a new IMatrix with all elements multiplied by the scalar
     */
    IMatrix multiply(float scalar);

    /**
     * Performs scalar multiplication with a double value.
     * Each element of the matrix is multiplied by the scalar.
     * 
     * @param scalar the double scalar to multiply by
     * @return a new IMatrix with all elements multiplied by the scalar
     */
    IMatrix multiply(double scalar);

    /**
     * Performs matrix multiplication with another matrix.
     * Computes C<sub>m×k</sub> = A<sub>m×n</sub> × B<sub>n×k</sub>, where A is this matrix.
     * The number of columns in this matrix must equal the number of rows in the other matrix.
     * 
     * @param other the matrix B<sub>n×k</sub> to multiply with this matrix
     * @return a new IMatrix representing the product C<sub>m×k</sub>
     * @throws IllegalArgumentException if matrices have incompatible dimensions for multiplication
     * @throws NullPointerException if other is null
     */
    IMatrix multiply(IMatrix other);
}