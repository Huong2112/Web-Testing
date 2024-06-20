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

public class VerifyEditCustomer {
    WebDriver driver ;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento-demo.mageplaza.com/admin/admin/");
    }

    @Test
    public void test(){
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

        //4. click to customer on left menu

        WebElement customer = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-ui-id ='menu-magento-customer-customer']")));
        customer.click();
        // 5. Click all customers
        WebElement allCustomers = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space() = 'All Customers']")));
        allCustomers.click();

        //6. Send key to search
        WebElement inputSearch = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fulltext")));
        inputSearch.clear();
        inputSearch.sendKeys("Veronica Costello");

        WebElement searchIcon = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by keyword']/following-sibling::button")));
        searchIcon.click();

        WebElement edit = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
        edit.click();

        WebElement accountInfor = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab_customer")));
        accountInfor.click();

        WebElement firstName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[firstname]")));
        Assert.assertEquals(firstName.getAttribute("value"),"Veronica");
        WebElement lastName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[lastname]")));
        Assert.assertEquals(lastName.getAttribute("value"),"Costello");
        System.out.println(firstName.getAttribute("value"));
        System.out.println(lastName.getAttribute("value"));

    }
    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done");
    }
}
