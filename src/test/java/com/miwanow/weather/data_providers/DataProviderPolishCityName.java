package test.java.com.miwanow.weather.data_providers;

import org.testng.annotations.DataProvider;

public class DataProviderPolishCityName {

    @DataProvider(name = "CityNamesProvider")
    public static Object[][] getDataFromProvider() {
        return new Object[][]{
                {"gliwice"},
                {"katowice"},
                {"warszawa"}
        };
    }
}

