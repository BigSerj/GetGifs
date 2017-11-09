package com.lserj.bigserj.data.entity;


import com.google.gson.annotations.SerializedName;

public class Original implements DataModel {

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }
}
