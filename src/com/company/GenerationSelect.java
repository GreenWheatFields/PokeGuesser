package com.company;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class GenerationSelect {
    public static int test(){
        int randomPoke;
        Scanner userInput = new Scanner(System.in);
        int bound2 = 0;
        String z = userInput.nextLine();
        if (z.equalsIgnoreCase("Gen 1")){
            bound2 = 151;
        }
        Random random = new Random();
        randomPoke = random.nextInt(bound2) + 1;
        return randomPoke;
    }
    public static int[] totalGuessed(){
        int[]a = new int[1];
        return a;
    }
}
