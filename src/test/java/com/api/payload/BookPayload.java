package com.api.payload;

public class BookPayload {
    int id;
    String title;
    String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPayloadData() {
        return "{\"id\":" + id + ",\"title\":\"" + title + "\",\"author\":\"" + author + "\"}";
    }
}
