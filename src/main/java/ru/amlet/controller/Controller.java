package ru.amlet.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.amlet.entity.Message;
import ru.amlet.service.ElasticService;

import java.util.List;

@RestController
public class Controller {

    private final ElasticService elasticService;

    public Controller(ElasticService elasticService) {
        this.elasticService = elasticService;
    }

    @PostMapping("/message")
    public Message save(@RequestBody Message msg) {
        return elasticService.save(msg);
    }

    @GetMapping("/message/{id}")
    public Message getById(@PathVariable("id") String id) {
            return elasticService.getById(id)
                    .orElseThrow();
    }

    @GetMapping("/message/all")
    public List<Message> findAll() {
        return elasticService.findAll();
    }

    @PostMapping("/message/similar")
    public Page<Message> searchSimilar(@RequestBody Message message) {
        return elasticService.searchSimilar(message);
    }

}
