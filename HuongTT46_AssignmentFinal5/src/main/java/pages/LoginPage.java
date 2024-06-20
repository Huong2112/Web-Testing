package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name= "identity")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//span[normalize-space()='Remember me']")
    private WebElement rememberMeLabel;

    @FindBy(xpath = "//input[@id='remember']/..")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(xpath = "//h3[text()='Please login to your account.']")
    private WebElement text;


    public boolean verifyUserNameCombobox(){
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(username)).isDisplayed() && username.isEnabled();

    }

    public boolean verifyPasswordText(){
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(password)).isDisplayed() && password.isEnabled();
    }

    public boolean verifyRememberMe(){
        return rememberMeLabel.isDisplayed() && rememberMeCheckbox.isDisplayed() && rememberMeCheckbox.isEnabled();
    }

    public boolean verifyLoginButton(){
        return loginButton.isEnabled() && loginButton.isDisplayed();
    }

    public void navigateToLoginPage(String url){
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }

    public void login(String name, String pass){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(username)).clear();
        username.sendKeys(name);
        password.clear();
        password.sendKeys(pass);
        loginButton.click();
    }

    public void verifyText(){
       getWebDriverWait().withTimeout(Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(text)).isDisplayed();
    }

}
