package com.company;

import java.io.IOException;
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

        System.out.println(name);
        var one = 1;
        int parseText = 2;
        while (one < 2) {
            parseText++;
            if (parseText >= 8){
                break;
            }
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
            String selector = "#mw-content-text > p:nth-child(" + parseText + ")";
            Elements elements = doc.select(selector);
            ArrayList<String> test = new ArrayList<>();
            for (Element e : elements) {
                test.add(e.text());
                var testing = 0;
                System.out.println(test.get(testing));
                testing++;

            }
            for (String s : test) {



            }


            one--;


        }



    }
    }



