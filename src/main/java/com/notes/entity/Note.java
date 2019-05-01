package com.notes.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Notes")
public class Note {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "message")
    private String message;
    @Column(name = "date")
    private Date date;

    public Note(String message) {
        this.message = message;
        this.date = new Date();
    }

    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
