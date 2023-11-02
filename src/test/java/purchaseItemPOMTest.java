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

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //added in the sleep to allow the item to be added
        home.viewCartLink();

        //applying coupon

        cart = new cartPOM(driver);

        cart.couponBox();
        cart.applyCouponBtn();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cart.couponPresent();
        cart.getPrice();
        cart.getShipping();

        /* logging in */

        login = new loginPOM(driver);
        login.myAccountLink();
        login.emailBox();
        login.passwordBox();
        login.logIn();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
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
            System.out.println("Shop has been opened");

            home.addProductToCart();
            System.out.println("Beanie has been added to cart");

            //click on checkout
            check = new checkoutPOM(driver);
            check.clickCart();
            System.out.println("Cart has been opened");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }

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

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }

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




