package com.company;

import java.io.IOException;
import java.util.Random;

public class test3 {

Random random = new Random();
    public test3() throws IOException {
    }
    String pokeURL;
    int randomPoke;
    public String newConnect(){
            int one = 1;

                randomPoke = random.nextInt(151) + 1;
                pokeURL = "https://pokeapi.co/api/v2/pokemon/" + randomPoke;
                one++;



            return pokeURL;
    }
}
