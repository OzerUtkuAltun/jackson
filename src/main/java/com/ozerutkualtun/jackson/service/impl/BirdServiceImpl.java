package com.ozerutkualtun.jackson.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozerutkualtun.jackson.model.Bird;
import com.ozerutkualtun.jackson.service.BirdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BirdServiceImpl implements BirdService  {

    private final ObjectMapper objectMapper;

    @Override
    public String serializeBirdUsingJsonRawValue(Bird bird) {

        try {
            return objectMapper.writeValueAsString(bird);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
