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

public class    DrivingDistanceClient {
    static final String baseUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&";
    static final String APIKey = "AIzaSyBdSLzCEPaTQTlR4mrIZtmt68fQy82AKCU";

//     Get Driving distance in miles of two LatLong

    public double getDrivingDistance(PositionCoordinates position1, PositionCoordinates position2) throws MalformedURLException {

//    public double getDrivingDistance(double lat1, double lng1, double lat2, double lng2) throws MalformedURLException {
        String url1 = baseUrl + "origins=" +
                position1.getLatitude() + "," +
                position1.getLongitude() + "&destinations=side_of_road:" +
                position2.getLatitude() + "," +
                position2.getLongitude() + "&key=" + APIKey;

        URL url = new URL(url1);
        try {
//             URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=36.578581,-118.291994&destinations=side_of_road:39.7391536,-104.9847034&key=AIzaSyBdSLzCEPaTQTlR4mrIZtmt68fQy82AKCU");

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
                JSONArray arr = (JSONArray) data_obj.get("rows");
                for (int i = 0; i < arr.size(); i++) {
                    JSONObject new_obj = (JSONObject) arr.get(i);
                    if (new_obj.containsKey("elements")) {
                        JSONArray arr1 = (JSONArray) new_obj.get("elements");
                        for (int j = 0; j < arr1.size(); j++) {
                            JSONObject new_obj1 = (JSONObject) arr1.get(j);
                            if (new_obj1.containsKey("distance")) {
                                JSONObject new_obj2 = (JSONObject) new_obj1.get("distance");
                                return (Integer.valueOf((new_obj2.get("value")).toString()) * 0.621371);
                            }
                        }
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void main(String[] args) throws ParseException, MalformedURLException {
        DrivingDistanceClient drivingDistanceClient = new DrivingDistanceClient();
        PositionCoordinates position1 = new PositionCoordinates();
        PositionCoordinates position2 = new PositionCoordinates();
        position1.setLatitude(36.5785810);
        position1.setLongitude(-118.2919940);
        position2.setLatitude(36.5785810);
        position1.setLongitude(-104.98470340);
        System.out.println(drivingDistanceClient.getDrivingDistance(position1,position2));
    }
}
