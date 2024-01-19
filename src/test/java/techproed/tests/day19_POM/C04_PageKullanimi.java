package techproed.tests.day19_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C04_PageKullanimi {
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
        Assert.assertTrue(sourcePage.verify.isDisplayed());
        Thread.sleep(2000);


        //sayfayı kapatınız
        Driver.closeDriver();

    }

}
