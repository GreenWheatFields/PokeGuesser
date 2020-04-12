package com.company;
import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Main {



    public static void main(String[] args) throws IOException {
        Random random = new Random();
        int randomPoke = random.nextInt(151) + 1;
        BufferedReader br;
        String line;
        String badResponse = null;
        int responseCode;
        StringBuffer responseContent = new StringBuffer();
        String pokeURL = "https://pokeapi.co/api/v2/pokemon/1"/* + randomPoke*/;
        URL url = new URL(pokeURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setReadTimeout(5000);
        con.setConnectTimeout(5000);
        responseCode = con.getResponseCode();
        System.out.println(responseCode);
        if (responseCode > 299) {
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            while ((line = br.readLine()) != null) {
                responseContent.append(line);
                badResponse = "BAD HTTPS RESPONSE";
            }
            br.close();}
        else {
            line = "";
            badResponse = "";
        }

        URLConnection request = url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject(); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject();
        //May be an array, may be an object.
        JsonArray types = root.getAsJsonObject().getAsJsonArray("types");
        JsonObject test = types.get(1).getAsJsonObject(); //bug: bulbasaur has two types, so when you got to a pokemone with one type this line searches for a type that doesnt exist.
        JsonObject types1 = test.getAsJsonObject("type");
        System.out.println(types1);
        String test1 = types1.get("name").getAsString();
        System.out.println(test1);
    }

}
/*          URLConnection request = url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject(); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
            boolean isdefault = rootobj.get("is_default").getAsBoolean(); //grab is_default
            int id = rootobj.get("id").getAsInt();
            String name = rootobj.get("name").getAsString();
            System.out.println(line + badResponse);
            System.out.println(id);*/
