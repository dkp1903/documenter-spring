package com.example.demo.Document;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

// This is a Spring Bean now.
@Service //Same as @Component, we're using Service for readability - this will tell
// the compiler that this service will have to be injected
public class DocumentService {
    public List<Document> getDocuments(){
        return List.of(
                new Document(
                        1L,
                        "DushyantPathak",
                        "Aadhar",
                        "https://aadhar.com/aadhar",
                        "123456789"
                )
        );
    }
}
