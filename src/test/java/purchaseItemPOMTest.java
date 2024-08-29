import POMpages.*;
import org.junit.jupiter.api.Test;

/**
 * This class contains test cases for purchasing items using the Page Object Model (POM).
 */
public class purchaseItemPOMTest extends TestBase {

    /**
     * Test case for buying a beanie and signing up.
     */
    @Test
    void buyABeanie() {

        home = new HomePage(driver);
        home.clickDismissDemoWarning();
        home.clickShopLink();
        home.addProductToCart();
        home.checkPrice();
        home.clickViewCartLink();

        cart = new CartPage(driver);
        cart.couponBox();
        cart.applyCouponBtn();
        cart.getPrice();
        cart.getShipping();

        login = new LoginPage(driver);
        login.myAccountLink();
        login.emailBox(EMAIL_ADDRESS);
        login.passwordBox();
        login.logIn();
    }

    /**
     * Test case for buying a beanie and signing up.
     */
    @Test
    void buyABeanieAndSignUp() {

            /* logging in */
            login = new LoginPage(driver);
            login.myAccountLink();
            login.emailBox(EMAIL_ADDRESS);
            login.passwordBox();
            login.logIn();

            home = new HomePage(driver);
            home.clickDismissDemoWarning();
            home.clickShopLink();
            home.addProductToCart();

            checkOut = new CheckoutPage(driver);
            checkOut.clickCart();
            //start of checkout
            checkOut.clickCheckoutLink();
            checkOut.enterFirstName(FIRST_NAME);
            checkOut.enterLastName(LAST_NAME);
            checkOut.chooseBillingCountry();
            checkOut.enterBillingAddress(BILLING_ADDRESS);
            checkOut.enterBillingCity(CITY);
            checkOut.enterPhoneNumber(PHONE_NUMBER);
            checkOut.enterPostcode(POSTCODE);
            checkOut.enterEmail(EMAIL_ADDRESS);
            checkOut.placeOrder();
            //end of checkout

            //start of order received
            received= new OrderPage(driver);
            received.clickOnAccount();
            received.clickOnOrders();
            received.clickOnAccount();
            received.clickOnOrders();
            String orderNumber = received.checkOrderNumber();
            received.compareOrderNumbers(orderNumber);
            received.clickOnAccount();

    }
}




