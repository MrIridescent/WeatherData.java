// WeatherData.java
public class WeatherData {
    private double temperature; // in Celsius
    private int humidity;
    private double windSpeed; // in km/h
    private String condition;
    
    public WeatherData(double temperature, int humidity, double windSpeed, String condition) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getCondition() {
        return condition;
    }
    
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    @Override
    public String toString() {
        return String.format("Temperature: %.1f°C\nHumidity: %d%%\nWind Speed: %.1f km/h\nCondition: %s",
                temperature, humidity, windSpeed, condition);
    }
}