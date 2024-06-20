package HuongTT46_Assignment7;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
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
import java.util.List;
import java.util.Random;

public class Exercise1_Scenario2 {
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


        WebElement productCatefories = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Product Categories']")));
        productCatefories.click();
        WebElement addBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Product Categories']/parent::div/following-sibling::div")));
        Thread.sleep(3000);
        addBtn.click();
        String key ="";
        if (browser.equals("chrome")){
            key = key+ "Demo_Chrome_"+generatedString;

        }
        if (browser.equals("firefox")){
            key = key+"Demo_Firefox_"+generatedString;
        }

        List<WebElement> listLanguage = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@id='myform']/descendant::div[position()=3]/descendant::div")));
        for (WebElement language: listLanguage){
            language.click();
            //step 6
            WebElement categoryName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(normalize-space(),'Name')]/following-sibling::input")));
            categoryName.sendKeys(key);

            //step 7
            WebElement description = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='quill-container']/descendant::div[@class='ql-editor ql-blank']")));
            description.sendKeys("Description for all language.");
            // step 8
            WebElement parentCat = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::fieldset")));
            parentCat.click();
            WebElement cat3 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='125']")));
            cat3.click();
            //step 9
            WebElement slug = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Slug']/following-sibling::input")));
            slug.sendKeys("demo");
            //step 10
            WebElement media = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Upload Category Media']")));
            media.click();
            List<WebElement> listIng = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@style,'block !important')]/descendant::div[@id='All-center']/descendant::div[@class='row']/descendant::div[contains(@class, 'col-xl-3 loadingmore')]")));
            WebElement firstImg = listIng.get(0);
            firstImg.click();
            WebElement closeBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Close']")));
            closeBtn.click();

            //step 11
            WebElement categoryImgBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Upload Category Icon']")));
            categoryImgBtn.click();
            List<WebElement> listIngCategory = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@style,'block !important')]/descendant::div[@id='All-center']/descendant::div[@class='row']/descendant::div[contains(@class, 'col-xl-3 loadingmore')]")));
            WebElement firstImgCategory = listIngCategory.get(0);
            firstImgCategory.click();
            WebElement closeBtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class ='modal-header']/descendant::button[@aria-label='Close'])[2]")));
            closeBtn1.click();

        }

        //step 12
        WebElement submitBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']")));
        submitBtn.click();

        //step 13
        WebElement searchCategory = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='productcategoryTable_filter']/descendant::input")));
        Actions actions = new Actions(driver);

        searchCategory.sendKeys(key);
        Thread.sleep(3000);
        actions.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        List<WebElement> listNameCategory = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr")));
        Assert.assertTrue(listNameCategory.size()>0);
        if (listNameCategory.size()>0) {
            WebElement nameCategory = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[position()=2]")));
            Thread.sleep(1000);
            Assert.assertEquals(nameCategory.getText(), key);
        }
    }
    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
