package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(linkText = "My account")    WebElement myAccountLink;
    @FindBy(id="username")              WebElement emailBox;
    @FindBy(name="password")            WebElement passwordBox;
    @FindBy(name = "login")             WebElement logInBtn;
    @FindBy(linkText = "Logout")        WebElement logOutBtn;




    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }

    public void myAccountLink(){
        myAccountLink.click();

    }

    public void emailBox(String email){
        emailBox.click();
        emailBox.sendKeys(email); /*This must be changed to a proper login that is manually setup*/
    }

    public void passwordBox(){
        passwordBox.click();
        passwordBox.sendKeys("Donotigiveout!"); /*This must be changed to a proper password  that is manually setup*/
    }

    public void logIn(){
        logInBtn.click();

    }

    public void logout(){
        logOutBtn.click();

    }
}
