package techproed.tests.day18_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BeforeGroupAfterGroup {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Once burasi calisir");
    }

    /*
    @BeforeGroup notasyanına sahip method ile test methodlarımızı gruplayabiliriz. Bunun için @BeforeGroup
    notasyonundan sonra parametre olarak bir isim belirtiriz. Gruplamak istediğimiz test methodlarına sahip
    @Test notasyonundan sonra parametre olarak groups="isim" yazarak testlerimiz aşağıdaki örnekteki gibi
    gruplamış oluruz
     */

    @BeforeGroups({"yasin", "ferdi"})
    public void beforeGroups() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @BeforeGroups("hanci")
    public void beforeGroups2() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(groups = "yasin")
    public void test01() {
        String amazonUrl = "https://amazon.com";
        driver.get(amazonUrl);
    }

    @Test(groups = "hanci")
    public void test02() {
        String youtubeUrl = "https://youtube.com";
        driver.get(youtubeUrl);
    }

    @Test(groups = "ferdi")
    public void test03() {
        String facebookUrl = "https://facebook.com";
        driver.get(facebookUrl);
    }

    @AfterGroups("hanci")
    public void afterGroups() {
        driver.close();
    }


}
