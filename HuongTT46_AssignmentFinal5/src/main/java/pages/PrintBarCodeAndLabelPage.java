package pages;

import core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class PrintBarCodeAndLabelPage extends BasePage {
    public PrintBarCodeAndLabelPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//label[text()='Add Product']")
    private WebElement addLabel;

    @FindBy(name = "add_item")
    private WebElement addBox;

    @FindBy(xpath = "//label[text()='Style']")
    private WebElement style;

    @FindBy(xpath = "//div[@id='s2id_style']")
    private WebElement styleCombobox;

    @FindBy(xpath = "//input[@id='s2id_autogen1_search']")
    private WebElement styleInput;

    @FindBy(xpath = "//span[text()='Print:']")
    private WebElement textPrint;

    @FindBy(xpath = "//input[@id='site_name']/parent::div")
    private WebElement siteNameValidate;

    @FindBy(xpath = "//input[@id='site_name']")
    private WebElement siteNameInput;
    @FindBy(xpath = "//label[text()='site name']")
    private WebElement siteName;


    @FindBy(xpath = "//input[@id='product_name']")
    private WebElement productNameInput;

    @FindBy(xpath = "//input[@id='product_name']/parent::div")
    private WebElement productNameValidate;
    @FindBy(xpath = "//label[text()='Product Name']")
    private WebElement productName;

    @FindBy(xpath = "//input[@id='price']/parent::div")
    private WebElement priceBoxValidate;
    @FindBy(xpath = "//input[@id='price']")
    private WebElement priceInput;
    @FindBy(xpath = "//label[text()='Price']")
    private WebElement price;


    @FindBy(xpath = "//input[@id='currencies']/parent::div")
    private WebElement currenciesBoxValidate;
    @FindBy(xpath = "//input[@id='currencies']")
    private WebElement currenciesInput;
    @FindBy(xpath = "//label[text()='Currencies']")
    private WebElement currencies;

    @FindBy(xpath = "//input[@id='unit']/parent::div")
    private WebElement unitBoxValidate;
    @FindBy(xpath = "//input[@id='unit']")
    private WebElement unitInput;

    @FindBy(xpath = "//label[text()='Unit']")
    private WebElement unit;

    @FindBy(xpath = "//input[@id='category']/parent::div")
    private WebElement categoryBoxValidate;

    @FindBy(xpath = "//input[@id='category']")
    private WebElement categoryInput;
    @FindBy(xpath = "//label[text()='Category']")
    private WebElement category;

    @FindBy(xpath = "//input[@id='variants']")
    private WebElement variantInput;

    @FindBy(xpath = "//input[@id='variants']/parent::div")
    private WebElement variantBoxValidate;
    @FindBy(xpath = "//label[text()='Variants']")
    private WebElement variants;

    @FindBy(xpath = "//input[@id='product_image']")
    private WebElement imageInput;

    @FindBy(xpath = "//input[@id='product_image']/parent::div")
    private WebElement imageCheckbox;
    @FindBy(xpath = "//label[text()='Product Image']")
    private WebElement productImage;

    @FindBy(xpath = "//input[@id='check_promo']")
    private WebElement promotionalPriceInput;

    @FindBy(xpath = "//input[@id='check_promo']/parent::div")
    private WebElement promotionalBoxValidate;
    @FindBy(xpath = "//label[text()='Check promotional price']")
    private WebElement promotionalPrice;

    @FindBy(name = "print")
    private WebElement updateButton;

    public boolean verifyPrintBarcodeAndLabelPage() throws InterruptedException {
        Thread.sleep(1000);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addLabel));

//        System.out.println(addLabel.isDisplayed());
//        System.out.println(addBox.isDisplayed());
//        System.out.println(style.isDisplayed());
//        System.out.println(styleCombobox.isDisplayed());
//        System.out.println(textPrint.isDisplayed());
//        System.out.println(verifyPrint());

        return addLabel.isDisplayed() && addBox.isDisplayed()
                && style.isDisplayed() && styleCombobox.isDisplayed()
                && textPrint.isDisplayed()
                && verifyPrint();


    }

    private boolean verifyPrint(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(siteName));

        System.out.println(siteName.isDisplayed());
        System.out.println(siteNameValidate.isDisplayed());//false
        System.out.println(productName.isDisplayed());
        System.out.println(productNameValidate.isDisplayed());//false
        System.out.println(price.isDisplayed());
        System.out.println(priceBoxValidate.isDisplayed());//false
        System.out.println(currencies.isDisplayed());
        System.out.println(currenciesBoxValidate.isDisplayed());
        System.out.println(unit.isDisplayed());
        System.out.println(unitBoxValidate.isDisplayed());
        System.out.println(category.isDisplayed());
        System.out.println(categoryBoxValidate.isDisplayed());
        System.out.println(variants.isDisplayed());
        System.out.println(variantBoxValidate.isDisplayed());
        System.out.println(productImage.isDisplayed());
        System.out.println(imageCheckbox.isDisplayed());
        System.out.println(promotionalPrice.isDisplayed());
        System.out.println( promotionalBoxValidate.isDisplayed());



        return siteName.isDisplayed() && siteNameValidate.isDisplayed()
                && productName.isDisplayed() && productNameValidate.isDisplayed()
                && price.isDisplayed() && priceBoxValidate.isDisplayed()
                && currencies.isDisplayed() && currenciesBoxValidate.isDisplayed()
                && unit.isDisplayed() && unitBoxValidate.isDisplayed()
                && category.isDisplayed() && categoryBoxValidate.isDisplayed()
                && variants.isDisplayed() && variantBoxValidate.isDisplayed()
                && productImage.isDisplayed() && imageCheckbox.isDisplayed()
                && promotionalPrice.isDisplayed() && promotionalBoxValidate.isDisplayed();
    }

    public void createBarCodeLabel(String pName, String pstyle) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addBox));
        addBox.sendKeys(pName);
        Thread.sleep(1000);
        styleCombobox.click();
        styleInput.sendKeys(pstyle);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();

        if (!siteNameInput.isSelected()){
            siteNameValidate.click();
        }
        if (!productNameInput.isSelected()){
            productNameValidate.click();
        }

        if (!priceInput.isSelected()){
            priceBoxValidate.click();
        }

        if (!currenciesInput.isSelected()){
            currenciesBoxValidate.click();
        }

        if (!unitInput.isSelected()) {
            unitBoxValidate.click();
        }

        if (!categoryInput.isSelected()){
            categoryBoxValidate.click();
        }
        if (!variantInput.isSelected()){
            variantBoxValidate.click();
        }

        if (!imageInput.isSelected()){
            imageCheckbox.click();
        }

        if (promotionalPriceInput.isSelected()){
          promotionalBoxValidate.click();
        }

    }

    public void clickToUpdateButton() throws InterruptedException {
        updateButton.click();
        Thread.sleep(1000);
    }
}
