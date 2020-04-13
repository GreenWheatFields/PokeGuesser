package com.company;

import java.io.*;

public class Test {



    public static void main(String[] args) throws IOException {
    test2 tst = new test2();
    tst.testConn();



        String name = tst.getName();
        //System.out.println(name);
        String pokeURL = tst.pokeURL;
        System.out.println(tst.pokeURL);
        //name = tst.getName();
        //System.out.println(name);




    }

    }

/*int pokeHeight;
    pokeHeight = tst.getHeight();
    int id = tst.getID();
        System.out.println(id);
    String firstTypeName = tst.getType();
        System.out.println(firstTypeName);
    String secondTypeName = tst.getType2();
        System.out.println(secondTypeName);
        String name = tst.getName();
        System.out.println(name);*/