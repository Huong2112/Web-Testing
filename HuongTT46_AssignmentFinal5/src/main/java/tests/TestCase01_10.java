package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;


public class TestCase01_10 extends BaseTest {

    @DataProvider(name = "TC_01")
    public Object[][] getData01(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\HuongTT46_AssignmentFinal5\\TestDataFinal5.xlsx", "Login", 1, 1);
    }
    @Test(dataProvider = "TC_01")
    public void TC_01(String url){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        Assert.assertTrue(loginPage.verifyUserNameCombobox());
        Assert.assertTrue(loginPage.verifyPasswordText());
        Assert.assertTrue(loginPage.verifyRememberMe());
        Assert.assertTrue(loginPage.verifyLoginButton());
    }
    @DataProvider(name = "TC_02")
    public Object[][] getData02(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\HuongTT46_AssignmentFinal5\\TestDataFinal5.xlsx", "Login", 1, 4);
    }
    @Test(dataProvider = "TC_02")
    public void TC_02(String url, String username, String password, String expectedMessage){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.verifyLoginSuccessfully(expectedMessage));
    }


    @DataProvider(name = "TC_03")
    public Object[][] getData03(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\HuongTT46_AssignmentFinal5\\TestDataFinal5.xlsx", "Login", 1, 3);
    }
    @Test(dataProvider = "TC_03")
    public void TC_03(String url, String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToProducts();
        menuPage.clickToListProduct();
        ProductListPage productListPage = new ProductListPage(getDriver());
        Assert.assertTrue(productListPage.verifyTableDisplayColumn());

    }

    @DataProvider(name = "TC_04")
    public Object[][] getData04(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\HuongTT46_AssignmentFinal5\\TestDataFinal5.xlsx", "TC_04", 1, 15);
    }
    @Test(dataProvider = "TC_04")
    public void TC_04(String url, String username, String password, String keyToSearch,
                      String expType, String expName, String expCode,
                      String expCategories, String expUnit, String expCost,
                      String expPrice, String expTaxRate, String expTaxMethod,
                      String expAlert, String expProductDetails) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToProducts();
        menuPage.clickToListProduct();
        ProductListPage productListPage = new ProductListPage(getDriver());
        productListPage.searchAndClickProduct(keyToSearch);
        ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
        Assert.assertTrue(productDetailPage.verifyProductDetail(expType, expName, expCode, expCategories,expUnit,expCost,expPrice, expTaxRate, expTaxMethod,expAlert, expProductDetails));
        productDetailPage.clickToCloseDetailsPage();
        Thread.sleep(500);



    }


    @DataProvider(name = "TC_05")
    public Object[][] getData05(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\HuongTT46_AssignmentFinal5\\TestDataFinal5.xlsx", "TC_05", 1, 8);
    }
    @Test(dataProvider = "TC_05")
    public void TC_05(String url, String username, String password, String keyToSearch,
                      String editType, String editCode, String editTaxMethod, String expMessage) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToProducts();
        menuPage.clickToListProduct();
        ProductListPage productListPage = new ProductListPage(getDriver());
        productListPage.searchAndClickProduct(keyToSearch);
       ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
        productDetailPage.clickToEditButton();
        EditProductPage editProductPage = new EditProductPage(getDriver());
        editProductPage.editProduct(editType, editCode, editTaxMethod);
        Assert.assertTrue(editProductPage.verifyMessage(expMessage));

    }


    @DataProvider(name = "TC_06")
    public Object[][] getData06(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\HuongTT46_AssignmentFinal5\\TestDataFinal5.xlsx", "Login", 1, 3);
    }
    @Test(dataProvider = "TC_06")
    public void TC_06(String url, String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToProducts();
        menuPage.clickToPrintBarCodeLabel();
        PrintBarCodeAndLabelPage printBarCodeAndLabelPage = new PrintBarCodeAndLabelPage(getDriver());
            Assert.assertTrue(printBarCodeAndLabelPage.verifyPrintBarcodeAndLabelPage());
    }


    @DataProvider(name = "TC_07")
    public Object[][] getData07(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\HuongTT46_AssignmentFinal5\\TestDataFinal5.xlsx", "TC_07", 1, 10);
    }
    @Test(dataProvider = "TC_07")
    public void TC_07(String url, String username, String password,String pName, String pstyle, String site, String name, String price, String unit, String category) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToProducts();
        menuPage.clickToPrintBarCodeLabel();
        PrintBarCodeAndLabelPage printBarCodeAndLabelPage = new PrintBarCodeAndLabelPage(getDriver());
        printBarCodeAndLabelPage.createBarCodeLabel(pName, pstyle);
        printBarCodeAndLabelPage.clickToUpdateButton();
        BarcodeDisplayPage barcodeDisplayPage = new BarcodeDisplayPage(getDriver());
        Assert.assertTrue(barcodeDisplayPage.verifyDisplayBarCode(site, name, price, unit, category ));

    }


    @DataProvider(name = "TC_08")
    public Object[][] getData08(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\HuongTT46_AssignmentFinal5\\TestDataFinal5.xlsx", "TC_08", 1, 6);
    }
    @Test(dataProvider = "TC_08")
    public void TC_08(String url, String username, String password, String customer, String productName, String expectedMessage ) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToSales();
        menuPage.clickToAddSale();

        AddSalePage addSalePage = new AddSalePage(getDriver());
        addSalePage.addSale(customer, productName);

        ListSalesPage listSalesPage = new ListSalesPage(getDriver());
        listSalesPage.verifyAddSaleSuccessfully(expectedMessage);

    }

    @DataProvider(name = "TC_09")
    public Object[][] getData09(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\HuongTT46_AssignmentFinal5\\TestDataFinal5.xlsx", "TC_09", 1, 5);
    }
    @Test(dataProvider = "TC_09")
    public void TC_09(String url, String username, String password, String pattern, String purchaseNum){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToPurchase();
        menuPage.clickToListPurchase();
        ListPurchasePage listPurchasePage = new ListPurchasePage(getDriver());
        Assert.assertTrue(listPurchasePage.verifyDateTimeFormat(pattern));
        Assert.assertTrue(listPurchasePage.verifyOderNoDesc());
        Assert.assertTrue(listPurchasePage.verifyPurchaseNumber(Integer.parseInt(purchaseNum)));


    }




    @DataProvider(name = "TC_10")
    public Object[][] getData10(){
        return ExcelUtils.getTableArray("D:\\AUT_Demo\\WEB\\HuongTT46_AssignmentFinal5\\TestDataFinal5.xlsx", "TC_10", 1, 6);
    }
    @Test(dataProvider = "TC_10")
    public void TC_10(String url, String username, String password, String supplier , String productName, String expectedMessage ) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.clickToPurchase();
        menuPage.clickToAddPurchase();
        AddPurchasePage addPurchasePage = new AddPurchasePage(getDriver());
        addPurchasePage.addPurchase(supplier, productName);
        ListPurchasePage listPurchasePage = new ListPurchasePage(getDriver());
        Assert.assertTrue(listPurchasePage.verifyAddSuccessfully(expectedMessage));


    }

}
