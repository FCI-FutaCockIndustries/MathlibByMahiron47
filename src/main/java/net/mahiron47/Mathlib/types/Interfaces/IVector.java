package net.mahiron47.mathlib.types.interfaces;

public interface IVector<NumT extends Number,
        VecT extends IVector<NumT, VecT, MatT>,
        MatT extends IMatrix<NumT, VecT, MatT>> {
    static final byte TYPE_NO_TYPE = 0b00000000;
    static final byte TYPE_NUM_VEC = 0b00000001;
    static final byte TYPE_VEC_VEC = 0b00000010;
    static final byte TYPE_MAT_VEC = 0b00000100;
    static final byte TYPE_TRNSPOS = 0b00001000;

    static final byte TYPE_ELEMENT_END = 0b00; //null type
    static final byte TYPE_ELEMENT_NUM = 0b01;
    static final byte TYPE_ELEMENT_VEC = 0b10;
    static final byte TYPE_ELEMENT_MAT = 0b11;

    /**
     * @param i the index
     * @return the value at the specified index in the vector
     */
    Object get(int i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index
     * @param a_i the value to set
     */
    void set(int i, NumT a_i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index
     * @param a_i the value to set
     */
    void set(int i, VecT a_i);

    /**
     * Sets the value at the specified index in the vector.
     *
     * @param i the index
     * @param a_i the value to set
     */
    void set(int i, MatT a_i);

    /**
     * @return the dimension of the vector, which is the same as the size
     */
    int getDimension();

    /**
     * @return a copy of this vector
     */
    IVector<NumT, VecT, MatT> copy();

    /**
     * @return the vector in matrix form
     */
    IMatrix<NumT, VecT, MatT> convert();

    /**
     * @return the column vector from row vector and vice versa
     */
    IVector<NumT, VecT, MatT> getTranspose();

    /**
     * @return the length of the vector
     */
    double getLength();

    /**
     * @return the normalized vector, which has a length of 1 or vector of other types which is normalized
     */
    IVector<Number, VecT, MatT> getNormal();

    /**
     * @return the sum of two vectors
     */
    IVector<NumT, VecT, MatT> add(IVector<NumT, VecT, MatT> other);

    /**
     * @return the difference of two vectors
     */
    IVector<NumT, VecT, MatT> subtract(IVector<NumT, VecT, MatT> other);

    /**
     * @param scalar the scalar to multiply by
     * @return the multiplied by scalar vector
     */
    IVector<NumT, VecT, MatT> multiply(NumT scalar);

    /**
     * @return the dot product of two vectors
     */
    NumT dot(IVector<NumT, VecT, MatT> other);

    /**
     * @return the cross product of two vectors
     */
    IVector<NumT, VecT, MatT> cross(IVector<NumT, VecT, MatT> other);
}
