package com.example.nutplant.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataNotification implements Parcelable {

    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("recommendation")
    @Expose
    private String recommendation;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
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
        dest.writeString(this.tanggal);
        dest.writeString(this.id);
        dest.writeValue(this.status);
        dest.writeString(this.recommendation);
        dest.writeValue(this.v);
    }

    public DataNotification() {
    }

    protected DataNotification(Parcel in) {
        this.tanggal = in.readString();
        this.id = in.readString();
        this.status = (Integer) in.readValue(Integer.class.getClassLoader());
        this.recommendation = in.readString();
        this.v = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<DataNotification> CREATOR = new Parcelable.Creator<DataNotification>() {
        @Override
        public DataNotification createFromParcel(Parcel source) {
            return new DataNotification(source);
        }

        @Override
        public DataNotification[] newArray(int size) {
            return new DataNotification[size];
        }
    };
}
