package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
    @DataProvider(name = "FB_Login")
    public static Object[][] credentials(){
        return new Object[][]{{"abc@gmail.com", "Test@123"}, {"def@gmail.com", "123@Test"}};
    }

    @Test(dataProvider = "FB_Login")
    public void test(String username, String password){
        System.out.println("Parameter for Username: " + username);
        System.out.println("Parameter for password: " + password);
    }
}
