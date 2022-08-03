package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonRootName(value = "user")
public class User {

    private final Integer id;
    private final String name;

}
