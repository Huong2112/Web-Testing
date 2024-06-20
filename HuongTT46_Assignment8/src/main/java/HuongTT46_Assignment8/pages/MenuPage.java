package HuongTT46_Assignment8.pages;

import Demo.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
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

    public void clickToProductUnit(){

        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getWebDriverWait().until(ExpectedConditions.visibilityOf(productUnits)));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", productUnits);
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
