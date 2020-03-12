package com.example.mnallamalli97.speedread;

import android.media.Image;

public class Book {
    private String title;
    private String author;
    private String bookCover;
    private String bookPath;

    public Book() {}

    public Book(String title, String author, String bookCover, String bookPath) {
        this.title = title;
        this.author = author;
        this.bookCover = bookCover;
        this.bookPath = bookPath;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookCover() {
        return bookCover;
    }

    public String getBookPath() {
        return bookPath;
    }
}