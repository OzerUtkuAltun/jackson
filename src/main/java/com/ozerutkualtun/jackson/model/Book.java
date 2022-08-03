package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
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
}
