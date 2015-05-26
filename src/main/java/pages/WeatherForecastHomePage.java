package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherForecastHomePage {
    WebDriver driver;

    @FindBy(className = "polski")
    WebElement switchToPolish;

    @FindBy(className = "english")
    WebElement switchToEnglish;

    @FindBy(id="miastoPL")
    WebElement polishCityTextbox;

    @FindBy(id="miastoEU")
    WebElement euCityTextbox;

    @FindBy(id="linkPL")
    WebElement polishWeatherForecast;

    @FindBy(id="linkEU")
    WebElement euWeatherForecast;

    @FindBy(className="btn_submit")
    WebElement buttonShowForecast;

    @FindBy(xpath = "/html/body/header/div[2]/nav[2]/div[1]/form/ul/li[1]/div[2]/a[2]")
    WebElement buttonSwitchToCoordinates;

    @FindBy(id="wspolrzednePL")
    WebElement coordinates;


    public WeatherForecastHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getStartPageTitle() {
        return driver.getTitle();
    }

    public void switchLanguageToEnglish() {
        switchToEnglish.click();
    }

    public void switchLanguageToPolish() {
        switchToPolish.click();
    }

    public void setPolishWeatherForecast() {
        polishWeatherForecast.click();
    }

    public void setEuWeatherForecast() {
        euWeatherForecast.click();
    }

    public void enterPolishCityName(String cityNamePl){
       polishCityTextbox.sendKeys(cityNamePl);
    }

    public void enterEuCityName(String cityNamePl) {
        euCityTextbox.sendKeys(cityNamePl);
    }

    public void switchToCoordinates() {
        buttonSwitchToCoordinates.click();
    }

    public void enterCoordinates(String coordinatesPl){
        coordinates.sendKeys(coordinatesPl);
    }

    public void showWeatherForecast(){
        buttonShowForecast.click();

    }


}