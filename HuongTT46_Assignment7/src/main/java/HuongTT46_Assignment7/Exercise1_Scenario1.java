package HuongTT46_Assignment7;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Random;

public class Exercise1_Scenario1 {
    WebDriver driver;
    @Test
    @Parameters({"platform", "browser"})
    public void test(String platform, String browser) throws MalformedURLException, InterruptedException {
        //step 1
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
         driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
        driver.get("https://rawal-admin.themes-coder.net/admin/login");
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        if (browser.equals("chrome")){
            WebElement advanced = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("details-button")));
            advanced.click();
            WebElement link = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("proceed-link")));
            link.click();
        }

        //step2
        WebElement email = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.clear();
        email.sendKeys("admin@email.com");
        //step3
        WebElement password = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.clear();
        password.sendKeys("123");
        // step4
        WebElement loginButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        loginButton.click();
        //step5

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(Exception.class);
        WebElement catalog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Catalog']/parent::a")));
        Thread.sleep(3000);
        catalog.click();
        Random random = new Random();
        String generatedString = random.ints(97, 100)
                .limit(5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        WebElement productBrands = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Product Brands']")));
        productBrands.click();

        WebElement addBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Product Brands']/parent::div/following-sibling::div/descendant::button")));
        Thread.sleep(3000);
        addBtn.click();
        //step 6
        WebElement brandName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Brand Name']/following-sibling::input")));
        String key ="";
        if (desiredCapabilities.getBrowserName().equals("Chrome")){
            key = "Demo_Chrome_"+generatedString;
            brandName.sendKeys( key );
        }
        if (desiredCapabilities.getBrowserName().equals("Firefox")){
            key = "Demo_Firefox_"+generatedString;
            brandName.sendKeys(key);
        }
        //step7
        WebElement submitBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']")));
        submitBtn.click();

        //step 8
        WebElement searchbrand = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='productbrandTable_filter']/descendant::input")));
        searchbrand.sendKeys(key);
        WebElement status = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody//tr//td[position()=4]")));
        Assert.assertEquals(status.getText(),"active");
    }
    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
