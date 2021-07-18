package com.example.demo.Document;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DocumentConfig {

    @Bean
    CommandLineRunner commandLineRunner(DocumentRepository repository) {
        return args -> {
                Document DKPAadhar = new Document(
                        "dkp1903",
                        "Aadhar",
                        "https://drive.google.com/1",
                        "12345"

                );
            Document PKPAadhar = new Document(
                    "pkp2004",
                    "Aadhar",
                    "https://drive.google.com/2",
                    "6789"
            );

            repository.saveAll(
                    List.of(DKPAadhar, PKPAadhar)
            );
        };
    }
}
