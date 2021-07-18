package com.example.demo.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This is a Spring Bean now.
@Service //Same as @Component, we're using Service for readability - this will tell
// the compiler that this service will have to be injected
public class DocumentService {
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    
    public List<Document> getDocuments(){
        return documentRepository.findAll();
    }

    public void addNewDocument(Document document) {
            Optional<Document> documentOptional =  documentRepository.findDocumentByUsername(document.getUsername());
            if(documentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            // validation, if any, should come here
            documentRepository.save(document);
    }
}
