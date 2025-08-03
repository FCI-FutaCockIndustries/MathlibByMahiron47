package net.mahiron47.mathlib.types.interfaces;

public interface IVector extends ITensor {
    /**
     * @param i the index
     * @return the value at the specified index in the vector as a Integer type
     */
    int geti(int i);

    /**
     * @param i the index
     * @return the value at the specified index in the vector as a Long type
     */
    long getl(int i);

    /**
     * @param i the index
     * @return the value at the specified index in the vector as a Float type
     */
    float getf(int i);

    /**
     * @param i the index
     * @return the value at the specified index in the vector as a Double type
     */
    double getd(int i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index
     * @param a_i the value to set
     */
    void set(int i, int a_i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index
     * @param a_i the value to set
     */
    void set(int i, long a_i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index
     * @param a_i the value to set
     */
    void set(int i, float a_i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index
     * @param a_i the value to set
     */
    void set(int i, double a_i);

    /**
     * @return the dimension of the vector, which is the same as the size
     */
    int getDimension();

    /**
     * @return a copy of this vector
     */
    IVector copy();

    /**
     * @return the vector in matrix form
     */
    IMatrix convert();

    /**
     * @return the length of the vector
     */
    double getLength();

    /**
     * @return the normalized vector, which has a length of 1 or vector of other types which is normalized
     */
    IVector getNormal();

    /**
     * @return the sum of two vectors
     */
    IVector add(IVector other);

    /**
     * @return the difference of two vectors
     */
    IVector subtract(IVector other);

    /**
     * @param scalar the scalar to multiply by
     * @return the multiplied by scalar vector
     */
    IVector multiply(int scalar);

    /**
     * @param scalar the scalar to multiply by
     * @return the multiplied by scalar vector
     */
    IVector multiply(long scalar);

    /**
     * @param scalar the scalar to multiply by
     * @return the multiplied by scalar vector
     */
    IVector multiply(float scalar);

    /**
     * @param scalar the scalar to multiply by
     * @return the multiplied by scalar vector
     */
    IVector multiply(double scalar);

    /**
     * @return the dot product of two vectors
     */
    int doti(IVector other);

    /**
     * @return the dot product of two vectors
     */
    long dotl(IVector other);

    /**
     * @return the dot product of two vectors
     */
    float dotf(IVector other);

    /**
     * @return the dot product of two vectors
     */
    double dotd(IVector other);

    /**
     * @return the cross product of two vectors
     */
    IVector cross(IVector other);
}
