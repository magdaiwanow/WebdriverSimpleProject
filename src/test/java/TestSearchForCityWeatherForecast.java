package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import main.java.pages.WeatherForecastForSelectedCity;
import main.java.pages.WeatherForecastHomePage;

import java.util.concurrent.TimeUnit;

public class TestSearchForCityWeatherForecast {
    WebDriver driver;
    WeatherForecastHomePage objHomePage;
    WeatherForecastForSelectedCity objSelectedCityPage;


    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://m.meteo.pl/");
    }

    @Test(priority=0)
    public void test_city_searching(){

        objHomePage = new WeatherForecastHomePage(driver);
        objHomePage.enterPolishCityName("Gliwice");
        objHomePage.showWeatherForecast();

        objSelectedCityPage = new WeatherForecastForSelectedCity(driver);
        Assert.assertTrue(objSelectedCityPage.getCityName().toLowerCase().contains("gliwice"));

    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }


}
