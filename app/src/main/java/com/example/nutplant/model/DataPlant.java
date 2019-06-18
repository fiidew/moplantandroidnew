package com.example.nutplant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPlant {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("idFarmer")
    @Expose
    private String idFarmer;
    @SerializedName("namaTanaman")
    @Expose
    private String namaTanaman;
    @SerializedName("luasLahan")
    @Expose
    private Double luasLahan;
    @SerializedName("lokasiLahan")
    @Expose
    private String lokasiLahan;
    @SerializedName("spesies")
    @Expose
    private String spesies;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("perangkat")
    @Expose
    private Perangkat perangkat;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFarmer() {
        return idFarmer;
    }

    public void setIdFarmer(String idFarmer) {
        this.idFarmer = idFarmer;
    }

    public String getNamaTanaman() {
        return namaTanaman;
    }

    public void setNamaTanaman(String namaTanaman) {
        this.namaTanaman = namaTanaman;
    }

    public Double getLuasLahan() {
        return luasLahan;
    }

    public void setLuasLahan(Double luasLahan) {
        this.luasLahan = luasLahan;
    }

    public String getLokasiLahan() {
        return lokasiLahan;
    }

    public void setLokasiLahan(String lokasiLahan) {
        this.lokasiLahan = lokasiLahan;
    }

    public String getSpesies() {
        return spesies;
    }

    public void setSpesies(String spesies) {
        this.spesies = spesies;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Perangkat getPerangkat() {
        return perangkat;
    }

    public void setPerangkat(Perangkat perangkat) {
        this.perangkat = perangkat;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
