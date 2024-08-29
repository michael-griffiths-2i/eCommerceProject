import POMpages.*;
import org.junit.jupiter.api.Test;


public class purchaseItemPOMTest extends TestBase {

    @Test
    void firstTest() {
        /**
         * Initializes the HomePage and performs a series of actions.
         * @param driver WebDriver instance
         */
        home = new HomePage(driver);
        home.clickDismissDemoWarning();
        home.clickShopLink();
        home.addProductToCart();
        home.checkPrice();
        home.clickViewCartLink();

        /**
         * Initializes the HomePage and performs a series of actions.
         * @param driver WebDriver instance
         */
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

    @Test
    void secondTest() {

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
            //cart.getOrderNumber();
            received.clickOnAccount();
            received.clickOnOrders();
            String orderNumber = received.checkOrderNumber();
            received.clickOnAccount();
            received.clickOnOrders();
            received.compareOrderNumbers(orderNumber);
            received.clickOnAccount();

    }
}




