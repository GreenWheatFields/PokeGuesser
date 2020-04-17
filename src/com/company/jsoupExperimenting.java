package com.company;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;

public class jsoupExperimenting {

        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36";
        test2 tst = new test2();
        String name = tst.getName();
        String url = "https://bulbapedia.bulbagarden.net/wiki/" + tst.getName() + "_(Pok%C3%A9mon)";
        String pokeDesc = null;
        String detailedSpriteURL = null;
        String lulw = null;
        ArrayList<String> test = new ArrayList<>();
       // ArrayList<String> test1 = new ArrayList<>();
        int one = 1;
        int parseText = 2;
        Document doc = Jsoup.connect(url).userAgent(userAgent).get();
    public jsoupExperimenting() throws IOException {
    }

    public String getPokeDesc() throws IOException {

        while (one < 2) {
            parseText++;
            if (parseText > 8){  // 'parseText > x' , x will most likely need to be a variable that changes with selected difficulty  //3 only gets the absoloute first line, 4 is evolutions, 7 is where more infomration comes in, but its not consisitent
                break;
            }

            String selector1 = "#mw-content-text > p:nth-child(" + parseText + ")";
            Elements elements = doc.select(selector1);



            for (Element e : elements) {
                test.add(e.text());

            }


        }

        pokeDesc = test.toString().replace("[", "").replace("]", "").replace(name.substring(0,1).toUpperCase() + name.substring(1), "______");
        return pokeDesc;
    }

    public String getDetailedSpriteURL(){
        String selector2 = "#mw-content-text > table:nth-child(2) > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td > a > img";
        Elements sprites = doc.select(selector2);
        lulw = sprites.attr("src");
        detailedSpriteURL = lulw.replace("//", "");
        return detailedSpriteURL;
    }



}



