package com.example.weatherapi.service;

import com.example.weatherapi.model.Forecast;
import com.example.weatherapi.repository.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ForecastService {
    private final RestTemplate restTemplate;
    private final ForecastRepository forecastRepository;
    private final String apiKey = "810b90d2c9d2f70fc9272e2ba6e30d22"; // Substitua pela sua chave de API válida
    private final String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q={city}&appid={apiKey}&units=metric"; // URL correta para previsões

    @Autowired
    public ForecastService(RestTemplate restTemplate, ForecastRepository forecastRepository) {
        this.restTemplate = restTemplate;
        this.forecastRepository = forecastRepository;
    }

    public List<Forecast> getForecast(String city) {
        ResponseEntity<Map> response = restTemplate.getForEntity(apiUrl, Map.class, city, apiKey);
        Map<String, Object> body = response.getBody();

        List<Forecast> forecasts = new ArrayList<>();

        if (body != null) {
            List<Map<String, Object>> list = (List<Map<String, Object>>) body.get("list");
            for (Map<String, Object> item : list) {
                Map<String, Object> main = (Map<String, Object>) item.get("main");
                List<Map<String, Object>> weatherList = (List<Map<String, Object>>) item.get("weather");
                Map<String, Object> weather = weatherList.get(0);

                Forecast forecast = new Forecast();
                forecast.setCity(city);
                forecast.setDate(Instant.ofEpochSecond(((Number) item.get("dt")).longValue())
                        .atZone(ZoneId.systemDefault()).toLocalDate());
                forecast.setTemperature(getDoubleValue(main.get("temp")));
                forecast.setDescription((String) weather.get("description"));

                forecasts.add(forecast);
            }
        }

        return forecasts;
    }

    private Double getDoubleValue(Object value) {
        if (value instanceof Integer) {
            return ((Integer) value).doubleValue();
        } else if (value instanceof Double) {
            return (Double) value;
        } else {
            return null;
        }
    }
}
