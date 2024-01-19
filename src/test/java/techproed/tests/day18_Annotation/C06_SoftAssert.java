package techproed.tests.day18_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C06_SoftAssert {
    /*
        SoftAssertion kullanmak icin once SoftAssert classindan bir obje olustururuz. ve bu obje ile daha once
     assertion da kullandigimiz ayni methodlar ile dogrulama yapariz. ve yaptigimiz assertionlar en son nerde
     asserAll methodu kullanirsak orda assertionlarin sonucunu bize verir.
     */
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        //amazon sayufasina gidelim
        driver.get("https://amazon.com");

        //basligin alisveris icerdigini test edelim
        softAssert.assertTrue(driver.getTitle().contains("alisveris"));

        //arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        softAssert.assertEquals(2,2);

        //sonuç yazısının iphone içerdiğini test edelim
        String sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(sonucYazisi.contains("iphone"));
        softAssert.assertTrue(false);
        softAssert.assertAll();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
