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
    public static void main(String[] args) throws IOException {
        System.out.println("test");
        test2 tst = new test2();
        String name = tst.getName();
        String url = "https://bulbapedia.bulbagarden.net/wiki/" + name + "_(Pok%C3%A9mon)";
        String desc = null;
        System.out.println(name);
        ArrayList<String> test = new ArrayList<>();
        var one = 1;
        int parseText = 2;
        while (one < 2) {
            parseText++;
            if (parseText > 8){  // parseText > x , x will most likely need to be a variable that changed with selected difficulty  //3 only gets the absoloute first line, 4 is evolutions, 7 is where more infomration comes in, but its not consisitent
                break;
            }
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
            String selector1 = "#mw-content-text > p:nth-child(" + parseText + ")";
          // String selector2 = "";
            Elements elements = doc.select(selector1);
            //Elements sprites = doc.select

            for (Element e : elements) {
                test.add(e.text());
            }

        }
        desc = test.toString().replace("[", "").replace("]", "").replace(name.substring(0,1).toUpperCase() + name.substring(1), "______");
        System.out.println(desc);
    }
}



