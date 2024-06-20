package HuongTT46_Assignment9.tests;

import HuongTT46_Assignment9.core.BaseTest;
import HuongTT46_Assignment9.core.ExcelUtils;
import HuongTT46_Assignment9.pages.Amazon.HomePage;
import HuongTT46_Assignment9.pages.Amazon.ProductPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_Exercise1 extends BaseTest {
    @DataProvider(name = "Exercise1")
    public Object[][] getData(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\TestData.xlsx", "TC01", 1, 4 );
    }
    @Test(dataProvider = "Exercise1")
    public void test(String url, String catName, String key, String expectedTitle){
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage(url);
        homePage.selectCategory(catName);
        homePage.sendKeyToSearch(key);
        homePage.clickToGoBtn();
        homePage.clickToTitleOfFirstResult();
        ProductPage productPage = new ProductPage(getDriver());
        Assert.assertTrue(productPage.verifyProductTile(expectedTitle));

    }
}
