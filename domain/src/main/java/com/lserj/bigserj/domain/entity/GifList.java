package com.lserj.bigserj.domain.entity;


import java.util.List;

public class GifList implements DomainModel {

    private List<Data> dataList;

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public List<Data> getDataList() {
        return dataList;
    }
}