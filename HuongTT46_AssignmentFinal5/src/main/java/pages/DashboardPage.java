package pages;

import core.BasePage;
import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-dismiss='alert']/following-sibling::p")
    private WebElement message;

    @FindBy(xpath = "//h2[text()= 'Overview Chart']")
    private WebElement overviewChart;

    @FindBy(xpath = "//h2[normalize-space()='Quick Links']")
    private WebElement quickLink;

    @FindBy(xpath = "//h2[text()=' Latest Five']")
    private WebElement lastestFive;

    @FindBy(xpath = "//h2[contains(text(),'Best Sellers')]")
    private WebElement bestSeller;



    public boolean verifyLoginSuccessfully(String expectedMessage){
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(message)).getText().trim().equals(expectedMessage.trim())
                && overviewChart.isDisplayed()
                && quickLink.isDisplayed()
                && lastestFive.isDisplayed()
                && bestSeller.isDisplayed();
    }

}
