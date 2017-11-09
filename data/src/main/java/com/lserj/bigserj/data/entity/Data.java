package com.lserj.bigserj.data.entity;


import com.google.gson.annotations.SerializedName;

public class Data  implements DataModel{

    @SerializedName("id")
    private String id;
    @SerializedName("images")
    private Images images;

    public String getId() {
        return id;
    }

    public Images getImages() {
        return images;
    }

}
