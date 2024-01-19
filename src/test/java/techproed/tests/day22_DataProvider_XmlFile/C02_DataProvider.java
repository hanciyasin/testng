package techproed.tests.day22_DataProvider_XmlFile;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.security.Key;

public class C02_DataProvider {


    @DataProvider
    public static Object[][] araclar() {
        return new Object[][]{{"honda"}, {"mercedes"}, {"audi"}, {"bmw"}};
    }

    @Test(dataProvider = "araclar")
    public void test01(String data) {
        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //DataProvider ile istediğimiz arac isimlerini aratalım
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(data, Keys.ENTER);
        ReusableMethods.bekle(2);

        //sayfayi kapatın
        Driver.closeDriver();
    }
}
