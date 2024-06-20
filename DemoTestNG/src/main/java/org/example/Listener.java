package org.example;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I am in onStart method " + getTestMethodName(result) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("I am in onTestSuccess method "+ getTestMethodName(result) + " success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("I am in onTestFailure method "+ getTestMethodName(result) + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("I am in onTestSkipped method: "+  getTestMethodName(result) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test fail but it is in defined success ratio " + getTestMethodName(result) );
    }


    @Override
    public void onStart(ITestContext context) {
        System.out.println("I am onStart method " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("I am on Finish method "+  context.getName());
    }
    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

}
