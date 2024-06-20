package Demo.pages;

import Demo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage  extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "username")
    private WebElement username;
    @FindBy(name = "login[password]")
    private WebElement password;
    @FindBy(xpath = "//span[text()='Sign in']")
    private WebElement loginBtn;

    public void login(String u, String p){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(username)).clear();
        username.sendKeys(u);
        password.clear();
        password.sendKeys(p);
        loginBtn.click();
    }

    public void navigateToLogin(String url){
        getDriver().get(url);;
        getDriver().manage().window().maximize();
    }

}
