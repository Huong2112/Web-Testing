package HuongTT46_Assignment8.pages;

import Demo.core.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class AddProductPage extends BasePage {
    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Select one']")
    private WebElement categories;
    @FindBy(xpath = "//div[@id='printableTable']/descendant::input[@placeholder='Select one']")
    private WebElement inputCategories;
    @FindBy(xpath = "//ul[@id='pills-tab1']/descendant::li")
    private List<WebElement> listLanguage;

    @FindBy(xpath = "//a[text()='Add Media']")
    private WebElement addMedia;
    @FindBy(xpath = "(//img[@alt='image']/..)[1]")
    private WebElement firstMedia;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement closeAlbum;

    @FindBy(xpath = "//ul[@id='pills-tabmain']/descendant::li[position()=2]/descendant::a")
    private WebElement advanceInfor;
    @FindBy(xpath = "//ul[@id='pills-tabmain']/descendant::li[position()=3]/descendant::a")
    private WebElement seo;
    @FindBy(xpath = "//label[normalize-space()='Product Type']/following-sibling::fieldset/descendant::select")
    private WebElement productType;

    @FindBy(xpath = "//label[normalize-space()='Units']/following-sibling::fieldset/descendant::select")
    private WebElement unitsSelect;

    @FindBy(xpath = "//label[normalize-space()='Brands']/following-sibling::fieldset/descendant::select")
    private WebElement brandsSelect;

    @FindBy(xpath = "//input[@placeholder='Enter Weight']")
    private  WebElement productWeight;

    @FindBy(xpath = "//input[@placeholder='Enter Price']")
    private WebElement price;

    @FindBy(xpath = "//input[@placeholder='Enter Discount Price']")
    private WebElement discountPrice;

    @FindBy(xpath = "//label[normalize-space()='SKU']/following-sibling::fieldset/descendant::input")
    private WebElement sku;

    @FindBy(xpath = "//a[text()='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[@class='v-toaster']")
    private WebElement message;


    private WebElement getProductNameWithDynamicXpath(int index){
        String xPath = String.format("//input[@name='name%s']", index);
        WebElement productName = getDriver().findElement(By.xpath(xPath));
        return productName;
    }

    private WebElement getProductDescriptionWithDynamicXpath(int index){
        String xPath = String.format("(//textarea[@id='label-textarea'])[%s]", index);
        WebElement productDescription = getDriver().findElement(By.xpath(xPath));
        return productDescription;
    }

    public void inputInformation() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        Actions actions = new Actions(getDriver());
        getWebDriverWait().until(ExpectedConditions.visibilityOf(categories)).click();
        inputCategories.sendKeys("cat3");
        actions.sendKeys(Keys.ENTER).perform();



        int  i = 0, j =1;
        for (WebElement language : listLanguage) {
            language.click();
            getProductNameWithDynamicXpath(i).sendKeys("This is name for all language");
            getProductDescriptionWithDynamicXpath(j).sendKeys("This is description for all language.");
            i++;
            j++;
        }

        jse.executeScript("arguments[0].scrollIntoView(true);", addMedia);
        jse.executeScript("arguments[0].click();", addMedia);

        jse.executeScript("arguments[0].scrollIntoView(true);", firstMedia);
        jse.executeScript("arguments[0].click();", firstMedia);

        jse.executeScript("arguments[0].scrollIntoView(true);", closeAlbum);
        jse.executeScript("arguments[0].click();", closeAlbum);

        jse.executeScript("arguments[0].scrollIntoView(true);", advanceInfor);
        jse.executeScript("arguments[0].click();", advanceInfor);

        jse.executeScript("arguments[0].scrollIntoView(true);", productType);
        jse.executeScript("arguments[0].click();", productType);


        Select types = new Select(productType);
        for (WebElement type : types.getOptions()){
            if (type.getText().equals("Simple")){
                type.click();
                break;
            }
        }

            Select units = new Select(unitsSelect);
            for (WebElement unit : units.getOptions()){
                if (unit.getText().equals("kilo")){
                    unit.click();
                    break;
                }
            }
            Select brands = new Select(brandsSelect);
            for (WebElement brand : brands.getOptions()){
                if (brand.getText().equals("KIA")){
                    brand.click();
                    break;

                }
            }


        jse.executeScript("arguments[0].scrollIntoView(true);", productWeight);
        productWeight.sendKeys("10");

        jse.executeScript("arguments[0].scrollIntoView(true);", price);
        price.sendKeys("1000");

        jse.executeScript("arguments[0].scrollIntoView(true);", discountPrice);
        discountPrice.sendKeys("-1");

            Random random = new Random();
            String generatedString = random.ints(97, 100)
                    .limit(5)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

        jse.executeScript("arguments[0].scrollIntoView(true);", sku);
        sku.sendKeys(generatedString);


        jse.executeScript("arguments[0].scrollIntoView(true);", seo);
        jse.executeScript("arguments[0].click();", seo);


        jse.executeScript("arguments[0].scrollIntoView(true);", saveBtn);
        jse.executeScript("arguments[0].click();", saveBtn);
        Thread.sleep(3000);
    }

    public boolean verifyMessageCreateSuccessfully(String expected){
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(message)).getText().trim().equals(expected);
    }

    public void captureScreen() throws IOException {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("captureScreenSuccess.png"));
    }
}
