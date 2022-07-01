package ru.amlet.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ru.amlet.entity.Message;

import java.util.List;

public interface ElasticRepository extends ElasticsearchRepository<Message, String> {

    @Override
    List<Message> findAll();
}
