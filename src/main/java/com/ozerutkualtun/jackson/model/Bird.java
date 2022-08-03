package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Bird {

    private String name;

    @JsonRawValue // @JsonRawValue instruct Jackson to serialize a property exactly as is
    private String json;
}
