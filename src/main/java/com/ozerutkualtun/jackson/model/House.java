package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
//@JsonIgnoreProperties(value = {"id", "size"}) // Jackson Property Inclusion Annotation #1
public class House {

    @JsonIgnore // Jackson Property Inclusion Annotation #1
    private Integer id;
    private Map<String, String> location;
    private Long price;
    private Integer size;
    private Owner name;

    // Jackson Property Inclusion Annotation #3
    @JsonIgnoreType // marks all properties of an annotated type to be ignored.
    @AllArgsConstructor
    public static class Owner {
        public String firstName;
        public String lastName;
    }

}
