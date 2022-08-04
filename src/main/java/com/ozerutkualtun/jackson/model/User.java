package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonRootName(value = "user")
public class User {

    @JacksonInject // indicates that a property will get its value from the injection and not from the JSON data.
    private final Integer id;

    private final String name;

}
