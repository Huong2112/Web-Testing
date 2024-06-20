package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Nest17 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://nest.botble.com/admin");;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void test() throws InterruptedException {

        WebElement emailInput = driver.findElement(By.id("username"));
        emailInput.clear();
        emailInput.sendKeys("admin");

        //password
        WebElement passInput = driver.findElement(By.id("password"));
        passInput.clear();
        passInput.sendKeys("12345678");
        //login button
        WebElement signInBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        signInBtn.click();
        //Page
        driver.findElement(By.id("cms-core-page")).click();
        // 3. The screen should be displayed:
        // + Filter button
        WebElement filterBtn = driver.findElement(By.xpath("//button[normalize-space()='Filters']"));
        Assert.assertTrue(filterBtn.isDisplayed());
        // + Search Button
        WebElement searchBtn = driver.findElement(By.xpath("//button[normalize-space()='Filters']/following-sibling::div/descendant::input"));
        Assert.assertTrue(searchBtn.isDisplayed());
        // + Create button
        WebElement createBtn = driver.findElement(By.xpath("//span[@data-action='create']/parent::button"));
        Assert.assertTrue(createBtn.isDisplayed());
        // + Reload button
        WebElement reloadBtn = driver.findElement(By.xpath("//span[@data-action='create']/parent::button/following-sibling::button"));
        Assert.assertTrue(reloadBtn.isDisplayed());
        //Table list of page display with columns: Name, Template, Create At, Status
        WebElement table = driver.findElement(By.id("botble-page-tables-page-table"));
        List<WebElement> colsName = table.findElements(By.xpath("//thead//tr//th[position()>2 and position() < 7]"));
        String[] cols = new String[colsName.size()];
        int i = 0;
        for (WebElement colName : colsName){
            cols[i] = colName.getText();
            i++;
        }
        Assert.assertEquals(cols,new String[]{"NAME","TEMPLATE","CREATED AT","STATUS"});

        // The screen should be displayed:
        createBtn.click();
        // + 2 tabs: Detail and Revision History
        List<WebElement> listTab = driver.findElements(By.xpath("//ul[@role='tablist']/descendant::li"));
        Assert.assertEquals(listTab.size(), 2);
        String[] textTab = new String[listTab.size()];
        int j =0;
        for (WebElement tab : listTab){
            textTab[j] = tab.getText();
            j++;
        }
        Assert.assertEquals(textTab, new String[]{"Detail", "Revision History"});
        // + In Detail tab should be display:
        // Name
        WebElement name = driver.findElement(By.id("name"));
        Assert.assertTrue(name.isDisplayed());
        // Description
        WebElement description = driver.findElement(By.id("description"));
        Assert.assertTrue(description.isDisplayed());
        // Content
        WebElement content = driver.findElement(By.xpath("//label[@for='content']/parent::div"));
        Assert.assertTrue(content.isDisplayed());
        // Save & exit button,
        WebElement SEBtn = driver.findElement(By.xpath("//div[@class='card-body']/descendant::button[@value='save']"));
        Assert.assertTrue(SEBtn.isDisplayed());
        // Save button
        WebElement saveBtn = driver.findElement(By.xpath("//div[@class='card-body']/descendant::button[@value='apply']"));
        // Header style combobox,
        Select headerStyle = new Select(driver.findElement(By.id("header_style")));
        Assert.assertFalse(headerStyle.isMultiple());
        Assert.assertEquals(headerStyle.getOptions().size(), 2);
        // Status combobox,
        Select status = new Select(driver.findElement(By.name("status")));
        Assert.assertFalse(status.isMultiple());
        Assert.assertEquals(status.getOptions().size(), 3);
        // Template combobox,
        Select template = new Select(driver.findElement(By.name("template")));
        Assert.assertFalse(template.isMultiple());
        Assert.assertEquals(template.getOptions().size(), 8);
        // Image combobox,
        WebElement image = driver.findElement(By.xpath("//input[@name='image']/parent::div/descendant::span"));
        Assert.assertTrue(image.isDisplayed());
        // Search Engine Optimize
        WebElement seo = driver.findElement(By.id("seo_wrap"));
        Assert.assertTrue(seo.isDisplayed());

    }

    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done");
    }
}
