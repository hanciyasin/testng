package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PozitifSmokeTest extends ReusableMethods {
    @Test (groups = "smoke")
    public void test01() {
        //Name: US100201_Admin_Login

        //Description:
        //Admin bilgileriyle giriş

        //Acceptance Criteria:
        //Admin olarak, uygulamaya giriş yapabilmeliyim

        //https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("blueRentalEmail"));
        blueRentalPage.password.sendKeys(ConfigReader.getProperty("blueRentalPass"), Keys.ENTER);







    }
}
