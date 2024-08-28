import POMpages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
    protected HomePage home;
    protected LoginPage login;
    protected LaunchCheckoutPage checkOut;
    protected OrderPage received;
    protected CartPage cart;

    //set up the WebDriver which should be protected (requires org.openqa.selenium.WebDriver);
    protected WebDriver driver;
    //set up the baseUrl which should be protected
    protected String baseUrl ="https://www.edgewordstraining.co.uk/demo-site";

    @BeforeEach
    void setUp(){
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        home = new HomePage(driver);
        login = new LoginPage(driver);
        checkOut = new LaunchCheckoutPage(driver);
        cart = new CartPage(driver);
        received = new OrderPage(driver);
    }

    //setUp AfterEach (requires org.junit.jupiter.api.*)
    @AfterEach
    void tearDown(){
        //received.logOut();
        driver.quit();
    }
}
