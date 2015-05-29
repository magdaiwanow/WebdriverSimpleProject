package test.java.com.miwanow.report;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import test.java.com.miwanow.weather.TestLanguageSwitch;

public class ScreenshotListener extends TestListenerAdapter{

    @Override
    public void onTestFailure(ITestResult result){
        CaptureScreenShot(result);
        System.out.println(result.getName()+" Test Failed \n");
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println(result.getName()+" Test Passed \n");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println(result.getName()+" Test Skipped \n");
    }

    public void CaptureScreenShot(ITestResult result){
        Object obj  = result.getInstance();
        WebDriver driver = ((TestLanguageSwitch) obj).getDriver();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(".\\test_results\\"+ result.getName()+".png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}