package com.example.demo;

public class Stuff {

    private String name;
    private int sid;
    private String location;

    public Stuff(String name, int sid, String location) {
        this.name = name;
        this.sid = sid;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
