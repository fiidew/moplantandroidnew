package com.example.nutplant.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPlant implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.idFarmer);
        dest.writeString(this.namaTanaman);
        dest.writeValue(this.luasLahan);
        dest.writeString(this.lokasiLahan);
        dest.writeString(this.spesies);
        dest.writeString(this.tanggal);
        dest.writeParcelable(this.perangkat, flags);
        dest.writeValue(this.v);
    }

    public DataPlant() {
    }

    protected DataPlant(Parcel in) {
        this.id = in.readString();
        this.idFarmer = in.readString();
        this.namaTanaman = in.readString();
        this.luasLahan = (Double) in.readValue(Double.class.getClassLoader());
        this.lokasiLahan = in.readString();
        this.spesies = in.readString();
        this.tanggal = in.readString();
        this.perangkat = in.readParcelable(Perangkat.class.getClassLoader());
        this.v = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<DataPlant> CREATOR = new Parcelable.Creator<DataPlant>() {
        @Override
        public DataPlant createFromParcel(Parcel source) {
            return new DataPlant(source);
        }

        @Override
        public DataPlant[] newArray(int size) {
            return new DataPlant[size];
        }
    };
}
