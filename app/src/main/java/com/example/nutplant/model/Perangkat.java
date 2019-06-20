package com.example.nutplant.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Perangkat implements Parcelable {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<DataPerangkat> data = null;

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

    public List<DataPerangkat> getData() {
        return data;
    }

    public void setData(List<DataPerangkat> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeValue(this.status);
        dest.writeList(this.data);
    }

    public Perangkat() {
    }

    protected Perangkat(Parcel in) {
        this.id = in.readString();
        this.status = (Integer) in.readValue(Integer.class.getClassLoader());
        this.data = new ArrayList<DataPerangkat>();
        in.readList(this.data, DataPerangkat.class.getClassLoader());
    }

    public static final Parcelable.Creator<Perangkat> CREATOR = new Parcelable.Creator<Perangkat>() {
        @Override
        public Perangkat createFromParcel(Parcel source) {
            return new Perangkat(source);
        }

        @Override
        public Perangkat[] newArray(int size) {
            return new Perangkat[size];
        }
    };
}
