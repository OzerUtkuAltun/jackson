package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "id"})
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

    /*
    After @JsonPropertyOrder
    {
        "bookId": 1,
        "bookName": "Lord of the Rings: Return of the King"
    }
     */

    // Jackson Deserialization Annotation #1
    @JsonCreator //It's very useful when we need to deserialize some JSON that doesn't exactly match the target entity we need to get.

    public Book(
            @JsonProperty("bookId") Integer id,
            @JsonProperty("bookName") String name) {
        this.id = id;
        this.name = name;
    }
}

