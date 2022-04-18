import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataFix implements PageObject {
    protected static Properties property;
    public static FileInputStream fileInputStream;

    @BeforeAll
    public static void beforeAll() {
        try {
            property = new Properties();
            fileInputStream = new FileInputStream("src/properties/config.properties");
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Properties not available");
        }
    }
}