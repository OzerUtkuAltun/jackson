package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
public class Employee {

    private final String name;
    private Map<String, String> properties;

    public String getName() {
        return name;
    }

    // Serialization annotation #1
    @JsonAnyGetter // used for serialize key/value pairs
    public Map<String, String> getProperties() {
        return properties;
    }

    // Deserialization annotation #3
    @JsonAnySetter // allows us the flexibility of using a Map as standard properties. On deserialization, the properties from JSON will simply be added to the map.
    public void add(String key, String value) {

        if(Objects.isNull(properties)) {
            properties = new HashMap<>();
        }

        properties.put(key, value);
    }


}
