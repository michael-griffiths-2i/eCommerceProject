package utilities;

import POMpages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class TestBase {
    private HomepagePOM home;
    private loginPOM login;
    private checkoutPOM checkout;
    private receivedPOM received;
    private cartPOM cart;



    //set up the WebDriver which should be protected (requires org.openqa.selenium.WebDriver);
    protected WebDriver driver;
    //set up the baseUrl which should be protected
    protected String baseUrl ="https://www.edgewordstraining.co.uk/demo-site";

    //setUp BeforeEach (requires org.junit.jupiter.api.*)
    @BeforeEach
    void setUp(){

        driver = new ChromeDriver();
        driver.get(baseUrl);

        home = new HomepagePOM(driver);
        login = new loginPOM(driver);
        checkout = new checkoutPOM(driver);
        cart = new cartPOM(driver);
        received = new receivedPOM(driver);





    }

    //setUp AfterEach (requires org.junit.jupiter.api.*)
    @AfterEach
    void tearDown(){
        //received.logOut();
        driver.quit();
    }
}
