package com.lserj.bigserj.data.entity;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GifList implements DataModel{

    @SerializedName("data")
    private List<Data> dataList;


    public List<Data> getDataList() {
        return dataList;
    }
}