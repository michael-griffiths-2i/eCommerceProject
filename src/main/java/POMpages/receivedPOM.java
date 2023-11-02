package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class receivedPOM {
    WebDriver driver;

    //constructor
    public receivedPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //stop forgetting this!!!
    }

    public void getOrderNumber() {
        String order = driver.findElement(By.cssSelector(".beta site-title")).getText();

        System.out.println(order);
        //store the orderNumber
    }

    @FindBy(linkText="My account")
    WebElement accountLink;
    public void clickOnAccount() {
        accountLink.click();
    }
    @FindBy(linkText="Orders")
    WebElement ordersLink;
    public void clickOnOrders() {
        ordersLink.click();
    }

    @FindBy(css = ".woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-number > a")
    WebElement orderListNumber;
    public String checkOrderNumber() {
        String orderNumber = orderListNumber.getText().substring(1);
        System.out.println("Order Number: " + orderNumber);
        return orderNumber;
    }
    @FindBy(css ="tr:nth-of-type(1) > .woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-number > a")
    WebElement myOrdersOrderNumber;
    public void compareOrderNumbers(String orderNumber){
        String finalOrderRaw = myOrdersOrderNumber.getText();
        String finalOrder= finalOrderRaw.substring(1);
        System.out.println(orderNumber);
        System.out.println(finalOrder);
        assertEquals(orderNumber, finalOrder);

    }

    //logout




}
