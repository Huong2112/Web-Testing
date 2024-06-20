package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListSalesPage extends BasePage {
    public ListSalesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement message;

    public boolean verifyAddSaleSuccessfully(String expMessage){
        return  getWebDriverWait().until(ExpectedConditions.visibilityOf(message)).getText().trim().equals(expMessage.trim());
    }
}

