package pages;

import core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPurchasePage extends BasePage {
    public AddPurchasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='s2id_posupplier']")
    private WebElement supplier;

    @FindBy(xpath = "//input[@id='s2id_autogen8_search']")
    private WebElement supplierInput;

    @FindBy(xpath = "//ul[@id='select2-results-8']/descendant::li")
    private WebElement firstSupplier;

    @FindBy(xpath = "//input[@name='add_item']")
    private WebElement addProductInput;

    @FindBy(xpath = "//div[@class='from-group']/descendant::input")
    private WebElement submitButton;


    public void addPurchase(String supInput, String productInput) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("javascript:window.scrollBy(0,-100)");
        Thread.sleep(500);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(supplier)).click();
       supplierInput.sendKeys(supInput);
       Thread.sleep(1000);
       firstSupplier.click();

        addProductInput.sendKeys(productInput);
        Thread.sleep(2000);
        //js.executeScript("javascript:window.scrollBy(0,180)");
        //js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        //getWebDriverWait().until(ExpectedConditions.visibilityOf(submitButton)).click();
        submitButton.click();
    }


}
