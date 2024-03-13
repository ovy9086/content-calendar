package com.olu.contentcalendar.repository;

import com.olu.contentcalendar.model.Content;
import com.olu.contentcalendar.model.Status;
import com.olu.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    @PostConstruct
    private void init() {
        contentList.add(new Content(1, "My First Blog post", "My first description", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, ""));
        contentList.add(new Content(2, "My Second Blog post", "My first description", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, ""));
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
