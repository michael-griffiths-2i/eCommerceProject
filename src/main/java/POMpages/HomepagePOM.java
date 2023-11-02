package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePOM {

    WebDriver driver;

    //constructor
    public HomepagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }

    //Locators
    @FindBy(linkText = "Dismiss")

    WebElement dismissLink;

    public void dismissWarning(){
        dismissLink.click();
        System.out.println("Demo store warning dismissed");

    }

    @FindBy(linkText = "Shop")
    WebElement shopLink;
    public void shopLink(){
        shopLink.click();
        System.out.println("Shop has been opened");
    }

    @FindBy(css = "a[aria-label='Add “Beanie” to your cart']")
    WebElement addBeanieToCart;
    public void addProductToCart() {
        addBeanieToCart.click();
        System.out.println("Beanie has been added to cart");
    }

    @FindBy(linkText ="Cart")
    WebElement viewCartLink;
    public void viewCartLink(){
        viewCartLink.click();
        System.out.println("Viewing cart");
    }


}
