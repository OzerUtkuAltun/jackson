package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TypeEnum {

    TYPE1(1, "Type-A"), TYPE2(2, "Type-B");

    private Integer id;
    private String name;

    @JsonValue // indicates a single method that the library will use to serialize the entire instance.
    public String getName() {
        return name;
    }
}
