package com.example.weatherapi.service;

import com.example.weatherapi.model.Forecast;
import com.example.weatherapi.repository.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ForecastService {
    private final RestTemplate restTemplate;
    private final ForecastRepository forecastRepository;
    private final String apiKey = "810b90d2c9d2f70fc9272e2ba6e30d22";
    private final String apiUrl = "https://api.openweathermap.org/data/2.5/forecast/daily?q={city}&cnt=5&appid={apiKey}&units=metric";

    @Autowired
    public ForecastService(RestTemplate restTemplate, ForecastRepository forecastRepository) {
        this.restTemplate = restTemplate;
        this.forecastRepository = forecastRepository;
    }

    public List<Forecast> getForecast(String city) {
        ResponseEntity<Map> response = restTemplate.getForEntity(apiUrl, Map.class, city, apiKey);
        Map<String, Object> body = response.getBody();

        if (body != null) {
            List<Map<String, Object>> list = (List<Map<String, Object>>) body.get("list");
            List<Forecast> forecasts = new ArrayList<>();

            for (Map<String, Object> item : list) {
                Forecast forecast = new Forecast();
                forecast.setCity(city);
                forecast.setDate(LocalDate.ofEpochDay(((Number) item.get("dt")).longValue() / 86400));
                forecast.setTemperature(((Map<String, Object>) item.get("temp")).get("day"));
                forecast.setDescription(((List<Map<String, Object>>) item.get("weather")).get(0).get("description"));

                forecasts.add(forecast);
            }

            return forecastRepository.saveAll(forecasts);
        }

        return new ArrayList<>();
    }
}
