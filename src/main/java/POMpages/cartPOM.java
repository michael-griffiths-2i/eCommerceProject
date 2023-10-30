package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.sql.SQLOutput;

import static java.lang.Double.parseDouble;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void getPrice(){
        String totalRaw = driver.findElement(By.cssSelector(".cart-subtotal > td > .amount.woocommerce-Price-amount > bdi")).getText();
        totalRaw = totalRaw.substring(1); //create substring totalRaw removing the first character
        double total=parseDouble(totalRaw);
        getDiscount(total);

    }

    public void getDiscount(double totalPrice){
        String totalDiscountRaw = driver.findElement(By.cssSelector(".cart-discount.coupon-edgewords > td > .amount.woocommerce-Price-amount")).getText();
        totalDiscountRaw =totalDiscountRaw.substring(1); //create substring of discount removing the minus and currency
        double totalDiscount =parseDouble(totalDiscountRaw);
        System.out.println("Total Discount"+ totalDiscount);
        //work out discount based on Price
        double actualDiscount = totalPrice*0.15;
        assertEquals(actualDiscount, totalDiscount,0.2); // Adjust the tolerance as needed


    }



    //check shipping
    public void getShipping(){
        String shippingTotalRaw = driver.findElement(By.cssSelector("ul#shipping_method  label")).getText();
        shippingTotalRaw = shippingTotalRaw.substring(12);//start the shipping total after Flat rate: £
        double shippingTotal = parseDouble(shippingTotalRaw);
        double expectedShippingTotal =3.95;
        System.out.println("Shipping Total Raw "+shippingTotal);

        assertEquals(expectedShippingTotal,shippingTotal,0.1);
        System.out.println("Shipping Total is accurate");
    }




}
