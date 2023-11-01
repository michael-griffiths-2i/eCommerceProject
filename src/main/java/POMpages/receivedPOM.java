package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

    @FindBy(css="li.woocommerce-order-overview__order strong")
    WebElement orderListNumber;
    public void checkOrderNumber() {
    }


    //            tag=woocommerce-order-overview__order order
    //            My Account
    //            Orders
    //            css =.woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-number > a


    //logout




}
