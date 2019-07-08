package com.example.nutplant.service;

public class ApiURL {
    public static final String LOGIN = "api/user/signin";
    public static final String REGISTER = "api/user/farmersignup";
    public static final String CREATE = "api/tanaman/create";
    public static final String UPDATE = "manage/update";
    public static final String DELETE = "manage/delete";
    public static final String GETPLANTS = "api/tanaman/showtanaman";
    public static final String GETDETAILPLANTS = "api/tanaman/{id}/tanamandetail";
    public static final String GETWEATHERFORECAST = "api/tanaman/{city}/getcuaca";
    public static final String GETDETAILHISTORY = "api/tanaman/data-in-time";
    public static final String UPDATEUSER = "api/user/{id}/update";
}
