package com.example.googlebooksapi_17mca049l;

public class DataProvider {

    final String description;
    final String bookName;
    final String authorName;

    public DataProvider(String description, String bookName, String authorName) {
        this.description = description;
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public String getBookName() {
        return bookName;
    }
}
