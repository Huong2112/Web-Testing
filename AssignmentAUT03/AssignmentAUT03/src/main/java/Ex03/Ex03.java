package Ex03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ex03 {
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

    @Test(priority = 2)
    public void test2() {
        WebElement orders = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
        orders.click();

        WebElement allOrders = driver.findElement(By.partialLinkText("All Products"));
        allOrders.click();

        WebElement edit = driver.findElement(By.xpath("//tbody/tr[1]/descendant::a[text()='Edit']"));
        edit.click();

        WebElement title = driver.findElement(By.name("title"));
        System.out.println("title: " + title.getAttribute("value"));

        WebElement slug = driver.findElement(By.name("slug"));
        System.out.println("slug: " + slug.getAttribute("value"));

        WebElement description = driver.findElement(By.name("excerpt"));
        System.out.println("description: " + description.getText());

        Select brand = new Select(driver.findElement(By.name("brand")));
        System.out.println(brand.getFirstSelectedOption().getText());

        Select category = new Select(driver.findElement(By.name("cats[]")));
        System.out.println(category.getFirstSelectedOption().getText());

        Select feature = new Select(driver.findElement(By.name("featured")));
        System.out.println(feature.getFirstSelectedOption().getText());
    }
}
