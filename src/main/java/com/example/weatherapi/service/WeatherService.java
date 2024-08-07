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
    private final String apiKey = "810b90d2c9d2f70fc9272e2ba6e30d22";
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
            Map<String, Object> weather = ((Map<String, Object>) ((List<?>) body.get("weather")).get(0));

            WeatherData weatherData = new WeatherData();
            weatherData.setCity(city);
            weatherData.setTemperature((Double) main.get("temp"));
            weatherData.setHumidity((Integer) main.get("humidity"));
            weatherData.setDescription((String) weather.get("description"));
            weatherData.setTimestamp(LocalDateTime.now());

            WeatherData savedData = weatherDataRepository.save(weatherData);
            System.out.println("Saved weather data: " + savedData);
            return savedData;
        }

        return null;
    }

    public List<WeatherData> getWeatherHistory(String city) {
        List<WeatherData> weatherHistory = weatherDataRepository.findByCityOrderByTimestampDesc(city);
        System.out.println("Weather history for city: " + city + ", size: " + weatherHistory.size());
        return weatherHistory;
    }
}
