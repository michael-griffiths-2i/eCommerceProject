package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestBase;

public class HomepagePOM {

    WebDriver driver;

    //constructor
    public HomepagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }

    //Locators
    @FindBy(linkText = "Dismiss")

    WebElement dissmissLink;

    public void dismissWarning(){
        dissmissLink.click();

    }

    @FindBy(linkText = "Shop")
    WebElement shopLink;
    public void shopLink(){
        shopLink.click();
    }

    @FindBy(css = "a[aria-label='Add “Beanie” to your cart']")
    WebElement addBeanieToCart;

    public void addBeanieToCart() {
        addBeanieToCart.click();
    }

    @FindBy(linkText ="Cart")
    WebElement viewCartLink;
    public void viewCartLink(){
        viewCartLink.click();
    }


}
