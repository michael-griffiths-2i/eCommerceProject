import POMpages.*;
import org.junit.jupiter.api.Test;
import utilities.TestBase;


public class purchaseItemPOMTest extends TestBase {

    private HomepagePOM home;
    private cartPOM cart;
    private checkoutPOM check;
    private loginPOM login;
    private receivedPOM received;
    @Test
    void firstTest() {


        home = new HomepagePOM(driver);
        home.dismissWarning();
        home.shopLink();
        home.addProductToCart();
        home.clickViewCartLink(driver);
        cart = new cartPOM(driver);
        cart.couponBox();
        cart.applyCouponBtn();
        cart.couponPresent();
        cart.getPrice();
        cart.getShipping();

        login = new loginPOM(driver);
        login.myAccountLink();
        login.emailBox();
        login.passwordBox();
        login.logIn();


    }

    @Test
    void secondTest() {

            /* logging in */
            login = new loginPOM(driver);
            login.myAccountLink();
            login.emailBox();
            login.passwordBox();
            login.logIn();

            home = new HomepagePOM(driver);
            home.dismissWarning();
            home.shopLink();
            home.addProductToCart();

            //click on checkout
            check = new checkoutPOM(driver);
            check.clickCart();


            //start of checkout
            check.openPage();
            check.billingFirstNameCheck();
            check.billingLastName();
            check.billingCountry();
            check.billingAddress1();
            check.billingCity();
            check.billingPhone();
            check.billingPostcode();
            check.emailAddress();
            check.placeOrder();
            //end of checkout

            //start of order received
            received= new receivedPOM(driver);


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




