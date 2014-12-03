package edu.nyu.cs.codinginterview.vi;

import java.util.ArrayList;
import java.util.List;

import edu.nyu.cs.codinginterview.util.Check;
import edu.nyu.cs.codinginterview.util.QuickSort;

/**
 * @author shenli
 * <p>
 * Write a function to add two simple polynomials. That is, the polynomial is a sequence of terms, where each 
 * term is simply a constant times an exponent.
 */
public class PolynomialSolution {
    
    private PolynomialSolution() {
        throw new AssertionError();
    }
    
    public static PolynomialTerms[] sum(PolynomialTerms[] pt1, PolynomialTerms[] pt2) {
        Check.nullCheck(pt1, "PolynomialTerms pt1");
        Check.nullCheck(pt2, "PolynomialTerms pt2");
        for (PolynomialTerms pt : pt1) {
            Check.nullCheck(pt, "PolynomialTerms pt");
        }
        for (PolynomialTerms pt : pt2) {
            Check.nullCheck(pt, "PolynomialTerms pt");
        }
        
        QuickSort.sort(pt1);
        QuickSort.sort(pt2);
        double d1 = 0;
        double d2 = 0;
        List<PolynomialTerms> result = new ArrayList<PolynomialTerms>();
        int i = 0;
        int j = 0;
        while (i < pt1.length && j < pt2.length) {
            d1 = pt1[i].getExponent();
            d2 = pt2[i].getExponent();
            if (Double.compare(d1, d2) == 0) {
                result.add(
                        new PolynomialTerms(
                                pt1[i].getCoefficient() + pt2[i].getCoefficient(), d1));
                i++;
                j++;
            } else if (Double.compare(d1, d2) < 0) {
                result.add(pt1[i]);
                i++;
            } else {
                result.add(pt2[j]);
                j++;
            }
        }
        if (i >= pt1.length) {
            for (; j < pt2.length; j++) {
                result.add(pt2[j]);
            }
        }
        if (j >= pt2.length) {
            for (; i < pt1.length; i++) {
                result.add(pt1[i]);
            }
        }
        return (PolynomialTerms[]) result.toArray();
    }
    
}
