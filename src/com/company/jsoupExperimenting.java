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
        Document doc = Jsoup.connect("https://bulbapedia.bulbagarden.net/wiki/litwick_(Pok%C3%A9mon)").userAgent("Mozilla/5.0").get();
        String selector = "#mw-content-text > p:nth-child(3)";
        Elements elements = doc.select(selector);
        ArrayList<String> test = new ArrayList<>();
        for (Element e:elements){test.add(e.text());}
        for (String s:test){
            System.out.println(s);
        }



    }
    }



