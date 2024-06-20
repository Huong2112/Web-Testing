package pages;

import core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()= ' Products ']")
    @CacheLookup
    private WebElement products;

    @FindBy(xpath = "//span[text()=' List Products']")
    private WebElement listProducts;

    @FindBy(xpath = "//span[text()=' Print Barcode/Label']")
    private WebElement printBarCodeLabel;


    @FindBy(xpath = "//span[contains(text(),'Welcome')]")
    private WebElement accountWelcome;

    @FindBy(xpath = "//i[@class='fa fa-sign-out']/parent::a[contains(@href,'logout')]")
    private WebElement logout;

    @FindBy(xpath = "//span[normalize-space()='Sales']")
    private WebElement sale;

    @FindBy(xpath = "//span[text()=' Add Sale']")
    private WebElement addSale;

    @FindBy(xpath = "//span[normalize-space()='Purchases']")
    @CacheLookup
    private WebElement purchase;

    @FindBy(xpath = "//span[normalize-space()='List Purchases']")
    private WebElement listPurchase;

    @FindBy(xpath = "//span[normalize-space()='Add Purchase']")
    private WebElement addPurchase;



    public void clickToProducts() throws InterruptedException {
        Thread.sleep(500);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(products)).click();
    }

    public void clickToListProduct(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(listProducts)).click();
    }

    public void clickToPrintBarCodeLabel(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(printBarCodeLabel)).click();
    }

    public void logOut() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(accountWelcome)).click();

        logout.click();
    }

    public void clickToSales(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(sale)).click();
    }
    public void clickToAddSale(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addSale)).click();
    }

    public void clickToPurchase(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(purchase)).click();
    }

    public void clickToListPurchase(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(listPurchase)).click();
    }

    public void clickToAddPurchase(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addPurchase)).click();
    }
}
