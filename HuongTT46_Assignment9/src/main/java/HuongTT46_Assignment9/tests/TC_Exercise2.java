package HuongTT46_Assignment9.tests;

import HuongTT46_Assignment9.core.BaseTest;
import HuongTT46_Assignment9.core.ExcelUtils;
import HuongTT46_Assignment9.pages.Rawal.PrivacyErrorPage;
import HuongTT46_Assignment9.pages.Rawal.RawalAddProductPage;
import HuongTT46_Assignment9.pages.Rawal.RawalLoginPage;
import HuongTT46_Assignment9.pages.Rawal.RawalMenuPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_Exercise2 extends BaseTest {
    @DataProvider(name="Exercise2")
    public Object[][] getData(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\TestData.xlsx","TC02", 1, 12);
    }
    @Test(dataProvider = "Exercise2")
    public void test(String category, String productName, String description, String type, String unit, String brand, String  weight, String price, String expectedMessage, String username, String password, String url) throws InterruptedException, IOException {

        RawalLoginPage rawalLoginPage = new RawalLoginPage(getDriver());
        rawalLoginPage.navigateToLogin(url);
        PrivacyErrorPage privacyErrorPage = new PrivacyErrorPage(getDriver());
        privacyErrorPage.escapeFromSecurityPage();
        rawalLoginPage.login(username, password);
        RawalMenuPage rawalMenuPage = new RawalMenuPage(getDriver());
        rawalMenuPage.clickToCatalog();
        rawalMenuPage.clickToProducts();
        rawalMenuPage.clickToAddProducts();
        RawalAddProductPage rawalAddProductPage = new RawalAddProductPage(getDriver());
        rawalAddProductPage.inputInformation(category,productName,description,type,unit,brand,weight,price);
        Assert.assertTrue(rawalAddProductPage.verifyMessage(expectedMessage));
        rawalAddProductPage.captureScreen();



    }
}
