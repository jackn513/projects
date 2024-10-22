package org.example.docmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication
public class DocMateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocMateApplication.class, args);
    }

}
