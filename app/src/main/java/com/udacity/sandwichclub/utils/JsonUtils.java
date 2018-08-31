package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jo = new JSONObject(json);
            JSONObject nameObj = jo.getJSONObject("name");
            String mainName = nameObj.getString("mainName");
            sandwich.setMainName(mainName);
            JSONArray alsoKnownArr = nameObj.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < alsoKnownArr.length(); i++) {
                alsoKnownAsList.add(alsoKnownArr.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAsList);
            String placeOfOrigin = jo.getString("placeOfOrigin");
            if (placeOfOrigin != null) {
                sandwich.setPlaceOfOrigin(placeOfOrigin);
            }
            String desc = jo.getString("description");
            if (desc != null) {
                sandwich.setDescription(desc);
            }
            String image = jo.getString("image");
            if (image != null) {
                sandwich.setImage(image);
            }
            JSONArray ingredientsArr = jo.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredientsArr.length(); i++) {
                ingredientsList.add(ingredientsArr.getString(i));
            }
            sandwich.setIngredients(ingredientsList);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return sandwich;
    }
}
