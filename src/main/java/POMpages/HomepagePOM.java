package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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


    public void addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addBeanieToCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[aria-label='Add “Beanie” to your cart']")));

        addBeanieToCart.click();
        System.out.println("Beanie has been added to cart");

    }


    public void clickViewCartLink(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement viewCartLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Cart")));

        viewCartLink.click();
        System.out.println("Viewing cart");



    }


}
