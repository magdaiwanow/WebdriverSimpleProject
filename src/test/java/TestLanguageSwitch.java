package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import main.java.pages.WeatherForecastHomePage;

import java.util.concurrent.TimeUnit;
@Listeners({TakingScreenShots.class})
public class TestLanguageSwitch {

    WebDriver driver;
    WeatherForecastHomePage objHomePage;

    @Parameters({"basic-tests"})
    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://m.meteo.pl/");
    }

    @Test
    public void test_language_switch(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://m.meteo.pl/");
        objHomePage = new WeatherForecastHomePage(driver);

        String homePageTitle = objHomePage.getStartPageTitle();

        Assert.assertEquals(homePageTitle.toLowerCase(), "icm meteo \u2013 nowa wersja" );
        // Assert.assertTrue(homePageTitle.toLowerCase().contains("icm meteo"));

        //switch language to English
        objHomePage.switchLanguageToEnglish();
        String homePageTitleEnglish = objHomePage.getStartPageTitle();
        Assert.assertEquals(homePageTitleEnglish.toLowerCase(), "icm meteo \u2013 new wersja" );

        }
    @AfterTest
        public void cleanup() {
        driver.quit();
    }
}

