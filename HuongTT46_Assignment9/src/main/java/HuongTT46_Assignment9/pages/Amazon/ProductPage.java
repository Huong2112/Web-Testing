package HuongTT46_Assignment9.pages.Amazon;

import HuongTT46_Assignment9.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.SQLOutput;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "productTitle")
    private WebElement productTitle;

    public boolean verifyProductTile(String expectedTitle){
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(productTitle)).getText().trim().equals(expectedTitle.trim());
    }
}
