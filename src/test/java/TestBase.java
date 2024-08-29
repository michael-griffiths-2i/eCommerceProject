import POMpages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
    /**
     * Make these instances of the class protected for encapsulation
     * Encapsulation : hiding the details hiding the internal details and only exposing necessary parts.
    */
    protected HomePage home;
    protected LoginPage login;
    protected CheckoutPage checkOut;
    protected OrderPage received;
    protected CartPage cart;
    protected WebDriver driver;
    protected String baseUrl ="https://www.edgewordstraining.co.uk/demo-site";

    protected String EMAIL_ADDRESS  =   "something@gmail.com";
    protected String FIRST_NAME     =   "Mickey";
    protected String LAST_NAME      =   "Mouse";
    protected String BILLING_ADDRESS=   "1 High Street";
    protected String CITY           =   "Glasgow";
    protected String POSTCODE       =   "G64 1AA";
    protected String PHONE_NUMBER   =   "0141 772 7720";


    @BeforeEach
    void setUp(){

        driver      =   new FirefoxDriver();
        driver.get(baseUrl);
        home        =   new HomePage(driver);
        login       =   new LoginPage(driver);
        checkOut    =   new CheckoutPage(driver);
        cart        =   new CartPage(driver);
        received    =   new OrderPage(driver);
    }

    @AfterEach
    void tearDown(){
       //driver.quit();
    }
}
