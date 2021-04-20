package com.jiffydelivery.jiffy.Repository.APIRepository;

import com.jiffydelivery.jiffy.Repository.APIRepository.Entity.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Repository;

import java.io.IOException;



@Repository
public class WeatherClient {

    static final String baseUrl = "https://api.openweathermap.org/data/2.5/weather?";
    static final String location = "zip=%s&appid=%s";
    static final String APIKey = "a7773d26679aa84b1ad9cfec4b064eae";

    private static final ObjectMapper mapper = new ObjectMapper();
    //private static final String url = "https://api.openweathermap.org/data/2.5/weather?zip=94102,us&appid=7773d26679aa84b1ad9cfec4b064eae";

//    get Weather of a zip code.
//    https://openweathermap.org/weather-conditions

    public static int getWeather(String zipcode) throws IOException {
        zipcode += ",us";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = baseUrl + String.format(location, zipcode, APIKey);
        HttpGet request = new HttpGet(url);
        request.setHeader("Content-type", "application/json");

        ResponseHandler<Integer> responseHandler = response -> {
            if (response.getStatusLine().getStatusCode() != 200) {
                return 404;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return 0;
            }
        WeatherResponse result = mapper.readValue(entity.getContent(), WeatherResponse.class);
            return result.getWeatherId();
        };
        try {
            return httpclient.execute(request, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        WeatherClient weatherClient = new WeatherClient();
        System.out.println(WeatherClient.getWeather("94579"));
    }
}

