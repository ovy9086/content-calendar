package com.olu.contentcalendar;

import com.olu.contentcalendar.model.Content;
import com.olu.contentcalendar.model.Status;
import com.olu.contentcalendar.model.Type;
import com.olu.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("Run inserts via command line runner...");
                repository.save(new Content(null, "My First Chat GPT post", "My first description", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, ""));
                repository.save(new Content(null, "My Crypto post", "My first description", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, ""));

            }
        };
    }
}
