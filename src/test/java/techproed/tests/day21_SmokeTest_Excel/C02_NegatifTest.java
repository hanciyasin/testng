package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.security.Key;

public class C02_NegatifTest extends ReusableMethods {
    @Test (groups = "smoke")
    public void test01() {
        /*
           Negatif test senaryolarında sayfaya giriş yapılamaması ile ilgi senaryoları oluşturmamız gerekir.
         Bunun için önce örnekte gibi girmemiz gereken email deki mesala bir @ işareti yada bir noktalama işareti
         email'de olmadan şifre doğru bile olsa giriş yapmamamız gerekir. Aynı şekilde email doğru olsa şifre
         yanlış olsa yine giriş yapamamamız gerekir. Dolayısıyla negatif testlerde bu senaryoları göz önünde
         bulundurup buna göre test case lerimizi yazmamız gerekir.
       */

        //Name:
        //US100208_Negative_Login
        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        //Acceptance Criteria
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error:
        //User with email fake@bluerentalcars.com not found

        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login butonuna tıklayalım
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();

        //Yanlış email ve yanlış password ile giriş yapılamadığını test edelim
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("blueRentalFakeEmail"));
        blueRentalPage.password.sendKeys(ConfigReader.getProperty("blueRentalFakePass"), Keys.ENTER);
        Assert.assertTrue(blueRentalPage.loginButton.isDisplayed());

        bekle(5);

        //sayfayı kapatını
        Driver.closeDriver();

    }

    @Test
    public void test02() {
         /*
        Driver driver = new Driver();
        driver.getDriver().get("https://amazon.com");
            SINGLETON PATTER (tekli kullanım)
                Driver class'ındaki gizli const.'ı private yaparak Driver
            class'ından obje oluşturmanın önüne geçeriz.
         */
    }
}
