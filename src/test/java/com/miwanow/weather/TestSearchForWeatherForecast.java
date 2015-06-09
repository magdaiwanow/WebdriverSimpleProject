package test.java.com.miwanow.weather;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import test.java.com.miwanow.report.TakingScreenShots;
import test.java.com.miwanow.weather.page.WeatherForecastForSelectedCity;
import test.java.com.miwanow.weather.page.WeatherForecastHomePage;


import java.util.concurrent.TimeUnit;
@Listeners({TakingScreenShots.class})
public class TestSearchForWeatherForecast {
    WebDriver driver;
     WeatherForecastHomePage objHomePage;
    WeatherForecastForSelectedCity objSelectedCityPage;

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


    @Parameters({"city"})
    @Test(priority = 0)
    public void test_city_searching(String city) {

        objHomePage = new WeatherForecastHomePage(driver);
        objHomePage.enterPolishCityName(city);
        objHomePage.showWeatherForecast();

        objSelectedCityPage = new WeatherForecastForSelectedCity(driver);
        Assert.assertTrue(objSelectedCityPage.getCityName().toLowerCase().contains(city));

    }

    @Parameters({"coordinates"})
    @Test
    public void test_coordinates_searching(String param) {
        objHomePage = new WeatherForecastHomePage(driver);
        objHomePage.switchToCoordinates();
        objHomePage.enterCoordinates(param);
        objHomePage.showWeatherForecast();

        objSelectedCityPage = new WeatherForecastForSelectedCity(driver);
        objSelectedCityPage.getCoordinates();
        Assert.assertEquals(objSelectedCityPage.getCoordinates(), param);


    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
