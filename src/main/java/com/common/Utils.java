package com.common;

import java.util.Random;

public class Utils {

    private static Random random;

    public static int getRandomInteger(int limit){

        Random random = new Random();
        int randomInt = 0;

        randomInt = random.nextInt(limit)+1;

        return  randomInt;
    }

}
