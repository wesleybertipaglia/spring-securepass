package com.wesleybertipaglia.securepass.entities;

public class Password {
    private String value;

    public Password() {
    }

    public Password(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
