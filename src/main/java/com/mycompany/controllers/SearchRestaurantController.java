package com.mycompany.controllers;

import com.mycompany.apis.YelpAPI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 12/16/15.
 */
@RestController
public class SearchRestaurantController {

    private static final String CONSUMER_KEY = "YUKthTnsRrsGvxLdITAFQQ";
    private static final String CONSUMER_SECRET = "k11Bub9ykmUjfWqbUW93v7blK8c";
    private static final String TOKEN = "9QgcuRVjhHKrs0tOwRZTgFtnjEN1kXsw";
    private static final String TOKEN_SECRET = "slpL_-GYpSAJsR_xHisTqe6Dfg4";
    YelpAPI yelpAPI = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);

    @RequestMapping(value = "/api/yelp/searchRestaurant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchRestaurantWithYelp(@RequestBody String jsonData) {
        org.json.JSONObject jsonObj = new org.json.JSONObject(jsonData);
        String term = (String) jsonObj.get("term");
        String location = (String) jsonObj.get("location");
        return queryYelp(yelpAPI, term, location);

    }


    public static String queryYelp(YelpAPI yelpApi, String term, String location) {
        String searchResponseJSON =
                yelpApi.searchForBusinessesByLocation(term, location);

        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe) {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }
        JSONArray businesses = (JSONArray) response.get("businesses");
        JSONObject firstBusiness = (JSONObject) businesses.get(0);
        String firstBusinessID = firstBusiness.get("id").toString();
        String businessResponseJSON = yelpApi.searchByBusinessId(firstBusinessID.toString());
        return businessResponseJSON;
    }

}
