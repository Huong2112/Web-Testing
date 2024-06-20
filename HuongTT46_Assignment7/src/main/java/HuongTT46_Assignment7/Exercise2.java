package HuongTT46_Assignment7;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise2 {
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
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(Exception.class);
        WebElement catalog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Catalog']/parent::a")));
        Thread.sleep(3000);
        catalog.click();

        WebElement products = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Products']")));
        products.click();

        WebElement addProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Add Product']")));
        addProduct.click();
        //step 6
        Thread.sleep(5000);
        WebElement category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Select one']")));
        category.click();
        Actions actions = new Actions(driver);
        WebElement inputkey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='printableTable']/descendant::input[@placeholder='Select one']")));
       inputkey.sendKeys("cat3");
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER).perform();

        String name ="This is name for all language";

      //step 7
        List<WebElement> listLanguage = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='pills-tab1']/descendant::li")));
        int i = 0;
        int j =1;
        for (WebElement language: listLanguage){
            language.click();
            String xpath = "//input[@name='name" +i+"']";
            String xpathDes = "(//textarea[@id='label-textarea'])[" +j+ "]";

            WebElement categoryName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            categoryName.sendKeys(name);


            WebElement description = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDes)));
            description.sendKeys("Description for all language.");
            i++;
            j++;

        }

        //step 8


        WebElement addMediaBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Add Media']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(3000);
        addMediaBtn.click();
        List<WebElement> listIng = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@style,'block !important')]/descendant::div[@id='All-center']/descendant::div[@class='row']/descendant::div[contains(@class, 'col-xl-3 loadingmore')]")));
        WebElement firstImg = listIng.get(0);
        firstImg.click();
        WebElement closeBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Close']")));
        closeBtn.click();



        WebElement advanceInfor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='pills-tabmain']/descendant::li[position()=2]")));
        advanceInfor.click();
        WebElement productType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Product Type']/following-sibling::fieldset/descendant::select")));
        productType.click();
        WebElement simple = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='simple']")));
        simple.click();

        //step 9
        Select units = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Units']/following-sibling::fieldset/descendant::select"))));
        for (WebElement unit : units.getOptions()){
            if (unit.getText().equals("kilo")){
                unit.click();
                break;
            }
        }

        //step 10
        Select brands = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Brands']/following-sibling::fieldset/descendant::select"))));
        for (WebElement brand : brands.getOptions()){
            if (brand.getText().equals("KIA")){
                brand.click();
                break;
            }
        }
        //step 11
        WebElement weight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("weight")));
        weight.sendKeys("10");

        //step 12
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Price']")));
        price.sendKeys("1000");

        //step 13
        WebElement discountPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Discount Price']")));
        discountPrice.sendKeys("0.1");

        //step 14
        Random random = new Random();
        String generatedString = random.ints(97, 100)
                .limit(5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        WebElement sku = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='SKU']/following-sibling::fieldset/descendant::input")));
        sku.sendKeys(generatedString);
        WebElement seo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='pills-tabmain']/descendant::li[position()=3]/descendant::a")));
        js.executeScript("window.scrollTo(0, 0);");
        seo.click();

        WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Save']")));
        saveBtn.click();

        //step 16
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='product_filter']/descendant::input")));
        js.executeScript("window.scrollTo(0, 0);");
        search.sendKeys(name);
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        List<WebElement> listProduct = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr")));
        Assert.assertTrue(listProduct.size()>0);
        if (listProduct.size()>0) {
            WebElement nameProduct = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[position()=2]")));
            Thread.sleep(1000);
            Assert.assertEquals(nameProduct.getText(), name);
        }

        //Step 19
        WebElement pos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='POS'])[3]")));
        pos.click();
        WebElement inputSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basicInput2")));
        inputSearch.sendKeys(name);
        actions.sendKeys(Keys.ENTER).perform();

        WebElement imageProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='img-fluid']/parent::a")));

        imageProduct.click();
        Thread.sleep(3000);
        WebElement discount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='orderTable']/tbody/tr/td[position()=4]")));
        Assert.assertEquals(discount.getText(), "0.1");

    }
    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
