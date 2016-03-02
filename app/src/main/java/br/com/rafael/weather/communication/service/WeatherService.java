package br.com.rafael.weather.communication.service;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import br.com.rafael.weather.communication.request.WeatherRequest;
import br.com.rafael.weather.communication.response.WeatherResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rafael on 3/2/16.
 */
public class WeatherService {

    private static final String TAG = "WEATHER_SERVICE";

    WeatherListener listener;

    public WeatherService(WeatherListener listener) {
        this.listener = listener;
    }

    public void requestWeather(WeatherRequest weatherRequest) {

        final OkHttpClient client = new OkHttpClient();

        StringBuilder sb = new StringBuilder("http://api.openweathermap.org/data/2.5/weather?")
                .append("q=")
                .append(weatherRequest.getCity())
                .append("&appid=")
                .append("44db6a862fba0b067b1930da0d769e98");

        final Request request = new Request.Builder()
                .url(sb.toString())
                .build();

        new AsyncTask<Request,Void,String>(){


            @Override
            protected String doInBackground(Request... req) {
                try {

                    Response response = client.newCall(request).execute();
                    return response.body().string();

                } catch (IOException e) {
                    Log.e(TAG, "doInBackground: " + e.getLocalizedMessage());
                }

                return null;
            }


            @Override
            protected void onPostExecute(String json) {

                WeatherResponse weatherResponse = WeatherResponse.fromJson(json);

                if (weatherResponse != null){
                    listener.onWeatherRetrieve(weatherResponse);
                }else{
                    listener.onWeatherFail();
                }
            }

        }.execute(request);

    }

    public interface WeatherListener {
        void onWeatherRetrieve(WeatherResponse response);

        void onWeatherFail();
    }
}
