package com.example.retrofitassignment;

public class DataProvider {
    final String content, imgUrl;

    public DataProvider(String content, String imgUrl) {
        this.content = content;
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
