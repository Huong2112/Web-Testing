package Demo.pages;

import Demo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerListPage extends BasePage {

    public CustomerListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add")
    private WebElement addNewCustomer;

    @FindBy(xpath = "//div[@data-ui-id = 'messages-message-success']")
    private WebElement message;

    public void clickToAddNewCustomer(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addNewCustomer)).click();
    }

    public boolean verifyMessage(String expected){
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(message)).getText().trim().equals(expected);
    }


}
