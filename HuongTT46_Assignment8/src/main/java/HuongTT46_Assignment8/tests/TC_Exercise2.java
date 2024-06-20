package HuongTT46_Assignment8.tests;

import Demo.core.BaseTest;
import HuongTT46_Assignment8.core.ExcelUtils;
import HuongTT46_Assignment8.pages.LoginPage;
import HuongTT46_Assignment8.pages.MenuPage;
import HuongTT46_Assignment8.pages.PrivacyErrorPage;
import HuongTT46_Assignment8.pages.ProductUnitsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TC_Exercise2 extends BaseTest {
    @DataProvider(name = "testData")
    public Object[][] getData(){
        return ExcelUtils.getTableArrayToLogin("D:\\Software Testing\\Automation Testing\\ATW\\Test.xlsx", "TC01",0,2);
    }
    @Test(dataProvider = "testData")
    public void test(String email, String password)  {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin("https://rawal-admin.themes-coder.net/admin/login");
        PrivacyErrorPage privacyErrorPage = new PrivacyErrorPage(getDriver());
        privacyErrorPage.escapeFromSecurityPage();
        loginPage.login(email, password);
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToCatalog();
        menuPage.clickToProductUnit();
        ProductUnitsPage productUnitsPage = new ProductUnitsPage(getDriver());
        productUnitsPage.verifyDisplayAtLeast2RowsData();
    }
}
