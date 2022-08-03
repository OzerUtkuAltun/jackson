package com.ozerutkualtun.jackson.controller;

import com.ozerutkualtun.jackson.model.Employee;
import com.ozerutkualtun.jackson.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String getEmployeeAsJson() {

        Map<String, String> properties = new HashMap<>();
        properties.put("salary", "$360000");
        properties.put("age", "23");
        properties.put("Occupation", "Compute Engineer");
        properties.put("Education Level", "Bachelor degree");

        Employee employee = new Employee("Özer Utku Altun", properties);

        return employeeService.serializeEmployeeUsingJsonAnyGetter(employee);

        /*
            OUTPUT
        {
            "name": "Özer Utku Altun",
            "Occupation": "Compute Engineer",
            "Education Level": "Bachelor degree",
            "salary": "$360000",
            "age": "23"
        }
         */


    }


}
