package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.IMatrix;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Mat<
    NumT extends Number, 
    VecT extends IVector<NumT, VecT, MatT>,
    MatT extends IMatrix<NumT, VecT, MatT>
> implements IMatrix<NumT, VecT, MatT> {
    private Object[][] data;
    /**
     * The every elements data type :
     * <ul>
     * <li>{@code 0b00} - first type bits</li>
     * <li>{@code 00} - second type bits</li>
     * <li>{@code 00} - third type bits</li>
     * <li>{@code 00} - fourth type bits</li>
     * </ul>
     * The types are defined as follows :
     * <ul>
     * <li>{@code 0b00} - null</li>
     * <li>{@code 0b01} - NumT</li>
     * <li>{@code 0b10} - VecT</li>
     * <li>{@code 0b11} - MatT</li>
     * </ul>
     * null bits is used to indicate end of the data type list
     */
    private byte[][] quadro_data_type;
    /**
     * Type of the matrix :
     * <ul>
     * <li>{@code 0b00000000} - TYPE_NO_TYPE</li>
     * <li>{@code 0b00000001} - TYPE_NUM_MAT</li>
     * <li>{@code 0b00000010} - TYPE_VEC_MAT</li>
     * <li>{@code 0b00000100} - TYPE_MAT_MAT</li>
     * </ul>
     */
    private byte type;

    public Mat(NumT[][] data) {
        assert data != null && data[0] != null && data[1] != null : "Mat:constructor1: data is null or has null elements";
        
        this.data = new Object[data.length][data[0].length];
        this.quadro_data_type = new byte[(data.length + 1) / 2][(data[0].length + 1) / 2]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                assert data[i][j] != null : "Mat:constructor1: data[i][j] is null";
                
                this.data[i][j] = (Object) data[i][j];

                switch ((i * data[0].length + j) % 4) {
                case 0:
                    this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_NUM << 6);
                    break;
                case 1:
                    this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_NUM << 4);
                    break;
                case 2:
                    this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_NUM << 2);
                    break;
                case 3:
                    this.quadro_data_type[i / 4][j / 4] |= IMatrix.TYPE_ELEMENT_NUM;
                    break;
                }
            }
        }
        this.type = IMatrix.TYPE_NUM_MAT;
    }

    public Mat(VecT[][] data) {
        assert data != null && data[0] != null && data[1] != null : "Mat:constructor2: data is null or has null elements";
        
        this.data = new Object[data.length][data[0].length];
        this.quadro_data_type = new byte[(data.length + 1) / 2][(data[0].length)]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                assert data[i][j] != null : "Mat:constructor2: data[i][j] is null";
                
                this.data[i][j] = (Object) data[i][j];

                switch ((i * data[0].length + j) % 4) {
                case 0:
                    this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_VEC << 6);
                    break;
                case 1:
                    this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_VEC << 4);
                    break;
                case 2:
                    this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_VEC << 2);
                    break;
                case 3:
                    this.quadro_data_type[i / 4][j / 4] |= IMatrix.TYPE_ELEMENT_VEC;
                    break;
                }
            }
        }
        this.type = IMatrix.TYPE_VEC_MAT;
    }

    public Mat(MatT[][] data) {
        assert data != null && data[0] != null && data[1] != null : "Mat:constructor3: data is null or has null elements";

        this.data = new Object[data.length][data[0].length];
        this.quadro_data_type = new byte[(data.length + 1) / 2][(data[0].length + 1) / 2]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                assert data[i][j] != null : "Mat:constructor3: data[i][j] is null";
                
                this.data[i][j] = (Object) data[i][j];

                switch ((i * data[0].length + j) % 4) {
                case 0:
                    this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_MAT << 6);
                    break;
                case 1:
                    this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_MAT << 4);
                    break;
                case 2:
                    this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_MAT << 2);
                    break;
                case 3:
                    this.quadro_data_type[i / 4][j / 4] |= IMatrix.TYPE_ELEMENT_MAT;
                    break;
                }
            }
        }
        this.type = IMatrix.TYPE_MAT_MAT;
    }

    public Mat(Object[][] data) {
        this(data, null, IMatrix.TYPE_NO_TYPE);
    }

    public Mat(Object[][] data, byte[][] quadro_data_type, byte type) {
        assert data != null && data[0] != null && data[1] != null : "Mat:constructor5";

        this.data = data;
        
        if (type == IMatrix.TYPE_NO_TYPE || quadro_data_type == null) {
            setProperlyType();
        } else {
            this.quadro_data_type = quadro_data_type;
            this.type = type;
        }
    }

    private void setProperlyType() {
        this.quadro_data_type = new byte[(data.length + 1) / 2][(data.length + 1) / 2]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                assert data[i][j] != null : "Mat:setProperlyType: data[i][j] is null";
                assert data[i][j] instanceof Number || data[i][j] instanceof IVector || data[i][j] instanceof IMatrix : 
                    "Mat:setProperlyType: data[i][j] is not a Number, IVector or IMatrix";

                byte flag = IMatrix.TYPE_ELEMENT_END; // null type
                if (data[i][j] instanceof Number) {
                    flag = IMatrix.TYPE_ELEMENT_NUM;
                    this.type |= IMatrix.TYPE_NUM_MAT;
                } else if (data[i][j] instanceof IVector) {
                    flag = IMatrix.TYPE_ELEMENT_VEC;
                    this.type |= IMatrix.TYPE_VEC_MAT;
                } else if (data[i][j] instanceof IMatrix) {
                    flag = IMatrix.TYPE_ELEMENT_MAT;
                    this.type |= IMatrix.TYPE_MAT_MAT;
                }

                switch ((i * data[0].length + j) % 4) {
                case 0:
                    this.quadro_data_type[i / 4][j / 4] |= (flag << 6);
                    break;
                case 1:
                    this.quadro_data_type[i / 4][j / 4] |= (flag << 4);
                    break;
                case 2:
                    this.quadro_data_type[i / 4][j / 4] |= (flag << 2);
                    break;
                case 3:
                    this.quadro_data_type[i / 4][j / 4] |= flag;
                    break;
                }
            }
        }
    }

    @Override
    public Object get(int i, int j) {
        assert i >= 0 && i < data.length && j >= 0 && j < data[i].length : "Mat:get: i or j is out of bounds";
        
        return this.data[i][j];
    }

    @Override
    public void set(int i, int j, NumT a_ij) {
        assert i >= 0 && i < data.length && j >= 0 && j < data[i].length : "Mat:set: i or j is out of bounds";
        assert a_ij != null : "Mat:set: a_ij is null";
        
        this.data[i][j] = a_ij;

        switch ((i * data[0].length + j) % 4) {
        case 0:
            this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_NUM << 6);
            break;
        case 1:
            this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_NUM << 4);
            break;
        case 2:
            this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_NUM << 2);
            break;
        case 3:
            this.quadro_data_type[i / 4][j / 4] |= IMatrix.TYPE_ELEMENT_NUM;
            break;
        }

        this.type |= IMatrix.TYPE_NUM_MAT;
    }

    @Override
    public void set(int i, int j, VecT a_ij) {
        assert i >= 0 && i < data.length && j >= 0 && j < data[i].length : "Mat:set: i or j is out of bounds";
        assert a_ij != null : "Mat:set: a_ij is null";

        this.data[i][j] = a_ij;

        switch ((i * data[0].length + j) % 4) {
        case 0:
            this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_VEC << 6);
            break;
        case 1:
            this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_VEC << 4);
            break;
        case 2:
            this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_VEC << 2);
            break;
        case 3:
            this.quadro_data_type[i / 4][j / 4] |= IMatrix.TYPE_ELEMENT_VEC;
            break;
        }

        this.type |= IMatrix.TYPE_VEC_MAT;
    }

    @Override
    public void set(int i, int j, MatT a_ij) {
        assert i >= 0 && i < data.length && j >= 0 && j < data[i].length : "Mat:set: i or j is out of bounds";
        assert a_ij != null : "Mat:set: a_ij is null";
        
        this.data[i][j] = a_ij;

        switch ((i * data[0].length + j) % 4) {
        case 0:
            this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_MAT << 6);
            break;
        case 1:
            this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_MAT << 4);
            break;
        case 2:
            this.quadro_data_type[i / 4][j / 4] |= (IMatrix.TYPE_ELEMENT_MAT << 2);
            break;
        case 3:
            this.quadro_data_type[i / 4][j / 4] |= IMatrix.TYPE_ELEMENT_MAT;
            break;
        }

        this.type |= IMatrix.TYPE_MAT_MAT;
    }

    @Override
    public int[] getDimensions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDimensions'");
    }

    @Override
    public IMatrix<NumT, VecT, MatT> copy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copy'");
    }

    @Override
    public IVector<NumT, VecT, MatT> convert(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convert'");
    }

    @Override
    public IMatrix<NumT, VecT, MatT> getTranspose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTranspose'");
    }

    @Override
    public double getLength() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLength'");
    }

    @Override
    public Mat<Number, VecT, MatT> getNormal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNormal'");
    }

    @Override
    public NumT getDeterminant() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeterminant'");
    }

    @Override
    public IMatrix<NumT, VecT, MatT> add(IMatrix<NumT, VecT, MatT> other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public IMatrix<NumT, VecT, MatT> subtract(IMatrix<NumT, VecT, MatT> other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subtract'");
    }

    @Override
    public IMatrix<NumT, VecT, MatT> multiply(NumT scalar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multiply'");
    }

    @Override
    public IMatrix<NumT, VecT, MatT> multiply(IMatrix<NumT, VecT, MatT> other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multiply'");
    }
}
