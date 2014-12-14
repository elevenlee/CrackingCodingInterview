package edu.nyu.cs.codinginterview.chapter11;

public class MatrixIndex {
    private final int row;
    private final int column;
    private volatile int hashCode;
    
    public MatrixIndex(int row, int column) {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException();
        }
        
        this.row = row;
        this.column = column;
    }
    
    public int getRow()     { return row; }
    public int getColumn()  { return column; }
    
    @Override
    public boolean equals(Object o) {
        if (o ==  this) {
            return true;
        }
        if (!(o instanceof MatrixIndex)) {
            return false;
        }
        MatrixIndex i = (MatrixIndex) o;
        return row == i.row
                && column == i.column;
    }
    
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + row;
            result = 31 * result + column;
            hashCode = result;
        }
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "[" + row + ", " + column + "]";
    }

}
