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
    }

    @FindBy(id = "billing_first_name")
    WebElement firstNameBox;
    public void billingFirstNameCheck() {
        firstNameBox.click();
        firstNameBox.clear();
        firstNameBox.sendKeys("Mickey");
    }


    @FindBy(id = "billing_last_name")
    WebElement lastNameBox;
    public void billingLastName() {

        lastNameBox.click();
        lastNameBox.clear();
        lastNameBox.sendKeys("Mouse");
    }

    @FindBy(id = "select2-billing_country-container")
    WebElement billingCountry;
    public void billingCountry() {

        billingCountry.click();
    }

    @FindBy(id = "billing_address_1")
    WebElement billingAddressBox;
    public void billingAddress1() {
        billingAddressBox.click();
        billingAddressBox.clear();
        billingAddressBox.sendKeys("123 Main Road");
    }

    @FindBy(id = "billing_city")
    WebElement billingCityBox;
    public void billingCity() {
        billingCityBox.click();
        billingCityBox.clear();
        billingCityBox.sendKeys("Glasgow");
    }
    @FindBy(id = "billing_phone")
    WebElement billingPhoneBox;
    public void billingPhone() {
        billingPhoneBox.click();
        billingPhoneBox.clear();
        billingPhoneBox.sendKeys("0141 432 1234");

    }

    @FindBy(id = "billing_postcode")
    WebElement billingPostcode;
    public void billingPostcode() {
        billingPostcode.click();
        billingPostcode.clear();
        billingPostcode.sendKeys("G11 3XY");
    }

    @FindBy(id = "billing_email")
    WebElement emailBox;
    public void emailAddress() {
        emailBox.click();
        emailBox.clear();
        emailBox.sendKeys("mickeymouse@hotmail.com");
    }

    @FindBy(id = "place_order")
    WebElement placeOrderBtn;
    public void placeOrder() {
        placeOrderBtn.click();

    }


}
