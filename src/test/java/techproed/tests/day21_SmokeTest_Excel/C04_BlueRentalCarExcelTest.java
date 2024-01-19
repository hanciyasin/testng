package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

import java.security.Key;

public class C04_BlueRentalCarExcelTest extends ReusableMethods {
    @Test
    public void test01() {
        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tıklayalım
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();

        //Excel dosyasındaki herhangi bir email ve password ile login olalım
        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata .xlsx";
        String sayfaIsmi = "customer_info";
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);

        String email = reader.getCellData(2,0);
        String password = reader.getCellData(2,1);

        blueRentalPage.email.sendKeys(email, Keys.TAB,password, Keys.ENTER);
        bekle(3);

        //Girilen email ile giriş yapıldığını doğrulayın
        blueRentalPage.profileButton.click();
        blueRentalPage.profile.click();
        String loggedInEmail = blueRentalPage.profileEmail.getText();
        Assert.assertEquals(email,loggedInEmail,"Email Adreslerinde Uyusmazlik Var");

        //sayfayı kapatalım
        Driver.closeDriver();


    }
}
