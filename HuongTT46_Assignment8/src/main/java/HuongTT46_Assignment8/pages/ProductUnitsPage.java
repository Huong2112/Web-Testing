package HuongTT46_Assignment8.pages;

import Demo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductUnitsPage extends BasePage {
    public ProductUnitsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//table[@id='productUnitTable']/tbody/tr")
    private List<WebElement> rows;

    public boolean verifyDisplayAtLeast2RowsData(){
        return getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(rows)).size() >= 2;
    }
}
