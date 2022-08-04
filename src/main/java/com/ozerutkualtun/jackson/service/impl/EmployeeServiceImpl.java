package com.ozerutkualtun.jackson.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozerutkualtun.jackson.model.Employee;
import com.ozerutkualtun.jackson.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final ObjectMapper objectMapper;

    @Override
    public String serializeEmployeeUsingJsonAnyGetter(Employee employee) {
        try {
            return objectMapper.writeValueAsString(employee);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee deserializeToEmployeeUsingJsonAnySetter(String json) {

        Employee employee = null;
        try {
            employee = objectMapper.readerFor(Employee.class).readValue(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
