package com.company;

import java.io.*;

public class Test {



    public static void main(String[] args) throws IOException {
    test2 tst = new test2();
    tst.testConn();
    int pokeHeight;
    pokeHeight = tst.getHeight();
    System.out.println(pokeHeight);
    int id = tst.getID();
        System.out.println(id);
    String firstTypeName = tst.getType();
        System.out.println(firstTypeName);
    String secondTypeName = tst.getType2();
        System.out.println(secondTypeName);


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
