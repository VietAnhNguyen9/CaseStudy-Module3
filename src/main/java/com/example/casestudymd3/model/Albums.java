package com.example.casestudymd3.model;

public class Albums {
    private int albumId;
    private String albumName;
    private Users user;

    public Albums() {
    }

    public Albums(int albumId, String albumName, Users user) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.user = user;
    }

    public Albums(int albumId, String albumName) {
        this.albumId = albumId;
        this.albumName = albumName;
    }

    public Albums(String albumName, Users user) {
        this.albumName = albumName;
        this.user = user;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", user=" + user +
                '}';
    }
}
