package com.categorie.model;

public class Categorie {

    private String name;
    //id must be unique
    private String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String setId() {


        String id = GenerateRandomCategorieID.generateString();
        return id;
    }

}
