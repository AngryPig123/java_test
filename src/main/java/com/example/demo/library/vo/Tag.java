package com.example.demo.library.vo;

public class Tag {

    private final String version;

    public Tag(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "version='" + version + '\'' +
                '}';
    }
    
}
