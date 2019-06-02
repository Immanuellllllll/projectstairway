package com.example.demo.Models;

public class Donation { //     Her er en donations klasse med private attributer
    private int donationId; // For at tilgå attributterne har vi getters og setters
    private int amount;
    private String phoneNumber;
    private String cpr;
    private String name;

    public Donation() {
    }

    public Donation(int donationId, int amount, String phoneNumber, String cpr,String name) {
        this.donationId = donationId;
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        this.cpr = cpr;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
