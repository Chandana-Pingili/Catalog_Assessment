package org.example;
import org.json.JSONObject;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String jsonFilePath = "Testcases/testcase2.json";
        JSONParser parser = new JSONParser();
        JSONObject jsonData = parser.parseJSONFile(jsonFilePath);

        if (jsonData != null) {
            JSONObject keys = jsonData.getJSONObject("keys");
            int n = keys.getInt("n");
            int k = keys.getInt("k");

            // Store the points for Lagrange interpolation as BigInteger
            Map<Integer, BigInteger> points = new HashMap<>();

            // Loop through the keys in the JSON to get base and value for each point
            for (String key : jsonData.keySet()) {
                if (!key.equals("keys")) {
                    JSONObject point = jsonData.getJSONObject(key);
                    String base = point.getString("base");
                    String value = point.getString("value");

                    // Convert base value to decimal (BigInteger)
                    BigInteger decimalValue = BaseConverter.convertToDecimal(base, value);
                    points.put(Integer.parseInt(key), decimalValue); // Store points as BigInteger
                }
            }

            // Calculate the constant term (secret) using Shamir's Secret Sharing algorithm
            BigInteger constantTerm = ShamirSecretSharingAlgorithm.findConstantTerm(points, k);

            // Output the result
            System.out.println("The constant term (secret) is: " + constantTerm);
        }
    }
}
