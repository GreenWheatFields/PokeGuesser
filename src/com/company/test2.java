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
import java.util.Scanner;

public class test2 {
    public test2() throws IOException {
    }
    Random random = new Random();
    int randomPoke = random.nextInt(807) + 1;
    BufferedReader br;
    String line;
    String badResponse = null;
    int responseCode;
    StringBuffer responseContent = new StringBuffer();
    String pokeURL = "https://pokeapi.co/api/v2/pokemon/" + randomPoke;
    URL url = new URL(pokeURL);
    String secondType;
    int height;
    int id;
    int weight;
    String name;
    int baseExperience;
    String firstTypeName;
    String secondTypeName;
    String frontSprite;
    String backSprite;
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    JsonParser jp = new JsonParser();
    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject();
    JsonObject rootobj = root.getAsJsonObject();




    public void testConn() throws IOException {

                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setReadTimeout(5000);
                con.setConnectTimeout(5000);
                responseCode = con.getResponseCode();
                //System.out.println(responseCode);
                if (responseCode > 299) {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                while ((line = br.readLine()) != null) {
                responseContent.append(line);
                badResponse = "BAD HTTPS RESPONSE";
                }
                br.close();}
                else if (responseCode == 0){
                    badResponse = "CANNOT CONNECT TO THE INTERNET AND/OR CANNOT CONNECT TO POKEAPI. PLEASE CHECK BOTH CONNECTIONS";
                }
                    else {
                line = "";
                badResponse = "";
                //System.out.println(line + badResponse + responseCode);
    }
                String message = "Testing connection to PokeApi...  https response code = " + responseCode + badResponse + line;
                if (responseCode == 200){
                    String good = ". good!";
                    message += good;
                }
        System.out.println(message);
                    con.disconnect();
}
    /*public void stats() throws IOException {


    }*/
    public int getHeight() {
        //request.connect(); //don't think this is necessary, will figure it out later
        height = rootobj.get("height").getAsInt(); //decimeters
        return height;
    }
    public int getID() {
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
        JsonArray types2 = root.getAsJsonObject().getAsJsonArray("types");
        int typeAmount = types2.size();
        if (typeAmount > 1){
            JsonObject secondTypeParent = types2.get(1).getAsJsonObject();
            JsonObject secondType = secondTypeParent.getAsJsonObject("type");
            secondTypeName = secondType.get("name").getAsString();
        }else{
            secondTypeName = null;
        }
        return secondTypeName;
    }
    public String getFrontSprite(){

        JsonObject sprite1 = root.getAsJsonObject().getAsJsonObject("sprites");
        frontSprite = sprite1.get("front_default").getAsString();
        System.out.println(frontSprite);
        return frontSprite;
    }
    public String getBackSprite(){

        JsonObject sprite1 = root.getAsJsonObject().getAsJsonObject("sprites");
        backSprite = sprite1.get("back_default").getAsString();
        System.out.println(backSprite);

        return backSprite;
    }



}
