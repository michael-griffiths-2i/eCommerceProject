import POMpages.HomepagePOM;
import POMpages.cartPOM;
import org.junit.jupiter.api.Test;
import utilities.TestBase;


public class purchaseItemPOMTest extends TestBase {

        @Test
        void test(){
            driver.get(baseUrl);
            System.out.println("Driver has got baseUrl");
            HomepagePOM home = new HomepagePOM(driver);
            System.out.println("Instance home of Homepage POM created");
            home.dismissWarning();
            System.out.println("Demo store warning dismissed");
            home.shopLink();
            System.out.println("Shop has been opened");
            home.addBeanieToCart();
            System.out.println("Beanie has been added to cart");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //added in the sleep to allow the item to be added
            home.viewCartLink();
            System.out.println("Viewing cart");

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


        }

    }

