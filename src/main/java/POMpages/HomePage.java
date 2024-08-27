package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class HomePage {

    WebDriver driver;
    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }

    //Locators
    @FindBy(linkText = "Dismiss") WebElement dismissLink;

    public void clickDismissDemoWarning(){

        dismissLink.click();
        System.out.println("Demo store warning dismissed");

    }

    @FindBy(linkText = "Shop")
    WebElement shopLink;
    public void clickShopLink(){

        shopLink.click();
        System.out.println("Shop has been opened");
    }


    public void addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement addBeanieToCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[aria-label='Add “Beanie” to your cart']")));

        addBeanieToCart.click();
        System.out.println("Beanie has been added to cart");


    }

    public void checkPrice() {

        System.out.println("Finding price");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isTextPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.cssSelector(".woocommerce-Price-amount.amount"), "18"));

        if(isTextPresent){
            WebElement priceInCart = driver.findElement(By.cssSelector(".woocommerce-Price-amount.amount"));
            String cartAmount =priceInCart.getText();
            cartAmount = cartAmount.substring(1); // Create substring totalRaw removing the first character
            System.out.println("Cart amount is "+cartAmount);
        }
        else {
            System.out.println("The expected price text was not found.");
        }

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        //WebElement priceInCart = wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector(".woocommerce-Price-amount.amount")));
//        WebElement priceInCart = driver.findElement(By.cssSelector(".woocommerce-Price-amount.amount"));
//        wait.until(ExpectedConditions.textToBePresentInElement(priceInCart, "18"));
//        String cartAmount =priceInCart.getText();
//        cartAmount = cartAmount.substring(1); // Create substring totalRaw removing the first character
//        System.out.println("Cart amount is "+cartAmount);

    }


    public void clickViewCartLink(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement viewCartLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Cart")));

        viewCartLink.click();
        System.out.println("Viewing cart");



    }


}
