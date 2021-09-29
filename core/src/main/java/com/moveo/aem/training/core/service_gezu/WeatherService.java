package com.moveo.aem.training.core.service_gezu;


import com.moveo.aem.training.core.services.beans.DailyWeatherBean;

import java.util.List;

public interface WeatherService {

    public List<DailyWeatherBean> getDailyForecast(String latitudine, String longitudine) throws Exception;
}
