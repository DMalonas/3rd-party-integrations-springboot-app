package com.mintos.weather.services.weather;

import com.mintos.weather.services.dto.WeatherDto;

import java.util.Optional;

public interface WeatherService {
    Optional<WeatherDto> getWeather(String ip);
}