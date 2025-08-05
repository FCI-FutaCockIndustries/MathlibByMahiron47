package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IMatrix;

/**
 * A 2x2 matrix with double elements.
 * <pre>
 * <p>The matrix is represented as:
 * | a11  a12 |
 * | a21  a22 |
 * </pre>
 */
public class Mat2d implements IMatrix {
    private double a11, a12;
    private double a21, a22;

    /**
     * Creates a new 2x2 double matrix with specified elements.
     * 
     * @param a11 element at position (0,0)
     * @param a12 element at position (0,1)
     * @param a21 element at position (1,0)
     * @param a22 element at position (1,1)
     */
    public Mat2d(double a11, double a12, double a21, double a22) {
        this.a11 = a11; this.a12 = a12;
        this.a21 = a21; this.a22 = a22;
    }

    public Mat2d(double[] elements) {
        assert elements.length == 4 : "Array must contain exactly 4 elements for a 2x2 matrix";

        this.a11 = elements[0]; this.a12 = elements[1];
        this.a21 = elements[2]; this.a22 = elements[3];
    }

    @Override
    public byte getType() {
        return ITensor.TYPE_DOUBLE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof IMatrix)) return false;
        
        IMatrix mat = (IMatrix) obj;
        
        return Double.compare(a11, mat.getd(0, 0)) == 0 && Double.compare(a12, mat.getd(0, 1)) == 0 && 
               Double.compare(a21, mat.getd(1, 0)) == 0 && Double.compare(a22, mat.getd(1, 1)) == 0;
    }
    
    @Override
    public int hashCode() {
        int result = Double.hashCode(a11);
        result = 31 * result + Double.hashCode(a12);
        result = 31 * result + Double.hashCode(a21);
        result = 31 * result + Double.hashCode(a22);
        return result;
    }
    
    @Override
    public String toString() {
        return String.format("Mat2d[\n  [%.6f, %.6f]\n  [%.6f, %.6f]\n]", 
            a11, a12, 
            a21, a22
        );
    }

    @Override
    public int geti(int i, int j) {
        switch ((i << 1) | j) {
            case 0: return (int) a11;
            case 1: return (int) a12;
            case 2: return (int) a21;
            case 3: return (int) a22;
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
            case 0: return a11;
            case 1: return a12;
            case 2: return a21;
            case 3: return a22;
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for 2x2 matrix");
        }
    }

    @Override
    public void set(int i, int j, int a_ij) {
        set(i, j, (double) a_ij);
    }

    @Override
    public void set(int i, int j, long a_ij) {
        set(i, j, (double) a_ij);
    }

    @Override
    public void set(int i, int j, float a_ij) {
        set(i, j, (double) a_ij);
    }

    @Override
    public void set(int i, int j, double a_ij) {
        switch ((i << 1) | j) {
            case 0: a11 = a_ij; break;
            case 1: a12 = a_ij; break;
            case 2: a21 = a_ij; break;
            case 3: a22 = a_ij; break;
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for 2x2 matrix");
        }
    }

    @Override
    public int[] getDimensions() {
        return new int[]{2, 2};
    }

    @Override
    public Mat2d copy() {
        return new Mat2d(a11, a12, a21, a22);
    }

    @Override
    public Vec2d convert(int i) {
        switch (i) {
            case 0: return new Vec2d(a11, a21);
            case 1: return new Vec2d(a12, a22);
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Mat2d");
        }
    }

    @Override
    public Mat2d getTranspose() {
        return new Mat2d(a11, a21, a12, a22);
    }

    @Override
    public int deti() {
        return (int) (a11 * a22 - a12 * a21);
    }

    @Override
    public long detl() {
        return (long) (a11 * a22 - a12 * a21);
    }

    @Override
    public float detf() {
        return (float) (a11 * a22 - a12 * a21);
    }

    @Override
    public double detd() {
        return a11 * a22 - a12 * a21;
    }

    @Override
    public Mat2d add(IMatrix other) {
        return new Mat2d(
            this.a11 + other.getd(0, 0), this.a12 + other.getd(0, 1),
            this.a21 + other.getd(1, 0), this.a22 + other.getd(1, 1)
        );
    }

    @Override
    public Mat2d subtract(IMatrix other) {
        return new Mat2d(
            this.a11 - other.getd(0, 0), this.a12 - other.getd(0, 1),
            this.a21 - other.getd(1, 0), this.a22 - other.getd(1, 1)
        );
    }

    @Override
    public Mat2d multiply(int scalar) {
        return new Mat2d(
            this.a11 * scalar, this.a12 * scalar,
            this.a21 * scalar, this.a22 * scalar
        );
    }

    @Override
    public Mat2d multiply(long scalar) {
        return new Mat2d(
            this.a11 * scalar, this.a12 * scalar,
            this.a21 * scalar, this.a22 * scalar
        );
    }

    @Override
    public Mat2d multiply(float scalar) {
        return new Mat2d(
            this.a11 * scalar, this.a12 * scalar,
            this.a21 * scalar, this.a22 * scalar
        );
    }

    @Override
    public Mat2d multiply(double scalar) {
        return new Mat2d(
            this.a11 * scalar, this.a12 * scalar,
            this.a21 * scalar, this.a22 * scalar
        );
    }

    @Override
    public IMatrix multiply(IMatrix other) {
        assert other != null : "Mat2d: multiply: Other matrix cannot be null";
        assert other.getDimensions()[0] == 2 : "Mat2d: multiply: Other matrix must have 2 rows";

        int k = other.getDimensions()[1];

        switch (k) {
        case 1:
            return new Mat(new double[][] {
                {this.a11 * other.getd(0, 0) + this.a12 * other.getd(1, 0)},
                {this.a21 * other.getd(0, 0) + this.a22 * other.getd(1, 0)}
            }, ITensor.TYPE_DOUBLE);
        case 2:
            return new Mat2d(
                this.a11 * other.getd(0, 0) + this.a12 * other.getd(1, 0), this.a11 * other.getd(0, 1) + this.a12 * other.getd(1, 1),
                this.a21 * other.getd(0, 0) + this.a22 * other.getd(1, 0), this.a21 * other.getd(0, 1) + this.a22 * other.getd(1, 1)
            );
        default:
            double[][] result = new double[2][k];

            for (int j = 0; j < k; j++) {
                result[0][j] = this.a11 * other.getd(0, j) + this.a12 * other.getd(1, j);
                result[1][j] = this.a21 * other.getd(0, j) + this.a22 * other.getd(1, j);
            }

            return new Mat(result, ITensor.TYPE_DOUBLE);
        }
    }
}
