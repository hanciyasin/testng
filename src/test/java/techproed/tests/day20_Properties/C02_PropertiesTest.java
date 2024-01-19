
package techproed.tests.day20_Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.time.Duration;

public class C02_PropertiesTest {
    @Test
    public void test01() throws InterruptedException {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("OpenSourceUrl"));

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        //kullanici=Admin
        //kullaniciSifre=admin123
        OpenSourcePage sourcePage = new OpenSourcePage();
        sourcePage.userName.sendKeys(ConfigReader.getProperty("OpenSourceUser"));
        sourcePage.password.sendKeys(ConfigReader.getProperty("OpenSourcePass"));
        sourcePage.loginButton.click();


        //Login Testinin basarili oldugunu test et
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(sourcePage.verify));
        Assert.assertTrue(sourcePage.verify.isDisplayed());
        Thread.sleep(2000);


        //sayfayı kapatınız
        Driver.closeDriver();

    }
}

