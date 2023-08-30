package com.example.casestudymd3.model;

public enum Role {
    ADMIN("ADMIN"),
    SINGER("SINGER"),
    MEMBER("MEMBER");
    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
