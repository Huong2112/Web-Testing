package HuongTT46_Assignment9.pages.Rawal;


import HuongTT46_Assignment9.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrivacyErrorPage extends BasePage {
    public PrivacyErrorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "details-button")
    private WebElement advanced;

    @FindBy(id = "proceed-link")
    private WebElement processLink;

    public void escapeFromSecurityPage(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(advanced)).click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(processLink)).click();
    }

}
