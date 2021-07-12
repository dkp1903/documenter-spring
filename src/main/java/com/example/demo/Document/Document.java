package com.example.demo.Document;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // for hibernate
@Table // For the table in our DB   
public class Document {
    @Id
    @SequenceGenerator(
            name="document_sequence",
            sequenceName = "document_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "document_sequence"
    )
    private Long id;
    private String username;
    private String name;
    private String url;
    private String identifier;
    @Transient
    private LocalDate lastUpdated;
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

    public LocalDate getUpdated() {
        return LocalDate.now();

    }

    public void setUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", identifier='" + identifier + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
