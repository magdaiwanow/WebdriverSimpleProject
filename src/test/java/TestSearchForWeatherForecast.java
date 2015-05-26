package test.java;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import main.java.pages.WeatherForecastForSelectedCity;
import main.java.pages.WeatherForecastHomePage;
import org.testng.annotations.Parameters;


import java.util.concurrent.TimeUnit;

public class TestSearchForWeatherForecast {
    WebDriver driver;
    WeatherForecastHomePage objHomePage;
    WeatherForecastForSelectedCity objSelectedCityPage;


    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://m.meteo.pl/");
    }
    @Parameters({"city"})
    @Test(priority=0)
    public void test_city_searching(String city){

        objHomePage = new WeatherForecastHomePage(driver);
        objHomePage.enterPolishCityName(city);
        objHomePage.showWeatherForecast();

        objSelectedCityPage = new WeatherForecastForSelectedCity(driver);
        Assert.assertTrue(objSelectedCityPage.getCityName().toLowerCase().contains(city));

    }
    @Parameters({"coordinates"})
    @Test
    public void test_coordinates_searching(String param)
    {
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
