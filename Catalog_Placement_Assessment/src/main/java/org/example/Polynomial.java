package org.example;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class Polynomial {

    // Lagrange interpolation to find constant term (secret)
    public static BigInteger lagrangeInterpolation(Map<Integer, BigInteger> points, int k) {
        BigInteger secret = BigInteger.ZERO;

        // Loop through the points to apply Lagrange formula
        for (int i = 1; i <= k; i++) {
            BigInteger numerator = BigInteger.ONE;
            BigInteger denominator = BigInteger.ONE;

            for (int j = 1; j <= k; j++) {
                if (i != j) {
                    // Calculate the numerator and denominator of the Lagrange basis polynomial
                    numerator = numerator.multiply(BigInteger.valueOf(j).negate());
                    denominator = denominator.multiply(BigInteger.valueOf(i - j));
                }
            }

            BigInteger term = points.get(i).multiply(numerator).divide(denominator);
            secret = secret.add(term);
        }

        return secret;
    }
}
