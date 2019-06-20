package com.example.nutplant.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPerangkat implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.tanggal);
        dest.writeValue(this.kelembabanTanah);
        dest.writeValue(this.ph);
        dest.writeValue(this.kelembabanUdara);
        dest.writeValue(this.suhuUdara);
        dest.writeValue(this.kondisi);
    }

    public DataPerangkat() {
    }

    protected DataPerangkat(Parcel in) {
        this.id = in.readString();
        this.tanggal = in.readString();
        this.kelembabanTanah = (Integer) in.readValue(Integer.class.getClassLoader());
        this.ph = (Integer) in.readValue(Integer.class.getClassLoader());
        this.kelembabanUdara = (Integer) in.readValue(Integer.class.getClassLoader());
        this.suhuUdara = (Integer) in.readValue(Integer.class.getClassLoader());
        this.kondisi = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<DataPerangkat> CREATOR = new Parcelable.Creator<DataPerangkat>() {
        @Override
        public DataPerangkat createFromParcel(Parcel source) {
            return new DataPerangkat(source);
        }

        @Override
        public DataPerangkat[] newArray(int size) {
            return new DataPerangkat[size];
        }
    };
}