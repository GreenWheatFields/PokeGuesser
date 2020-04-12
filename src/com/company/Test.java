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
public class Test {



    public static void main(String[] args) throws IOException {
    test2 tst = new test2();
        tst.testConn();
        tst.stats();
        System.out.println(tst.test1);

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
