package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestCenterPage {
    public TestCenterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "(//input)[1]")
    public WebElement userName;

    @FindBy (xpath = "(//input)[2]")
    public WebElement password;

    @FindBy (xpath = "//button")
    public WebElement loginButton;

    @FindBy (xpath = "//*[@class='alert alert-success alert-dismissible fade show']")
    public WebElement loginVerify;

    @FindBy (xpath = "//*[@class='fa fa-sign-out-alt']")
    public WebElement logoutButton;

    @FindBy (xpath = "//h2")
    public WebElement logoutVerify;
}
