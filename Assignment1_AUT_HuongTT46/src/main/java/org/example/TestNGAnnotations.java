package org.example;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void setupSuite() {
        System.out.println("@BeforeSuite started.");
    }

    @BeforeTest
    public void setupTests() {
        System.out.println("@BeforeTest started.");
    }

    @BeforeClass
    public void setupClass() {
        System.out.println("@BeforeClass started.");
    }

    @BeforeMethod
    public void setupTest() {
        System.out.println("@BeforeMethod has started.");
    }



    @AfterMethod
    public void teardownTest() {
        System.out.println("@AfterMethod has started.");
    }

    @AfterClass
    public void teardownClass() {
        System.out.println("@AfterClass has started.");
    }

    @AfterTest
    public void teardownTests() {
        System.out.println("@AfterTest has started.");
    }

    @AfterSuite
    public void teardownSuite() {
        System.out.println("@AfterSuite has started.");
    }

    @Test
    public void test1(){
        System.out.println("Test case 1");
    }

    @Test
    public void test2(){
        System.out.println("Test case 2");
    }

}
