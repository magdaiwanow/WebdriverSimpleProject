package test.java;

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
    private int count = 0;

    @Override
    public void onTestFailure(ITestResult tr){
        ScreenShot();
    }

    private void ScreenShot() {
        try{
            String fileNamePath;
            File directory = new File(".");
            DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
            Date date = new Date();
            fileNamePath = directory.getCanonicalPath()+"\\Screenshots\\"+dateFormat.format(date) +".png";
            Robot robot = new Robot();

            BufferedImage bi=robot.createScreenCapture(new Rectangle(1280,1024));

            ImageIO.write(bi, "png", new File(fileNamePath));
            count++;//Assign each screen shot a number

            //Place the reference in TestNG web report
            Reporter.log(fileNamePath);

        } catch (AWTException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
