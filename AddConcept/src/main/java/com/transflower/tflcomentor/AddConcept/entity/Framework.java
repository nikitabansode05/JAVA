package com.transflower.tflcomentor.AddConcept.entity;

public class Framework{
    private int id;
    private String name;
    private int layerId;
    private int languageId;

    public Framework() {
    }

    public Framework(int id, String name, int layerId, int languageId) {
        this.id = id;
        this.name = name;
        this.layerId = layerId;
        this.languageId = languageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLayerId() {
        return layerId;
    }

    public void setLayerId(int layerId) {
        this.layerId = layerId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}