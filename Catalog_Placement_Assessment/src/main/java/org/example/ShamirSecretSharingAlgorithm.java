package org.example;
import java.math.BigInteger;
import java.util.Map;

import java.math.BigInteger;
import java.util.Map;

public class ShamirSecretSharingAlgorithm {

    public static BigInteger findConstantTerm(Map<Integer, BigInteger> points, int k) {
        // Use the Polynomial's lagrangeInterpolation method to find the constant term
        return Polynomial.lagrangeInterpolation(points, k);
    }
}
