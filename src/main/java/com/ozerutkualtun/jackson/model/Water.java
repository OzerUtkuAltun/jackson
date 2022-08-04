package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Water {

    private final Integer id;
    private String name;

    @JsonSetter("waterName") // seful when we need to read some JSON data, but the target entity class doesn't exactly match that data
    public void setWaterName(String waterName) {
        this.name = waterName;
    }

}
