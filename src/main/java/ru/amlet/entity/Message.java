package ru.amlet.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "elastic-2")
public class Message {

    @Id
    @JsonProperty
    private String id;

    @Field
    @JsonProperty
    private String data;
}
