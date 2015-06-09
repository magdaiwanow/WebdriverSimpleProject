package test.java.com.miwanow.weather;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import test.java.com.miwanow.weather.page.WeatherForecastHomePage;
import test.java.com.miwanow.report.TakingScreenShots;


@Listeners({TakingScreenShots.class})
public class TestLanguageSwitch {

    private WebDriver driver;
    private WeatherForecastHomePage objHomePage;

    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(String browser)
    {
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","D://SeleniumWebDriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "D://SeleniumWebDriver//IEDriverServer");
            driver = new InternetExplorerDriver();
        }
        else
        {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
        driver.manage().window().maximize();
        driver.get("http://m.meteo.pl/");
    }


    @Test
    public void shouldChangeLanguageToEnglish() {
        objHomePage = new WeatherForecastHomePage(driver);

        String homePageTitle = objHomePage.getStartPageTitle();

        Assert.assertEquals(homePageTitle.toLowerCase(), "icm meteo \u2013 nowa wersja");

        objHomePage.switchLanguageToEnglish();
        String homePageTitleEnglish = objHomePage.getStartPageTitle();
        Assert.assertEquals(homePageTitleEnglish.toLowerCase(), "icm meteo \u2013 new version");
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}

