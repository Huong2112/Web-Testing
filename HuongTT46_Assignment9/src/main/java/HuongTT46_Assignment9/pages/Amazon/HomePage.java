package HuongTT46_Assignment9.pages.Amazon;

import HuongTT46_Assignment9.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    private WebElement categoriesSearch;


    @FindBy(id = "twotabsearchtextbox")
    private WebElement inputKey;

    @FindBy(id = "nav-search-submit-button")
    private WebElement goBtn;

    @FindBy(xpath = "(//span[contains(@class, 'a-color-base a-text-normal')])[1]")
    private WebElement firstResultTitle;

    public void navigateToHomePage(String url){
        getDriver().get(url);
        getDriver().manage().window().maximize();

    }


    public void selectCategory(String catName){
        categoriesSearch.click();
        new Select(categoriesSearch).selectByVisibleText(catName);
    }

    public void sendKeyToSearch(String key){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(inputKey)).sendKeys(key);

    }

    public void clickToGoBtn(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(goBtn)).click();
    }

    public void clickToTitleOfFirstResult(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(firstResultTitle)).click();
    }


}
