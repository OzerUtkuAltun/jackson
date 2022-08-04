package com.ozerutkualtun.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
public class EventWithSerializer {

    private final String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class) //  indicates the use of a custom deserializer.
    private final Date eventDate;

    @JsonCreator
    public EventWithSerializer(@JsonProperty("name") String name, @JsonProperty("eventDate") Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

}
