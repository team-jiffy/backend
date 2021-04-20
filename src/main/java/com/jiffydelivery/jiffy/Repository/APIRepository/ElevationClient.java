package com.jiffydelivery.jiffy.Repository.APIRepository;

import com.jiffydelivery.jiffy.Entity.DAO.PositionCoordinates;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class ElevationClient {
        static final String baseUrl = "https://maps.googleapis.com/maps/api/elevation/json?";
        static final String APIKey = "AIzaSyBdSLzCEPaTQTlR4mrIZtmt68fQy82AKCU";

//get Elevation of a LatLong

    public PositionCoordinates getElevation(PositionCoordinates coordinates) throws MalformedURLException {
        String url1 = baseUrl + "locations=" +
                coordinates.getLatitude() + "," +
                coordinates.getLatitude() + "&key=" + APIKey;
        URL url = new URL(url1);
        try {
            // URL url = new URL("https://maps.googleapis.com/maps/api/elevation/json?locations=39.7391536,-104.9847034&key=AIzaSyBdSLzCEPaTQTlR4mrIZtmt68fQy82AKCU");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);

                //Get the required object from the above created object
//
                JSONArray arr = (JSONArray) data_obj.get("results");
                for (int i = 0; i < arr.size(); i++) {
                    JSONObject new_obj = (JSONObject) arr.get(i);
                    if (new_obj.containsKey("elevation")) {
                        coordinates.setElevation(Double.valueOf(new_obj.get("elevation").toString()));
                        return coordinates;
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        public static void main(String[] args) throws ParseException, MalformedURLException {
            ElevationClient elevationClient = new ElevationClient();
            PositionCoordinates position = new PositionCoordinates();
            position.setLatitude(36.5785810);
            position.setLongitude(-118.291994);
            System.out.println(elevationClient.getElevation(position));
        }
}








