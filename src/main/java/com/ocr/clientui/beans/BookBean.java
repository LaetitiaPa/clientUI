package com.ocr.clientui.beans;

import java.util.Date;

public class BookBean {

    private Long   id;

    private Long   isbn;

    private String author;

    private String title;

    private String summary;

    private Date publishingDate;

    private String audience;

    private String genre;

    private String language;

    private String pictureBook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPictureBook() {
        return pictureBook;
    }

    public void setPictureBook(String pictureBook) {
        this.pictureBook = pictureBook;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", publishingDate=" + publishingDate +
                ", audience='" + audience + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", pictureBook='" + pictureBook + '\'' +
                '}';
    }


}
