package Ex02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ex02 {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://dokans.online/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void test() throws InterruptedException {
        Actions action = new Actions(driver);

        WebElement username = driver.findElement(By.name("email"));
        username.clear();
        username.sendKeys( "bigbag@email.com");

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("rootadmin");

        WebElement rememberMe = driver.findElement(By.id("remember-me"));
        action.moveToElement(rememberMe).click().perform();

        WebElement forgotPassword = driver.findElement(By.partialLinkText("Forgot Password?"));
        Assert.assertTrue(forgotPassword.isDisplayed());

        WebElement loginButton = driver.findElement(By.xpath("//button [@type='submit']"));
        loginButton.click();

        Thread.sleep(3000);

        WebElement username1 = driver.findElement(By.name("email"));
        username1.clear();
        username1.sendKeys( "bigbag@email.com");

        WebElement password1 = driver.findElement(By.name("password"));
        password1.clear();
        password1.sendKeys("rootadmin");

        WebElement loginButton1 = driver.findElement(By.xpath("//button [@type='submit']"));
        loginButton1.click();

    }

    @Test(priority = 1)
    public void test2() {
        WebElement orders = driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
        orders.click();

        WebElement allOrders = driver.findElement(By.partialLinkText("All Orders"));
        allOrders.click();

        WebElement orderTotal = driver.findElement(By.xpath("//td[normalize-space()='bigbag703']/following-sibling::td[3]"));
        System.out.println(orderTotal.getText());

        WebElement paymentStatus = driver.findElement(By.xpath("//td[normalize-space()='bigbag703']/following-sibling::td[4]"));
        System.out.println(paymentStatus.getText());

        List<WebElement> listOrder = driver.findElements(By.xpath("//tbody/tr"));
        for (int i = 0; i < 4; i++) {
            List<WebElement> order = listOrder.get(i).findElements(By.tagName("td"));
            for (int j = 1; j < order.size() - 1; j++) {
                System.out.printf("%s \t\t",order.get(j).getText());
                if (j == order.size() - 2) {
                    System.out.println("\n");
                }
            }
        }
    }
}
