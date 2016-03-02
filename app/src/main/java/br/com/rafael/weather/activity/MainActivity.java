package br.com.rafael.weather.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.rafael.weather.R;
import br.com.rafael.weather.communication.request.WeatherRequest;
import br.com.rafael.weather.communication.response.WeatherResponse;
import br.com.rafael.weather.communication.service.WeatherService;

public class MainActivity extends AppCompatActivity implements WeatherService.WeatherListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.my_textview);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestWeather();
            }
        });
    }

    private void requestWeather() {

        WeatherRequest request = new WeatherRequest("London,uk");

        WeatherService service = new WeatherService(this);
        service.requestWeather(request);

    }


    @Override
    public void onWeatherRetrieve(WeatherResponse response) {
        textView.setText(response.getName());
    }

    @Override
    public void onWeatherFail() {
        Toast.makeText(this, "deu ruim", Toast.LENGTH_SHORT).show();
    }
}
