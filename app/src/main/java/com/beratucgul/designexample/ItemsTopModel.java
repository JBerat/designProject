package com.beratucgul.designexample;

public class ItemsTopModel {

    private int Image;
    private String fashionName;
    private String fashionType;
    private String fashionSize;
    private String fashionSizeType;
    private String fashionNumber;
    private String fashionPrice;

    public ItemsTopModel(int image, String fashionName, String fashionType, String fashionSize, String fashionSizeType, String fashionNumber, String fashionPrice) {
        Image = image;
        this.fashionName = fashionName;
        this.fashionType = fashionType;
        this.fashionSize = fashionSize;
        this.fashionSizeType = fashionSizeType;
        this.fashionNumber = fashionNumber;
        this.fashionPrice = fashionPrice;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getFashionName() {
        return fashionName;
    }

    public void setFashionName(String fashionName) {
        this.fashionName = fashionName;
    }

    public String getFashionType() {
        return fashionType;
    }

    public void setFashionType(String fashionType) {
        this.fashionType = fashionType;
    }

    public String getFashionSize() {
        return fashionSize;
    }

    public void setFashionSize(String fashionSize) {
        this.fashionSize = fashionSize;
    }

    public String getFashionSizeType() {
        return fashionSizeType;
    }

    public void setFashionSizeType(String fashionSizeType) {
        this.fashionSizeType = fashionSizeType;
    }

    public String getFashionNumber() {
        return fashionNumber;
    }

    public void setFashionNumber(String fashionNumber) {
        this.fashionNumber = fashionNumber;
    }

    public String getFashionPrice() {
        return fashionPrice;
    }

    public void setFashionPrice(String fashionPrice) {
        this.fashionPrice = fashionPrice;
    }
}
