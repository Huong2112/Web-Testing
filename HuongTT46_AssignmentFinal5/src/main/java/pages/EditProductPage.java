package pages;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EditProductPage extends BasePage {
    public EditProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='s2id_type']/preceding-sibling::label")
    private WebElement productTypeLabel;

    @FindBy(xpath = "//div[@id='s2id_type']")
    private WebElement productTypeBox;

    @FindBy(xpath = "//input[@name='name']/preceding-sibling::label")
    private WebElement productNameLabel;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement productNameBox;

    @FindBy(xpath = "//input[@name='code']/preceding-sibling::label")
    private WebElement productCodeLabel;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement productCodeBox;

    @FindBy(xpath = "//input[@name='slug']/preceding-sibling::label")
    private WebElement slugLabel;

    @FindBy(xpath = "//input[@name='slug']")
    private WebElement slugBox;

    @FindBy(xpath = "//div[@id='s2id_barcode_symbology']/preceding-sibling::label")
    private WebElement barcodeSymbologyLabel;

    @FindBy(xpath = "//div[@id='s2id_barcode_symbology']")
    private WebElement barcodeSymbologyBox;


    @FindBy(xpath = "//ul[@id='select2-results-5']/li")
    private List<WebElement> selectType;

    @FindBy(xpath = "//input[@id='s2id_autogen6_search']")
    private WebElement inputBarCode;

    @FindBy(xpath = "//div[@id='s2id_tax_method']")
    private WebElement taxMethodBox;
    @FindBy(xpath = "//li[contains(@class,'select2-result-selectable')]")
    private List<WebElement> methodOptions;

    @FindBy(name = "edit_product")
    private WebElement editBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger']/descendant::p")
    private WebElement failMessage;


    public boolean verifyEditPageDisplay(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productTypeBox));
        return productTypeLabel.isDisplayed() && productTypeBox.isDisplayed()
                && productNameLabel.isDisplayed() && productNameBox.isDisplayed()
                && productCodeLabel.isDisplayed() && productCodeBox.isDisplayed()
                && slugLabel.isDisplayed() && slugBox.isDisplayed()
                && barcodeSymbologyBox.isDisplayed() && barcodeSymbologyBox.isDisplayed();


    }
    public void editProduct(String type, String barcode, String taxMethod){
        productTypeBox.click();
        for (WebElement t : selectType){
            if (t.getText().trim().equals(type.trim())){
                t.click();
                break;
            }
        }
        barcodeSymbologyBox.click();
        inputBarCode.sendKeys(barcode);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();
        taxMethodBox.click();
        for (WebElement method : methodOptions){
            if (method.getText().trim().equals(taxMethod.trim())){
                method.click();
                break;
            }
        }
    }

    public boolean verifyMessage(String expectedMessage){
        try {
            getWebDriverWait().until(ExpectedConditions.visibilityOf(failMessage));
            return  failMessage.getText().trim().equals(expectedMessage.trim());
        }catch (Exception e) {
            System.out.println("Cannot edit this product!");
            return false;
        }

    }
}
