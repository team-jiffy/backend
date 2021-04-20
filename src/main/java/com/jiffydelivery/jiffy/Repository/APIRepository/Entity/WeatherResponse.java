package com.jiffydelivery.jiffy.Repository.APIRepository.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherResponse {
    public Weather[] weather;

    public int getWeatherId() {
        return weather[0].getId();
    }

}
