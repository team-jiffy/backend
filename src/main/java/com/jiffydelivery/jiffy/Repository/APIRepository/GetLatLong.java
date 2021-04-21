package com.jiffydelivery.jiffy.Repository.APIRepository;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetLatLong {
        static final String baseUrl = "https://maps.googleapis.com/maps/api/geocode/json?";
        static final String location = "address=%s&Key=%s";
        static final String APIKey = "AIzaSyBdSLzCEPaTQTlR4mrIZtmt68fQy82AKCU";

//        get LatLong of an address

        public double[] getCoordinates(Address address) throws MalformedURLException {
                String addressString = address.getStreet1() + " " +
                                        address.getStreet2() + ", " +
                                        "San Francisco" + " " +
                                        "CA";
                addressString = addressString.replaceAll("\\s+","+");
                String url1 = baseUrl + "address="+addressString + "&key=" + APIKey;
                URL url = new URL(url1);
                try {
//                        String tmp = "https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,Mountain+View,+CA&key=AIzaSyBdSLzCEPaTQTlR4mrIZtmt68fQy82AKCU";
//                        URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,Mountain+View,+CA&key=AIzaSyBdSLzCEPaTQTlR4mrIZtmt68fQy82AKCU");
//                        System.out.println("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,Mountain+View,+CA&key=AIzaSyBdSLzCEPaTQTlR4mrIZtmt68fQy82AKCU");
//                        System.out.println(url1);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                        System.out.println(tmp.equals(baseUrl + "address="+address + "&key=" + APIKey));
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
                                        if (new_obj.containsKey("geometry")) {
                                                JSONObject new_obj1 = (JSONObject) new_obj.get("geometry");
                                                if (new_obj1.containsKey("location")) {
                                                        JSONObject new_obj2 = (JSONObject) new_obj1.get("location");

                                                        List<String> result = new ArrayList<>();
                                                        result.add(((new_obj2.get("lat")).toString()));
                                                        result.add(((new_obj2.get("lng")).toString()));
                                                        double[] result1 = new double[2];
                                                        for(int j = 0; j <result1.length; j++) {
                                                                result1[j] = Double.parseDouble(result.get(j));
                                                        }
                                                        System.out.println(result);
                                                        return result1;
//                                                        result1[0] = Double.parseDouble(result.get(0));
//                                                        result1[1] = Double.parseDouble(result.get(1));


//                                                        System.out.println(new_obj2.toString());
//
//                                                        result[0] = new_obj2.getString("lat");
//                                                        result[1] = String.valueOf(new_obj2.get("lng"));

                                                        //double[0] = Double.parseDouble(new_obj2.get("lat"));

                                                        //System.out.println(new_obj1.get("arr1"));

                                                }
                                        }
                                }
                        }

                } catch(Exception e){
                        e.printStackTrace();
                }
                return null;
        }
        public static void main(String[] args) throws ParseException, MalformedURLException {
                GetLatLong googleClient = new GetLatLong();
                Address address = new Address();
                address.setStreet1("1600 Amphitheatre Parkway");
                address.setCity("Mountain View");
                System.out.println(address);//format the address

        }
}


