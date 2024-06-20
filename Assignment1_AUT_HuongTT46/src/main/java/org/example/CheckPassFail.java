package org.example;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckPassFail {
    @Parameters({"mark"})
    @Test
    public void checkPassFail(String mark){
        int m = Integer.parseInt(mark);
        if (m  >= 50){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }



}
