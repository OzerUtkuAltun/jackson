package com.ozerutkualtun.jackson.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozerutkualtun.jackson.model.TypeEnum;
import com.ozerutkualtun.jackson.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final ObjectMapper objectMapper;

    @Override
    public String serializeTypeEnumWithValueUsingJsonValue(TypeEnum typeEnum) {

        try {
            return objectMapper.writeValueAsString(typeEnum);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
