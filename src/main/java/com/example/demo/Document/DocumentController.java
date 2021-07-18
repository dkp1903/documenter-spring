package com.example.demo.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This annotation makes this class serve restful endpoints
@RequestMapping(path="api/v1/document")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired //Dependency injection : plugging in the above service automatically into constructor
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    // This is a restful endpoint
    @GetMapping
    public List<Document> getDocuments(){
        return documentService.getDocuments();
    }

    @PostMapping
    public void addNewDocument(@RequestBody Document document) {
        documentService.addNewDocument(document);
    }

    @DeleteMapping(path = "{documentId}")
    public void deleteDocument(@PathVariable("documentId") Long documentId ) {
        documentService.deleteDocument(documentId);
    }

    @PutMapping(path = "{documentId}")
    public void updateDocument(@PathVariable("documentId") Long documentId, @RequestParam(required = false) String username,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String url,
                               @RequestParam(required = false) String identifier){
        documentService.updateDocument(documentId, username, name, url, identifier);
    }
}
