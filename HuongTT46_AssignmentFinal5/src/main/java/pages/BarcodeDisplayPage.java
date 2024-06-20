package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BarcodeDisplayPage extends BasePage {
    public BarcodeDisplayPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='product_image']/descendant::img")
    private WebElement productImage;

    @FindBy(xpath = "//div[@id='barcode-con']/descendant::span[@class='barcode_site']")
    private WebElement barcodeSite;

    @FindBy(xpath = "//div[@id='barcode-con']/descendant::span[@class='barcode_name']")
    private WebElement barcodeName;

    @FindBy(xpath = "//div[@id='barcode-con']/descendant::span[@class='barcode_price']")
    private WebElement barcodePrice;

    @FindBy(xpath = "//div[@id='barcode-con']/descendant::span[@class='barcode_unit']")
    private WebElement barcodeUnit;

    @FindBy(xpath = "//div[@id='barcode-con']/descendant::span[@class='barcode_category']")
    private WebElement barcodeCategory;

    @FindBy(xpath = "//div[@id='barcode-con']/descendant::span[@class='barcode_image']")
    private WebElement barcodeImage;



    public boolean verifyDisplayBarCode(String site, String name, String price, String unit, String category) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(productImage.isDisplayed());
        System.out.println(barcodeImage.isDisplayed());
        Assert.assertEquals(barcodeSite.getText(), site.toUpperCase() );
        Assert.assertEquals(barcodeName.getText(), name.toUpperCase());
        Assert.assertEquals(barcodePrice.getText(), price.toUpperCase());
        Assert.assertEquals(barcodeUnit.getText(), unit.toUpperCase());
        Assert.assertEquals(barcodeCategory.getText(), category.toUpperCase());

        return productImage.isDisplayed()
                && (barcodeSite.getText().trim().equals(site.toUpperCase().trim()))
                && (barcodeName.getText().trim().equals(name.toUpperCase().trim()))
                && (barcodePrice.getText().trim().equals(price.toUpperCase().trim()))
                && (barcodeUnit.getText().trim().equals(unit.toUpperCase().trim()))
                && (barcodeCategory.getText().trim().equals(category.toUpperCase().trim()))
                && barcodeImage.isDisplayed();
    }
}
