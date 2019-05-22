package com.example.demo.Models;

public class Member {
    private int memberId;
    private String firstName;
    private String lastName;
    private String street;
    private String postalcode;
    private String city;
    private String email;
    private String description;
    private String privatephone;
    private String mobilephone;
    private String workphone;
    private String job;
    private String fax;
    private String lastpayed;
    private String memberstatus;
    private String volunteerstatus;


    public Member() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member(int memberId, String firstName, String lastName, String street, String postalcode, String city, String email, String description, String privatephone, String mobilephone, String workphone, String job, String fax, String lastpayed, String memberstatus, String volunteerstatus) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.postalcode = postalcode;
        this.city = city;
        this.email = email;
        this.description = description;
        this.privatephone = privatephone;
        this.mobilephone = mobilephone;
        this.workphone = workphone;
        this.job = job;
        this.fax = fax;
        this.lastpayed = lastpayed;
        this.memberstatus = memberstatus;
        this.volunteerstatus = volunteerstatus;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrivatephone() {
        return privatephone;
    }

    public void setPrivatephone(String privatephone) {
        this.privatephone = privatephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLastpayed() {
        return lastpayed;
    }

    public void setLastpayed(String lastpayed) {
        this.lastpayed = lastpayed;
    }

    public String getMemberstatus() {
        return memberstatus;
    }

    public void setMemberstatus(String memberstatus) {
        this.memberstatus = memberstatus;
    }

    public String getVolunteerstatus() {
        return volunteerstatus;
    }

    public void setVolunteerstatus(String volunteerstatus) {
        this.volunteerstatus = volunteerstatus;
    }
}
