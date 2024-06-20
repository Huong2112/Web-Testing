package Lect5_Demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v122.debugger.model.WasmDisassemblyChunk;
import org.testng.annotations.Test;

public class JSExecutor {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://martfury.botble.com/admin/login");
        Thread.sleep(3000);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        WebElement email = (WebElement) javascriptExecutor.executeScript("return document.getElementById('username')");
        email.clear();
        email.sendKeys("admin");
        WebElement password = (WebElement) javascriptExecutor.executeScript("return document.getElementById('password')");
        email.clear();
        email.sendKeys("12345678");

    }
}
