package HuongTT46_Assignment9.pages.Rawal;

import HuongTT46_Assignment9.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RawalMenuPage  extends BasePage {
    public RawalMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()= 'Catalog']/..")
    private WebElement catalog;

    @FindBy(xpath = "//span[text()='Product Units']")
    private WebElement productUnits;

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement products;

    @FindBy(xpath = "//span[text()='Add Product']")
    private WebElement addProducts;



    public boolean verifyLoginSuccessfully(){
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(catalog)).isDisplayed();
    }

    public void clickToCatalog()  {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", catalog);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", catalog);

    }
    public void clickToProducts(){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getWebDriverWait().until(ExpectedConditions.visibilityOf(products)));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",products);

    }

    public void clickToAddProducts(){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getWebDriverWait().until(ExpectedConditions.visibilityOf(addProducts)));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", addProducts);

    }

}
