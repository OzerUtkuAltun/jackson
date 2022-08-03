package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Book {

    private final Integer id;
    private final String name;

    // Jackson Serialization Annotations #2 : @JsonGetter
    @JsonGetter("bookId") // can be alternative to @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonGetter("bookName")
    public String getName() {
        return name;
    }
}
