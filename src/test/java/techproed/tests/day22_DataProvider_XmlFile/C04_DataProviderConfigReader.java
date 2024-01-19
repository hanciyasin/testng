package techproed.tests.day22_DataProvider_XmlFile;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_DataProviderConfigReader {


    @DataProvider
    public static Object[][] girisBilgileri() {
        return new Object[][]{{ConfigReader.getProperty("mail1"), ConfigReader.getProperty("password1")},
                {ConfigReader.getProperty("mail2"), ConfigReader.getProperty("password2")},
                {ConfigReader.getProperty("mail3"), ConfigReader.getProperty("password3")},
                {ConfigReader.getProperty("mail4"), ConfigReader.getProperty("password4")}};
    }

    @Test(dataProvider = "girisBilgileri")
    public void test01(String email, String pass) {
        //BlueRentalCar Sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //login buttonuna basınız
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();
        ReusableMethods.bekle(1);

        //DataProvider ile girilen mail ve password bilgileri ile login olalım
        blueRentalPage.email.sendKeys(email, Keys.TAB,pass,Keys.ENTER);
        ReusableMethods.bekle(2);

        //sayfayı kapatalım
        Driver.closeDriver();


    }
}
