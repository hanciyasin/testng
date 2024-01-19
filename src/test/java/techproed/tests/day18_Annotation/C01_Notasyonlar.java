package techproed.tests.day18_Annotation;

import org.testng.annotations.*;

public class C01_Notasyonlar {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Herseyden once beforeSuite notasyonuna sahip method 1 kez calisir");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Testlerden once beforeTest notasyonuna sahip method 1 kez calisir");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Her classtan once beforeClass notasyonuna sahip method 1 kez calisir");
        System.out.println("-----------------------------------------------------------------------------------");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Her methoddan once beforeMethod notasyonuna sahip method 1 kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("test01 calisti");

    }

    @Test
    public void test02() {
        System.out.println("test02 calisti");
    }

    @Test
    public void test03() {
        System.out.println("test03 calisti");
    }
}
