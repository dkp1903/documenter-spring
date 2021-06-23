package com.example.demo.Document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// We want the JpaRepo to work with the type document, and Long represents the Student ID
public interface DocumentRepository extends JpaRepository<Document, Long>{
}
