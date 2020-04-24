package com.company;

import com.google.gson.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Stats {
    public Stats() throws IOException {}
    public int randomPoke;



    int one = 1;
    int parseText = 2;
    int responseCode;
    int height;
    int id;
    int weight;
    int baseExperience;

    String firstTypeName;
    String secondTypeName;
    String frontSprite;
    String backSprite;
    String name;
    String line;
    String badResponse = null;
    String pokeURL = "https://pokeapi.co/api/v2/pokemon/" + GenerationSelect.getRandomPoke();
    int lulw = GenerationSelect.getSize();

    String pokeDesc = null;
    String detailedSprite = null;
    String firstGens;

    StringBuffer responseContent = new StringBuffer();
    URL pokeAPI = new URL(pokeURL);
    HttpURLConnection con = (HttpURLConnection) pokeAPI.openConnection();
    URL bulbapedia = new URL("https://bulbapedia.bulbagarden.net/wiki/Main_Page");
    BufferedReader br;

    JsonParser jp = new JsonParser();
    JsonElement root = jp.parse(new InputStreamReader((InputStream) con.getContent())).getAsJsonObject();
    JsonObject rootobj = root.getAsJsonObject();

    ArrayList<String> desc = new ArrayList<>();




    public void testConn() throws IOException {
                HttpURLConnection con2 = (HttpURLConnection) bulbapedia.openConnection(); // this might be inefficient, it opens a connection with no definent instructions
                con.setReadTimeout(5000);
                con2.setReadTimeout(5000);
                con.setConnectTimeout(5000);
                con2.setConnectTimeout(5000);
                responseCode = con.getResponseCode();
                var responseCode2 = con2.getResponseCode();
                if (responseCode > 299 || responseCode2 > 299) {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                while ((line = br.readLine()) != null) {
                responseContent.append(line);
                badResponse = "BAD HTTPS RESPONSE FROM EITHER POKEAPI OR BULBAPEDIA";
                }
                br.close();}
                else if (responseCode == 0){
                    badResponse = "CANNOT CONNECT TO THE INTERNET PLEASE CHECK CONNECTIONS";
                }
                    else {
                line = "";
                badResponse = "";
    }
                String message = "Testing connection to PokeApi and Bulbapedia...  PokeApi https response code = " + responseCode + " Bulbapedia response code = \n" + responseCode2 + badResponse + line;
                if (responseCode == 200 && responseCode2 == 200){
                    String good = ". good!";
                    message += good;
                }
        System.out.println(message);
                    con.disconnect();
        }

    public int getHeight() {
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
        firstTypeName = firstTypeName.substring(0,1).toUpperCase() + firstTypeName.substring(1);
        return firstTypeName;
    }
    public String getType2(){
        JsonArray types2 = root.getAsJsonObject().getAsJsonArray("types");
        int typeAmount = types2.size();
        if (typeAmount > 1){
            JsonObject secondTypeParent = types2.get(1).getAsJsonObject();
            JsonObject secondType = secondTypeParent.getAsJsonObject("type");
            secondTypeName = secondType.get("name").getAsString();
            secondTypeName = secondTypeName.substring(0,1).toUpperCase() + secondTypeName.substring(1);
        }else{
            secondTypeName = null;
        }
        return secondTypeName;
    }
    public String getFirstGens(){
        JsonArray gameIndex = root.getAsJsonObject().getAsJsonArray("game_indices");
        int length = gameIndex.size() - 1;
        if (length <= -1){
           int  id = rootobj.get("id").getAsInt();
           if (id > 649 && id < 722){
               firstGens = "X/Y";
           }else if (id > 721 && id < 808){
               firstGens = "Sun/Moon";
            }
        }else if (length >= 0) {

            JsonObject gameIndexParent = gameIndex.get(length).getAsJsonObject();
            JsonObject firstGenParent = gameIndexParent.getAsJsonObject("version");
            String firstGen = firstGenParent.getAsJsonPrimitive("name").getAsString();
            JsonObject gameIndexParent2 = gameIndex.get(length - 1).getAsJsonObject();
            JsonObject secondGenParent = gameIndexParent2.getAsJsonObject("version");
            String secondGen = secondGenParent.getAsJsonPrimitive("name").getAsString();
            firstGens = firstGen.substring(0,1).toUpperCase() + firstGen.substring(1) + " and " + secondGen.substring(0,1).toUpperCase() + secondGen.substring(1);
        }
        return firstGens;
    }


    public String getFrontSprite(){

        JsonObject sprite1 = root.getAsJsonObject().getAsJsonObject("sprites");
        frontSprite = sprite1.get("front_default").getAsString();
        return frontSprite;
    }
    public String getBackSprite(){

        JsonObject sprite1 = root.getAsJsonObject().getAsJsonObject("sprites");
        backSprite = sprite1.get("back_default").getAsString();
        return backSprite;
    }
    public String getPokeDesc(int parseLength) throws IOException {

        checkName ck = new checkName();
        name = rootobj.get("name").getAsString();
        name = ck.checkName(name);
        String parseKey = ck.getParseKey();
        if (parseKey == null){
            parseKey = name.substring(0,1).toUpperCase() + name.substring(1);}

        while (one < 2) {
            parseText++;
            if (parseText > parseLength){  // parseText > x , x will most likely need to be a variable that changed with selected difficulty  //3 only gets the absoloute first line, 4 is evolutions, 7 is where more infomration comes in, but its not consisitent
                break;
            }
            String url2 = "https://bulbapedia.bulbagarden.net/wiki/" + name + "_(Pok%C3%A9mon)";
            Document doc = Jsoup.connect(url2).userAgent("Mozilla/5.0").get();
            String selector1 = "#mw-content-text > p:nth-child(" + parseText + ")";
            Elements elements = doc.select(selector1);

            for (Element e : elements) {
                desc.add(e.text());
            }
        }
        pokeDesc = desc.toString().replace("[", "").replace("]", "").replace(parseKey, "______");
        return pokeDesc;
    }
    public String getDetailedSprite() throws IOException {
        String urlPlaceholder;
        name = rootobj.get("name").getAsString();
        checkName ck = new checkName();
        name = ck.checkName(name);
        String url2 = "https://bulbapedia.bulbagarden.net/wiki/" + name + "_(Pok%C3%A9mon)";
        Document doc = Jsoup.connect(url2).userAgent("Mozilla/5.0").get();
        String selector2 = "#mw-content-text > table:nth-child(2) > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td > a > img";
        Elements sprites = doc.select(selector2);
        urlPlaceholder = sprites.attr("src");
        detailedSprite = urlPlaceholder.replace("//", "");
        return detailedSprite;
    }
}
