package com.company;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

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
    String pokeURL = "https://pokeapi.co/api/v2/pokemon/25"  /* + randomPoke*/;
    URL url = new URL(pokeURL);
    String secondType;
    int height;
    int id;
    int weight;
    String name;
    int baseExperience;
    String firstTypeName;
    String secondTypeName;
    URLConnection request = url.openConnection();
    JsonParser jp = new JsonParser();
    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject();
    JsonObject rootobj = root.getAsJsonObject();

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

        request.connect();
         //from gson
         //Convert the input stream to a json element

        /*JsonArray types = root.getAsJsonObject().getAsJsonArray("types");
        JsonObject test = types.get(1).getAsJsonObject(); //bug: bulbasaur has two types, so when you got to a pokemone with one type this line searches for a type that doesnt exist.
        JsonObject types1 = test.getAsJsonObject("type");
        secondType = types1.get("name").getAsString();
        System.out.println(secondType);*/   //will need to add if else statement to check if a second type exist going to focus on top level attributes for now
        int id = rootobj.get("id").getAsInt();
        System.out.println(height);
    }
    public int getHeight() throws IOException {
        //request.connect(); //don't think this is necessary, will figure it out later
        height = rootobj.get("height").getAsInt(); //decimeters

        return height;
    }
    public int getID() throws IOException{
        id = rootobj.get("id").getAsInt();
        return id;
    }
    public int getWeight(){
        weight = rootobj.get("weight").getAsInt(); //hectograms
    return weight;
    }
    public String getName(){
        name = rootobj.get("name").getAsString();
        return name;
    }
    public int getBaseExperience(){
        baseExperience = rootobj.get("base_experience").getAsInt();
        return baseExperience;
    }
    public String getType(){

        JsonArray types = root.getAsJsonObject().getAsJsonArray("types");
        JsonObject firstTypeParent = types.get(0).getAsJsonObject();
        JsonObject firstType = firstTypeParent.getAsJsonObject("type");
        firstTypeName = firstType.get("name").getAsString();
        return firstTypeName;
    }
    public String getType2(){
        //secondTypeName = null;
        JsonArray types2 = root.getAsJsonObject().getAsJsonArray("types");
        int typeAmount = types2.size();
        if (typeAmount > 1){
            JsonObject secondTypeParent = types2.get(1).getAsJsonObject();
            JsonObject secondType = secondTypeParent.getAsJsonObject("type");
            secondTypeName = secondType.get("name").getAsString();
        }else{
            secondTypeName = null;
        }

        /*JsonObject secondTypeParent = types2.get(1).getAsJsonObject();
        JsonObject secondType = secondTypeParent.getAsJsonObject("type");
        secondTypeName = secondType.get("name").getAsString();*/


        return secondTypeName;
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