package com.moveo.aem.training.core.models;

import com.moveo.aem.training.core.services.WeatherService;
import com.moveo.aem.training.core.beans.DailyWeatherBean;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.List;

@Model(adaptables = Resource.class)
public class WeatherModelGezu {

    @ValueMapValue
    private String latitude;

    @ValueMapValue
    private String longtitude;

    @OSGiService
    private WeatherService weatherService;

    private List<DailyWeatherBean> dailyWeatherBeanList;


    private static Logger logger = LoggerFactory.getLogger(WeatherModelGezu.class);

    @PostConstruct
    protected void init() {

        try {
            dailyWeatherBeanList = weatherService.getDailyForecast(latitude, longtitude);
            logger.debug("Check daily forecast response");
        } catch (Exception e) {
            logger.error("there is an error is {}" + e.getMessage());
        }

    }

    public List<DailyWeatherBean> getDailyWeatherBeanList() {
        return dailyWeatherBeanList;
    }

    public DailyWeatherBean getDayOne() {
        return dailyWeatherBeanList.get(0);
    }

}
