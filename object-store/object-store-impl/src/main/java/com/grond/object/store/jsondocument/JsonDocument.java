package com.grond.object.store.jsondocument;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("JsonDocument")
public class JsonDocument implements Serializable {
    @Id
    private String key;

    private JsonNode value;
}
