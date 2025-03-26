// WeatherAPI.java
public class WeatherAPI {
    // In a real implementation, include your API key and URL here.
    // private static final String API_KEY = "523c0b55952c4ca484b183400252603";
    // private static final String API_URL = "https://api.weatherapi.com/v1/current.json?key=";

    /**
     * Simulates fetching weather data for a given location.
     * Replace this dummy implementation with your API integration logic.
     */
    public static WeatherData getWeather(String location, boolean useMetric) {
        // Simulate different data based on location
        // In real usage, perform HTTP GET request and parse the JSON response
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be empty");
        }
        
        // Dummy data (you can customize based on location)
        double temperature = 25.0;
        int humidity = 60;
        double windSpeed = 10.0;
        String condition = "Sunny";
        
        // If using imperial units, convert temperature (Celsius to Fahrenheit) and wind speed (km/h to mph)
        if (!useMetric) {
            temperature = (temperature * 9/5) + 32; // Convert to Fahrenheit
            windSpeed = windSpeed * 0.621371; // Convert to mph
        }
        
        return new WeatherData(temperature, humidity, windSpeed, condition);
    }
}
