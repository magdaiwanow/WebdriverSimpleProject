package test.java.com.miwanow.weather.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherForecastForSelectedCity {

    WebDriver driver;

    @FindBy(className = "titlePogoda")
    WebElement cityName;

    @FindBy(xpath = "/html/body/article/div/h2/span")
    WebElement coordinates;

    public WeatherForecastForSelectedCity(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCityPageTitle() {
        return driver.getTitle();
    }

    public String getCityName() {
        return cityName.getText();
    }

    public String getCoordinates() {
        String cutCoordinates = coordinates.getText();
        cutCoordinates = cutCoordinates.substring(2, 4) + cutCoordinates.substring(6, 8) + cutCoordinates.substring(12, 14) + cutCoordinates.substring(16, 18);
        return cutCoordinates;
    }

}
