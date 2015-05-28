package test.java.com.miwanow.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RealTimeReport implements ITestListener {

    @Override
    public void onStart(ITestContext testContext) {
        System.out.println("Start of executions (TEST)-> " + testContext.getName());
    }

    @Override
    public void onTestStart(ITestResult testResult) {
        System.out.println("Test started-> " + testResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        System.out.println("Test Pass-> " + testResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        System.out.println("Test Failed-> " + testResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        System.out.println("Test skipped-> " + testResult.getName());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        System.out.println("End of executions (TEST)-> " + testContext.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
        // TODO Auto-generated method stub
    }

}
