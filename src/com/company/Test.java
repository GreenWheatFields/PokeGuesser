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

