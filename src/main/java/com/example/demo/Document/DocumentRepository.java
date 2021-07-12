package com.example.demo.Document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// We want the JpaRepo to work with the type document, and Long represents the Student ID
public interface DocumentRepository extends JpaRepository<Document, Long>{

    @Query("SELECT d FROM Document d WHERE d.username=$1")  //Document is Document.java class
    Optional<Document> findDocumentByUsername(String username);
}
