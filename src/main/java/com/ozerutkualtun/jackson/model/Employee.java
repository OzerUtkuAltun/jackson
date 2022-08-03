package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Employee {

    private String name;
    private Map<String, String> properties;

    public String getName() {
        return name;
    }

    // Serialization annotation #1
    @JsonAnyGetter // used for serialize key/value pairs
    public Map<String, String> getProperties() {
        return properties;
    }
}
