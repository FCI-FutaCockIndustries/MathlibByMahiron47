package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IMatrix;

/**
 * A 2x2 matrix with integer elements.
 * <pre>
 * <p>The matrix is represented as:
 * | a11  a12 |
 * | a21  a22 |
 * </pre>
 */
public class Mat2i implements IMatrix {
    private int a11, a12;
    private int a21, a22;

    /**
     * Creates a new 2x2 integer matrix with specified elements.
     * 
     * @param a11 element at position (0,0)
     * @param a12 element at position (0,1)
     * @param a21 element at position (1,0)
     * @param a22 element at position (1,1)
     */
    public Mat2i(int a11, int a12, int a21, int a22) {
        this.a11 = a11; this.a12 = a12;
        this.a21 = a21; this.a22 = a22;
    }

    public Mat2i(int[] elements) {
        assert elements.length == 4 : "Array must contain exactly 4 elements for a 2x2 matrix";

        this.a11 = elements[0]; this.a12 = elements[1];
        this.a21 = elements[2]; this.a22 = elements[3];
    }

    @Override
    public byte getType() {
        return ITensor.TYPE_INT;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof IMatrix)) return false;
        
        IMatrix mat = (IMatrix) obj;
        
        return a11 == mat.geti(0, 0) && a12 == mat.geti(0, 1) && 
               a21 == mat.geti(1, 0) && a22 == mat.geti(1, 1);
    }
    
    @Override
    public int hashCode() {
        int result = a11;
        result = 31 * result + a12;
        result = 31 * result + a21;
        result = 31 * result + a22;
        return result;
    }
    
    @Override
    public String toString() {
        return String.format("Mat2i[\n  [%d, %d]\n  [%d, %d]\n]", 
            a11, a12, 
            a21, a22
        );
    }

    @Override
    public int geti(int i, int j) {
        switch ((i << 1) | j) {
            case 0: return a11;
            case 1: return a12;
            case 2: return a21;
            case 3: return a22;
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for 2x2 matrix");
        }
    }

    @Override
    public long getl(int i, int j) {
        switch ((i << 1) | j) {
            case 0: return (long) a11;
            case 1: return (long) a12;
            case 2: return (long) a21;
            case 3: return (long) a22;
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for 2x2 matrix");
        }
    }

    @Override
    public float getf(int i, int j) {
        switch ((i << 1) | j) {
            case 0: return (float) a11;
            case 1: return (float) a12;
            case 2: return (float) a21;
            case 3: return (float) a22;
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for 2x2 matrix");
        }
    }

    @Override
    public double getd(int i, int j) {
        switch ((i << 1) | j) {
            case 0: return (double) a11;
            case 1: return (double) a12;
            case 2: return (double) a21;
            case 3: return (double) a22;
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for 2x2 matrix");
        }
    }

    @Override
    public void set(int i, int j, int a_ij) {
        switch ((i << 1) | j) {
            case 0: a11 = a_ij; break;
            case 1: a12 = a_ij; break;
            case 2: a21 = a_ij; break;
            case 3: a22 = a_ij; break;
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for 2x2 matrix");
        }
    }

    @Override
    public void set(int i, int j, long a_ij) {
        set(i, j, (int) a_ij);
    }

    @Override
    public void set(int i, int j, float a_ij) {
        set(i, j, (int) a_ij);
    }

    @Override
    public void set(int i, int j, double a_ij) {
        set(i, j, (int) a_ij);
    }

    @Override
    public int[] getDimensions() {
        return new int[]{2, 2};
    }

    @Override
    public Mat2i copy() {
        return new Mat2i(a11, a12, a21, a22);
    }

    @Override
    public Vec2i convert(int i) {
        switch (i) {
            case 0: return new Vec2i(a11, a21);
            case 1: return new Vec2i(a12, a22);
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Mat2i");
        }
    }

    @Override
    public Mat2i getTranspose() {
        return new Mat2i(a11, a21, a12, a22);
    }

    @Override
    public int deti() {
        return a11 * a22 - a12 * a21;
    }

    @Override
    public long detl() {
        return a11 * a22 - a12 * a21;
    }

    @Override
    public float detf() {
        return a11 * a22 - a12 * a21;
    }

    @Override
    public double detd() {
        return a11 * a22 - a12 * a21;
    }

    @Override
    public Mat2i add(IMatrix other) {
        return new Mat2i(
            this.a11 + other.geti(0, 0), this.a12 + other.geti(0, 1),
            this.a21 + other.geti(1, 0), this.a22 + other.geti(1, 1)
        );
    }

    @Override
    public Mat2i subtract(IMatrix other) {
        return new Mat2i(
            this.a11 - other.geti(0, 0), this.a12 - other.geti(0, 1),
            this.a21 - other.geti(1, 0), this.a22 - other.geti(1, 1)
        );
    }

    @Override
    public Mat2i multiply(int scalar) {
        return new Mat2i(
            this.a11 * scalar, this.a12 * scalar,
            this.a21 * scalar, this.a22 * scalar
        );
    }

    @Override
    public Mat2i multiply(long scalar) {
        return new Mat2i(
            (int) (this.a11 * scalar), (int) (this.a12 * scalar),
            (int) (this.a21 * scalar), (int) (this.a22 * scalar)
        );
    }

    @Override
    public Mat2i multiply(float scalar) {
        return new Mat2i(
            (int) (this.a11 * scalar), (int) (this.a12 * scalar),
            (int) (this.a21 * scalar), (int) (this.a22 * scalar)
        );
    }

    @Override
    public Mat2i multiply(double scalar) {
        return new Mat2i(
            (int) (this.a11 * scalar), (int) (this.a12 * scalar),
            (int) (this.a21 * scalar), (int) (this.a22 * scalar)
        );
    }

    @Override
    public IMatrix multiply(IMatrix other) {
        assert other != null : "Mat2i: multiply: Other matrix cannot be null";
        assert other.getDimensions()[0] == 2 : "Mat2i: multiply: Other matrix must have 2 rows";

        int k = other.getDimensions()[1];

        switch (k) {
        case 1:
            return new Mat(new int[][] {
                {this.a11 * other.geti(0, 0) + this.a12 * other.geti(1, 0)},
                {this.a21 * other.geti(0, 0) + this.a22 * other.geti(1, 0)}
            }, ITensor.TYPE_INT);
        case 2:
            return new Mat2i(
                this.a11 * other.geti(0, 0) + this.a12 * other.geti(1, 0), this.a11 * other.geti(0, 1) + this.a12 * other.geti(1, 1),
                this.a21 * other.geti(0, 0) + this.a22 * other.geti(1, 0), this.a21 * other.geti(0, 1) + this.a22 * other.geti(1, 1)
            );
        default:
            int[][] result = new int[2][k];

            for (int j = 0; j < k; j++) {
                result[0][j] = this.a11 * other.geti(0, j) + this.a12 * other.geti(1, j);
                result[1][j] = this.a21 * other.geti(0, j) + this.a22 * other.geti(1, j);
            }

            return new Mat(result, ITensor.TYPE_INT);
        }
    }
}