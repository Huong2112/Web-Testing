package pages;

import core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//img[@id='pr-image']")
    private WebElement productImage;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=2]/td[position()=1]")
    private WebElement BarQrCodeText;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=2]/td[position()=2]/img[position()=1]")
    private WebElement barCodeImage;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=2]/td[position()=2]/img[position()=2]")
    private WebElement qrCodeImage;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=3]/td[position()=2]")
    private WebElement type;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=4]/td[position()=2]")
    private WebElement productName;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=5]/td[position()=2]")
    private WebElement code;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=7]/td[position()=2]")
    private WebElement category;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=8]/td[position()=2]")
    private WebElement unit;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=9]/td[position()=2]")
    private WebElement cost;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=10]/td[position()=2]")
    private WebElement price;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=11]/td[position()=2]")
    private WebElement taxRate;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=12]/td[position()=2]")
    private WebElement taxMethod;

    @FindBy(xpath = "//table[contains(@class,'table-right-left')]/tbody/tr[position()=13]/td[position()=2]")
    private WebElement alertQuantity;

    @FindBy(xpath = "//div[text()='Product Details']/following-sibling::div")
    private WebElement productDetails;

    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeButton;

    @FindBy(xpath = "//span[text()='Edit']")
    private WebElement editBtn;

    public boolean verifyProductDetail(String expType, String expName, String expCode,
                                       String expCategories, String expUnit, String expCost,
                                       String expPrice, String expTaxRate, String expTaxMethod,
                                       String expAlert, String expProductDetails){

      Assert.assertEquals(type.getText(), expType);
        Assert.assertEquals(productName.getText().trim(),(expName.trim()));
        Assert.assertEquals(code.getText(), expCode);
        Assert.assertEquals(category.getText(), expCategories);
        Assert.assertEquals(unit.getText(), expUnit);
        Assert.assertEquals(cost.getText(), expCost);
        Assert.assertEquals(price.getText(),expPrice);
        Assert.assertEquals(taxRate.getText(), expTaxRate);
        Assert.assertEquals(taxMethod.getText(), expTaxMethod);
        Assert.assertEquals(alertQuantity.getText(), expAlert);
        Assert.assertEquals(productDetails.getText(), expProductDetails);








        return getWebDriverWait().until(ExpectedConditions.visibilityOf(productImage)).isDisplayed()
                && qrCodeImage.isDisplayed()
                && getWebDriverWait().until(ExpectedConditions.visibilityOf(barCodeImage)).isDisplayed()
                && type.getText().trim().equals(expType.trim())
                && productName.getText().trim().equals(expName.trim())
                && code.getText().trim().equals(expCode.trim())
                && category.getText().trim().equals(expCategories.trim())
                && unit.getText().trim().equals(expUnit.trim())
                && cost.getText().trim().equals(expCost.trim())
                && price.getText().trim().equals(expPrice.trim())
                && taxRate.getText().trim().equals(expTaxRate.trim())
                && taxMethod.getText().trim().equals(expTaxMethod.trim())
                && alertQuantity.getText().trim().equals(expAlert.trim())
                && productDetails.getText().trim().equals(expProductDetails.trim());



    }
    public void clickToCloseDetailsPage(){
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", closeButton);
        jse.executeScript("arguments[0].click();", closeButton);
    }

    public void clickToEditButton(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(editBtn)).click();
    }



}
