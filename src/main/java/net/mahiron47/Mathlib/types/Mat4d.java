package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IMatrix;
import net.mahiron47.mathlib.types.interfaces.IVector;

/**
 * Represents a 4x4 matrix of double values with comprehensive mathematical operations.
 * 
 * <pre>
 * The matrix is represented in order as:</p>
 * | a11  a12  a13  a14 |
 * | a21  a22  a23  a24 |
 * | a31  a32  a33  a34 |
 * | a41  a42  a43  a44 |
 * </pre>
 */
public class Mat4d implements IMatrix {
    private double a11, a12, a13, a14;
    private double a21, a22, a23, a24;
    private double a31, a32, a33, a34;
    private double a41, a42, a43, a44;
    
    public Mat4d(
        double a11, double a12, double a13, double a14,
        double a21, double a22, double a23, double a24,
        double a31, double a32, double a33, double a34,
        double a41, double a42, double a43, double a44
    ) {
        this.a11 = a11; this.a12 = a12; this.a13 = a13; this.a14 = a14;
        this.a21 = a21; this.a22 = a22; this.a23 = a23; this.a24 = a24;
        this.a31 = a31; this.a32 = a32; this.a33 = a33; this.a34 = a34;
        this.a41 = a41; this.a42 = a42; this.a43 = a43; this.a44 = a44;
    }

    public Mat4d(double[] elements) {
        assert elements.length == 16 : "Mat4d:constructor2: Array must contain exactly 16 elements for a 4x4 matrix";

        this.a11 = elements[0]; this.a12 = elements[1]; this.a13 = elements[2]; this.a14 = elements[3];
        this.a21 = elements[4]; this.a22 = elements[5]; this.a23 = elements[6]; this.a24 = elements[7];
        this.a31 = elements[8]; this.a32 = elements[9]; this.a33 = elements[10]; this.a34 = elements[11];
        this.a41 = elements[12]; this.a42 = elements[13]; this.a43 = elements[14]; this.a44 = elements[15];
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
        
        return Double.compare(a11, mat.getd(0, 0)) == 0 && Double.compare(a12, mat.getd(0, 1)) == 0 && Double.compare(a13, mat.getd(0, 2)) == 0 && Double.compare(a14, mat.getd(0, 3)) == 0 &&
               Double.compare(a21, mat.getd(1, 0)) == 0 && Double.compare(a22, mat.getd(1, 1)) == 0 && Double.compare(a23, mat.getd(1, 2)) == 0 && Double.compare(a24, mat.getd(1, 3)) == 0 &&
               Double.compare(a31, mat.getd(2, 0)) == 0 && Double.compare(a32, mat.getd(2, 1)) == 0 && Double.compare(a33, mat.getd(2, 2)) == 0 && Double.compare(a34, mat.getd(2, 3)) == 0 &&
               Double.compare(a41, mat.getd(3, 0)) == 0 && Double.compare(a42, mat.getd(3, 1)) == 0 && Double.compare(a43, mat.getd(3, 2)) == 0 && Double.compare(a44, mat.getd(3, 3)) == 0;
    }

    @Override
    public int hashCode() {
        long result = Double.doubleToLongBits(a11);
        result = 31 * result + Double.doubleToLongBits(a12);
        result = 31 * result + Double.doubleToLongBits(a13);
        result = 31 * result + Double.doubleToLongBits(a14);
        result = 31 * result + Double.doubleToLongBits(a21);
        result = 31 * result + Double.doubleToLongBits(a22);
        result = 31 * result + Double.doubleToLongBits(a23);
        result = 31 * result + Double.doubleToLongBits(a24);
        result = 31 * result + Double.doubleToLongBits(a31);
        result = 31 * result + Double.doubleToLongBits(a32);
        result = 31 * result + Double.doubleToLongBits(a33);
        result = 31 * result + Double.doubleToLongBits(a34);
        result = 31 * result + Double.doubleToLongBits(a41);
        result = 31 * result + Double.doubleToLongBits(a42);
        result = 31 * result + Double.doubleToLongBits(a43);
        result = 31 * result + Double.doubleToLongBits(a44);
        return (int) result;
    }

    @Override
    public String toString() {
        return String.format("Mat4d[\n  [%.12f, %.12f, %.12f, %.12f]\n  [%.12f, %.12f, %.12f, %.12f]\n  [%.12f, %.12f, %.12f, %.12f]\n  [%.12f, %.12f, %.12f, %.12f]\n]", 
            a11, a12, a13, a14,
            a21, a22, a23, a24,
            a31, a32, a33, a34,
            a41, a42, a43, a44
        );
    }

    @Override
    public int geti(int i, int j) {
        return (int) getd(i, j);
    }

    @Override
    public long getl(int i, int j) {
        return (long) getd(i, j);
    }

    @Override
    public float getf(int i, int j) {
        return (float) getd(i, j);
    }

    @Override
    public double getd(int i, int j) {
        switch ((i * 4) + j) {
            case 0: return a11;
            case 1: return a12;
            case 2: return a13;
            case 3: return a14;
            case 4: return a21;
            case 5: return a22;
            case 6: return a23;
            case 7: return a24;
            case 8: return a31;
            case 9: return a32;
            case 10: return a33;
            case 11: return a34;
            case 12: return a41;
            case 13: return a42;
            case 14: return a43;
            case 15: return a44;
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for Mat4d");
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
        assert i >= 0 && i < 4 : "Mat4d:set: row index out of bounds: " + i;
        assert j >= 0 && j < 4 : "Mat4d:set: column index out of bounds: " + j;
        switch (i) {
        case 0: switch (j) {
                case 0: a11 = a_ij; return;
                case 1: a12 = a_ij; return;
                case 2: a13 = a_ij; return;
                case 3: a14 = a_ij; return;
                }
        case 1: switch (j) {
                case 0: a21 = a_ij; return;
                case 1: a22 = a_ij; return;
                case 2: a23 = a_ij; return;
                case 3: a24 = a_ij; return;
                }
        case 2: switch (j) {
                case 0: a31 = a_ij; return;
                case 1: a32 = a_ij; return;
                case 2: a33 = a_ij; return;
                case 3: a34 = a_ij; return;
                }
        case 3: switch (j) {
                case 0: a41 = a_ij; return;
                case 1: a42 = a_ij; return;
                case 2: a43 = a_ij; return;
                case 3: a44 = a_ij; return;
                }
        }
    }

    @Override
    public int[] getDimensions() {
        return new int[]{4, 4};
    }

    @Override
    public IMatrix copy() {
        return new Mat4d(a11, a12, a13, a14, a21, a22, a23, a24, a31, a32, a33, a34, a41, a42, a43, a44);
    }

    @Override
    public IVector convert(int i) {
        switch (i) {
            case 0: return new Vec4d(a11, a21, a31, a41);
            case 1: return new Vec4d(a12, a22, a32, a42);
            case 2: return new Vec4d(a13, a23, a33, a43);
            case 3: return new Vec4d(a14, a24, a34, a44);
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Mat4d");
        }
    }

    @Override
    public IMatrix getTranspose() {
        return new Mat4d(a11, a21, a31, a41, a12, a22, a32, a42, a13, a23, a33, a43, a14, a24, a34, a44);
    }

    @Override
    public int deti() {
        return (int) detd();
    }

    @Override
    public long detl() {
        return (long) detd();
    }

    @Override
    public float detf() {
        return (float) detd();
    }

    @Override
    public double detd() {
        return a11 * (a22 * (a33 * a44 - a34 * a43) - a23 * (a32 * a44 - a34 * a42) + a24 * (a32 * a43 - a33 * a42))
             - a12 * (a21 * (a33 * a44 - a34 * a43) - a23 * (a31 * a44 - a34 * a41) + a24 * (a31 * a43 - a33 * a41))
             + a13 * (a21 * (a32 * a44 - a34 * a42) - a22 * (a31 * a44 - a34 * a41) + a24 * (a31 * a42 - a32 * a41))
             - a14 * (a21 * (a32 * a43 - a33 * a42) - a22 * (a31 * a43 - a33 * a41) + a23 * (a31 * a42 - a32 * a41));
    }

    @Override
    public Mat4d add(IMatrix other) {
        assert other.getDimensions()[0] == 4 : "Mat4d:add: other matrix must have 4 rows";
        assert other.getDimensions()[1] == 4 : "Mat4d:add: other matrix must have 4 columns";
        
        return new Mat4d(
            this.a11 + other.getd(0, 0), this.a12 + other.getd(0, 1), this.a13 + other.getd(0, 2), this.a14 + other.getd(0, 3),
            this.a21 + other.getd(1, 0), this.a22 + other.getd(1, 1), this.a23 + other.getd(1, 2), this.a24 + other.getd(1, 3),
            this.a31 + other.getd(2, 0), this.a32 + other.getd(2, 1), this.a33 + other.getd(2, 2), this.a34 + other.getd(2, 3),
            this.a41 + other.getd(3, 0), this.a42 + other.getd(3, 1), this.a43 + other.getd(3, 2), this.a44 + other.getd(3, 3)
        );
    }

    @Override
    public Mat4d subtract(IMatrix other) {
        assert other.getDimensions()[0] == 4 : "Mat4d:subtract: other matrix must have 4 rows";
        assert other.getDimensions()[1] == 4 : "Mat4d:subtract: other matrix must have 4 columns";
        
        return new Mat4d(
            this.a11 - other.getd(0, 0), this.a12 - other.getd(0, 1), this.a13 - other.getd(0, 2), this.a14 - other.getd(0, 3),
            this.a21 - other.getd(1, 0), this.a22 - other.getd(1, 1), this.a23 - other.getd(1, 2), this.a24 - other.getd(1, 3),
            this.a31 - other.getd(2, 0), this.a32 - other.getd(2, 1), this.a33 - other.getd(2, 2), this.a34 - other.getd(2, 3),
            this.a41 - other.getd(3, 0), this.a42 - other.getd(3, 1), this.a43 - other.getd(3, 2), this.a44 - other.getd(3, 3)
        );
    }

    @Override
    public Mat4d multiply(int scalar) {
        return new Mat4d(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar, this.a14 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar, this.a24 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar, this.a34 * scalar,
            this.a41 * scalar, this.a42 * scalar, this.a43 * scalar, this.a44 * scalar
        );
    }

    @Override
    public Mat4d multiply(long scalar) {
        return new Mat4d(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar, this.a14 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar, this.a24 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar, this.a34 * scalar,
            this.a41 * scalar, this.a42 * scalar, this.a43 * scalar, this.a44 * scalar
        );
    }

    @Override
    public Mat4d multiply(float scalar) {
        return new Mat4d(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar, this.a14 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar, this.a24 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar, this.a34 * scalar,
            this.a41 * scalar, this.a42 * scalar, this.a43 * scalar, this.a44 * scalar
        );
    }

    @Override
    public Mat4d multiply(double scalar) {
        return new Mat4d(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar, this.a14 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar, this.a24 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar, this.a34 * scalar,
            this.a41 * scalar, this.a42 * scalar, this.a43 * scalar, this.a44 * scalar
        );
    }

    @Override
    public IMatrix multiply(IMatrix other) {
        assert other != null : "Mat4d: multiply: Other matrix cannot be null";
        assert this.getDimensions()[1] == other.getDimensions()[0] : "Mat4d:multiply: Incompatible dimensions for multiplication";
        switch (other.getDimensions()[1]) {
        case 1:
            double[][] result = new double[4][1];
            
            result[0][0] = this.a11 * other.getd(0, 0) + this.a12 * other.getd(1, 0) + this.a13 * other.getd(2, 0) + this.a14 * other.getd(3, 0);
            result[1][0] = this.a21 * other.getd(0, 0) + this.a22 * other.getd(1, 0) + this.a23 * other.getd(2, 0) + this.a24 * other.getd(3, 0);
            result[2][0] = this.a31 * other.getd(0, 0) + this.a32 * other.getd(1, 0) + this.a33 * other.getd(2, 0) + this.a34 * other.getd(3, 0);
            result[3][0] = this.a41 * other.getd(0, 0) + this.a42 * other.getd(1, 0) + this.a43 * other.getd(2, 0) + this.a44 * other.getd(3, 0);
            
            return new Mat(result, ITensor.TYPE_DOUBLE);
        case 4:
            return new Mat4d(
                this.a11 * other.getd(0, 0) + this.a12 * other.getd(1, 0) + this.a13 * other.getd(2, 0) + this.a14 * other.getd(3, 0),
                this.a11 * other.getd(0, 1) + this.a12 * other.getd(1, 1) + this.a13 * other.getd(2, 1) + this.a14 * other.getd(3, 1),
                this.a11 * other.getd(0, 2) + this.a12 * other.getd(1, 2) + this.a13 * other.getd(2, 2) + this.a14 * other.getd(3, 2),
                this.a11 * other.getd(0, 3) + this.a12 * other.getd(1, 3) + this.a13 * other.getd(2, 3) + this.a14 * other.getd(3, 3),
                
                this.a21 * other.getd(0, 0) + this.a22 * other.getd(1, 0) + this.a23 * other.getd(2, 0) + this.a24 * other.getd(3, 0),
                this.a21 * other.getd(0, 1) + this.a22 * other.getd(1, 1) + this.a23 * other.getd(2, 1) + this.a24 * other.getd(3, 1),
                this.a21 * other.getd(0, 2) + this.a22 * other.getd(1, 2) + this.a23 * other.getd(2, 2) + this.a24 * other.getd(3, 2),
                this.a21 * other.getd(0, 3) + this.a22 * other.getd(1, 3) + this.a23 * other.getd(2, 3) + this.a24 * other.getd(3, 3),
                
                this.a31 * other.getd(0, 0) + this.a32 * other.getd(1, 0) + this.a33 * other.getd(2, 0) + this.a34 * other.getd(3, 0),
                this.a31 * other.getd(0, 1) + this.a32 * other.getd(1, 1) + this.a33 * other.getd(2, 1) + this.a34 * other.getd(3, 1),
                this.a31 * other.getd(0, 2) + this.a32 * other.getd(1, 2) + this.a33 * other.getd(2, 2) + this.a34 * other.getd(3, 2),
                this.a31 * other.getd(0, 3) + this.a32 * other.getd(1, 3) + this.a33 * other.getd(2, 3) + this.a34 * other.getd(3, 3),
                
                this.a41 * other.getd(0, 0) + this.a42 * other.getd(1, 0) + this.a43 * other.getd(2, 0) + this.a44 * other.getd(3, 0),
                this.a41 * other.getd(0, 1) + this.a42 * other.getd(1, 1) + this.a43 * other.getd(2, 1) + this.a44 * other.getd(3, 1),
                this.a41 * other.getd(0, 2) + this.a42 * other.getd(1, 2) + this.a43 * other.getd(2, 2) + this.a44 * other.getd(3, 2),
                this.a41 * other.getd(0, 3) + this.a42 * other.getd(1, 3) + this.a43 * other.getd(2, 3) + this.a44 * other.getd(3, 3)
            );
        default:
            throw new IllegalArgumentException("Mat4d:multiply: Unsupported matrix dimensions");
        }
    }
}
