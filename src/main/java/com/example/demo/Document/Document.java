package com.example.demo.Document;

public class Document {
    private Long id;
    private String username;
    private String name;
    private String url;
    private String identifier;

    public Document() {
    }

    public Document(Long id, String username, String name, String url, String identifier) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.url = url;
        this.identifier = identifier;
    }

    public Document(String username, String name, String url, String identifier) {
        this.username = username;
        this.name = name;
        this.url = url;
        this.identifier = identifier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
