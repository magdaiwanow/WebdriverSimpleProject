package test.java.com.miwanow.weather;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import test.java.com.miwanow.weather.page.WeatherForecastForSelectedCity;
import test.java.com.miwanow.weather.page.WeatherForecastHomePage;


import java.util.concurrent.TimeUnit;

public class TestSearchForWeatherForecast {
    WebDriver driver;
    WeatherForecastHomePage objHomePage;
    WeatherForecastForSelectedCity objSelectedCityPage;

    // @Parameters({"basic-tests"})
    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    @AfterTest
    public void cleanup() {
        driver.quit();
    }

}
