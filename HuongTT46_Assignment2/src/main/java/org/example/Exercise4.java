package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise4 {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test(){
        driver.get("https://rawal-admin.themes-coder.net/admin/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Login
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("admin@email.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        WebElement account = driver.findElement(By.xpath("//span[normalize-space() = 'Accounts']"));
        if (account.isDisplayed()){
            account.click();
            System.out.println("Account is clicked!");

        }


        WebElement payments = driver.findElement(By.xpath("//span[normalize-space() = 'Payments']"));
        if (payments.isDisplayed()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payments);
            payments.click();
            System.out.println("Payments is clicked!");
        }

        //Verify Payment Adjustments screen
        // AccountType
        WebElement accountTypeLabel = driver.findElement(By.xpath("(//label[normalize-space() = 'Account Type'])[2]"));
        Assert.assertTrue(accountTypeLabel.isDisplayed(), "Account type label is not displayed.");

        WebElement accountTypeSelect1 = driver.findElement(By.xpath("(//fieldset[@class = 'form-group mb-3'])[2]"));
        Assert.assertTrue(accountTypeSelect1.isDisplayed(),"Selection box 1 is not display.");

        WebElement  accountTypeSelect2 = driver.findElement(By.xpath("(//div[@class='form-group child']/select)[2]"));
        Assert.assertTrue(accountTypeSelect2.isDisplayed(), "Selection box 2 is not display.");

        //Amounts
        WebElement amountLabel = driver.findElement(By.xpath("//label[normalize-space() = 'Amount']"));
        Assert.assertTrue(amountLabel.isDisplayed(), "Amount label is not displayed.");

        WebElement amountInput = driver.findElement(By.xpath("(//input[@type = 'text'])[1]"));
        Assert.assertTrue(amountInput.isDisplayed(),"Amount input is not display.");

        // Description
        WebElement desLabel = driver.findElement(By.xpath("//label[normalize-space() = 'Description']"));
        Assert.assertTrue(desLabel.isDisplayed(), "Amount label is not displayed.");

        WebElement  descriptionInput = driver.findElement(By.xpath("(//input[@type = 'text'])[2]"));
        Assert.assertTrue(descriptionInput.isDisplayed(), "Description input is not display.");

        //Button
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space() = 'Submit']"));
        Assert.assertTrue(submitButton.isDisplayed(), "Submit button is not dislayed.");
    }

    @AfterTest
    public void closedBrowser(){
        driver.quit();
        System.out.println("Browser is closed! Test done!");
    }
}
