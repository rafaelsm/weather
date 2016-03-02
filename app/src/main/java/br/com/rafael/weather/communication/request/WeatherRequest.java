package br.com.rafael.weather.communication.request;

/**
 * Created by rafael on 3/2/16.
 */
public class WeatherRequest {

    String city;

    public WeatherRequest(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
