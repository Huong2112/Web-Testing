package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
    @Test
    public void test1(){
        System.out.println("I am in test 1 test method and it will pass.");
    }

    @Test
    public void test2(){
        System.out.println("I am in test 2 test method and it will fail.");
    }

    @Test
    public void test3(){
        System.out.println("Skipping test 3 test method!");
    }

    private int i = 0 ;
    @Test(successPercentage = 60, invocationCount = 5)
    public void test4(){
        i++;
        System.out.println("test4 test method , invocationCount: "+ i);
        if (i == 1 || i ==2){
            System.out.println("test4 failed!");
            Assert.assertEquals(i, 8);
        }
    }
}
