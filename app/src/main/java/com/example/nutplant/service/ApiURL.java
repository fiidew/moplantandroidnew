package com.example.nutplant.service;

public class ApiURL {
    //USER
    public static final String LOGIN = "api/user/signin";
    public static final String REGISTER = "api/user/farmersignup";

    //TANAMAN
    public static final String GETDETAILPLANTS = "api/tanaman/{id}/tanamandetail";
    public static final String GETWEATHERFORECAST = "api/tanaman/{city}/getcuaca";
    public static final String GETDETAILHISTORY = "api/tanaman/data-in-time";
    public static final String GETPLANTS = "api/tanaman/showtanaman";
    public static final String CREATE = "api/tanaman/create";

    //MANAGE
    public static final String UPDATE = "manage/update";
    public static final String DELETE = "manage/delete";

    //NOTIFICATION
    public static final String GETNOTIFICATION = "api/notification/getAll";
    public static final String UPDATENOTIFICATION = "api/notification/updateStatus";
    public static final String UPDATEUSER = "api/user/{id}/update";

    //TIPE TANAMAN
    public static final String CREATETIPE = "api/tipe/create";
    public static final String GETALLTYPE = "api/tipe/tipe-show-all";
    public static final String GETTYPE = "api/user/{id}/tipedetail";


}
