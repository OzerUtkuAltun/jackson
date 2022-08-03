package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class EventWithSerializer {

    private final String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    private final Date eventDate;
}
