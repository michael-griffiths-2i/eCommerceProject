package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {

    @FindBy(id = "billing_postcode")                    WebElement billingPostcode;
    @FindBy(id = "menu-item-44")                        WebElement cartLink;
    @FindBy(id = "billing_first_name")                  WebElement firstNameBox;
    @FindBy(id = "billing_last_name")                   WebElement lastNameBox;
    @FindBy(id = "select2-billing_country-container")   WebElement billingCountry;
    @FindBy(id = "billing_address_1")                   WebElement billingAddressBox;
    @FindBy(id = "billing_city")                        WebElement billingCityBox;
    @FindBy(id = "billing_phone")                       WebElement billingPhoneBox;

    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }

    public void clickCart() {
        cartLink.click();
    }

    public void clickCheckoutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           WebElement checkoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Checkout")));
        checkoutLink.click();
        System.out.println("First Name Entered");
    }

    public void enterFirstName(String firstName) {
        firstNameBox.click();
        firstNameBox.clear();
        firstNameBox.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameBox.click();
        lastNameBox.clear();
        lastNameBox.sendKeys(lastName);
        System.out.println("Last Name Entered");
    }

    public void chooseBillingCountry() {
        billingCountry.click();
        System.out.println("Billing Country chosen");
    }

    public void enterBillingAddress(String emailAddress) {
        billingAddressBox.click();
        billingAddressBox.clear();
        billingAddressBox.sendKeys(emailAddress);
        System.out.println("Billing Address 1 entered");
    }

    public void enterBillingCity(String city) {
        billingCityBox.click();
        billingCityBox.clear();
        billingCityBox.sendKeys(city);
        System.out.println("Billing City Entered");
    }

    public void enterPhoneNumber(String phone_number) {
        billingPhoneBox.click();
        billingPhoneBox.clear();
        billingPhoneBox.sendKeys(phone_number);
        System.out.println("Billing Phone Entered");
    }

    public void enterPostcode(String postcode) {
        billingPostcode.click();
        billingPostcode.clear();
        billingPostcode.sendKeys(postcode);
        System.out.println("Billing Postcode Entered");
    }

    public void enterEmail(String emailAddress) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //had to add this to stop the JQuery overlay blocking the button. The button being present wasn't enough.
        WebElement emailBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("billing_email")));
        emailBox.click();
        emailBox.clear();
        emailBox.sendKeys(emailAddress);
        System.out.println("Email address entered");
    }

    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //had to add this to stop the JQuery overlay blocking the button. The button being present wasn't enough.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockOverlay")));
        WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order")));
        System.out.println("waiting to be clickable");
        placeOrderBtn.click();
        System.out.println("Place Order");
    }
}
