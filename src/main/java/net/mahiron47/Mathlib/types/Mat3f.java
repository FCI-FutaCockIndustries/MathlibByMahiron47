package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IMatrix;
import net.mahiron47.mathlib.types.interfaces.IVector;

/**
 * Represents a 3x3 matrix of float values with comprehensive mathematical operations.
 * 
 * <pre>
 * The matrix is represented in order as:</p>
 * | a11  a12  a13 |
 * | a21  a22  a23 |
 * | a31  a32  a33 |
 * </pre>
 */
public class Mat3f implements IMatrix {
    private float a11, a12, a13;
    private float a21, a22, a23;
    private float a31, a32, a33;
    
    public Mat3f(
        float a11, float a12, float a13, 
        float a21, float a22, float a23, 
        float a31, float a32, float a33
    ) {
        this.a11 = a11; this.a12 = a12; this.a13 = a13;
        this.a21 = a21; this.a22 = a22; this.a23 = a23;
        this.a31 = a31; this.a32 = a32; this.a33 = a33;
    }

    public Mat3f(float[] elements) {
        assert elements.length == 9 : "Mat3f:constructor2: Array must contain exactly 9 elements for a 3x3 matrix";

        this.a11 = elements[0]; this.a12 = elements[1]; this.a13 = elements[2];
        this.a21 = elements[3]; this.a22 = elements[4]; this.a23 = elements[5];
        this.a31 = elements[6]; this.a32 = elements[7]; this.a33 = elements[8];
    }

    @Override
    public byte getType() {
        return ITensor.TYPE_FLOAT;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof IMatrix)) return false;
        IMatrix mat = (IMatrix) obj;
        
        return Float.compare(a11, mat.getf(0, 0)) == 0 && Float.compare(a12, mat.getf(0, 1)) == 0 && Float.compare(a13, mat.getf(0, 2)) == 0 &&
               Float.compare(a21, mat.getf(1, 0)) == 0 && Float.compare(a22, mat.getf(1, 1)) == 0 && Float.compare(a23, mat.getf(1, 2)) == 0 &&
               Float.compare(a31, mat.getf(2, 0)) == 0 && Float.compare(a32, mat.getf(2, 1)) == 0 && Float.compare(a33, mat.getf(2, 2)) == 0;
    }

    @Override
    public int hashCode() {
        int result = Float.floatToIntBits(a11);
        result = 31 * result + Float.floatToIntBits(a12);
        result = 31 * result + Float.floatToIntBits(a13);
        result = 31 * result + Float.floatToIntBits(a21);
        result = 31 * result + Float.floatToIntBits(a22);
        result = 31 * result + Float.floatToIntBits(a23);
        result = 31 * result + Float.floatToIntBits(a31);
        result = 31 * result + Float.floatToIntBits(a32);
        result = 31 * result + Float.floatToIntBits(a33);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Mat3f[\n  [%.6f, %.6f, %.6f]\n  [%.6f, %.6f, %.6f]\n  [%.6f, %.6f, %.6f]\n]", 
            a11, a12, a13, 
            a21, a22, a23, 
            a31, a32, a33
        );
    }

    @Override
    public int geti(int i, int j) {
        return (int) getf(i, j);
    }

    @Override
    public long getl(int i, int j) {
        return (long) getf(i, j);
    }

    @Override
    public float getf(int i, int j) {
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
            default: throw new IndexOutOfBoundsException("Index (" + i + ", " + j + ") is out of bounds for Mat3f");
        }
    }

    @Override
    public double getd(int i, int j) {
        return getf(i, j);
    }

    @Override
    public void set(int i, int j, int a_ij) {
        set(i, j, (float) a_ij);
    }

    @Override
    public void set(int i, int j, long a_ij) {
        set(i, j, (float) a_ij);
    }

    @Override
    public void set(int i, int j, float a_ij) {
        assert i >= 0 && i < 3 : "Mat3f:set: row index out of bounds: " + i;
        assert j >= 0 && j < 3 : "Mat3f:set: column index out of bounds: " + j;
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
    public void set(int i, int j, double a_ij) {
        set(i, j, (float) a_ij);
    }

    @Override
    public int[] getDimensions() {
        return new int[]{3, 3};
    }

    @Override
    public IMatrix copy() {
        return new Mat3f(a11, a12, a13, a21, a22, a23, a31, a32, a33);
    }

    @Override
    public IVector convert(int i) {
        switch (i) {
            case 0: return new Vec3f(a11, a21, a31);
            case 1: return new Vec3f(a12, a22, a32);
            case 2: return new Vec3f(a13, a23, a33);
            default: throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for Mat3f");
        }
    }

    @Override
    public IMatrix getTranspose() {
        return new Mat3f(a11, a21, a31, a12, a22, a32, a13, a23, a33);
    }

    @Override
    public int deti() {
        return (int) detf();
    }

    @Override
    public long detl() {
        return (long) detf();
    }

    @Override
    public float detf() {
        return a11 * (a22 * a33 - a23 * a32) 
             - a12 * (a21 * a33 - a23 * a31) 
             + a13 * (a21 * a32 - a22 * a31);
    }

    @Override
    public double detd() {
        return detf();
    }

    @Override
    public Mat3f add(IMatrix other) {
        assert other.getDimensions()[0] == 3 : "Mat3f:add: other matrix must have 3 rows";
        assert other.getDimensions()[1] == 3 : "Mat3f:add: other matrix must have 3 columns";
        
        return new Mat3f(
            this.a11 + other.getf(0, 0), this.a12 + other.getf(0, 1), this.a13 + other.getf(0, 2),
            this.a21 + other.getf(1, 0), this.a22 + other.getf(1, 1), this.a23 + other.getf(1, 2),
            this.a31 + other.getf(2, 0), this.a32 + other.getf(2, 1), this.a33 + other.getf(2, 2)
        );
    }

    @Override
    public Mat3f subtract(IMatrix other) {
        assert other.getDimensions()[0] == 3 : "Mat3f:subtract: other matrix must have 3 rows";
        assert other.getDimensions()[1] == 3 : "Mat3f:subtract: other matrix must have 3 columns";
        return new Mat3f(
            this.a11 - other.getf(0, 0), this.a12 - other.getf(0, 1), this.a13 - other.getf(0, 2),
            this.a21 - other.getf(1, 0), this.a22 - other.getf(1, 1), this.a23 - other.getf(1, 2),
            this.a31 - other.getf(2, 0), this.a32 - other.getf(2, 1), this.a33 - other.getf(2, 2)
        );
    }

    @Override
    public Mat3f multiply(int scalar) {
        return new Mat3f(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar
        );
    }

    @Override
    public Mat3f multiply(long scalar) {
        return new Mat3f(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar
        );
    }

    @Override
    public Mat3f multiply(float scalar) {
        return new Mat3f(
            this.a11 * scalar, this.a12 * scalar, this.a13 * scalar,
            this.a21 * scalar, this.a22 * scalar, this.a23 * scalar,
            this.a31 * scalar, this.a32 * scalar, this.a33 * scalar
        );
    }

    @Override
    public Mat3f multiply(double scalar) {
        return new Mat3f(
            (float) (this.a11 * scalar), (float) (this.a12 * scalar), (float) (this.a13 * scalar),
            (float) (this.a21 * scalar), (float) (this.a22 * scalar), (float) (this.a23 * scalar),
            (float) (this.a31 * scalar), (float) (this.a32 * scalar), (float) (this.a33 * scalar)
        );
    }

    @Override
    public IMatrix multiply(IMatrix other) {
        assert other != null : "Mat3f: multiply: Other matrix cannot be null";
        assert this.getDimensions()[1] == other.getDimensions()[0] : "Mat3f:multiply: Incompatible dimensions for multiplication";
        switch (other.getDimensions()[1]) {
        case 1:
            float[][] result = new float[3][1];
            
            result[0][0] = this.a11 * other.getf(0, 0) + this.a12 * other.getf(1, 0) + this.a13 * other.getf(2, 0);
            result[1][0] = this.a21 * other.getf(0, 0) + this.a22 * other.getf(1, 0) + this.a23 * other.getf(2, 0);
            result[2][0] = this.a31 * other.getf(0, 0) + this.a32 * other.getf(1, 0) + this.a33 * other.getf(2, 0);
            
            return new Mat(result, ITensor.TYPE_FLOAT);
        case 2:
            float[][] matrixData = new float[3][2];
            
            matrixData[0][0] = this.a11 * other.getf(0, 0) + this.a12 * other.getf(1, 0) + this.a13 * other.getf(2, 0);
            matrixData[0][1] = this.a11 * other.getf(0, 1) + this.a12 * other.getf(1, 1) + this.a13 * other.getf(2, 1);
            
            matrixData[1][0] = this.a21 * other.getf(0, 0) + this.a22 * other.getf(1, 0) + this.a23 * other.getf(2, 0);
            matrixData[1][1] = this.a21 * other.getf(0, 1) + this.a22 * other.getf(1, 1) + this.a23 * other.getf(2, 1);
            
            matrixData[2][0] = this.a31 * other.getf(0, 0) + this.a32 * other.getf(1, 0) + this.a33 * other.getf(2, 0);
            matrixData[2][1] = this.a31 * other.getf(0, 1) + this.a32 * other.getf(1, 1) + this.a33 * other.getf(2, 1);
            
            return new Mat(matrixData, ITensor.TYPE_FLOAT);
        case 3:
            return new Mat3f(
                this.a11 * other.getf(0, 0) + this.a12 * other.getf(1, 0) + this.a13 * other.getf(2, 0),
                this.a11 * other.getf(0, 1) + this.a12 * other.getf(1, 1) + this.a13 * other.getf(2, 1),
                this.a11 * other.getf(0, 2) + this.a12 * other.getf(1, 2) + this.a13 * other.getf(2, 2),
                
                this.a21 * other.getf(0, 0) + this.a22 * other.getf(1, 0) + this.a23 * other.getf(2, 0),
                this.a21 * other.getf(0, 1) + this.a22 * other.getf(1, 1) + this.a23 * other.getf(2, 1),
                this.a21 * other.getf(0, 2) + this.a22 * other.getf(1, 2) + this.a23 * other.getf(2, 2),
                
                this.a31 * other.getf(0, 0) + this.a32 * other.getf(1, 0) + this.a33 * other.getf(2, 0),
                this.a31 * other.getf(0, 1) + this.a32 * other.getf(1, 1) + this.a33 * other.getf(2, 1),
                this.a31 * other.getf(0, 2) + this.a32 * other.getf(1, 2) + this.a33 * other.getf(2, 2)
            );
        default:
            float[][] resultMatrix = new float[3][other.getDimensions()[1]];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < other.getDimensions()[1]; j++) {
                    resultMatrix[i][j] = 0;
                    for (int k = 0; k < 3; k++) {
                        resultMatrix[i][j] += this.getf(i, k) * other.getf(k, j);
                    }
                }
            }
            
            return new Mat(resultMatrix, ITensor.TYPE_FLOAT);
        }
    }
}
