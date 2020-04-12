package com.company;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Random;

public class test2 {
    public test2() throws IOException {
    }
    Random random = new Random();
    int randomPoke = random.nextInt(151) + 1;
    BufferedReader br;
    String line;
    String badResponse = null;
    int responseCode;
    StringBuffer responseContent = new StringBuffer();
    String pokeURL = "https://pokeapi.co/api/v2/pokemon/1"/* + randomPoke*/;
    URL url = new URL(pokeURL);
    String test1;

    public void testConn() throws IOException {

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
                System.out.println(line + badResponse + responseCode);
    }
}
    public void stats() throws IOException {
        URLConnection request = url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject(); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject();
        //May be an array, may be an object.
        JsonArray types = root.getAsJsonObject().getAsJsonArray("types");
        JsonObject test = types.get(1).getAsJsonObject(); //bug: bulbasaur has two types, so when you got to a pokemone with one type this line searches for a type that doesnt exist.
        JsonObject types1 = test.getAsJsonObject("type");
        //System.out.println(types1);
        test1 = types1.get("name").getAsString();
        //System.out.println(test1);

    }

}
/*      Random random = new Random();
        int randomPoke = random.nextInt(151) + 1;
        BufferedReader br;
        String line;
        String badResponse = null;
        int responseCode;
        StringBuffer responseContent = new StringBuffer();
       // String pokeURL = "https://pokeapi.co/api/v2/pokemon/1"/* + randomPoke*/
      /*  URL url = new URL(pokeURL);
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
                }*/