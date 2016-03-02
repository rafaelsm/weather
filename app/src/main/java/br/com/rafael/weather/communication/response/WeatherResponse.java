
package br.com.rafael.weather.communication.response;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.com.rafael.weather.model.Clouds;
import br.com.rafael.weather.model.Coord;
import br.com.rafael.weather.model.Main;
import br.com.rafael.weather.model.Rain;
import br.com.rafael.weather.model.Sys;
import br.com.rafael.weather.model.Weather;
import br.com.rafael.weather.model.Wind;

public class WeatherResponse {

    private Coord coord;
    private List<Weather> weather = new ArrayList<Weather>();
    private String base;
    private Main main;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private Integer dt;
    private Sys sys;
    private Integer id;
    private String name;
    private Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public static WeatherResponse fromJson(String json) {
        return new Gson().fromJson(json, WeatherResponse.class);
    }
}
