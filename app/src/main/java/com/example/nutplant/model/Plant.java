package com.example.nutplant.model;

import com.google.gson.annotations.SerializedName;

public class Plant {
    @SerializedName("_id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("species")
    private String species;
    @SerializedName("date")
    private String date;
    @SerializedName("area")
    private Float area;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }
}
