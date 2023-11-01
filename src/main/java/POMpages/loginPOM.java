package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPOM {

    WebDriver driver;
    public loginPOM(WebDriver driver) {
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
        emailBox.sendKeys("mikeyg77@gmail.com");
    }
    //input password
    @FindBy(name="password")
    WebElement passwordBox;
    public void passwordBox(){
        passwordBox.click();
        passwordBox.sendKeys("Donotigiveout!");
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
