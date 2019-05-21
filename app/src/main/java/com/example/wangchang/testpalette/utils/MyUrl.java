package com.example.wangchang.testpalette.utils;

public class MyUrl {

    public static String baseUrl = "http://192.168.122.253:81/AppWebService.asmx";


    //获取展示列表图片
    public static String getShowSourceList = baseUrl + "/getShowSourceList";

    public static void SetUrl() {

        getShowSourceList = baseUrl + "/getShowSourceList";
    }
}
