package org.example;

import java.math.BigInteger;

public class BaseConverter {

    public static BigInteger convertToDecimal(String base, String value) {
        // Convert the base and value to decimal (BigInteger)
        int radix = Integer.parseInt(base);
        return new BigInteger(value, radix);
    }
}



