package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class checkoutPOM {
    WebDriver driver;

    public checkoutPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }


    @FindBy(id = "menu-item-44")
    WebElement cartLink;
    public void clickCart() {
        cartLink.click();
    }


    @FindBy(linkText = "Checkout")
    WebElement checkoutLink;
    public void openPage() {

        checkoutLink.click();
        System.out.println("First Name Entered");
    }

    @FindBy(id = "billing_first_name")
    WebElement firstNameBox;
    public void billingFirstNameCheck() {
        firstNameBox.click();
        firstNameBox.clear();
        firstNameBox.sendKeys("Mickey");
        System.out.println("First Name Entered");
    }


    @FindBy(id = "billing_last_name")
    WebElement lastNameBox;
    public void billingLastName() {

        lastNameBox.click();
        lastNameBox.clear();
        lastNameBox.sendKeys("Mouse");
        System.out.println("Last Name Entered");
    }

    @FindBy(id = "select2-billing_country-container")
    WebElement billingCountry;
    public void billingCountry() {

        billingCountry.click();
        System.out.println("Billing Country chosen");
    }

    @FindBy(id = "billing_address_1")
    WebElement billingAddressBox;
    public void billingAddress1() {
        billingAddressBox.click();
        billingAddressBox.clear();
        billingAddressBox.sendKeys("123 Main Road");
        System.out.println("Billing Address 1 entered");
    }

    @FindBy(id = "billing_city")
    WebElement billingCityBox;
    public void billingCity() {
        billingCityBox.click();
        billingCityBox.clear();
        billingCityBox.sendKeys("Glasgow");
        System.out.println("Billing City Entered");
    }
    @FindBy(id = "billing_phone")
    WebElement billingPhoneBox;
    public void billingPhone() {
        billingPhoneBox.click();
        billingPhoneBox.clear();
        billingPhoneBox.sendKeys("0141 432 1234");
        System.out.println("Billing Phone Entered");

    }

    @FindBy(id = "billing_postcode")
    WebElement billingPostcode;
    public void billingPostcode() {
        billingPostcode.click();
        billingPostcode.clear();
        billingPostcode.sendKeys("G11 3XY");
        System.out.println("Billing Postcode Entered");
    }

    @FindBy(id = "billing_email")
    WebElement emailBox;
    public void emailAddress() {
        emailBox.click();
        emailBox.clear();
        emailBox.sendKeys("mickeymouse@hotmail.com");
        System.out.println("Email address entered");
    }

    @FindBy(id = "place_order")
    WebElement placeOrderBtn;
    public void placeOrder() {
        placeOrderBtn.click();
        System.out.println("Place Order");

    }


}
