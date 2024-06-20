package Lect7_Demo;

import net.bytebuddy.agent.builder.ResettableClassFileTransformer;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumDemo {
    @Test
    @Parameters({"platform", "browser"})
    public void test(String platform, String browser) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if (platform.equals("Windows")){
            desiredCapabilities.setPlatform(Platform.WINDOWS);
        }
        if (browser.equals("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);

        }
        if (browser.equals("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        }
        desiredCapabilities.setBrowserName(browser);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
       driver.get("https://rawal-admin.themes-coder.net/admin/login");
        // driver.get("https://martfury.botble.com/admin/login");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         //driver.quit();
    }
}
