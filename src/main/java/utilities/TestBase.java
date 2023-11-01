package utilities;

import POMpages.HomepagePOM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
    //set up the WebDriver which should be protected (requires org.openqa.selenium.WebDriver);
    protected WebDriver driver;
    //set up the baseUrl which should be protected
    protected String baseUrl ="https://www.edgewordstraining.co.uk/demo-site";

    //setUp BeforeEach (requires org.junit.jupiter.api.*)
    @BeforeEach
    void setUp(){

        driver = new ChromeDriver();


    }

    //setUp AfterEach (requires org.junit.jupiter.api.*)
    @AfterEach
    void tearDown(){

        driver.quit();
    }
}
