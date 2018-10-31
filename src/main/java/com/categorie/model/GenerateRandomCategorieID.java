package com.categorie.model;

import java.util.Random;

public class GenerateRandomCategorieID {


    public static void main(String[] args) {
        System.out.println(generateString());
    }

    public static String generateString() {
        String idPrefix = "autoIdApi";
        String id = idPrefix + generateRandom();
        return id;
    }

    public static int generateRandom() {
        Random rand = new Random();
        return rand.nextInt(500) + 1;
    }
}

