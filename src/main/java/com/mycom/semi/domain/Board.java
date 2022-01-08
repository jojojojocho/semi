package com.mycom.semi.domain;

import javax.persistence.*;

@Entity
public class Board {


    public long getId() {
        return postnum;
    }

    public void setId(long id) {
        this.postnum = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postnum;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;


    @Column(name = "time")
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
