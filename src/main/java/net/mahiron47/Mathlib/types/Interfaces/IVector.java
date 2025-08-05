package net.mahiron47.mathlib.types.interfaces;

public interface IVector extends ITensor {
    /**
     * Gets the value at the specified index in the vector as an integer.
     * 
     * @param i the index (0-based)
     * @return the value at the specified index cast to int
     * @throws IndexOutOfBoundsException if index is negative or greater than or equal to vector dimension
     */
    int geti(int i);

    /**
     * Gets the value at the specified index in the vector as a long.
     * 
     * @param i the index (0-based)
     * @return the value at the specified index cast to long
     * @throws IndexOutOfBoundsException if index is negative or greater than or equal to vector dimension
     */
    long getl(int i);

    /**
     * Gets the value at the specified index in the vector as a float.
     * 
     * @param i the index (0-based)
     * @return the value at the specified index cast to float
     * @throws IndexOutOfBoundsException if index is negative or greater than or equal to vector dimension
     */
    float getf(int i);

    /**
     * Gets the value at the specified index in the vector as a double.
     * 
     * @param i the index (0-based)
     * @return the value at the specified index cast to double
     * @throws IndexOutOfBoundsException if index is negative or greater than or equal to vector dimension
     */
    double getd(int i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index (0-based)
     * @param a_i the integer value to set at the specified index
     * @throws IndexOutOfBoundsException if index is negative or greater than or equal to vector dimension
     */
    void set(int i, int a_i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index (0-based)
     * @param a_i the long value to set at the specified index
     * @throws IndexOutOfBoundsException if index is negative or greater than or equal to vector dimension
     */
    void set(int i, long a_i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index (0-based)
     * @param a_i the float value to set at the specified index
     * @throws IndexOutOfBoundsException if index is negative or greater than or equal to vector dimension
     */
    void set(int i, float a_i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index (0-based)
     * @param a_i the double value to set at the specified index
     * @throws IndexOutOfBoundsException if index is negative or greater than or equal to vector dimension
     */
    void set(int i, double a_i);

    /**
     * Gets the dimension (size) of the vector.
     * 
     * @return the number of elements in the vector
     */
    int getDimension();

    /**
     * Creates a deep copy of this vector.
     * 
     * @return a new IVector instance that is an independent copy of this vector
     */
    IVector copy();

    /**
     * Converts this vector to matrix form as a column vector.
     * Creates an n×1 matrix where n is the dimension of this vector.
     * 
     * @return a new IMatrix representing this vector as a column matrix
     */
    IMatrix convert();

    /**
     * Calculates the Euclidean length (magnitude) of the vector.
     * Computes ||v|| = √(v₁² + v₂² + ... + vₙ²).
     * 
     * @return the length of the vector as a double
     */
    double getLength();

    /**
     * Creates a normalized (unit) vector with the same direction as this vector.
     * The resulting vector has a length of 1.0. If this vector is a zero vector,
     * the behavior is implementation-dependent.
     * 
     * @return a new IVector representing the normalized vector
     * @throws ArithmeticException if the vector has zero length and cannot be normalized
     */
    IVector getNormal();

    /**
     * Performs vector addition with another vector.
     * Both vectors must have the same dimension.
     * Computes result[i] = this[i] + other[i] for all valid indices.
     * 
     * @param other the vector to add to this vector
     * @return a new IVector representing the sum of this vector and the other vector
     * @throws IllegalArgumentException if vectors have different dimensions
     * @throws NullPointerException if other is null
     */
    IVector add(IVector other);

    /**
     * Performs vector subtraction with another vector.
     * Both vectors must have the same dimension.
     * Computes result[i] = this[i] - other[i] for all valid indices.
     * 
     * @param other the vector to subtract from this vector
     * @return a new IVector representing the difference of this vector and the other vector
     * @throws IllegalArgumentException if vectors have different dimensions
     * @throws NullPointerException if other is null
     */
    IVector subtract(IVector other);

    /**
     * Performs scalar multiplication with an integer value.
     * Each element of the vector is multiplied by the scalar.
     * 
     * @param scalar the integer scalar to multiply by
     * @return a new IVector with all elements multiplied by the scalar
     */
    IVector multiply(int scalar);

    /**
     * Performs scalar multiplication with a long value.
     * Each element of the vector is multiplied by the scalar.
     * 
     * @param scalar the long scalar to multiply by
     * @return a new IVector with all elements multiplied by the scalar
     */
    IVector multiply(long scalar);

    /**
     * Performs scalar multiplication with a float value.
     * Each element of the vector is multiplied by the scalar.
     * 
     * @param scalar the float scalar to multiply by
     * @return a new IVector with all elements multiplied by the scalar
     */
    IVector multiply(float scalar);

    /**
     * Performs scalar multiplication with a double value.
     * Each element of the vector is multiplied by the scalar.
     * 
     * @param scalar the double scalar to multiply by
     * @return a new IVector with all elements multiplied by the scalar
     */
    IVector multiply(double scalar);

    /**
     * Computes the dot product (scalar product) of this vector and another vector.
     * Both vectors must have the same dimension.
     * Calculates Σ(this[i] * other[i]) for i = 0 to dimension-1.
     * 
     * @param other the vector to compute dot product with
     * @return the dot product as an integer
     * @throws IllegalArgumentException if vectors have different dimensions
     * @throws NullPointerException if other is null
     */
    int doti(IVector other);

    /**
     * Computes the dot product (scalar product) of this vector and another vector.
     * Both vectors must have the same dimension.
     * Calculates Σ(this[i] * other[i]) for i = 0 to dimension-1.
     * 
     * @param other the vector to compute dot product with
     * @return the dot product as a long
     * @throws IllegalArgumentException if vectors have different dimensions
     * @throws NullPointerException if other is null
     */
    long dotl(IVector other);

    /**
     * Computes the dot product (scalar product) of this vector and another vector.
     * Both vectors must have the same dimension.
     * Calculates Σ(this[i] * other[i]) for i = 0 to dimension-1.
     * 
     * @param other the vector to compute dot product with
     * @return the dot product as a float
     * @throws IllegalArgumentException if vectors have different dimensions
     * @throws NullPointerException if other is null
     */
    float dotf(IVector other);

    /**
     * Computes the dot product (scalar product) of this vector and another vector.
     * Both vectors must have the same dimension.
     * Calculates Σ(this[i] * other[i]) for i = 0 to dimension-1.
     * 
     * @param other the vector to compute dot product with
     * @return the dot product as a double
     * @throws IllegalArgumentException if vectors have different dimensions
     * @throws NullPointerException if other is null
     */
    double dotd(IVector other);

    /**
     * Computes the cross product of this vector and another vector.
     * Only valid for 3-dimensional vectors. The cross product produces a vector
     * perpendicular to both input vectors following the right-hand rule.
     * For vectors a = (a₁, a₂, a₃) and b = (b₁, b₂, b₃),
     * the cross product is (a₂b₃ - a₃b₂, a₃b₁ - a₁b₃, a₁b₂ - a₂b₁).
     * 
     * @param other the vector to compute cross product with
     * @return a new IVector representing the cross product
     * @throws IllegalArgumentException if either vector is not 3-dimensional
     * @throws NullPointerException if other is null
     */
    IVector cross(IVector other);
}
