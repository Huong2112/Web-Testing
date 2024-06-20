package HuongTT46_Assignment8.tests;

import Demo.core.BaseTest;
import HuongTT46_Assignment8.pages.LoginPage;
import HuongTT46_Assignment8.pages.MenuPage;
import HuongTT46_Assignment8.pages.PrivacyErrorPage;
import org.testng.Assert;

import org.testng.annotations.Test;

public class TC_Exercise1 extends BaseTest {
    @Test(priority = 1)
    public void testCase1(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin("https://rawal-admin.themes-coder.net/admin/login");
        PrivacyErrorPage privacyErrorPage = new PrivacyErrorPage(getDriver());
        privacyErrorPage.escapeFromSecurityPage();
        loginPage.login("admin@email.com","123");
        MenuPage menuPage = new MenuPage(getDriver());
        Assert.assertTrue(menuPage.verifyLoginSuccessfully());
    }

    @Test(priority = 2)
    public void testCase2(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin("https://rawal-admin.themes-coder.net/admin/login");
        loginPage.login("fake@email.com","12456");
        loginPage.verifyInputInvalidData("invalid Credentials");

    }

    @Test(priority = 3)
    private void testCase3(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin("https://rawal-admin.themes-coder.net/admin/login");
        loginPage.login("","");
        loginPage.verifyInputInvalidData("invalid Credentials");

    }
}
