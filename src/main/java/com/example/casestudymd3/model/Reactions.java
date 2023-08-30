package com.example.casestudymd3.model;

public class Reactions {
    private int reactionId;
    private Songs song;
    private Users user;
    private double orderPrice;

    public Reactions() {
    }

    public Reactions(int reactionId, Songs song, Users user, double orderPrice) {
        this.reactionId = reactionId;
        this.song = song;
        this.user = user;
        this.orderPrice = orderPrice;
    }

    public int getReactionId() {
        return reactionId;
    }

    public void setReactionId(int reactionId) {
        this.reactionId = reactionId;
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

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Reactions{" +
                "reactionId=" + reactionId +
                ", song=" + song +
                ", user=" + user +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
