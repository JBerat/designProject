package com.beratucgul.designexample;

public class ItemsModel {

    private int Image;
    private String desc;
    private String price;

    public ItemsModel(int image, String desc, String price) {
        Image = image;
        this.desc = desc;
        this.price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
