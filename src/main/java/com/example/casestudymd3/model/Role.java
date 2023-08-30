package com.example.casestudymd3.model;

public enum Role {
    ADMIN("admin"),
    SINGER("singer"),
    MEMBER("member");
    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
