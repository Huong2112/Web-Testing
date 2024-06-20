package core;

import org.openqa.selenium.WebDriver;

public class BaseTest {
    private WebDriver driver;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
