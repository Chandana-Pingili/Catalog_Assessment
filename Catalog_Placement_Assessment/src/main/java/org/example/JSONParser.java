package org.example;

import org.json.JSONObject;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class JSONParser {

    public JSONObject parseJSONFile(String filePath) {
        try {
            FileReader reader = new FileReader(new File(filePath));
            StringBuilder jsonText = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                jsonText.append((char) i);
            }
            reader.close();
            return new JSONObject(jsonText.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

