package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Nest16 {

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
        WebElement signInBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        signInBtn.click();
        //Page
        WebElement pageDiv = driver.findElement(By.id("cms-core-page"));
        Assert.assertEquals(pageDiv.getAttribute("href"),"https://nest.botble.com/admin/pages");
        Assert.assertTrue(pageDiv.isDisplayed(),"Page is not display");
        WebElement page = driver.findElement(By.xpath("//span[@title='Pages']/following-sibling::span"));
        Assert.assertEquals(page.getText(),"Pages");


        //Blog
        WebElement blogDiv = driver.findElement(By.id("cms-plugins-blog"));
        Assert.assertEquals(blogDiv.getAttribute("href"),"https://nest.botble.com/admin#cms-plugins-blog");
        Assert.assertTrue(pageDiv.isDisplayed(),"Blog is not display");
        WebElement  blog = driver.findElement(By.xpath("//span[@title='Blog']/following-sibling::span"));
        Assert.assertEquals(blog.getText(),"Blog");
        // Ads
        WebElement adsDiv = driver.findElement(By.id("cms-plugins-ads"));
        Assert.assertEquals(adsDiv.getAttribute("href"),"https://nest.botble.com/admin#cms-plugins-ads");
        Assert.assertTrue(adsDiv.isDisplayed(),"Ads is not display");
        WebElement  ads = driver.findElement(By.xpath("//span[@title='Ads']/following-sibling::span"));
        Assert.assertEquals(ads.getText(),"Ads");
        // FAQ
        WebElement faqDiv = driver.findElement(By.id("cms-plugins-faq"));
        Assert.assertEquals(faqDiv.getAttribute("href"),"https://nest.botble.com/admin#cms-plugins-faq");
        Assert.assertTrue(adsDiv.isDisplayed(),"FAQs is not display");
        WebElement  faq = driver.findElement(By.xpath("//span[@title='FAQs']/following-sibling::span"));
        Assert.assertEquals(faq.getText(),"FAQs");
        // NewLetters
        WebElement letterDiv = driver.findElement(By.id("cms-plugins-newsletter"));
        Assert.assertEquals(letterDiv.getAttribute("href"),"https://nest.botble.com/admin/newsletters");
        Assert.assertTrue(adsDiv.isDisplayed(),"Newsletters is not display");
        WebElement  letter = driver.findElement(By.xpath("//span[@title='Newsletters']/following-sibling::span"));
        Assert.assertEquals(letter.getText(),"Newsletters");
        // Ecommerce
        WebElement ecommerceDiv = driver.findElement(By.id("cms-plugins-ecommerce"));
        Assert.assertEquals(ecommerceDiv.getAttribute("href"),"https://nest.botble.com/admin#cms-plugins-ecommerce");
        Assert.assertTrue(adsDiv.isDisplayed(),"Ecommerce is not display");
        WebElement  ecommerce = driver.findElement(By.xpath("//span[@title='Ecommerce']/following-sibling::span"));
        Assert.assertEquals(ecommerce.getText(),"Ecommerce");
        // Marketplace
        WebElement placeDiv = driver.findElement(By.id("cms-plugins-marketplace"));
        Assert.assertEquals(placeDiv.getAttribute("href"),"https://nest.botble.com/admin#cms-plugins-marketplace");
        Assert.assertTrue(adsDiv.isDisplayed(),"Marketplace is not display");
        WebElement  place = driver.findElement(By.xpath("//span[@title='Marketplace']/following-sibling::span"));
        Assert.assertEquals(place.getText(),"Marketplace");
        // Simple Slide
        WebElement slideDiv = driver.findElement(By.id("cms-plugins-simple-slider"));
        Assert.assertEquals(slideDiv.getAttribute("href"),"https://nest.botble.com/admin/simple-sliders");
        Assert.assertTrue(adsDiv.isDisplayed(),"Simple slides is not display");
        WebElement  slide = driver.findElement(By.xpath("//span[@title='Simple Sliders']/following-sibling::span"));
        Assert.assertEquals(slide.getText(),"Simple Sliders");
        // Contact
        WebElement contactDiv = driver.findElement(By.id("cms-plugins-contact"));
        Assert.assertEquals(contactDiv.getAttribute("href"),"https://nest.botble.com/admin#cms-plugins-contact");
        Assert.assertTrue(contactDiv.isDisplayed(),"Contact is not display");
        WebElement  contact = driver.findElement(By.xpath("//span[@title='Contact']/following-sibling::span"));
        Assert.assertEquals(contact.getText(),"Contact");
        // Payments
        WebElement paymentDiv = driver.findElement(By.id("cms-plugins-payments"));
        Assert.assertEquals(paymentDiv.getAttribute("href"),"https://nest.botble.com/admin#cms-plugins-payments");
        Assert.assertTrue(paymentDiv.isDisplayed(),"Payment is not display");
        WebElement  payment = driver.findElement(By.xpath("//span[@title='Payments']/following-sibling::span"));
        Assert.assertEquals(payment.getText(),"Payments");
        // Locations
        WebElement locationsDiv = driver.findElement(By.id("cms-plugins-location"));
        Assert.assertEquals(locationsDiv.getAttribute("href"),"https://nest.botble.com/admin#cms-plugins-location");
        Assert.assertTrue(locationsDiv.isDisplayed(),"Location is not display");
        WebElement  locations = driver.findElement(By.xpath("//span[@title='Locations']/following-sibling::span"));
        Assert.assertEquals(locations.getText(),"Locations");
        // Media
        WebElement mediaDiv = driver.findElement(By.id("cms-core-media"));
        Assert.assertEquals(mediaDiv.getAttribute("href"),"https://nest.botble.com/admin/media");
        Assert.assertTrue(mediaDiv.isDisplayed(),"Location is not display");
        WebElement  media = driver.findElement(By.xpath("//span[@title='Media']/following-sibling::span"));
        Assert.assertEquals(media.getText(),"Media");
        // Appearance
        WebElement appearanceDiv = driver.findElement(By.id("cms-core-appearance"));
        Assert.assertEquals(appearanceDiv.getAttribute("href"),"https://nest.botble.com/admin#cms-core-appearance");
        Assert.assertTrue(appearanceDiv.isDisplayed(),"Appearance is not display");
        WebElement  appearance = driver.findElement(By.xpath("//span[@title='Appearance']/following-sibling::span"));
        Assert.assertEquals(appearance.getText(),"Appearance");
        // Plugin
        WebElement pluginDiv = driver.findElement(By.id("cms-core-plugins"));
        Assert.assertEquals(pluginDiv.getAttribute("href"),"https://nest.botble.com/admin#cms-core-plugins");
        Assert.assertTrue(pluginDiv.isDisplayed(),"Plugins is not display");
        WebElement  plugin = driver.findElement(By.xpath("//span[@title='Plugins']/following-sibling::span"));
        Assert.assertEquals(plugin.getText(),"Plugins");

        // Settings
        WebElement settingsDiv = driver.findElement(By.id("cms-core-settings"));
        Assert.assertEquals(settingsDiv.getAttribute("href"),"https://nest.botble.com/admin/settings");
        Assert.assertTrue(settingsDiv.isDisplayed(),"Settings is not display");
        WebElement  settings = driver.findElement(By.xpath("//span[@title='Settings']/following-sibling::span"));
        Assert.assertEquals(settings.getText(),"Settings");
        // Platform Admin
        WebElement platformsDiv = driver.findElement(By.id("cms-core-system"));
        Assert.assertEquals(platformsDiv.getAttribute("href"),"https://nest.botble.com/admin/system");
        Assert.assertTrue(platformsDiv.isDisplayed(),"Platform Administration is not display");
        WebElement  platform = driver.findElement(By.xpath("//span[@title='Platform Administration']/following-sibling::span"));
        Assert.assertEquals(platform.getText(),"Platform Administration");

        // Transactions
        driver.findElement(By.id("cms-plugins-payments")).click();
        Thread.sleep(3000);
        WebElement transactionsDiv = driver.findElement(By.id("cms-plugins-payments-all"));
        Assert.assertEquals(transactionsDiv.getAttribute("href"),"https://nest.botble.com/admin/payments/transactions");
        Assert.assertTrue(transactionsDiv.isDisplayed(),"Transactions is not display");
        WebElement  transactions = driver.findElement(By.xpath("//span[@title='Transactions']/following-sibling::span"));
        Assert.assertEquals(transactions.getText(),"Transactions");
    }

    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done");
    }

}
