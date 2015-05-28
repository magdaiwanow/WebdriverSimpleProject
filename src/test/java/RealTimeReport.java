package test.java;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RealTimeReport implements ITestListener {

    @Override
    public void onStart(ITestContext arg0){
        System.out.println("Start of executions (TEST)-> " +arg0.getName());
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        System.out.println("Test started-> " +arg0.getName());
    }

    @Override
         public void onTestSuccess(ITestResult arg0) {
        System.out.println("Test Pass-> " +arg0.getName());
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        System.out.println("Test Failed-> " +arg0.getName());
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        System.out.println("Test skipped-> " +arg0.getName());
    }

    @Override
    public void onFinish(ITestContext arg0) {
        System.out.println("End of executions (TEST)-> " +arg0.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

        // TODO Auto-generated method stub

    }


}
