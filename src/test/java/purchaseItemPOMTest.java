import POMpages.*;
import org.junit.jupiter.api.Test;


public class purchaseItemPOMTest extends TestBase {

    private HomePage home;
    private CartPage cart;
    private launchCheckoutPage check;
    private LoginPage login;
    private OrderPage received;
    @Test
    void firstTest() {


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
        login.emailBox();
        login.passwordBox();
        login.logIn();


    }

    @Test
    void secondTest() {

            /* logging in */
            login = new LoginPage(driver);
            login.myAccountLink();
            login.emailBox();
            login.passwordBox();
            login.logIn();

            home = new HomePage(driver);
            home.clickDismissDemoWarning();
            home.clickShopLink();
            home.addProductToCart();

            //click on checkout
            check = new launchCheckoutPage(driver);
            check.clickCart();


            //start of checkout
            check.clickCheckoutLink();
            check.enterFirstName();
            check.enterLastName();
            check.chooseBillingCountry();
            check.enterBillingAddress();
            check.enterBillingCity();
            check.enterPhoneNumber();
            check.enterPostcode();
            check.enterEmail();
            check.placeOrder();
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




