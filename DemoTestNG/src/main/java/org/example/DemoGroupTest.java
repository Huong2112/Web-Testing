package org.example;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class DemoGroupTest {


    @BeforeGroups
    public void beforeGroup(){
        System.out.println("BeforeGroup");
    }

    @AfterGroups
    public void afterGroup(){
        System.out.println("AfterGroup");
    }
    @Test(groups = {"Regression", "Smoke"})
    public void firstTest(){
        System.out.println("1st test is started");
    }

    @Test(groups = {"Regression", "Smoke"})
    public void secondTest(){
        System.out.println("2nd test is started");
    }
    @Test(groups = {"Regression"})
    public void thirdTest(){
        System.out.println("3rd test is started");
    }

    @Test(groups = {"Medium"})
    public void fourthTest(){
        System.out.println("4th test is started");
    }

    @Test(groups = {"Regression"})
    public void fifthTest(){
        System.out.println("5ht test is started");
    }
    @Test(groups = {"Medium"})
    public void sixthTest(){
        System.out.println("6th test is started");
    }

}
