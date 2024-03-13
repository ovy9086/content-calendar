package com.olu.contentcalendar.controller;

import com.olu.contentcalendar.model.Content;
import com.olu.contentcalendar.model.Status;
import com.olu.contentcalendar.repository.ContentCollectionRepository;
import com.olu.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentRepository repository;

    public ContentController(ContentRepository repo) {
        this.repository = repo;
    }

    //make a request and find all the pieces of content in the system

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @Valid @RequestBody Content content) {
        if (repository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }
}
