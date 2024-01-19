package techproed.tests.day20_Properties;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;

import java.util.Properties;

public class C01_PropertiesTest {
    @Test
    public void test01() {
        String url = ConfigReader.getProperty("amazonUrl");

    }
}
