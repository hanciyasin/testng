package techproed.tests.day22_DataProvider_XmlFile;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.awt.image.RescaleOp;

public class C03_DataProvider {


    @DataProvider
    public static Object[][] girisBilgileri() {
        return new Object[][]{{"sam.walker@bluerentalcars.com", "c!fas_art"},
                              {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                              {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                              {"pam.raymond@bluerentalcars.com", "Nga^g6!"}};
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
        blueRentalPage.email.sendKeys(email,Keys.TAB,pass,Keys.ENTER);
        ReusableMethods.bekle(2);

        //sayfayı kapatalım
        Driver.closeDriver();


    }
}
