package com.example.casestudymd3.model;

public class Billings {
    private int billId;
    private Songs song;
    private Users user;

    public Billings() {
    }

    public Billings(int billId, Songs song, Users user) {
        this.billId = billId;
        this.song = song;
        this.user = user;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Songs getSong() {
        return song;
    }

    public void setSong(Songs song) {
        this.song = song;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Billings{" +
                "billId=" + billId +
                ", song=" + song +
                ", user=" + user +
                '}';
    }
}
