package Demo.pages;

import Demo.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.jar.JarEntry;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "menu-magento-customer-customer")
    private WebElement menuCustomer;
    @FindBy(xpath = "//span[text()='All Customers']/..")
    private WebElement menuAllCustomer;

    public void clickToMenuCustomer(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(menuCustomer)).click();
    }
    public void clickToMenuAllCustomers(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(menuAllCustomer));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", menuAllCustomer);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", menuAllCustomer);
    }

}
