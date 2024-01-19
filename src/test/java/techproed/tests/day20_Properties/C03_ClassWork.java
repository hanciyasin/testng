package techproed.tests.day20_Properties;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_ClassWork extends ReusableMethods {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        centerPage.userName.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        centerPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        centerPage.loginButton.click();
        bekle(2);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(centerPage.loginVerify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.logoutButton.click();
        softAssert.assertTrue(centerPage.logoutVerify.isDisplayed());

        softAssert.assertAll();

        //sayfayı kapatınız
        Driver.closeDriver();


    }

    @Test
    public void test02() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));
        ReusableMethods.bekle(2);

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        centerPage.userName.sendKeys(ConfigReader.getProperty("techpro_test_username"), Keys.TAB,ConfigReader.getProperty("techpro_test_password"),Keys.ENTER);
        ReusableMethods.bekle(2);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(centerPage.loginVerify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.logoutButton.click();
        softAssert.assertTrue(centerPage.logoutVerify.isDisplayed());
        softAssert.assertAll();

        //sayfayı kapatınız
        Driver.closeDriver();

    }

    @Test
    public void test03() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        String url = ConfigReader.getProperty("testCenterUrl");
        Driver.getDriver().get(url);
        ReusableMethods.bekle(2);

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        String kullaniAdi = ConfigReader.getProperty("techpro_test_username");
        String password = ConfigReader.getProperty("techpro_test_password");
        centerPage.userName.sendKeys(kullaniAdi, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(2);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(centerPage.loginVerify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.loginButton.click();
        softAssert.assertTrue(centerPage.logoutVerify.isDisplayed());
        softAssert.assertAll();

        //sayfayı kapatınız
        Driver.closeDriver();
    }
}
