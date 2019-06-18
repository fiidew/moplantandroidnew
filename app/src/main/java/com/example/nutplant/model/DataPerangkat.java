package com.example.nutplant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPerangkat {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("kelembabanTanah")
    @Expose
    private Integer kelembabanTanah;
    @SerializedName("ph")
    @Expose
    private Integer ph;
    @SerializedName("kelembabanUdara")
    @Expose
    private Integer kelembabanUdara;
    @SerializedName("suhuUdara")
    @Expose
    private Integer suhuUdara;
    @SerializedName("kondisi")
    @Expose
    private Integer kondisi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getKelembabanTanah() {
        return kelembabanTanah;
    }

    public void setKelembabanTanah(Integer kelembabanTanah) {
        this.kelembabanTanah = kelembabanTanah;
    }

    public Integer getPh() {
        return ph;
    }

    public void setPh(Integer ph) {
        this.ph = ph;
    }

    public Integer getKelembabanUdara() {
        return kelembabanUdara;
    }

    public void setKelembabanUdara(Integer kelembabanUdara) {
        this.kelembabanUdara = kelembabanUdara;
    }

    public Integer getSuhuUdara() {
        return suhuUdara;
    }

    public void setSuhuUdara(Integer suhuUdara) {
        this.suhuUdara = suhuUdara;
    }

    public Integer getKondisi() {
        return kondisi;
    }

    public void setKondisi(Integer kondisi) {
        this.kondisi = kondisi;
    }

}