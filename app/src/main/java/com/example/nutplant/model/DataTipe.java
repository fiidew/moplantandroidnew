package com.example.nutplant.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataTipe implements Parcelable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("tipe")
    @Expose
    private String tipe;
    @SerializedName("nitrogen")
    @Expose
    private Integer nitrogen;
    @SerializedName("phosporusVL")
    @Expose
    private Integer phosporusVL;
    @SerializedName("phosporusL")
    @Expose
    private Integer phosporusL;
    @SerializedName("phosporusM")
    @Expose
    private Integer phosporusM;
    @SerializedName("potassiumVL")
    @Expose
    private Integer potassiumVL;
    @SerializedName("potassiumL")
    @Expose
    private Integer potassiumL;
    @SerializedName("potassiumM")
    @Expose
    private Integer potassiumM;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public Integer getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(Integer nitrogen) {
        this.nitrogen = nitrogen;
    }

    public Integer getPhosporusVL() {
        return phosporusVL;
    }

    public void setPhosporusVL(Integer phosporusVL) {
        this.phosporusVL = phosporusVL;
    }

    public Integer getPhosporusL() {
        return phosporusL;
    }

    public void setPhosporusL(Integer phosporusL) {
        this.phosporusL = phosporusL;
    }

    public Integer getPhosporusM() {
        return phosporusM;
    }

    public void setPhosporusM(Integer phosporusM) {
        this.phosporusM = phosporusM;
    }

    public Integer getPotassiumVL() {
        return potassiumVL;
    }

    public void setPotassiumVL(Integer potassiumVL) {
        this.potassiumVL = potassiumVL;
    }

    public Integer getPotassiumL() {
        return potassiumL;
    }

    public void setPotassiumL(Integer potassiumL) {
        this.potassiumL = potassiumL;
    }

    public Integer getPotassiumM() {
        return potassiumM;
    }

    public void setPotassiumM(Integer potassiumM) {
        this.potassiumM = potassiumM;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.tipe);
        dest.writeValue(this.nitrogen);
        dest.writeValue(this.phosporusVL);
        dest.writeValue(this.phosporusL);
        dest.writeValue(this.phosporusM);
        dest.writeValue(this.potassiumVL);
        dest.writeValue(this.potassiumL);
        dest.writeValue(this.potassiumM);
        dest.writeValue(this.v);
    }

    public DataTipe() {
    }

    protected DataTipe(Parcel in) {
        this.id = in.readString();
        this.tipe = in.readString();
        this.nitrogen = (Integer) in.readValue(Integer.class.getClassLoader());
        this.phosporusVL = (Integer) in.readValue(Integer.class.getClassLoader());
        this.phosporusL = (Integer) in.readValue(Integer.class.getClassLoader());
        this.phosporusM = (Integer) in.readValue(Integer.class.getClassLoader());
        this.potassiumVL = (Integer) in.readValue(Integer.class.getClassLoader());
        this.potassiumL = (Integer) in.readValue(Integer.class.getClassLoader());
        this.potassiumM = (Integer) in.readValue(Integer.class.getClassLoader());
        this.v = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<DataTipe> CREATOR = new Parcelable.Creator<DataTipe>() {
        @Override
        public DataTipe createFromParcel(Parcel source) {
            return new DataTipe(source);
        }

        @Override
        public DataTipe[] newArray(int size) {
            return new DataTipe[size];
        }
    };
}