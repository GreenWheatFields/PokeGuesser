package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GenerationSelect {
    public static int upperBound = 0;
    public static int  lowerBound = 0;
    public static int test(){
        System.out.println("Select Generation:\n" + "1-7\n" + "EX: 'Gen 4'");
        int randomPoke;
        Scanner userInput = new Scanner(System.in);

        String z = userInput.nextLine().toLowerCase();

        switch (z){
            case "gen 1":
                upperBound = 151;
                lowerBound = 1;
                break;
            case "gen 2":
                upperBound = 251;
                lowerBound = 152;
                break;
            case "gen 3":
                upperBound = 386;
                lowerBound = 252;
                break;
            case "gen 4":
                upperBound = 493;
                lowerBound= 387;
                break;
            case "gen 5":
                upperBound = 649;
                lowerBound = 494;
                break;
            case "gen 6":
                upperBound = 721;
                lowerBound = 650;
                break;
            case "gen 7":
                upperBound = 807;
                lowerBound = 722;
                break;
        }
        randomPoke = ThreadLocalRandom.current().nextInt(lowerBound, upperBound);
        return randomPoke;
    }


    public static int[] totalGuessed(){
        int[]a = new int[1];
        return a;
    }
}
