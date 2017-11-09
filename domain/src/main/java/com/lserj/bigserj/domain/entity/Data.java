package com.lserj.bigserj.domain.entity;


public class Data implements DomainModel {

    private String id;
    private Images images;

    public void setImages(Images images) {
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public Images getImages() {
        return images;
    }

    public void setId(String id) {
        this.id = id;
    }

}
