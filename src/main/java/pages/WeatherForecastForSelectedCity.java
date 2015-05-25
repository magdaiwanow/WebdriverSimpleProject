package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WeatherForecastForSelectedCity{

    WebDriver driver;
    By cityName = By.className("titlePogoda");


    public WeatherForecastForSelectedCity(WebDriver driver) {
        this.driver = driver;
    }

    public String getCityPageTitle() {
        return driver.getTitle();
    }

    public String getCityName() {
       return driver.findElement(cityName).getText();
    }
}
