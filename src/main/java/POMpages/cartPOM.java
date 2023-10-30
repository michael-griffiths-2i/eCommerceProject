package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class cartPOM {
    WebDriver driver;

    //constructor
    public cartPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }

    //Locators

    //find the textbox
    @FindBy(id="coupon_code")
    WebElement couponBox;
    public void couponBox(){
        couponBox.click();
        couponBox.sendKeys("edgewords");
    }

    //apply the coupon
    @FindBy(name="apply_coupon")
    WebElement applyCouponBtn;
    public void applyCouponBtn(){
        applyCouponBtn.click();
    }

    //check for coupon applied successfully banner
    @FindBy(id="post-5")
    WebElement wholePost;

    public void couponPresent(){
        String textToFind = "Coupon code applied successfully.";
        String pageText = wholePost.getText();

        assertTrue(pageText.contains(textToFind), "Text not found: " + textToFind);


    }


    //check total

    //check shipping

    //logout
}
