package net.mahiron47.mathlib.types.interfaces;

public interface ITensor {
    static final byte TYPE_NULL   = 0b00000000; 
    static final byte TYPE_INT    = 0b00000001;
    static final byte TYPE_LONG   = 0b00000010;
    static final byte TYPE_FLOAT  = 0b00000100;
    static final byte TYPE_DOUBLE = 0b00001000;
}