package Lect5_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Static.html");
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("angular"));
        WebElement destination = driver.findElement(By.id("droparea"));
        actions.dragAndDrop(source, destination).perform();

        Thread.sleep(5000);
        driver.quit();

    }
}
