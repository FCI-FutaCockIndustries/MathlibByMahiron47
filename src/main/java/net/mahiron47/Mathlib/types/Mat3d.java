package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IMatrix;
import net.mahiron47.mathlib.types.interfaces.IVector;

/**
 * Represents a 3x3 matrix of double values with comprehensive mathematical operations.
 * 
 * <pre>
 * The matrix is represented in order as:</p>
 * | a11  a12  a13 |
 * | a21  a22  a23 |
 * | a31  a32  a33 |
 * </pre>
 */
public class Mat3d implements IMatrix {
    private double a11, a12, a13;
    private double a21, a22, a23;
    private double a31, a32, a33;
    
    public Mat3d(
        double a11, double a12, double a13, 
        double a21, double a22, double a23, 
        double a31, double a32, double a33
    ) {
        this.a11 = a11; this.a12 = a12; this.a13 = a13;
        this.a21 = a21; this.a22 = a22; this.a23 = a23;
        this.a31 = a31; this.a32 = a32; this.a33 = a33;
    }

    public Mat3d(double[] elements) {
        assert elements.length == 9 : "Mat3d:constructor2: Array must contain exactly 9 elements for a 3x3 matrix";

        this.a11 = elements[0]; this.a12 = elements[1]; this.a13 = elements[2];
        this.a21 = elements[3]; this.a22 = elements[4]; this.a23 = elements[5];
        this.a31 = elements[6]; this.a32 = elements[7]; this.a33 = elements[8];
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
        
        return Double.compare(a11, mat.getd(0, 0)) == 0 && Double.compare(a12, mat.getd(0, 1)) == 0 && Double.compare(a13, mat.getd(0, 2)) == 0 &&
               Double.compare(a21, mat.getd(1, 0)) == 0 && Double.compare(a22, mat.getd(1, 1)) == 0 && Double.compare(a23, mat.getd(1, 2)) == 0 &&
               Double.compare(a31, mat.getd(2, 0)) == 0 && Double.compare(a32, mat.getd(2, 1)) == 0 && Double.compare(a33, mat.getd(2, 2)) == 0;
    }

    @Override
    public int hashCode() {
        long result = Double.doubleToLongBits(a11);
        result = 31 * result + Double.doubleToLongBits(a12);
        result = 31 * result + Double.doubleToLongBits(a13);
        result = 31 * result + Double.doubleToLongBits(a21);
        result = 31 * result + Double.doubleToLongBits(a22);
        result = 31 * result + Double.doubleToLongBits(a23);
        result = 31 * result + Double.doubleToLongBits(a31);
        result = 31 * result + Double.doubleToLongBits(a32);
        result = 31 * result + Double.doubleToLongBits(a33);
        return (int) result;
    }

    @Override
    public String toString() {
        return String.format("Mat3d[\n  [%.12f, %.12f, %.12f]\n  [%.12f, %.12f, %.12f]\n  [%.12f, %.12f, %.12f]\n]", 
            a11, a12, a13, 
            a21, a22, a23, 
            a31, a32, a33
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
        switch ((i * 3) + j) {
            case 0: return a11;
            case 1: return a12;
            case 2: return a13;
            case 3: return a21;
            case 4: return a22;
            case 5: return a23;
            case 6: return a31;
            case 7: return a32;
            case 8: return a33;
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for Mat3d");
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
        assert i >= 0 && i < 3 : "Mat3d:set: row index out of bounds: " + i;
        assert j >= 0 && j < 3 : "Mat3d:set: column index out of bounds: " + j;
        switch (i) {
        case 0: switch (j) {
                case 0: a11 = a_ij; return;
                case 1: a12 = a_ij; return;
                case 2: a13 = a_ij; return;
                }
        case 1: switch (j) {
                case 0: a21 = a_ij; return;
                case 1: a22 = a_ij; return;
                case 2: a23 = a_ij; return;
                }
        case 2: switch (j) {
                case 0: a31 = a_ij; return;
                case 1: a32 = a_ij; return;
                case 2: a33 = a_ij; return;
                }
        }
    }

    @Override
    public int[] getDimensions() {
        return new int[]{3, 3};
    }

    @Override
    public IMatrix copy() {
        return new Mat3d(a11, a12, a13, a21, a22, a23, a31, a32, a33);
    }

    @Override
    public IVector convert(int i) {
        switch (i) {
            case 0: return new Vec3d(a11, a21, a31);
            case 1: return new Vec3d(a12, a22, a32);
            case 2: return new Vec3d(a13, a23, a33);
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Mat3d");
        }
    }

    @Override
    public IMatrix getTranspose() {
        return new Mat3d(a11, a21, a31, a12, a22, a32, a13, a23, a33);
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
        return a11 * (a22 * a33 - a23 * a32) 
             - a12 * (a21 * a33 - a23 * a31) 
             + a13 * (a21 * a32 - a22 * a31);
    }

    @Override
    public Mat3d add(IMatrix other) {
        assert other.getDimensions()[0] == 3 : "Mat3d:add: other matrix must have 3 rows";
        assert other.getDimensions()[1] == 3 : "Mat3d:add: other matrix must have 3 columns";
        
        return new Mat3d(
            this.a11 + other.getd(0, 0), this.a12 + other.getd(0, 1), this.a13 + other.getd(0, 2),
            this.a21 + other.getd(1, 0), this.a22 + other.getd(1, 1), this.a23 + other.getd(1, 2),
            this.a31 + other.getd(2, 0), this.a32 + other.getd(2, 1), this.a33 + other.getd(2, 2)
        );
    }

    @Override
    public Mat3d subtract(IMatrix other) {
        assert other.getDimensions()[0] == 3 : "Mat3d:subtract: other matrix must have 3 rows";
        assert other.getDimensions()[1] == 3 : "Mat3d:subtract: other matrix must have 3 columns";
        
        return new Mat3d(
            this.a11 - other.getd(0, 0), this.a12 - other.getd(0, 1), this.a13 - other.getd(0, 2),
            this.a21 - other.getd(1, 0), this.a22 - other.getd(1, 1), this.a23 - other.getd(1, 2),
            this.a31 - other.getd(2, 0), this.a32 - other.getd(2, 1), this.a33 - other.getd(2, 2)
        );
    }

    @Override
    public Mat3d multiply(int scalar) {
        return new Mat3d(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar
        );
    }

    @Override
    public Mat3d multiply(long scalar) {
        return new Mat3d(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar
        );
    }

    @Override
    public Mat3d multiply(float scalar) {
        return new Mat3d(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar
        );
    }

    @Override
    public Mat3d multiply(double scalar) {
        return new Mat3d(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar
        );
    }

    @Override
    public IMatrix multiply(IMatrix other) {
        assert other != null : "Mat3d: multiply: Other matrix cannot be null";
        assert this.getDimensions()[1] == other.getDimensions()[0] : "Mat3d:multiply: Incompatible dimensions for multiplication";
        switch (other.getDimensions()[1]) {
        case 1:
            double[][] result = new double[3][1];
            
            result[0][0] = this.a11 * other.getd(0, 0) + this.a12 * other.getd(1, 0) + this.a13 * other.getd(2, 0);
            result[1][0] = this.a21 * other.getd(0, 0) + this.a22 * other.getd(1, 0) + this.a23 * other.getd(2, 0);
            result[2][0] = this.a31 * other.getd(0, 0) + this.a32 * other.getd(1, 0) + this.a33 * other.getd(2, 0);
            
            return new Mat(result, ITensor.TYPE_DOUBLE);
        case 2:
            double[][] matrixData = new double[3][2];
            
            matrixData[0][0] = this.a11 * other.getd(0, 0) + this.a12 * other.getd(1, 0) + this.a13 * other.getd(2, 0);
            matrixData[0][1] = this.a11 * other.getd(0, 1) + this.a12 * other.getd(1, 1) + this.a13 * other.getd(2, 1);
            
            matrixData[1][0] = this.a21 * other.getd(0, 0) + this.a22 * other.getd(1, 0) + this.a23 * other.getd(2, 0);
            matrixData[1][1] = this.a21 * other.getd(0, 1) + this.a22 * other.getd(1, 1) + this.a23 * other.getd(2, 1);
            
            matrixData[2][0] = this.a31 * other.getd(0, 0) + this.a32 * other.getd(1, 0) + this.a33 * other.getd(2, 0);
            matrixData[2][1] = this.a31 * other.getd(0, 1) + this.a32 * other.getd(1, 1) + this.a33 * other.getd(2, 1);
            
            return new Mat(matrixData, ITensor.TYPE_DOUBLE);
        case 3:
            return new Mat3d(
                this.a11 * other.getd(0, 0) + this.a12 * other.getd(1, 0) + this.a13 * other.getd(2, 0),
                this.a11 * other.getd(0, 1) + this.a12 * other.getd(1, 1) + this.a13 * other.getd(2, 1),
                this.a11 * other.getd(0, 2) + this.a12 * other.getd(1, 2) + this.a13 * other.getd(2, 2),
                
                this.a21 * other.getd(0, 0) + this.a22 * other.getd(1, 0) + this.a23 * other.getd(2, 0),
                this.a21 * other.getd(0, 1) + this.a22 * other.getd(1, 1) + this.a23 * other.getd(2, 1),
                this.a21 * other.getd(0, 2) + this.a22 * other.getd(1, 2) + this.a23 * other.getd(2, 2),
                
                this.a31 * other.getd(0, 0) + this.a32 * other.getd(1, 0) + this.a33 * other.getd(2, 0),
                this.a31 * other.getd(0, 1) + this.a32 * other.getd(1, 1) + this.a33 * other.getd(2, 1),
                this.a31 * other.getd(0, 2) + this.a32 * other.getd(1, 2) + this.a33 * other.getd(2, 2)
            );
        default:
            throw new IllegalArgumentException("Mat3d:multiply: Unsupported matrix dimensions");
        }
    }
}
