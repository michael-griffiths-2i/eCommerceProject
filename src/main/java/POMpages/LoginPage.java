package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }

    //click My account
    @FindBy(linkText = "My account")
    WebElement myAccountLink;
    public void myAccountLink(){
        myAccountLink.click();

    }
    //input username
    @FindBy(id="username")
    WebElement emailBox;
    public void emailBox(){
        emailBox.click();
        emailBox.sendKeys("something@gmail.com"); /*This must be changed to a proper login that is manually setup*/
    }
    //input password
    @FindBy(name="password")
    WebElement passwordBox;
    public void passwordBox(){
        passwordBox.click();
        passwordBox.sendKeys("Donotigiveout!"); /*This must be changed to a proper password  that is manually setup*/
    }

    //click login
    @FindBy(name = "login")
    WebElement logInBtn;
    public void logIn(){
        logInBtn.click();

    }

    //logout
    @FindBy(linkText = "Logout")
    WebElement logOutBtn;
    public void logout(){
        logOutBtn.click();

    }

}
