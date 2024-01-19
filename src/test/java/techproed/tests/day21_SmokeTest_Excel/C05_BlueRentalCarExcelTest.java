package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

import java.awt.*;
import java.awt.image.RescaleOp;

public class C05_BlueRentalCarExcelTest {
    @Test
    public void test01() {
        //BlueRentalCar Sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage blueRentalPage =new BlueRentalPage();

        //Excel dosyasındaki tüm kullanıcı bilgileri ile login olalım login olduğumuzu doğrulayalım
        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata .xlsx";
        String sayfaIsmi = "customer_info";
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);
        for (int i = 1; i <=reader.rowCount() ; i++) {
            String email = reader.getCellData(i,0);
            String password = reader.getCellData(i,1);
            System.out.println(email+" || "+password);
            blueRentalPage.loginButton.click();
            ReusableMethods.bekle(1);
            blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
            Assert.assertTrue(blueRentalPage.verifyLogin.isDisplayed());
            ReusableMethods.bekle(1);
            blueRentalPage.profileButton.click();
            ReusableMethods.bekle(1);
            blueRentalPage.logoutButton.click();
            ReusableMethods.bekle(1);
            blueRentalPage.logoutOkButton.click();
            Assert.assertTrue(blueRentalPage.loginButton.isDisplayed());
        }


        //sayfayı kapatını
        Driver.closeDriver();


    }

}
