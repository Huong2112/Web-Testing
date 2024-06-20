package Demo.pages;

import Demo.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerPage extends BasePage {
    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "customer[firstname]")
    private WebElement firstname;
    @FindBy(name = "customer[lastname]")
    private WebElement lastname;
    @FindBy(name = "customer[email]")
    private WebElement email;
    @FindBy(id = "save")
    private WebElement saveBtn;

    public void createNewCustomer(String f, String l, String e) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(firstname)).sendKeys(f);
        lastname.sendKeys(l);
        email.sendKeys(e);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", saveBtn);
    }

    }
