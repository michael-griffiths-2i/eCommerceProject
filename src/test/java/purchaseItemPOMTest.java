import POMpages.*;
import org.junit.jupiter.api.Test;
import utilities.TestBase;


public class purchaseItemPOMTest extends TestBase {


    void firstTest() {
        //could go into before each
        driver.get(baseUrl);
        System.out.println("Driver has got baseUrl");
        HomepagePOM home = new HomepagePOM(driver);
        System.out.println("Instance home of Homepage POM created");
        home.dismissWarning();
        System.out.println("Demo store warning dismissed");
        home.shopLink();
        System.out.println("Shop has been opened");
        home.addProductToCart();
        System.out.println("Beanie has been added to cart");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //added in the sleep to allow the item to be added
        home.viewCartLink();
        System.out.println("Viewing cart");

        //applying coupon

        cartPOM cart = new cartPOM(driver);

        cart.couponBox();
        System.out.println("coupon box has been found");

        cart.applyCouponBtn();
        System.out.println("apply coupon button clicked");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cart.couponPresent();
        System.out.println("coupon applied correctly");
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

            check.openPage();
            System.out.println("First Name Entered");
            check.billingFirstNameCheck();
            System.out.println("First Name Entered");
            check.billingLastName();
            System.out.println("Last Name Entered");
            check.billingCountry();
            System.out.println("Billing Country chosen");
            check.billingAddress1();
            System.out.println("Billing Address 1 entered");
            check.billingCity();
            System.out.println("Billing City Entered");
            check.billingPhone();
            System.out.println("Billing Phone Entered");
            check.billingPostcode();
            System.out.println("Billing Postcode Entered");
            check.emailAddress();
            System.out.println("Email address entered");
            check.placeOrder();
            System.out.println("Place Order");
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
            cart.checkOrderNumber();














    }
}




