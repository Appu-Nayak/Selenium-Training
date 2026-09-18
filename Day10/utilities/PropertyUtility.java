package Assessments.Day10.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
    public static String getData(String key) throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/Assessments/Day10/resources/Task.properties");
        Properties p = new Properties();
        p.load(fis);
        String data = p.getProperty(key);
        fis.close();
        return data;
    }
}
