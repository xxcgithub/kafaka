package com.example.kafaka2.util.entity;

import javax.validation.constraints.*;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/7
 * Time: 10:42
 */
public class XxcTest {
    @Digits(integer = 3, fraction = 2)
    @NotNull
    private Float aid;
    @NotNull
    @Max(value = 2000)
    private int  bid;
    @Size(min = 1, max = 200)
    @NotNull
    private String  name;
    @Email
    private String email;
    @AssertTrue
    private boolean cc;


    public boolean isCc() {
        return cc;
    }

    public void setCc(boolean cc) {
        this.cc = cc;
    }

    public Float getAid() {
        return aid;
    }

    public void setAid(Float aid) {
        this.aid = aid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
