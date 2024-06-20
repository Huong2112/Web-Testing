package pages;


import core.BasePage;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddSalePage extends BasePage {
    public AddSalePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='s2id_slcustomer']")
    private WebElement customer;

    @FindBy(xpath = "//input[@id='s2id_autogen12_search']")
    private WebElement customerInput;
    @FindBy(id = "add_item")
    private WebElement inputProduct;

    @FindBy(xpath = "//input[@id='add_sale']")
    private WebElement submitBtn;

    @FindBy(xpath = "//ul[@id='select2-results-12']/descendant::li")
    private WebElement firstCustomer;

    public void addSale(String inputCustomer, String inputProductName) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("javascript:window.scrollBy(0,-250)");
        Thread.sleep(1000);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(customer)).click();
        customerInput.sendKeys(inputCustomer);
        Thread.sleep(1000);
        firstCustomer.click();
        Thread.sleep(500);
        inputProduct.sendKeys(inputProductName);
        Thread.sleep(1000);

       // js.executeScript("javascript:window.scrollBy(0,200)");
        //js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
       // getWebDriverWait().until(ExpectedConditions.visibilityOf(submitBtn)).click();
        submitBtn.click();
    }

}
