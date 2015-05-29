package test.java.com.miwanow.report;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakingScreenShots extends TestListenerAdapter {

    private static final String DD_MMM_YYYY__HH_MM_SSAA = "dd_MMM_yyyy__hh_mm_ssaa";
    public static final String PNG = "png";
    private int count = 0;

    @Override
    public void onTestFailure(ITestResult testResult) {
        screenShot();
    }

    private void screenShot() {
        try {
            DateFormat dateFormat = new SimpleDateFormat(DD_MMM_YYYY__HH_MM_SSAA);
            Date date = new Date();

            File testResultsDirectory = new File(".\\test_results\\");
            if (!testResultsDirectory.exists()) {
                testResultsDirectory.mkdir();
            }

            String fileName = dateFormat.format(date) + "." + PNG;
            Robot robot = new Robot();
            BufferedImage bi = robot.createScreenCapture(new Rectangle(1280, 1024));

            ImageIO.write(bi, PNG, new File(testResultsDirectory.getCanonicalPath() + "\\"+ fileName));
            count++;
            Reporter.log(fileName);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
