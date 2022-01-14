package com.example.poneproject.DataModel;

public class Numberlist_Data {
    public int iv_profile;
    public String numberlist_name;
    public String numberList_ponumber;


    public Numberlist_Data(int iv_profile, String numberlist_name, String numberList_ponumber) {
        this.iv_profile = iv_profile;
        this.numberlist_name = numberlist_name;
        this.numberList_ponumber = numberList_ponumber;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getNumberlist_name() {
        return numberlist_name;
    }

    public void setNumberlist_name(String numberlist_name) {
        this.numberlist_name = numberlist_name;
    }

    public String getNumberList_ponumber() {
        return numberList_ponumber;
    }

    public void setNumberList_ponumber(String numberList_ponumber) {
        this.numberList_ponumber = numberList_ponumber;
    }
}
