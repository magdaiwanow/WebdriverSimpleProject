package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeatherForecastHomePage {
    WebDriver driver;
    By switchToPolish = By.className("polski");
    By switchToEnglish = By.className("english");
    By polishCityTextbox = By.id("miastoPL");
    By euCityTextbox = By.id("miastoEU");
    By polishWeatherForecast = By.id("linkPL");
    By euWeatherForecast = By.id("linkEU");
    By buttonShowForecast = By.className("btn_submit");


    public WeatherForecastHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Get the page title
    public String getStartPageTitle() {
        return driver.getTitle();
    }

    // Change language to English
    public void switchLanguageToEnglish() {
        driver.findElement(switchToEnglish).click();
    }

    // Change language to Polish
    public void switchLanguageToPolish() {
        driver.findElement(switchToPolish).click();
    }

    //Switch to Polish weather forecast
    public void setPolishWeatherForecast() {
        driver.findElement(polishWeatherForecast).click();
    }

    //Switch to EU weather forecast
    public void setEuWeatherForecast() {
        driver.findElement(euWeatherForecast).click();
    }

    //Enter polish city name
    public void enterPolishCityName(String cityNamePl){
        driver.findElement(polishCityTextbox).sendKeys(cityNamePl);
    }

    //Enter EU city name
    public void enterEuCityName(String cityNamePl) {
        driver.findElement(euCityTextbox).sendKeys(cityNamePl);
    }

    //Show the weather forecast of selected city
    public void showWeatherForecast(){
        driver.findElement(buttonShowForecast).click();

    }


}