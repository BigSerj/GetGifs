package com.lserj.bigserj.data.entity;


import com.google.gson.annotations.SerializedName;

public class Images implements DataModel{

    @SerializedName("original")
    private Original original;

    public Original getOriginal() {
        return original;
    }
}
