package com.company;

import java.io.IOException;
import java.util.Random;

public class test3 {

Random random = new Random();
    String pokeURL;
    int randomPoke;
public test3() throws IOException {
    }
    public int randomPoke(){
        randomPoke = random.nextInt(151) + 1;
    return  randomPoke;
    }
    public String newConnect(){
            int one = 1;

                randomPoke = random.nextInt(151) + 1;
                pokeURL = "https://pokeapi.co/api/v2/pokemon/" + randomPoke;
                one++;



            return pokeURL;
    }
}
