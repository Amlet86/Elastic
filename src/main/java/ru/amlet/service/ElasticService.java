package ru.amlet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.amlet.entity.Message;
import ru.amlet.repository.ElasticRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ElasticService {

    private final ElasticRepository elasticRepository;

    public ElasticService(ElasticRepository elasticRepository) {
        this.elasticRepository = elasticRepository;
    }

    public Message save(Message msg) {
        return elasticRepository.save(msg);
    }

    public Optional<Message> getById(String id) {
        return elasticRepository.findById(id);
    }

    public List<Message> findAll() {
        return new ArrayList<>(elasticRepository.findAll());
    }

    public Page<Message> searchSimilar(Message message) {
        return elasticRepository.searchSimilar(message, new String[]{"data"}, PageRequest.of(0, 100));
    }

}
