package HuongTT46_Assignment8.tests;

import Demo.core.BaseTest;
import HuongTT46_Assignment8.pages.AddProductPage;
import HuongTT46_Assignment8.pages.LoginPage;
import HuongTT46_Assignment8.pages.MenuPage;
import HuongTT46_Assignment8.pages.PrivacyErrorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class TC_Exercise3 extends BaseTest {

    @Test
    public void test() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin("https://rawal-admin.themes-coder.net/admin/login");
        PrivacyErrorPage privacyErrorPage = new PrivacyErrorPage(getDriver());
        privacyErrorPage.escapeFromSecurityPage();
        loginPage.login("owner@email.com", "123");
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToCatalog();
        menuPage.clickToProducts();
        menuPage.clickToAddProducts();
        AddProductPage addProductPage = new AddProductPage(getDriver());
        addProductPage.inputInformation();
        addProductPage.captureScreen();
        Assert.assertTrue(addProductPage.verifyMessageCreateSuccessfully("Product Save Successfully!"));

    }
}
