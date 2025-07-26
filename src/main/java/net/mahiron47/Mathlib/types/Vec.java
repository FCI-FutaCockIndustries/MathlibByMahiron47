package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.IMatrix;
import net.mahiron47.mathlib.types.interfaces.IVector;

public class Vec<
    NumT extends Number, 
    VecT extends IVector<NumT, VecT, MatT>,
    MatT extends IMatrix<NumT, VecT, MatT>
> implements IVector<NumT, VecT, MatT> {
    private Object[] data;
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
    private byte[] quadro_data_type;
    /**
     * Type of the vector :
     * <ul>
     * <li>{@code 0b00000000}: TYPE_NO_TYPE</li>
     * <li>{@code 0b00000001}: TYPE_NUM_VEC</li>
     * <li>{@code 0b00000010}: TYPE_VEC_VEC</li>
     * <li>{@code 0b00000100}: TYPE_MAT_VEC</li>
     * <li>{@code 0b00001000}: TYPE_TRNSPOS</li>
     * </ul>
     */
    private byte type;

    @SuppressWarnings("unchecked")
    public Vec(NumT... data) {
        assert data != null : "Vec:constructor1: data cannot be null";

        this.data = new Object[data.length];
        this.quadro_data_type = new byte[(data.length + 3) / 4]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            assert data[i] != null : "Vec:constructor1: data element cannot be null";
            
            this.data[i] = (Object) data[i];

            switch (i % 4) {
            case 0:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_NUM << 6);
                break;
            case 1:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_NUM << 4);
                break;
            case 2:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_NUM << 2);
                break;
            case 3:
                this.quadro_data_type[i / 4] |= IVector.TYPE_ELEMENT_NUM;
                break;
            }
        }
        this.type = IVector.TYPE_NUM_VEC;
    }

    public Vec(NumT[] data, boolean transposed) {
        assert data != null : "Vec:constructor2: data cannot be null";

        this.data = new Object[data.length];
        this.quadro_data_type = new byte[(data.length + 3) / 4]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            assert data[i] != null : "Vec:constructor2: data element cannot be null";
            
            this.data[i] = (Object) data[i];

            switch (i % 4) {
            case 0:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_NUM << 6);
                break;
            case 1:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_NUM << 4);
                break;
            case 2:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_NUM << 2);
                break;
            case 3:
                this.quadro_data_type[i / 4] |= IVector.TYPE_ELEMENT_NUM;
                break;
            }
        }
        this.type = IVector.TYPE_NUM_VEC;
        if (transposed) {
            this.type |= IVector.TYPE_TRNSPOS;
        }
    }

    @SuppressWarnings("unchecked")
    public Vec(VecT... data) {
        assert data != null : "Vec:constructor3: data cannot be null";

        this.data = new Object[data.length];
        this.quadro_data_type = new byte[(data.length + 3) / 4]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            assert data[i] != null : "Vec:constructor3: data element cannot be null";
            
            this.data[i] = (Object) data[i];

            switch (i % 4) {
            case 0:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_VEC << 6);
                break;
            case 1:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_VEC << 4);
                break;
            case 2:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_VEC << 2);
                break;
            case 3:
                this.quadro_data_type[i / 4] |= IVector.TYPE_ELEMENT_VEC;
                break;
            }
        }
        this.type = IVector.TYPE_VEC_VEC;
    }

    public Vec(VecT[] data, boolean transposed) {
        assert data != null : "Vec:constructor4: data cannot be null";

        this.data = new Object[data.length];
        this.quadro_data_type = new byte[(data.length + 3) / 4]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            assert data[i] != null : "Vec:constructor4: data element cannot be null";
            
            this.data[i] = (Object) data[i];

            switch (i % 4) {
            case 0:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_VEC << 6);
                break;
            case 1:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_VEC << 4);
                break;
            case 2:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_VEC << 2);
                break;
            case 3:
                this.quadro_data_type[i / 4] |= IVector.TYPE_ELEMENT_VEC;
                break;
            }
        }
        this.type = IVector.TYPE_VEC_VEC;
        if (transposed) {
            this.type |= IVector.TYPE_TRNSPOS;
        }
    }

    @SuppressWarnings("unchecked")
    public Vec(MatT... data) {
        assert data != null : "Vec:constructor5: data cannot be null";

        this.data = new Object[data.length];
        this.quadro_data_type = new byte[(data.length + 3) / 4]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            this.data[i] = (Object) data[i];

            assert data[i] != null : "Vec:constructor5: data element cannot be null";

            switch (i % 4) {
            case 0:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_MAT << 6);
                break;
            case 1:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_MAT << 4);
                break;
            case 2:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_MAT << 2);
                break;
            case 3:
                this.quadro_data_type[i / 4] |= IVector.TYPE_ELEMENT_MAT;
                break;
            }
        }
        this.type = IVector.TYPE_MAT_VEC;
    }

    public Vec(MatT[] data, boolean transposed) {
        assert data != null : "Vec:constructor6: data cannot be null";

        this.data = new Object[data.length];
        this.quadro_data_type = new byte[(data.length + 3) / 4]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            this.data[i] = (Object) data[i];

            assert data[i] != null : "Vec:constructor6: data element cannot be null";

            switch (i % 4) {
            case 0:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_MAT << 6);
                break;
            case 1:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_MAT << 4);
                break;
            case 2:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_MAT << 2);
                break;
            case 3:
                this.quadro_data_type[i / 4] |= IVector.TYPE_ELEMENT_MAT;
                break;
            }
        }
        this.type = IVector.TYPE_MAT_VEC;
        if (transposed) {
            this.type |= IVector.TYPE_TRNSPOS;
        }
    }

    public Vec(NumT[] NumD, VecT[] VecD, MatT[] MatD) {
        assert NumD != null || VecD != null || MatD != null : "Vec:constructor7: at least one data array must be non-null";

        int size = NumD.length + VecD.length + MatD.length;
        this.data = new Object[size];
        this.quadro_data_type = new byte[(size + 3) / 4]; // optimization of Math.ceil and float division
        int index = 0;
        if (NumD != null) {
            for (NumT num : NumD) {
                assert num != null : "Vec:constructor7: NumD element cannot be null";
                
                this.data[index++] = (Object) num;

                switch (index % 4) {
                case 0:
                    this.quadro_data_type[index / 4] |= (IVector.TYPE_ELEMENT_NUM << 6);
                    break;
                case 1:
                    this.quadro_data_type[index / 4] |= (IVector.TYPE_ELEMENT_NUM << 4);
                    break;
                case 2:
                    this.quadro_data_type[index / 4] |= (IVector.TYPE_ELEMENT_NUM << 2);
                    break;
                case 3:
                    this.quadro_data_type[index / 4] |= IVector.TYPE_ELEMENT_NUM;
                    break;
                }
            }
            this.type |= IVector.TYPE_NUM_VEC;
        }
        if (VecD != null) {
            for (VecT vec : VecD) {
                assert vec != null : "Vec:constructor7: VecD element cannot be null";
                
                this.data[index++] = (Object) vec;

                switch (index % 4) {
                case 0:
                    this.quadro_data_type[index / 4] |= (IVector.TYPE_ELEMENT_VEC << 6);
                    break;
                case 1:
                    this.quadro_data_type[index / 4] |= (IVector.TYPE_ELEMENT_VEC << 4);
                    break;
                case 2:
                    this.quadro_data_type[index / 4] |= (IVector.TYPE_ELEMENT_VEC << 2);
                    break;
                case 3:
                    this.quadro_data_type[index / 4] |= IVector.TYPE_ELEMENT_VEC;
                    break;
                }
            }
            this.type |= IVector.TYPE_VEC_VEC;
        }
        if (MatD != null) {
            for (MatT mat : MatD) {
                assert mat != null : "Vec:constructor7: MatD element cannot be null";
                
                this.data[index++] = (Object) mat;

                switch (index % 4) {
                case 0:
                    this.quadro_data_type[index / 4] |= (IVector.TYPE_ELEMENT_MAT << 6);
                    break;
                case 1:
                    this.quadro_data_type[index / 4] |= (IVector.TYPE_ELEMENT_MAT << 4);
                    break;
                case 2:
                    this.quadro_data_type[index / 4] |= (IVector.TYPE_ELEMENT_MAT << 2);
                    break;
                case 3:
                    this.quadro_data_type[index / 4] |= IVector.TYPE_ELEMENT_MAT;
                    break;
                }
            }
            this.type |= IVector.TYPE_MAT_VEC;
        }
    }

    public Vec(Object[] data) {
        this(data, null, IVector.TYPE_NO_TYPE);
    }

    public Vec(Object[] data, byte[] quadro_data_type, byte type) {
        assert data != null : "Vec:constructor8: data cannot be null";
        
        this.data = data;
        
        if (type == IVector.TYPE_NO_TYPE || quadro_data_type == null) {
            setProperlyType();
        } else {
            this.quadro_data_type = quadro_data_type;
            this.type = type;
        }
    }

    private void setProperlyType() {
        this.quadro_data_type = new byte[(data.length + 3) / 4]; // optimization of Math.ceil and float division
        for (int i = 0; i < data.length; i++) {
            byte flag = IVector.TYPE_ELEMENT_END; // null type
            if (data[i] instanceof Number) {
                flag = IVector.TYPE_ELEMENT_NUM;
                this.type |= IVector.TYPE_NUM_VEC;
            } else if (data[i] instanceof IVector) {
                flag = IVector.TYPE_ELEMENT_VEC;
                this.type |= IVector.TYPE_VEC_VEC;
            } else if (data[i] instanceof IMatrix) {
                flag = IVector.TYPE_ELEMENT_MAT;
                this.type |= IVector.TYPE_MAT_VEC;
            }
            switch (i % 4) {
            case 0:
                this.quadro_data_type[i / 4] |= (flag << 6);
                break;
            case 1:
                this.quadro_data_type[i / 4] |= (flag << 4);
                break;
            case 2:
                this.quadro_data_type[i / 4] |= (flag << 2);
                break;
            case 3:
                this.quadro_data_type[i / 4] |= flag;
                break;
            }
        }
    }

    @Override
    public Object get(int i) {
        assert i >= 0 && i < data.length : "Vec:get: index out of bounds";

        return this.data[i];
    }

    @Override
    public void set(int i, NumT a_i) {
        assert i >= 0 && i < data.length : "Vec:set: index out of bounds";
        assert a_i != null : "Vec:set: value cannot be null";

        this.data[i] = a_i;

        switch (i % 4) {
            case 0:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_NUM << 6);
                break;
            case 1:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_NUM << 4);
                break;
            case 2:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_NUM << 2);
                break;
            case 3:
                this.quadro_data_type[i / 4] |= IVector.TYPE_ELEMENT_NUM;
                break;
        }

        this.type = IVector.TYPE_NUM_VEC;
    }

    @Override
    public void set(int i, VecT a_i) {
        assert i >= 0 && i < data.length : "Vec:set: index out of bounds";
        assert a_i != null : "Vec:set: value cannot be null";

        this.data[i] = a_i;

        switch (i % 4) {
            case 0:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_VEC << 6);
                break;
            case 1:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_VEC << 4);
                break;
            case 2:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_VEC << 2);
                break;
            case 3:
                this.quadro_data_type[i / 4] |= IVector.TYPE_ELEMENT_VEC;
                break;
        }

        this.type = IVector.TYPE_VEC_VEC;
    }

    @Override
    public void set(int i, MatT a_i) {
        assert i >= 0 && i < data.length : "Vec:set: index out of bounds";
        assert a_i != null : "Vec:set: value cannot be null";

        this.data[i] = a_i;

        switch (i % 4) {
            case 0:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_MAT << 6);
                break;
            case 1:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_MAT << 4);
                break;
            case 2:
                this.quadro_data_type[i / 4] |= (IVector.TYPE_ELEMENT_MAT << 2);
                break;
            case 3:
                this.quadro_data_type[i / 4] |= IVector.TYPE_ELEMENT_MAT;
                break;
        }

        this.type = IVector.TYPE_MAT_VEC;
    }

    @Override
    public int getDimension() {
        return data.length;
    }

    @Override
    public Vec<NumT, VecT, MatT> copy() {
        return (Vec<NumT, VecT, MatT>) new Vec<NumT, VecT, MatT>(
            this.data, 
            this.quadro_data_type, 
            this.type
        );
    }

    @Override
    public IMatrix<NumT, VecT, MatT> convert() {
        Object[][] matrixData;
        byte[][] quadroDataType;
        if (this.type == IVector.TYPE_TRNSPOS) {
            matrixData = new Object[data.length][1];
            quadroDataType = new byte[data.length][1];
            for (int i = 0; i < this.data.length; i++) {
                matrixData[i][0] = this.data[i];
                quadroDataType[i][0] = this.quadro_data_type[i];
            }
        } else {
            matrixData = new Object[1][data.length];
            quadroDataType = new byte[1][data.length];
            for (int i = 0; i < this.data.length; i++) {
                matrixData[0][i] = this.data[i];
                quadroDataType[0][i] = this.quadro_data_type[i];
            }
        }
        return (IMatrix<NumT, VecT, MatT>) new Mat<NumT, VecT, MatT>(
            matrixData, 
            quadroDataType, 
            (byte) (this.type & (IMatrix.TYPE_NUM_MAT | IMatrix.TYPE_VEC_MAT | IMatrix.TYPE_MAT_MAT))
        );
    }

    @Override
    public Vec<NumT, VecT, MatT> getTranspose() {
        return (Vec<NumT, VecT, MatT>) new Vec<NumT, VecT, MatT>(
            this.data, 
            this.quadro_data_type, 
            (byte) (this.type | IVector.TYPE_TRNSPOS)
        );
    }

    @Override
    public double getLength() {
        double length = 0;

        switch (this.type & (IVector.TYPE_NUM_VEC | IVector.TYPE_VEC_VEC | IVector.TYPE_MAT_VEC)) {
        case IVector.TYPE_NO_TYPE:
            setProperlyType();
            return this.getLength(); // recursive call to ensure proper type is set
        case IVector.TYPE_NUM_VEC:
            for (Object value : data) {
                assert value instanceof Number : "Vec:getLength: data type mismatch";

                length += Math.pow(((Number) value).doubleValue(), 2);
            }
            break;
        default:
            throw new UnsupportedOperationException("Vec:getLength - vector of vectors or matrix vector not supported");
        }

        return Math.sqrt(length);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Vec<Number, VecT, MatT> getNormal() {
        Object[] newData = new Object[data.length];
        switch(this.type & (IVector.TYPE_NUM_VEC | IVector.TYPE_VEC_VEC | IVector.TYPE_MAT_VEC)) {
            case IVector.TYPE_NO_TYPE:
                setProperlyType();
                return this.getNormal(); // recursive call to ensure proper type is set
            case IVector.TYPE_NUM_VEC:
                double length = this.getLength();
                
                assert length != 0 : "Vec:getNormal: length cannot be zero";
                
                for (int i = 0; i < data.length; i++) {
                    assert data[i] instanceof Number : "Vec:getNormal: data type mismatch";
                
                    newData[i] = ((Number) data[i]).doubleValue() / length;
                }
                return new Vec<Number, VecT, MatT>(
                    newData, 
                    this.quadro_data_type, 
                    IVector.TYPE_NUM_VEC
                );
            case IVector.TYPE_VEC_VEC:
                for (int i = 0; i < data.length; i++) {
                    assert data[i] instanceof IVector : "Vec:getNormal: data type mismatch";

                    newData[i] = ((IVector<NumT, VecT, MatT>) data[i]).getNormal();    
                }
                return new Vec<Number, VecT, MatT>(
                    newData, 
                    this.quadro_data_type, 
                    IVector.TYPE_VEC_VEC
                );
            case IVector.TYPE_MAT_VEC:
                for (int i = 0; i < data.length; i++) {
                    assert data[i] instanceof IMatrix : "Vec:getNormal: data type mismatch";

                    newData[i] = ((IMatrix<NumT, VecT, MatT>) data[i]).getNormal();    
                }
                return new Vec<Number, VecT, MatT>(
                    newData, 
                    this.quadro_data_type, 
                    IVector.TYPE_MAT_VEC
                );
            default:
                throw new IllegalStateException("Vec:getNormal");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Vec<NumT, VecT, MatT> add(IVector<NumT, VecT, MatT> other) {
        Vec<NumT, VecT, MatT> resVec;
        switch (this.type & (IVector.TYPE_NUM_VEC | IVector.TYPE_VEC_VEC | IVector.TYPE_MAT_VEC)) {
        case IVector.TYPE_NO_TYPE:
            setProperlyType();
            return this.add(other); // recursive call to ensure proper type is set
        case IVector.TYPE_NUM_VEC:
            if (this.getDimension() >= other.getDimension()) {
                resVec = (Vec<NumT, VecT, MatT>) this.copy();
                for (int i = 0; i < other.getDimension(); i++) {
                    assert this.data[i] instanceof Number : "Vec:add: data type mismatch";

                    resVec.set(i, (NumT) (Double) (((Number) this.data[i]).doubleValue()
                            + ((Number) other.get(i)).doubleValue()));
                }
            } else {
                resVec = (Vec<NumT, VecT, MatT>) other.copy();
                for (int i = 0; i < this.data.length; i++) {
                    assert this.data[i] instanceof Number : "Vec:add: data type mismatch";

                    resVec.set(i, (NumT) (Double) (((Number) this.data[i]).doubleValue()
                            + ((Number) other.get(i)).doubleValue()));
                }
            }
            break;
        case IVector.TYPE_VEC_VEC:
            if (this.getDimension() >= other.getDimension()) {
                resVec = (Vec<NumT, VecT, MatT>) this.copy();
                for (int i = 0; i < other.getDimension(); i++) {
                    assert this.data[i] instanceof IVector : "Vec:add: data type mismatch";

                    resVec.set(i, (VecT) ((IVector<NumT, VecT, MatT>) this.data[i])
                            .add((IVector<NumT, VecT, MatT>) other.get(i)));
                }
            } else {
                resVec = (Vec<NumT, VecT, MatT>) other.copy();
                for (int i = 0; i < this.data.length; i++) {
                    assert this.data[i] instanceof IVector : "Vec:add: data type mismatch";

                    resVec.set(i, (VecT) ((IVector<NumT, VecT, MatT>) this.data[i])
                            .add((IVector<NumT, VecT, MatT>) other.get(i)));
                }
            }
            break;
        case IVector.TYPE_MAT_VEC:
            if (this.getDimension() >= other.getDimension()) {
                resVec = (Vec<NumT, VecT, MatT>) this.copy();
                for (int i = 0; i < other.getDimension(); i++) {
                    assert this.data[i] instanceof IMatrix : "Vec:add: data type mismatch";

                    resVec.set(i, (MatT) ((IMatrix<NumT, VecT, MatT>) this.data[i])
                            .add((IMatrix<NumT, VecT, MatT>) other.get(i)));
                }
            } else {
                resVec = (Vec<NumT, VecT, MatT>) other.copy();
                for (int i = 0; i < this.data.length; i++) {
                    assert this.data[i] instanceof IMatrix : "Vec:add: data type mismatch";

                    resVec.set(i, (MatT) ((IMatrix<NumT, VecT, MatT>) this.data[i])
                            .add((IMatrix<NumT, VecT, MatT>) other.get(i)));
                }
            }
            break;
        default:
            resVec = (Vec<NumT, VecT, MatT>) this.copy();
            for (int i = 0; i < this.data.length; i++) {
                switch (this.quadro_data_type[i % 4]) {
                case IVector.TYPE_ELEMENT_NUM:
                    assert this.data[i] instanceof Number : "Vec:add: data type mismatch";

                    resVec.set(i, (NumT) (Double) (((Number) this.data[i]).doubleValue()
                            + ((Number) other.get(i)).doubleValue()));
                    break;
                case IVector.TYPE_ELEMENT_VEC:
                    assert this.data[i] instanceof IVector : "Vec:add: data type mismatch";

                    resVec.set(i, (VecT) ((IVector<NumT, VecT, MatT>) this.data[i])
                            .add((IVector<NumT, VecT, MatT>) other.get(i)));
                    break;
                case IVector.TYPE_ELEMENT_MAT:
                    assert this.data[i] instanceof IMatrix : "Vec:add: data type mismatch";

                    resVec.set(i, (MatT) ((IMatrix<NumT, VecT, MatT>) this.data[i])
                            .add((IMatrix<NumT, VecT, MatT>) other.get(i)));
                    break;
                }
            }
        }
        return resVec;
    }

    @SuppressWarnings("unchecked")
    @Override
    public IVector<NumT, VecT, MatT> subtract(IVector<NumT, VecT, MatT> other) {
        Vec<NumT, VecT, MatT> resVec;
        switch (this.type & (IVector.TYPE_NUM_VEC | IVector.TYPE_VEC_VEC | IVector.TYPE_MAT_VEC)) {
        case IVector.TYPE_NO_TYPE:
            setProperlyType();
            return this.add(other); // recursive call to ensure proper type is set
        case IVector.TYPE_NUM_VEC:
            if (this.getDimension() >= other.getDimension()) {
                resVec = (Vec<NumT, VecT, MatT>) this.copy();
                for (int i = 0; i < other.getDimension(); i++) {
                    assert this.data[i] instanceof Number : "Vec:subtract: data type mismatch";

                    resVec.set(i, (NumT) (Double) (((Number) this.data[i]).doubleValue()
                            - ((Number) other.get(i)).doubleValue()));
                }
            } else {
                resVec = (Vec<NumT, VecT, MatT>) other.copy();
                for (int i = 0; i < this.data.length; i++) {
                    assert this.data[i] instanceof Number : "Vec:subtract: data type mismatch";

                    resVec.set(i, (NumT) (Double) (((Number) this.data[i]).doubleValue()
                            - ((Number) other.get(i)).doubleValue()));
                }
            }
            break;
        case IVector.TYPE_VEC_VEC:
            if (this.getDimension() >= other.getDimension()) {
                resVec = (Vec<NumT, VecT, MatT>) this.copy();
                for (int i = 0; i < other.getDimension(); i++) {
                    assert this.data[i] instanceof IVector : "Vec:subtract: data type mismatch";
                    
                    resVec.set(i, (VecT) ((IVector<NumT, VecT, MatT>) this.data[i])
                            .subtract((IVector<NumT, VecT, MatT>) other.get(i)));
                }
            } else {
                resVec = (Vec<NumT, VecT, MatT>) other.copy();
                for (int i = 0; i < this.data.length; i++) {
                    assert this.data[i] instanceof IVector : "Vec:subtract: data type mismatch";

                    resVec.set(i, (VecT) ((IVector<NumT, VecT, MatT>) this.data[i])
                            .subtract((IVector<NumT, VecT, MatT>) other.get(i)));
                }
            }
            break;
        case IVector.TYPE_MAT_VEC:
            if (this.getDimension() >= other.getDimension()) {
                resVec = (Vec<NumT, VecT, MatT>) this.copy();
                for (int i = 0; i < other.getDimension(); i++) {
                    assert this.data[i] instanceof IMatrix : "Vec:subtract: data type mismatch";

                    resVec.set(i, (MatT) ((IMatrix<NumT, VecT, MatT>) this.data[i])
                            .subtract((IMatrix<NumT, VecT, MatT>) other.get(i)));
                }
            } else {
                resVec = (Vec<NumT, VecT, MatT>) other.copy();
                for (int i = 0; i < this.data.length; i++) {
                    assert this.data[i] instanceof IMatrix : "Vec:subtract: data type mismatch";

                    resVec.set(i, (MatT) ((IMatrix<NumT, VecT, MatT>) this.data[i])
                            .subtract((IMatrix<NumT, VecT, MatT>) other.get(i)));
                }
            }
            break;
        default:
            resVec = (Vec<NumT, VecT, MatT>) this.copy();
            for (int i = 0; i < this.data.length; i++) {
                switch (this.quadro_data_type[i % 4]) {
                case IVector.TYPE_ELEMENT_NUM:
                    assert this.data[i] instanceof Number : "Vec:subtract: data type mismatch";

                    resVec.set(i, (NumT) (Double) (((Number) this.data[i]).doubleValue()
                            - ((Number) other.get(i)).doubleValue()));
                    break;
                case IVector.TYPE_ELEMENT_VEC:
                    assert this.data[i] instanceof IVector : "Vec:subtract: data type mismatch";

                    resVec.set(i, (VecT) ((IVector<NumT, VecT, MatT>) this.data[i])
                            .subtract((IVector<NumT, VecT, MatT>) other.get(i)));
                    break;
                case IVector.TYPE_ELEMENT_MAT:
                    assert this.data[i] instanceof IMatrix : "Vec:subtract: data type mismatch";

                    resVec.set(i, (MatT) ((IMatrix<NumT, VecT, MatT>) this.data[i])
                            .subtract((IMatrix<NumT, VecT, MatT>) other.get(i)));
                    break;
                }
            }
        }
        return resVec;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Vec<NumT, VecT, MatT> multiply(NumT scalar) {
        Vec<NumT, VecT, MatT> resVec = (Vec<NumT, VecT, MatT>) this.copy();
        switch (this.type & (IVector.TYPE_NUM_VEC | IVector.TYPE_VEC_VEC | IVector.TYPE_MAT_VEC)) {
        case IVector.TYPE_NO_TYPE:
            setProperlyType();
            return this.multiply(scalar); // recursive call to ensure proper type is set
        case IVector.TYPE_NUM_VEC:
            for (int i = 0; i < this.data.length; i++) {
                assert this.data[i] instanceof Number : "Vec:multiply: data type mismatch";

                resVec.set(i, (NumT) (Double) (((Number) this.data[i]).doubleValue() * scalar.doubleValue()));
            }
            break;
        case IVector.TYPE_VEC_VEC:
            for (int i = 0; i < this.data.length; i++) {
                assert this.data[i] instanceof IVector : "Vec:multiply: data type mismatch";

                resVec.set(i, (VecT) ((IVector<NumT, VecT, MatT>) this.data[i]).multiply(scalar));
            }
            break;
        case IVector.TYPE_MAT_VEC:
            for (int i = 0; i < this.data.length; i++) {
                assert this.data[i] instanceof IMatrix : "Vec:multiply: data type mismatch";

                resVec.set(i, (MatT) ((IMatrix<NumT, VecT, MatT>) this.data[i]).multiply(scalar));
            }
            break;
        default:
            for (int i = 0; i < this.data.length; i++) {
                switch (this.quadro_data_type[i % 4]) {
                case IVector.TYPE_ELEMENT_NUM:
                    assert this.data[i] instanceof Number : "Vec:multiply: data type mismatch";

                    resVec.set(i, (NumT) (Double) (((Number) this.data[i]).doubleValue() * scalar.doubleValue()));
                    break;
                case IVector.TYPE_ELEMENT_VEC:
                    assert this.data[i] instanceof IVector : "Vec:multiply: data type mismatch";

                    resVec.set(i, (VecT) ((IVector<NumT, VecT, MatT>) this.data[i]).multiply(scalar));
                    break;
                case IVector.TYPE_ELEMENT_MAT:
                    assert this.data[i] instanceof IMatrix : "Vec:multiply: data type mismatch";

                    resVec.set(i, (MatT) ((IMatrix<NumT, VecT, MatT>) this.data[i]).multiply(scalar));
                    break;
                default:
                    throw new IllegalStateException("Vec:multiply: missing data type");
                }
            }
        }
        return resVec;
    }

    @SuppressWarnings("unchecked")
    @Override
    public NumT dot(IVector<NumT, VecT, MatT> other) {
        double result = 0;
        switch (this.type & (IVector.TYPE_NUM_VEC | IVector.TYPE_VEC_VEC | IVector.TYPE_MAT_VEC)) {
        case IVector.TYPE_NO_TYPE:
            setProperlyType();
            return this.dot(other); // recursive call to ensure proper type is set
        case IVector.TYPE_NUM_VEC:
            if (this.data.length >= other.getDimension()) {
                for (int i = 0; i < other.getDimension(); i++) {
                    assert this.data[i] instanceof Number : "Vec:dot: data type mismatch";
                    assert other.get(i) instanceof Number : "Vec:dot: other data type mismatch";

                    result += ((Number) this.data[i]).doubleValue() * ((Number) other.get(i)).doubleValue();
                }
            } else {
                for (int i = 0; i < this.data.length; i++) {
                    assert this.data[i] instanceof Number : "Vec:dot: data type mismatch";
                    assert other.get(i) instanceof Number : "Vec:dot: other data type mismatch";
                    
                    result += ((Number) this.data[i]).doubleValue() * ((Number) other.get(i)).doubleValue();
                }
            }
            return (NumT) (Double) result;
        default:
            throw new UnsupportedOperationException("Vec:dot - vector of vectors or matrix vector not supported");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Vec<NumT, VecT, MatT> cross(IVector<NumT, VecT, MatT> other) {
        switch (this.type & (IVector.TYPE_NUM_VEC | IVector.TYPE_VEC_VEC | IVector.TYPE_MAT_VEC)) {
        case IVector.TYPE_NO_TYPE:
            setProperlyType();
            return this.cross(other); // recursive call to ensure proper type is set
        case IVector.TYPE_NUM_VEC:
            Vec<NumT, VecT, MatT> rVec = new Vec<>((NumT) (Double) 0.0, (NumT) (Double) 0.0, (NumT) (Double) 0.0);
            Vec<NumT, VecT, MatT> fVec;

            switch (this.getDimension()) {
            case 0:
                rVec = new Vec<NumT, VecT, MatT>((NumT) (Double) 0.0, (NumT) (Double) 0.0, (NumT) (Double) 0.0);
                return rVec;
            case 1:
                fVec = new Vec<NumT, VecT, MatT>((NumT) data[0], (NumT) (Double) 0.0, (NumT) (Double) 0.0);
                break;
            case 2:
                fVec = new Vec<NumT, VecT, MatT>((NumT) data[0], (NumT) data[1], (NumT) (Double) 0.0);
                break;
            case 3:
                fVec = (Vec<NumT, VecT, MatT>) this.copy();
                break;
            default:
                throw new UnsupportedOperationException("Vec:cross: cross product is only defined for 3-D vectors");
            }

            switch (other.getDimension()) {
            case 0:
                rVec = new Vec<NumT, VecT, MatT>((NumT) (Double) 0.0, (NumT) (Double) 0.0, (NumT) (Double) 0.0);
                return rVec;
            case 1:
                rVec.set(0, (NumT) (Double) 0.0);
                rVec.set(1, (NumT) (Double) (((Number) other.get(0)).doubleValue() * ((Number) fVec.get(2)).doubleValue()));
                rVec.set(2, (NumT) (Double) (-((Number) other.get(0)).doubleValue() * ((Number) fVec.get(1)).doubleValue()));
                return rVec;
            case 2:
                rVec.set(0, (NumT) (Double) (-((Number) other.get(1)).doubleValue() * ((Number) fVec.get(2)).doubleValue()));
                rVec.set(1, (NumT) (Double) (((Number) other.get(0)).doubleValue() * ((Number) fVec.get(2)).doubleValue()));
                rVec.set(2, (NumT) (Double) ((((Number) fVec.get(0)).doubleValue() * ((Number) other.get(1)).doubleValue()) - ((Number) other.get(0)).doubleValue() * ((Number) fVec.get(1)).doubleValue()));
                return rVec;
            case 3:
                rVec.set(0, (NumT) (Double) (((Number) fVec.get(1)).doubleValue() * ((Number) other.get(2)).doubleValue()
                    - ((Number) fVec.get(2)).doubleValue() * ((Number) other.get(1)).doubleValue()));
                rVec.set(1, (NumT) (Double) (((Number) fVec.get(2)).doubleValue() * ((Number) other.get(0)).doubleValue()
                    - ((Number) fVec.get(0)).doubleValue() * ((Number) other.get(2)).doubleValue()));
                rVec.set(2, (NumT) (Double) (((Number) fVec.get(0)).doubleValue() * ((Number) other.get(1)).doubleValue()
                    - ((Number) fVec.get(1)).doubleValue() * ((Number) other.get(0)).doubleValue()));

                return rVec;
            default:
                throw new UnsupportedOperationException("Vec:cross: cross product is only undefined for 4+D vectors");
            }
        default:
            throw new UnsupportedOperationException("Vec:cross: vector of vectors or matrix vector not supported");
        }
    }
}