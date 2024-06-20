package ExtraPractice_Lect6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifySearchProductPage {
    WebDriver driver ;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento-demo.mageplaza.com/admin/admin/");
    }
    @Test
    public void test() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //2 input
        WebElement username = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username.clear();
        username.sendKeys("mageplaza");

        WebElement password = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        password.clear();
        password.sendKeys("demo123");

        //3. login
        WebElement loginBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
        loginBtn.click();

        //4. Click to the Catalog on the left menu.
        WebElement catalog = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-ui-id='menu-magento-catalog-catalog']")));
        catalog.click();
        //5. click on products
        WebElement products = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Products")));
        products.click();

        // Send key to search

        WebElement searchKey = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fulltext")));
        Assert.assertTrue(searchKey.isDisplayed());
        searchKey.sendKeys("ProdI-Conf ");

        WebElement searchBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Search'][@type='button']")));
        searchBtn.click();

        // Verify product name
        WebElement productName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr/td[position()=4]/descendant::div")));
        System.out.println(productName.getText());
        Assert.assertEquals(productName.getText(),"ProdI-Conf");
        webDriverWait.withTimeout(Duration.ofSeconds(20));
    }

    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done");
    }
}
