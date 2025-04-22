package com.sharu.back_end.model;

import java.util.Date;
import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment {

    private String id;
    private String text;
    private Date createdAt;

    public Comment() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = new Date();
    }

    public Comment(String text) {
        this.id = UUID.randomUUID().toString();
        this.text = text;
        this.createdAt = new Date();
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
