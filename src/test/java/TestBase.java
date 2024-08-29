import POMpages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

    protected String baseUrl;
    protected String EMAIL_ADDRESS;
    protected String FIRST_NAME;
    protected String LAST_NAME;
    protected String BILLING_ADDRESS;
    protected String CITY;
    protected String POSTCODE;
    protected String PHONE_NUMBER;

    @BeforeEach
    void setUp() throws IOException {
        Properties props = new Properties();
        FileInputStream fis= new FileInputStream("resources/config.properties");
        props.load(fis);
        baseUrl = props.getProperty("baseUrl");
        driver= new FirefoxDriver();
        driver.get(baseUrl);
        EMAIL_ADDRESS = props.getProperty("emailAddress");
        FIRST_NAME = props.getProperty("firstName");
        LAST_NAME = props.getProperty("lastName");
        BILLING_ADDRESS = props.getProperty("billingAddress");
        CITY = props.getProperty("city");
        POSTCODE = props.getProperty("postcode");
        PHONE_NUMBER = props.getProperty("phoneNumber");






    }

    @AfterEach
    void tearDown(){
       //driver.quit();
    }
}
