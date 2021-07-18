package com.example.demo.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
                throw new IllegalStateException("username taken");
            }
            // validation, if any, should come here
            documentRepository.save(document);
    }

    public void deleteDocument(Long documentId) {
        boolean exists = documentRepository.existsById(documentId);
        if(!exists){
            throw new IllegalStateException("student with id " + documentId + " does not exist");
        }
        documentRepository.deleteById(documentId);
    }

    @Transactional
    public void updateDocument(Long documentId, String username, String name, String url, String identifier) {
        Document document = documentRepository.findById(documentId)
                                                .orElseThrow(() -> new IllegalStateException(
                                                        "document with id " + documentId + " does not exist"));
        if(username != null && username.length() > 0 && !Objects.equals(document.getUsername(), username)){
            document.setUsername(username);
        }
        if(name != null && name.length() > 0 && !Objects.equals(document.getName(), name)){
            document.setName(name);
        }
        if(url != null && url.length() > 0 && !Objects.equals(document.getUrl(), url)){
            document.setUrl(url);
        }
        if(identifier != null && identifier.length() > 0 && !Objects.equals(document.getIdentifier(), identifier)){
            document.setIdentifier(identifier);
        }
    }
}
