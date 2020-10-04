package com.example.recycler_17mca049l;

public class DataProvider {
    final int imageAddress;
    final String textResources;

    public DataProvider(int imageAddress, String textResources) {
        this.imageAddress = imageAddress;
        this.textResources = textResources;
    }

    public int getImageAddress() {
        return this.imageAddress;
    }

    public String getTextResources() {
        return this.textResources;
    }
}
