package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Exercise5 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://demo.seleniumeasy.com/table-pagination-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void test(){
        //2.	Looking for “Table with Pagination Example”
        WebElement table = driver.findElement(By.tagName("table"));
        //3.	Get the first row value of table and display value to the screen
        WebElement bodyTable  = table.findElement(By.id("myTable"));
        List<WebElement> rows = bodyTable.findElements(By.tagName("tr"));
        List<WebElement> cols = rows.get(0).findElements(By.tagName("td"));
        for (WebElement col : cols){
            System.out.print(col.getText()  + "\t");
        }
        System.out.println();

    }
    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done!");
    }
}
