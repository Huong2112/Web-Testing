package pages;

import core.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductListPage extends BasePage {
    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table[@id='PRData']/thead/descendant::th[position()>1]")
    private List<WebElement> columnName;

    @FindBy(xpath = "//label[text()='Search ']/descendant::input")
    private WebElement searchInput;

    @FindBy(xpath = "//table[@id='PRData']/tbody/tr/td[position()=4]")
    private WebElement productResult;

    @FindBy(xpath = "//button[text()='Actions ']")
    private WebElement actions;

    @FindBy(xpath = "//a[text()=' Edit Product']")
    private WebElement editBtn;


    public boolean verifyTableDisplayColumn(){
        boolean result = true;
        String[] expectedName = {"Image", "Code", "Name", "Brand", "Category", "Cost", "Price", "Quantity", "Unit", "Alert Quantity", "Actions"};
        for (int i = 0; i < columnName.size(); i++){
            if (!columnName.get(i).getText().trim().equals(expectedName[i].trim())){
                result = false;
                break;
            }
        }
        return result;
    }


    public void searchAndClickProduct(String key) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(key);
        Thread.sleep(3000);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productResult)).click();
        Thread.sleep(2000);
    }

    public void searchProduct(String key) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(key);
        Thread.sleep(1000);
    }

    public void clickToEditProduct(){
            getWebDriverWait().until(ExpectedConditions.visibilityOf(actions)).click();
            editBtn.click();
    }


}
