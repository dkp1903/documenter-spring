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
                        "123456789101",
                        "Aadhar",
                        "https://drive.google.com",
                        "dkp1903"
                );
            Document PKPAadhar = new Document(
                    "3214567394",
                    "Aadhar",
                    "https://drive.google.com/1",
                    "pkp2207"
            );

            repository.saveAll(
                    List.of(DKPAadhar, PKPAadhar)
            );
        };
    }
}
