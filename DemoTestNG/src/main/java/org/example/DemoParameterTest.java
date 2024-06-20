package org.example;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameterTest {
    @Parameters({"username", "password"})
    @Test
    public void testcaseTwo(String username, String password){
        System.out.println("Parameter for Username passed as: "+ username);
        System.out.println("Paramenter for Password passed as: " + password);
    }
}
