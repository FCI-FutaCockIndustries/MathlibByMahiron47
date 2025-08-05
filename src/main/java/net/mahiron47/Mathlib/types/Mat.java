package net.mahiron47.mathlib.types;

import net.mahiron47.mathlib.types.interfaces.ITensor;
import net.mahiron47.mathlib.types.interfaces.IMatrix;

public class Mat implements IMatrix {
    private final int[][]    Idata;
    private final long[][]   Ldata;
    private final float[][]  Fdata;
    private final double[][] Ddata;
    private final byte       type ;

    public Mat(int[][] data, byte type) {
        assert data != null : "Mat:constructor:data == null";
        assert data.length > 0 : "Mat:constructor:data.length == 0";
        assert data[0].length > 0 : "Mat:constructor:data[0].length == 0";
        assert type != ITensor.TYPE_NULL : "Mat:constructor:type == ITensor.TYPE_NULL";

        switch (type) {
        case ITensor.TYPE_INT:
            Idata = new int[data.length][data[0].length];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    Idata[i][j] = data[i][j];
                }
            }
            Ldata = null;
            Fdata = null;
            Ddata = null;
            break;
        default:
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
        this.type = type;
    }

    public Mat(long[][] data, byte type) {
        assert data != null : "Mat:constructor:data == null";
        assert data.length > 0 : "Mat:constructor:data.length == 0";
        assert data[0].length > 0 : "Mat:constructor:data[0].length == 0";
        assert type != ITensor.TYPE_NULL : "Mat:constructor:type == ITensor.TYPE_NULL";

        switch (type) {
        case ITensor.TYPE_INT:
            Idata = new int[data.length][data[0].length];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    Idata[i][j] = (int) data[i][j];
                }
            }
            Ldata = null;
            Fdata = null;
            Ddata = null;
            break;
        case ITensor.TYPE_LONG:
            Idata = null;
            Ldata = new long[data.length][data[0].length];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    Ldata[i][j] = data[i][j];
                }
            }
            Fdata = null;
            Ddata = null;
            break;
        default:
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
        this.type = type;
    }

    public Mat(float[][] data, byte type) {
        assert data != null : "Mat:constructor:data == null";
        assert data.length > 0 : "Mat:constructor:data.length == 0";
        assert data[0].length > 0 : "Mat:constructor:data[0].length == 0";
        assert type != ITensor.TYPE_NULL : "Mat:constructor:type == ITensor.TYPE_NULL";

        switch (type) {
        case ITensor.TYPE_FLOAT:
            Idata = null;
            Ldata = null;
            Fdata = new float[data.length][data[0].length];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    Fdata[i][j] = data[i][j];
                }
            }
            Ddata = null;
            break;
        default:
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
        this.type = type;
    }

    public Mat(double[][] data, byte type) {
        assert data != null : "Mat:constructor:data == null";
        assert data.length > 0 : "Mat:constructor:data.length == 0";
        assert data[0].length > 0 : "Mat:constructor:data[0].length == 0";
        assert type != ITensor.TYPE_NULL : "Mat:constructor:type == ITensor.TYPE_NULL";

        switch (type) {
        case ITensor.TYPE_FLOAT:
            Idata = null;
            Ldata = null;
            Fdata = new float[data.length][data[0].length];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    Fdata[i][j] = (float) data[i][j];
                }
            }
            Ddata = null;
            break;
        case ITensor.TYPE_DOUBLE:
            Idata = null;
            Ldata = null;
            Fdata = null;
            Ddata = new double[data.length][data[0].length];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    Ddata[i][j] = data[i][j];
                }
            }
            break;
        default:
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
        this.type = type;
    }

    @Override
    public byte getType() {
        return this.type;
    }

    @Override
    public int geti(int i, int j) {
        assert i >= 0 && i < Idata.length : "Mat:get:i out of bounds for Idata";
        assert j >= 0 && j < Idata[i].length : "Mat:get:j out of bounds for Idata";
        assert Idata != null : "Mat:get:Idata == null";
        assert Idata[i] != null : "Mat:get:Idata[i] == null";

        return Idata[i][j];
    }

    @Override
    public long getl(int i, int j) {
        assert i >= 0 && i < Ldata.length : "Mat:get:i out of bounds for Ldata";
        assert j >= 0 && j < Ldata[i].length : "Mat:get:j out of bounds for Ldata";
        assert Ldata != null : "Mat:get:Ldata == null";
        assert Ldata[i] != null : "Mat:get:Ldata[i] == null";

        return Ldata[i][j];
    }

    @Override
    public float getf(int i, int j) {
        assert i >= 0 && i < Fdata.length : "Mat:get:i out of bounds for Fdata";
        assert j >= 0 && j < Fdata[i].length : "Mat:get:j out of bounds for Fdata";
        assert Fdata != null : "Mat:get:Fdata == null";
        assert Fdata[i] != null : "Mat:get:Fdata[i] == null";

        return Fdata[i][j];
    }

    @Override
    public double getd(int i, int j) {
        assert i >= 0 && i < Ddata.length : "Mat:get:i out of bounds for Ddata";
        assert j >= 0 && j < Ddata[i].length : "Mat:get:j out of bounds for Ddata";
        assert Ddata != null : "Mat:get:Ddata == null";
        assert Ddata[i] != null : "Mat:get:Ddata[i] == null";

        return Ddata[i][j];
    }

    @Override
    public void set(int i, int j, int a_ij) {
        assert i >= 0 && i < Idata.length : "Mat:set:i out of bounds for Idata";
        assert j >= 0 && j < Idata[i].length : "Mat:set:j out of bounds for Idata";
        assert Idata != null : "Mat:set:Idata == null";
        assert Idata[i] != null : "Mat:set:Idata[i] == null";

        Idata[i][j] = a_ij;
    }

    @Override
    public void set(int i, int j, long a_ij) {
        assert i >= 0 && i < Ldata.length : "Mat:set:i out of bounds for Ldata";
        assert j >= 0 && j < Ldata[i].length : "Mat:set:j out of bounds for Ldata";
        assert Ldata != null : "Mat:set:Ldata == null";
        assert Ldata[i] != null : "Mat:set:Ldata[i] == null";

        Ldata[i][j] = a_ij;
    }

    @Override
    public void set(int i, int j, float a_ij) {
        assert i >= 0 && i < Fdata.length : "Mat:set:i out of bounds for Fdata";
        assert j >= 0 && j < Fdata[i].length : "Mat:set:j out of bounds for Fdata";
        assert Fdata != null : "Mat:set:Fdata == null";
        assert Fdata[i] != null : "Mat:set:Fdata[i] == null";

        Fdata[i][j] = a_ij;
    }

    @Override
    public void set(int i, int j, double a_ij) {
        assert i >= 0 && i < Ddata.length : "Mat:set:i out of bounds for Ddata";
        assert j >= 0 && j < Ddata[i].length : "Mat:set:j out of bounds for Ddata";
        assert Ddata != null : "Mat:set:Ddata == null";
        assert Ddata[i] != null : "Mat:set:Ddata[i] == null";

        Ddata[i][j] = a_ij;
    }

    @Override
    public int[] getDimensions() {
        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Mat:getDimensions:Idata == null";
            assert Idata[0] != null : "Mat:getDimensions:Idata[0] == null";
            
            return new int[] { Idata.length, Idata[0].length };
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Mat:getDimensions:Ldata == null";
            assert Ldata[0] != null : "Mat:getDimensions:Ldata[0] == null";
            
            return new int[] { Ldata.length, Ldata[0].length };
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Mat:getDimensions:Fdata == null";
            assert Fdata[0] != null : "Mat:getDimensions:Fdata[0] == null";
            
            return new int[] { Fdata.length, Fdata[0].length };
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Mat:getDimensions:Ddata == null";
            assert Ddata[0] != null : "Mat:getDimensions:Ddata[0] == null";
            
            return new int[] { Ddata.length, Ddata[0].length };
        default:
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }

    @Override
    public Mat copy() {
        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Mat:copy: Idata is null";

            int[][] copiedIdata = new int[Idata.length][];
            for (int i = 0; i < Idata.length; i++) {
                copiedIdata[i] = Idata[i].clone();
            }
            return new Mat(copiedIdata, this.type);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Mat:copy: Ldata is null";

            long[][] copiedLdata = new long[Ldata.length][];
            for (int i = 0; i < Ldata.length; i++) {
                copiedLdata[i] = Ldata[i].clone();
            }
            return new Mat(copiedLdata, this.type);
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Mat:copy: Fdata is null";

            float[][] copiedFdata = new float[Fdata.length][];
            for (int i = 0; i < Fdata.length; i++) {
                copiedFdata[i] = Fdata[i].clone();
            }
            return new Mat(copiedFdata, this.type);
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Mat:copy: Ddata is null";

            double[][] copiedDdata = new double[Ddata.length][];
            for (int i = 0; i < Ddata.length; i++) {
                copiedDdata[i] = Ddata[i].clone();
            }
            return new Mat(copiedDdata, this.type);
        default:
            throw new IllegalArgumentException("Mat:copy - unsupported type: " + type);
        }
    }

    @Override
    public Vec convert(int i) {
        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Mat:convert: Idata == null";
            assert i >= 0 && i < Idata.length : "Mat:convert: column index out of bounds: " + i;

            int[] intColumn = new int[Idata[i].length];
            for (int j = 0; j < Idata[i].length; j++) {
                intColumn[j] = Idata[j][i];
            }

            return new Vec(intColumn, this.type);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Mat:convert: Ldata == null";
            assert i >= 0 && i < Ldata.length : "Mat:convert: column index out of bounds: " + i;

            long[] longColumn = new long[Ldata[i].length];
            for (int j = 0; j < Ldata[i].length; j++) {
                longColumn[j] = Ldata[j][i];
            }

            return new Vec(longColumn, this.type);
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Mat:convert: Fdata == null";
            assert i >= 0 && i < Fdata.length : "Mat:convert: column index out of bounds: " + i;

            float[] floatColumn = new float[Fdata[i].length];
            for (int j = 0; j < Fdata[i].length; j++) {
                floatColumn[j] = Fdata[j][i];
            }

            return new Vec(floatColumn, this.type);
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Mat:convert: Ddata == null";
            assert i >= 0 && i < Ddata.length : "Mat:convert: column index out of bounds: " + i;

            double[] doubleColumn = new double[Ddata[i].length];
            for (int j = 0; j < Ddata[i].length; j++) {
                doubleColumn[j] = Ddata[j][i];
            }

            return new Vec(doubleColumn, this.type);
        default:
            throw new IllegalArgumentException("Mat:convert: unsupported type: " + type);
        }
    }

    @Override
    public Mat getTranspose() {
        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Mat:getTranspose: Idata == null";

            int[][] transposedIdata = new int[Idata[0].length][Idata.length];
            for (int i = 0; i < Idata.length; i++) {
                for (int j = 0; j < Idata[i].length; j++) {
                    transposedIdata[j][i] = Idata[i][j];
                }
            }

            return new Mat(transposedIdata, this.type);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Mat:getTranspose: Ldata == null";

            long[][] transposedLdata = new long[Ldata[0].length][Ldata.length];
            for (int i = 0; i < Ldata.length; i++) {
                for (int j = 0; j < Ldata[i].length; j++) {
                    transposedLdata[j][i] = Ldata[i][j];
                }
            }

            return new Mat(transposedLdata, this.type);

        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Mat:getTranspose: Fdata == null";

            float[][] transposedFdata = new float[Fdata[0].length][Fdata.length];
            for (int i = 0; i < Fdata.length; i++) {
                for (int j = 0; j < Fdata[i].length; j++) {
                    transposedFdata[j][i] = Fdata[i][j];
                }
            }

            return new Mat(transposedFdata, this.type);

        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Mat:getTranspose: Ddata == null";

            double[][] transposedDdata = new double[Ddata[0].length][Ddata.length];
            for (int i = 0; i < Ddata.length; i++) {
                for (int j = 0; j < Ddata[i].length; j++) {
                    transposedDdata[j][i] = Ddata[i][j];
                }
            }

            return new Mat(transposedDdata, this.type);

        default:
            throw new IllegalArgumentException("Mat:getTranspose: unsupported type: " + type);
        }
    }

    @Override
    public int deti() {
        assert this.getDimensions()[0] == this.getDimensions()[1] : "Mat:getDeterminant: matrix is not square";
        assert Idata != null : "Mat:getDeterminant: Idata == null";

        switch (Idata.length) {
        case 1:
            return Idata[0][0];
        case 2:
            return Idata[0][0] * Idata[1][1] - Idata[0][1] * Idata[1][0];
        default:
            int det = 0;

            for (int j = 0; j < Idata.length; j++) {
                // Create minor matrix (n-1 × n-1)
                int[][] minor = new int[Idata.length - 1][Idata.length - 1];
                for (int i = 1; i < Idata.length; i++) {
                    for (int k = 0, minorCol = 0; k < Idata.length; k++, minorCol++) {
                        if (k != j) {
                            minor[i - 1][minorCol] = Idata[i][k];
                        }
                    }
                }

                int minorDet = new Mat(minor, this.type).deti();

                if (j % 2 == 0) {
                    det += Idata[0][j] * minorDet;
                } else {
                    det -= Idata[0][j] * minorDet;
                }
            }

            return det;
        }
    }

    @Override
    public long detl() {
        assert this.getDimensions()[0] == this.getDimensions()[1] : "Mat:getDeterminant: matrix is not square";
        assert Ldata != null : "Mat:getDeterminant: Ldata == null";

        switch (Ldata.length) {
        case 1:
            return Ldata[0][0];
        case 2:
            return Ldata[0][0] * Ldata[1][1] - Ldata[0][1] * Ldata[1][0];
        default:
            long det = 0;

            for (int j = 0; j < Ldata.length; j++) {
                // Create minor matrix (n-1 × n-1)
                long[][] minor = new long[Ldata.length - 1][Ldata.length - 1];
                for (int i = 1; i < Ldata.length; i++) {
                    for (int k = 0, minorCol = 0; k < Ldata.length; k++, minorCol++) {
                        if (k != j) {
                            minor[i - 1][minorCol] = Ldata[i][k];
                        }
                    }
                }

                long minorDet = new Mat(minor, this.type).detl();

                if (j % 2 == 0) {
                    det += Ldata[0][j] * minorDet;
                } else {
                    det -= Ldata[0][j] * minorDet;
                }
            }

            return det;
        }
    }

    @Override
    public float detf() {
        assert this.getDimensions()[0] == this.getDimensions()[1] : "Mat:getDeterminant: matrix is not square";
        assert Fdata != null : "Mat:getDeterminant: Fdata == null";

        switch (Fdata.length) {
        case 1:
            return Fdata[0][0];
        case 2:
            return Fdata[0][0] * Fdata[1][1] - Fdata[0][1] * Fdata[1][0];
        default:
            float det = 0;

            for (int j = 0; j < Fdata.length; j++) {
                // Create minor matrix (n-1 × n-1)
                float[][] minor = new float[Fdata.length - 1][Fdata.length - 1];
                for (int i = 1; i < Fdata.length; i++) {
                    for (int k = 0, minorCol = 0; k < Fdata.length; k++, minorCol++) {
                        if (k != j) {
                            minor[i - 1][minorCol] = Fdata[i][k];
                        }
                    }
                }

                float minorDet = new Mat(minor, this.type).detf();

                if (j % 2 == 0) {
                    det += Fdata[0][j] * minorDet;
                } else {
                    det -= Fdata[0][j] * minorDet;
                }
            }

            return det;
        }
    }

    @Override
    public double detd() {
        assert this.getDimensions()[0] == this.getDimensions()[1] : "Mat:getDeterminant: matrix is not square";
        assert Ddata != null : "Mat:getDeterminant: Ddata == null";

        switch (Ddata.length) {
        case 1:
            return Ddata[0][0];
        case 2:
            return Ddata[0][0] * Ddata[1][1] - Ddata[0][1] * Ddata[1][0];
        default:
            double det = 0;

            for (int j = 0; j < Ddata.length; j++) {
                // Create minor matrix (n-1 × n-1)
                double[][] minor = new double[Ddata.length - 1][Ddata.length - 1];
                for (int i = 1; i < Ddata.length; i++) {
                    for (int k = 0, minorCol = 0; k < Ddata.length; k++, minorCol++) {
                        if (k != j) {
                            minor[i - 1][minorCol] = Ddata[i][k];
                        }
                    }
                }

                double minorDet = new Mat(minor, this.type).detd();

                if (j % 2 == 0) {
                    det += Ddata[0][j] * minorDet;
                } else {
                    det -= Ddata[0][j] * minorDet;
                }
            }

            return det;
        }
    }

    @Override
    public Mat add(IMatrix other) {
        assert other != null : "Mat:add: other == null";
        assert this.getDimensions()[0] == other.getDimensions()[0] : "Mat:add: row dimensions do not match";
        assert this.getDimensions()[1] == other.getDimensions()[1] : "Mat:add: column dimensions do not match";

        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Mat:add: Idata == null";

            int[][] resultIdata = new int[Idata.length][Idata[0].length];
            for (int i = 0; i < Idata.length; i++) {
                for (int j = 0; j < Idata[i].length; j++) {
                    resultIdata[i][j] = Idata[i][j] + other.geti(i, j);
                }
            }

            return new Mat(resultIdata, this.type);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Mat:add: Ldata == null";

            long[][] resultLdata = new long[Ldata.length][Ldata[0].length];
            for (int i = 0; i < Ldata.length; i++) {
                for (int j = 0; j < Ldata[i].length; j++) {
                    resultLdata[i][j] = Ldata[i][j] + other.getl(i, j);
                }
            }

            return new Mat(resultLdata, this.type);
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Mat:add: Fdata == null";

            float[][] resultFdata = new float[Fdata.length][Fdata[0].length];
            for (int i = 0; i < Fdata.length; i++) {
                for (int j = 0; j < Fdata[i].length; j++) {
                    resultFdata[i][j] = Fdata[i][j] + other.getf(i, j);
                }
            }

            return new Mat(resultFdata, this.type);
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Mat:add: Ddata == null";

            double[][] resultDdata = new double[Ddata.length][Ddata[0].length];
            for (int i = 0; i < Ddata.length; i++) {
                for (int j = 0; j < Ddata[i].length; j++) {
                    resultDdata[i][j] = Ddata[i][j] + other.getd(i, j);
                }
            }

            return new Mat(resultDdata, this.type);
        default:
            throw new IllegalArgumentException("Mat:add: unsupported type: " + type);
        }
    }

    @Override
    public Mat subtract(IMatrix other) {
        assert other != null : "Mat:add: other == null";
        assert this.getDimensions()[0] == other.getDimensions()[0] : "Mat:add: row dimensions do not match";
        assert this.getDimensions()[1] == other.getDimensions()[1] : "Mat:add: column dimensions do not match";

        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Mat:add: Idata == null";

            int[][] resultIdata = new int[Idata.length][Idata[0].length];
            for (int i = 0; i < Idata.length; i++) {
                for (int j = 0; j < Idata[i].length; j++) {
                    resultIdata[i][j] = Idata[i][j] - other.geti(i, j);
                }
            }

            return new Mat(resultIdata, this.type);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Mat:add: Ldata == null";

            long[][] resultLdata = new long[Ldata.length][Ldata[0].length];
            for (int i = 0; i < Ldata.length; i++) {
                for (int j = 0; j < Ldata[i].length; j++) {
                    resultLdata[i][j] = Ldata[i][j] - other.getl(i, j);
                }
            }

            return new Mat(resultLdata, this.type);
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Mat:add: Fdata == null";

            float[][] resultFdata = new float[Fdata.length][Fdata[0].length];
            for (int i = 0; i < Fdata.length; i++) {
                for (int j = 0; j < Fdata[i].length; j++) {
                    resultFdata[i][j] = Fdata[i][j] - other.getf(i, j);
                }
            }

            return new Mat(resultFdata, this.type);
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Mat:add: Ddata == null";

            double[][] resultDdata = new double[Ddata.length][Ddata[0].length];
            for (int i = 0; i < Ddata.length; i++) {
                for (int j = 0; j < Ddata[i].length; j++) {
                    resultDdata[i][j] = Ddata[i][j] - other.getd(i, j);
                }
            }
            
            return new Mat(resultDdata, this.type);
        default:
            throw new IllegalArgumentException("Mat:add: unsupported type: " + type);
        }
    }

    @Override
    public Mat multiply(int scalar) {
        assert Idata != null : "Mat:multiply: Idata == null";

        int[][] resultIdata = new int[Idata.length][Idata[0].length];
        for (int i = 0; i < Idata.length; i++) {
            for (int j = 0; j < Idata[i].length; j++) {
                resultIdata[i][j] = Idata[i][j] * scalar;
            }
        }

        return new Mat(resultIdata, this.type);
    }

    @Override
    public Mat multiply(long scalar) {
        assert Ldata != null : "Mat:multiply: Ldata == null";

        long[][] resultLdata = new long[Ldata.length][Ldata[0].length];
        for (int i = 0; i < Ldata.length; i++) {
            for (int j = 0; j < Ldata[i].length; j++) {
                resultLdata[i][j] = Ldata[i][j] * scalar;
            }
        }

        return new Mat(resultLdata, this.type);
    }

    @Override
    public Mat multiply(float scalar) {
        assert Fdata != null : "Mat:multiply: Fdata == null";

        float[][] resultFdata = new float[Fdata.length][Fdata[0].length];
        for (int i = 0; i < Fdata.length; i++) {
            for (int j = 0; j < Fdata[i].length; j++) {
                resultFdata[i][j] = Fdata[i][j] * scalar;
            }
        }

        return new Mat(resultFdata, this.type);
    }

    @Override
    public Mat multiply(double scalar) {
        assert Ddata != null : "Mat:multiply: Ddata == null";

        double[][] resultDdata = new double[Ddata.length][Ddata[0].length];
        for (int i = 0; i < Ddata.length; i++) {
            for (int j = 0; j < Ddata[i].length; j++) {
                resultDdata[i][j] = Ddata[i][j] * scalar;
            }
        }

        return new Mat(resultDdata, this.type);
    }

    @Override
    public Mat multiply(IMatrix other) {
        assert other != null : "Mat:multiply: other == null";
        assert this.getDimensions()[1] == other.getDimensions()[0] : "Mat:multiply: column dimensions do not match";

        switch (this.type) {
        case ITensor.TYPE_INT:
            assert Idata != null : "Mat:multiply: Idata == null";

            int[][] resultIdata = new int[Idata.length][other.getDimensions()[1]];
            for (int i = 0; i < Idata.length; i++) {
                for (int j = 0; j < other.getDimensions()[1]; j++) {
                    resultIdata[i][j] = 0;
                    for (int k = 0; k < Idata[i].length; k++) {
                        resultIdata[i][j] += Idata[i][k] * other.geti(k, j);
                    }
                }
            }

            return new Mat(resultIdata, this.type);
        case ITensor.TYPE_LONG:
            assert Ldata != null : "Mat:multiply: Ldata == null";

            long[][] resultLdata = new long[Ldata.length][other.getDimensions()[1]];
            for (int i = 0; i < Ldata.length; i++) {
                for (int j = 0; j < other.getDimensions()[1]; j++) {
                    resultLdata[i][j] = 0;
                    for (int k = 0; k < Ldata[i].length; k++) {
                        resultLdata[i][j] += Ldata[i][k] * other.getl(k, j);
                    }
                }
            }

            return new Mat(resultLdata, this.type);
        case ITensor.TYPE_FLOAT:
            assert Fdata != null : "Mat:multiply: Fdata == null";

            float[][] resultFdata = new float[Fdata.length][other.getDimensions()[1]];
            for (int i = 0; i < Fdata.length; i++) {
                for (int j = 0; j < other.getDimensions()[1]; j++) {
                    resultFdata[i][j] = 0;
                    for (int k = 0; k < Fdata[i].length; k++) {
                        resultFdata[i][j] += Fdata[i][k] * other.getf(k, j);
                    }
                }
            }

            return new Mat(resultFdata, this.type);
        case ITensor.TYPE_DOUBLE:
            assert Ddata != null : "Mat:multiply: Ddata == null";

            double[][] resultDdata = new double[Ddata.length][other.getDimensions()[1]];
            for (int i = 0; i < Ddata.length; i++) {
                for (int j = 0; j < other.getDimensions()[1]; j++) {
                    resultDdata[i][j] = 0;
                    for (int k = 0; k < Ddata[i].length; k++) {
                        resultDdata[i][j] += Ddata[i][k] * other.getd(k, j);
                    }
                }
            }

            return new Mat(resultDdata, this.type);
        default:
            throw new IllegalArgumentException("Mat:multiply: unsupported type: " + type);
        }
    }
}
