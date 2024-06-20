package HuongTT46_Assignment8.pages;

import Demo.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//input[@name='password']/following-sibling::span")
    private WebElement warning;

    public void login(String e, String p){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(email)).clear();
        email.sendKeys(e);
        password.clear();
        password.sendKeys(p);
        loginBtn.click();
    }

    public void navigateToLogin(String url){
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }

    public boolean verifyInputInvalidData(String expected){
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(warning)).getText().trim().equals(expected);
    }

}
