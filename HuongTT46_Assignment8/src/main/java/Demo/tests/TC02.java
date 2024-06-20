package Demo.tests;

import Demo.core.BaseTest;
import Demo.core.ExcelUtils;
import Demo.pages.CustomerPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Demo.pages.CustomerListPage;
import Demo.pages.LoginPage;
import Demo.pages.MenuPage;

public class TC02 extends BaseTest {

    @DataProvider(name = "testData")
    public Object[][] getData(){
        return ExcelUtils.getTableArray("D:\\Software Testing\\Automation Testing\\ATW\\TestData.xlsx", "TC01",0,6);
    }
    @Test (dataProvider = "testData")
    public void test(String username, String password , String firstname, String lastname, String email, String message) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin("https://osc-ultimate-demo.mageplaza.com/admin/admin/");
        loginPage.login(username, password);

        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToMenuCustomer();
        menuPage.clickToMenuAllCustomers();

        CustomerListPage customerListPage = new CustomerListPage(getDriver());
        customerListPage.clickToAddNewCustomer();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.createNewCustomer(firstname, lastname, email);
        Thread.sleep(1000);
        Assert.assertTrue(customerListPage.verifyMessage(message));
    }

}
