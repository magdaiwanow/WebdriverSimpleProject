package test.java.com.miwanow.weather.data_providers;

import org.testng.annotations.DataProvider;

public class DataProviderCoordinates {
    @DataProvider(name="CoordinatesProvider")
    public static Object [][] getDataFromDataProvider() {
        return new Object[][]{
                {"50171840"},
                {"51741950"}

        };
    }
}
