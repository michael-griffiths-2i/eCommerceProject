package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static java.lang.Double.parseDouble;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CartPage {
    @FindBy(name="apply_coupon")    WebElement applyCouponBtn;

    WebDriver driver;

    //constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }


    public void couponBox(String coupon){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement couponBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("coupon_code")));
        couponBox.click();
        couponBox.sendKeys(coupon);
        System.out.println("coupon box has been found");
    }

    public void applyCouponBtn(){

        applyCouponBtn.click();
        System.out.println("apply coupon button clicked");
    }

    public void getPrice() {

        System.out.println("Finding price");
        String totalRaw = driver.findElement(By.cssSelector(".woocommerce-Price-amount.amount")).getText();
        totalRaw = totalRaw.substring(1); // Create substring totalRaw removing the first character
        double total = parseDouble(totalRaw);
        System.out.println("Total Price is : "+total);
        getDiscount(total);

    }

    private void getDiscount(double totalPrice) {

        System.out.println("Waiting for the discount element to have the correct value");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      boolean isTextPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.cssSelector("tr.cart-discount.coupon-edgewords span.woocommerce-Price-amount.amount"), "£2.70"));

      //took a different approach here, stored the state of the discount as boolean isTextPresent. If it is we can do the test of the value, if it isn't it will output an error message
      //could have also used a try-catch instead

      if (isTextPresent) {
            WebElement discountElement = driver.findElement(By.cssSelector("tr.cart-discount.coupon-edgewords span.woocommerce-Price-amount.amount"));
            String totalDiscountRaw = discountElement.getText();
            System.out.println(totalDiscountRaw);
            totalDiscountRaw = totalDiscountRaw.substring(1); // Remove the currency symbol
            double totalDiscount = Double.parseDouble(totalDiscountRaw);
            System.out.println("Raw Discount: " + totalDiscount);

            // Calculate the expected discount based on the total price
            double actualDiscount = totalPrice * 0.15;
            System.out.println("Actual Discount: " + actualDiscount);

            // Assert the discount with a tolerance
            assertEquals(actualDiscount, totalDiscount, 0.2); // Adjust the tolerance as needed
      }
      else {
            System.out.println("The expected discount text was not found.");
      }

    }

    public void getShipping() {
        String shippingTotalRaw = driver.findElement(By.cssSelector("ul#shipping_method  label")).getText();
        shippingTotalRaw = shippingTotalRaw.substring(12); // Start the shipping total after Flat rate: £
        double shippingTotal = parseDouble(shippingTotalRaw);
        double expectedShippingTotal = 3.95;
        System.out.println("Shipping Total Raw " + shippingTotal);
        assertEquals(expectedShippingTotal, shippingTotal, 0.1);
        System.out.println("Shipping Total is accurate");
    }
}
