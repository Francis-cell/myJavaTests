package com.zmr.LearningFiles.BooksReading.MultiThreadTests.syncUtils.entity;

public class ProductInfo {
    private String productName;

    private String productType;

    public ProductInfo() {
    }

    public ProductInfo(String productName, String productType) {
        this.productName = productName;
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
