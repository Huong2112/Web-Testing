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

public class VerifyCreateNewCustomer {
    WebDriver driver ;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento-demo.mageplaza.com/admin/admin/");

    }

    @Test
    public void test() throws InterruptedException {
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
        //6. Add button
        WebElement addBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
        addBtn.click();
        //7. Fill data
        WebElement firstName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[firstname]")));
        firstName.sendKeys("Huong4");
        WebElement lastName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[lastname]")));
        lastName.sendKeys("Tran4");
        WebElement email = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[email]")));
        email.sendKeys("huongtt4@gmail.com");
        WebElement saveBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save")));
        saveBtn.click();

        WebElement message = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-ui-id='messages-message-success']")));
        Assert.assertEquals(message.getText(), "You saved the customer.");
    }

    @AfterTest
    public void closeWeb(){
        driver.quit();
        System.out.println("Test done!");
    }
}
