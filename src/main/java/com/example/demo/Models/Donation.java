package com.example.demo.Models;

public class Donation {
    private int donationId;
    private int amount;
    private String phoneNumber;
    private String cpr;

    public Donation() {
    }

    public Donation(int donationId, int amount, String phoneNumber, String cpr) {
        this.donationId = donationId;
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        this.cpr = cpr;
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
