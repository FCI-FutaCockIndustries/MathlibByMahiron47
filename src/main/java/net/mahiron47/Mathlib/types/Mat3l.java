package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IMatrix;
import net.mahiron47.mathlib.types.interfaces.IVector;

/**
 * Represents a 3x3 matrix of long integers with comprehensive mathematical operations.
 * 
 * <pre>
 * The matrix is represented in order as:</p>
 * | a11  a12  a13 |
 * | a21  a22  a23 |
 * | a31  a32  a33 |
 * </pre>
 */
public class Mat3l implements IMatrix {
    private long a11, a12, a13;
    private long a21, a22, a23;
    private long a31, a32, a33;
    
    public Mat3l(
        long a11, long a12, long a13, 
        long a21, long a22, long a23, 
        long a31, long a32, long a33
    ) {
        this.a11 = a11; this.a12 = a12; this.a13 = a13;
        this.a21 = a21; this.a22 = a22; this.a23 = a23;
        this.a31 = a31; this.a32 = a32; this.a33 = a33;
    }

    public Mat3l(long[] elements) {
        assert elements.length == 9 : "Mat3l:constructor2: Array must contain exactly 9 elements for a 3x3 matrix";

        this.a11 = elements[0]; this.a12 = elements[1]; this.a13 = elements[2];
        this.a21 = elements[3]; this.a22 = elements[4]; this.a23 = elements[5];
        this.a31 = elements[6]; this.a32 = elements[7]; this.a33 = elements[8];
    }

    @Override
    public byte getType() {
        return ITensor.TYPE_LONG;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof IMatrix)) return false;
        IMatrix mat = (IMatrix) obj;
        
        return a11 == mat.getl(0, 0) && a12 == mat.getl(0, 1) && a13 == mat.getl(0, 2) &&
               a21 == mat.getl(1, 0) && a22 == mat.getl(1, 1) && a23 == mat.getl(1, 2) &&
               a31 == mat.getl(2, 0) && a32 == mat.getl(2, 1) && a33 == mat.getl(2, 2);
    }

    @Override
    public int hashCode() {
        long result = a11;
        result = 31 * result + a12;
        result = 31 * result + a13;
        result = 31 * result + a21;
        result = 31 * result + a22;
        result = 31 * result + a23;
        result = 31 * result + a31;
        result = 31 * result + a32;
        result = 31 * result + a33;
        return (int) result;
    }

    @Override
    public String toString() {
        return String.format("Mat3l[\n  [%d, %d, %d]\n  [%d, %d, %d]\n  [%d, %d, %d]\n]", 
            a11, a12, a13, 
            a21, a22, a23, 
            a31, a32, a33
        );
    }

    @Override
    public int geti(int i, int j) {
        return (int) getl(i, j);
    }

    @Override
    public long getl(int i, int j) {
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
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for Mat3l");
        }
    }

    @Override
    public float getf(int i, int j) {
        return getl(i, j);
    }

    @Override
    public double getd(int i, int j) {
        return getl(i, j);
    }

    @Override
    public void set(int i, int j, int a_ij) {
        set(i, j, (long) a_ij);
    }

    @Override
    public void set(int i, int j, long a_ij) {
        assert i >= 0 && i < 3 : "Mat3l:set: row index out of bounds: " + i;
        assert j >= 0 && j < 3 : "Mat3l:set: column index out of bounds: " + j;
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
    public void set(int i, int j, float a_ij) {
        set(i, j, (long) a_ij);
    }

    @Override
    public void set(int i, int j, double a_ij) {
        set(i, j, (long) a_ij);
    }

    @Override
    public int[] getDimensions() {
        return new int[]{3, 3};
    }

    @Override
    public IMatrix copy() {
        return new Mat3l(a11, a12, a13, a21, a22, a23, a31, a32, a33);
    }

    @Override
    public IVector convert(int i) {
        switch (i) {
            case 0: return new Vec3l(a11, a21, a31);
            case 1: return new Vec3l(a12, a22, a32);
            case 2: return new Vec3l(a13, a23, a33);
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Mat3l");
        }
    }

    @Override
    public IMatrix getTranspose() {
        return new Mat3l(a11, a21, a31, a12, a22, a32, a13, a23, a33);
    }

    @Override
    public int deti() {
        return (int) detl();
    }

    @Override
    public long detl() {
        return a11 * (a22 * a33 - a23 * a32) 
             - a12 * (a21 * a33 - a23 * a31) 
             + a13 * (a21 * a32 - a22 * a31);
    }

    @Override
    public float detf() {
        return (float) detl();
    }

    @Override
    public double detd() {
        return (double) detl();
    }

    @Override
    public Mat3l add(IMatrix other) {
        assert other.getDimensions()[0] == 3 : "Mat3l:add: other matrix must have 3 rows";
        assert other.getDimensions()[1] == 3 : "Mat3l:add: other matrix must have 3 columns";
        return new Mat3l(
            this.a11 + other.getl(0, 0), this.a12 + other.getl(0, 1), this.a13 + other.getl(0, 2),
            this.a21 + other.getl(1, 0), this.a22 + other.getl(1, 1), this.a23 + other.getl(1, 2),
            this.a31 + other.getl(2, 0), this.a32 + other.getl(2, 1), this.a33 + other.getl(2, 2)
        );
    }

    @Override
    public Mat3l subtract(IMatrix other) {
        assert other.getDimensions()[0] == 3 : "Mat3l:subtract: other matrix must have 3 rows";
        assert other.getDimensions()[1] == 3 : "Mat3l:subtract: other matrix must have 3 columns";
        return new Mat3l(
            this.a11 - other.getl(0, 0), this.a12 - other.getl(0, 1), this.a13 - other.getl(0, 2),
            this.a21 - other.getl(1, 0), this.a22 - other.getl(1, 1), this.a23 - other.getl(1, 2),
            this.a31 - other.getl(2, 0), this.a32 - other.getl(2, 1), this.a33 - other.getl(2, 2)
        );
    }

    @Override
    public Mat3l multiply(int scalar) {
        return new Mat3l(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar
        );
    }

    @Override
    public Mat3l multiply(long scalar) {
        return new Mat3l(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar
        );
    }

    @Override
    public Mat3l multiply(float scalar) {
        return new Mat3l(
            (long) (this.a11 * scalar), (long) (this.a12 * scalar), (long) (this.a13 * scalar),
            (long) (this.a21 * scalar), (long) (this.a22 * scalar), (long) (this.a23 * scalar),
            (long) (this.a31 * scalar), (long) (this.a32 * scalar), (long) (this.a33 * scalar)
        );
    }

    @Override
    public Mat3l multiply(double scalar) {
        return new Mat3l(
            (long) (this.a11 * scalar), (long) (this.a12 * scalar), (long) (this.a13 * scalar),
            (long) (this.a21 * scalar), (long) (this.a22 * scalar), (long) (this.a23 * scalar),
            (long) (this.a31 * scalar), (long) (this.a32 * scalar), (long) (this.a33 * scalar)
        );
    }

    @Override
    public IMatrix multiply(IMatrix other) {
        assert other != null : "Mat3l: multiply: Other matrix cannot be null";
        assert this.getDimensions()[1] == other.getDimensions()[0] : "Mat3l:multiply: Incompatible dimensions for multiplication";
        switch (other.getDimensions()[1]) {
        case 1:
            long[][] result = new long[3][1];
            
            result[0][0] = this.a11 * other.getl(0, 0) + this.a12 * other.getl(1, 0) + this.a13 * other.getl(2, 0);
            result[1][0] = this.a21 * other.getl(0, 0) + this.a22 * other.getl(1, 0) + this.a23 * other.getl(2, 0);
            result[2][0] = this.a31 * other.getl(0, 0) + this.a32 * other.getl(1, 0) + this.a33 * other.getl(2, 0);
            
            return new Mat(result, ITensor.TYPE_LONG);
        case 2:
            long[][] matrixData = new long[3][2];
            
            matrixData[0][0] = this.a11 * other.getl(0, 0) + this.a12 * other.getl(1, 0) + this.a13 * other.getl(2, 0);
            matrixData[0][1] = this.a11 * other.getl(0, 1) + this.a12 * other.getl(1, 1) + this.a13 * other.getl(2, 1);
            
            matrixData[1][0] = this.a21 * other.getl(0, 0) + this.a22 * other.getl(1, 0) + this.a23 * other.getl(2, 0);
            matrixData[1][1] = this.a21 * other.getl(0, 1) + this.a22 * other.getl(1, 1) + this.a23 * other.getl(2, 1);
            
            matrixData[2][0] = this.a31 * other.getl(0, 0) + this.a32 * other.getl(1, 0) + this.a33 * other.getl(2, 0);
            matrixData[2][1] = this.a31 * other.getl(0, 1) + this.a32 * other.getl(1, 1) + this.a33 * other.getl(2, 1);
            
            return new Mat(matrixData, ITensor.TYPE_LONG);
        case 3:
            return new Mat3l(
                this.a11 * other.getl(0, 0) + this.a12 * other.getl(1, 0) + this.a13 * other.getl(2, 0),
                this.a11 * other.getl(0, 1) + this.a12 * other.getl(1, 1) + this.a13 * other.getl(2, 1),
                this.a11 * other.getl(0, 2) + this.a12 * other.getl(1, 2) + this.a13 * other.getl(2, 2),
                
                this.a21 * other.getl(0, 0) + this.a22 * other.getl(1, 0) + this.a23 * other.getl(2, 0),
                this.a21 * other.getl(0, 1) + this.a22 * other.getl(1, 1) + this.a23 * other.getl(2, 1),
                this.a21 * other.getl(0, 2) + this.a22 * other.getl(1, 2) + this.a23 * other.getl(2, 2),
                
                this.a31 * other.getl(0, 0) + this.a32 * other.getl(1, 0) + this.a33 * other.getl(2, 0),
                this.a31 * other.getl(0, 1) + this.a32 * other.getl(1, 1) + this.a33 * other.getl(2, 1),
                this.a31 * other.getl(0, 2) + this.a32 * other.getl(1, 2) + this.a33 * other.getl(2, 2)
            );
        default:
            long[][] resultMatrix = new long[3][other.getDimensions()[1]];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < other.getDimensions()[1]; j++) {
                    resultMatrix[i][j] = 0;
                    for (int k = 0; k < 3; k++) {
                        resultMatrix[i][j] += this.getl(i, k) * other.getl(k, j);
                    }
                }
            }
            
            return new Mat(resultMatrix, ITensor.TYPE_LONG);
        }
    }
}
