package org.example;

import org.testng.annotations.Test;

public class TestNGGrouping {
    @Test(groups = { "Regression", "Smoke" })
    public void firstTest() {
        System.out.println("1st Test is Started.");
    }

    @Test(groups = { "Regression", "Smoke" })
    public void secondTest() {
        System.out.println("2nd Test is Started.");
    }

    @Test(groups = { "Regression" })
    public void thirdTest() {
        System.out.println("3rd Test is Started.");
    }

    @Test(groups = { "Medium" })
    public void fourthTest() {
        System.out.println("4th Test is Started.");
    }

    @Test(groups = { "Regression" })
    public void fifthTest() {
        System.out.println("5th Test is Started.");
    }

    @Test(groups = { "Medium" })
    public void sixthTest() {
        System.out.println("6th Test is Started.");
    }
}
