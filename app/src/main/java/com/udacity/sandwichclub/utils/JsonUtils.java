package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            List<String> alsoKnownAs = new ArrayList<>();
            List<String> ingredients = new ArrayList<>();

            JSONObject j = new JSONObject(json);
            JSONObject name = j.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAsJSON = name.getJSONArray("alsoKnownAs");
            String placeOfOrigin = j.getString("placeOfOrigin");
            String description = j.getString("description");
            String image = j.getString("image");
            JSONArray ingredientsJSON = j.getJSONArray("ingredients");

            for(int i=0;i<alsoKnownAsJSON.length();i++) {
                alsoKnownAs.add(alsoKnownAsJSON.getString(i));
            }

            for(int i=0;i<ingredientsJSON.length();i++) {
                ingredients.add(ingredientsJSON.getString(i));
            }

            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return sandwich;
    }
}
