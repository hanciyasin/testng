package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {
    public BlueRentalPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[@class='btn btn-primary btn-sm']")
    public WebElement loginButton ;

    @FindBy (xpath = "//*[@name='email']")
    public WebElement email;

    @FindBy (xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "(//button)[3]")
    public WebElement verify;

    //Negatif Login Button
    @FindBy(xpath = "(//button)[2]")
    public WebElement verifyLogin;

    @FindBy (id = "dropdown-basic-button")
    public WebElement profileButton;

    @FindBy (xpath = "//*[.='Profile']")
    public WebElement profile;

    @FindBy (xpath = "//em")
    public WebElement profileEmail;

    @FindBy (xpath = "//*[.='Logout']")
    public WebElement logoutButton;

    @FindBy (xpath = "//*[.='OK']")
    public WebElement logoutOkButton;

}
