package org.example;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void setupSuite(){
        System.out.println("@BeforeSuite started.");
    }
    @BeforeTest
    public void setupSet(){
        System.out.println("@BeforeTest started.");
    }
    @BeforeClass
    public void setupClass(){
        System.out.println("@BeforeClass started");
    }

    @BeforeMethod
    public void setupTest(){
        System.out.println("@BeforeMethod started.");
    }

    @AfterMethod
    public void teardownTest(){
        System.out.println("@AfterMethod started.");
    }

    @Test
    public void Atest(){
        System.out.println("@Test started" );
    }

    @AfterClass
    public void teardownClass(){
        System.out.println("@AfterClass started.");
    }

    @AfterTest
    public void teardownTests(){
        System.out.println("@AfterTest started.");
    }
    @AfterSuite
    public void teardownSuite(){
        System.out.println("@AfterSuite has started");
    }

}
