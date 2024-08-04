package com.example.weatherapi.service;

import com.example.weatherapi.model.WeatherData;
import com.example.weatherapi.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final WeatherDataRepository weatherDataRepository;
    private final String apiKey = "YOUR_OPENWEATHERMAP_API_KEY";
    private final String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";

    @Autowired
    public WeatherService(RestTemplate restTemplate, WeatherDataRepository weatherDataRepository) {
        this.restTemplate = restTemplate;
        this.weatherDataRepository = weatherDataRepository;
    }

    public WeatherData getWeatherData(String city) {
        ResponseEntity<Map> response = restTemplate.getForEntity(apiUrl, Map.class, city, apiKey);
        Map<String, Object> body = response.getBody();

        if (body != null) {
            Map<String, Object> main = (Map<String, Object>) body.get("main");
            Map<String, Object> weather = ((List<Map<String, Object>>) body.get("weather")).get(0);

            WeatherData weatherData = new WeatherData();
            weatherData.setCity(city);
            weatherData.setTemperature((Double) main.get("temp"));
            weatherData.setHumidity((Integer) main.get("humidity"));
            weatherData.setDescription((String) weather.get("description"));
            weatherData.setTimestamp(LocalDateTime.now());

            return weatherDataRepository.save(weatherData);
        }

        return null;
    }
}
