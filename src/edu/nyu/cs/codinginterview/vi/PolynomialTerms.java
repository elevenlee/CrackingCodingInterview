package edu.nyu.cs.codinginterview.vi;

class PolynomialTerms implements Comparable<PolynomialTerms> {
    private final double coefficient;
    private final double exponent;
    private volatile int hashCode;
    
    PolynomialTerms(double coefficient, double exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    
    public double getCoefficient() {
        return coefficient;
    }
    
    public double getExponent() {
        return exponent;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PolynomialTerms)) {
            return false;
        }
        PolynomialTerms p = (PolynomialTerms) o;
        return Double.compare(exponent, p.exponent) == 0
                && Double.compare(coefficient, p.coefficient) == 0;
    }
    
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result
                    + (int) (Double.doubleToLongBits(exponent) ^
                            (Double.doubleToLongBits(exponent) >>> 32));
            result = 31 * result
                    + (int) (Double.doubleToLongBits(coefficient) ^
                            (Double.doubleToLongBits(coefficient) >>> 32));;
            hashCode = result;
        }
        return result;
    }

    @Override
    public int compareTo(PolynomialTerms p) {
        return Double.compare(exponent, p.exponent);
    }
    
}
