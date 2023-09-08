package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    //you have to define/(give it a name) your WebElements and make it public.
    //then create a constructor to initialize the WebElements on the current page


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="txtUsername")
    public WebElement usernameTextBox;
    @FindBy(id="txtPassword")
    public WebElement passwordTextbox;
    @FindBy(id="btnLogin")
    public WebElement loginBtn;
    @FindBy(id="welcome")
    public WebElement welcomeIcon;

    @FindBy(xpath="//a[text()='logout']")
    public WebElement logoutLink;


    //Page Factory Model

}
