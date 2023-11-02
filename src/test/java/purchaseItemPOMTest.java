import POMpages.*;
import org.junit.jupiter.api.Test;
import utilities.TestBase;


public class purchaseItemPOMTest extends TestBase {


    void firstTest() {
        //could go into before each
        driver.get(baseUrl);
        HomepagePOM home = new HomepagePOM(driver);
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

        cartPOM cart = new cartPOM(driver);

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

        loginPOM login = new loginPOM(driver);
        login.myAccountLink();
        login.emailBox();
        login.passwordBox();
        login.logIn();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        login.logout();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

        @Test
    void secondTest() {
        // Your second test code here
            driver.get(baseUrl);
            System.out.println("Driver has got baseUrl");
            HomepagePOM home = new HomepagePOM(driver);
            System.out.println("Instance home of Homepage POM created");
            home.dismissWarning();
            System.out.println("Demo store warning dismissed");

            /* logging in */

            loginPOM login = new loginPOM(driver);
            login.myAccountLink();
            login.emailBox();
            login.passwordBox();
            login.logIn();

            home.shopLink();
            System.out.println("Shop has been opened");

            home.addProductToCart();
            System.out.println("Beanie has been added to cart");

            //click on checkout
            checkoutPOM check = new checkoutPOM(driver);
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
            receivedPOM cart= new receivedPOM(driver);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }

            //cart.getOrderNumber();
            cart.clickOnAccount();
            cart.clickOnOrders();
            String orderNumber = cart.checkOrderNumber();
            cart.clickOnAccount();
            cart.clickOnOrders();
            cart.compareOrderNumbers(orderNumber);














    }
}




