package com.example.casestudymd3.model;

public class Songs {
    private int songId;
    private String songName;
    private String fileLink;
    private String avatarLink;
    private String description;
    private Albums album;
    private double price;
    private Users user;

    public Songs() {
    }

    public Songs(int songId, String songName, String fileLink, String avatarLink, String description, Albums album, double price, Users user) {
        this.songId = songId;
        this.songName = songName;
        this.fileLink = fileLink;
        this.avatarLink = avatarLink;
        this.description = description;
        this.album = album;
        this.price = price;
        this.user = user;
    }

    public Songs(int songId, String songName, String fileLink, String avatarLink, String description, Albums album, double price) {
        this.songId = songId;
        this.songName = songName;
        this.fileLink = fileLink;
        this.avatarLink = avatarLink;
        this.description = description;
        this.album = album;
        this.price = price;
    }

    public Songs(String songName, String fileLink, String avatarLink, String description, Albums album, double price, Users user) {
        this.songName = songName;
        this.fileLink = fileLink;
        this.avatarLink = avatarLink;
        this.description = description;
        this.album = album;
        this.price = price;
        this.user = user;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Albums getAlbum() {
        return album;
    }

    public void setAlbum(Albums album) {
        this.album = album;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", fileLink='" + fileLink + '\'' +
                ", avatarLink='" + avatarLink + '\'' +
                ", description='" + description + '\'' +
                ", album=" + album +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
