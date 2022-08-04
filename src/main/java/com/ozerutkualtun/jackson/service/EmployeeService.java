package com.ozerutkualtun.jackson.service;

import com.ozerutkualtun.jackson.model.Employee;

public interface EmployeeService {

    String serializeEmployeeUsingJsonAnyGetter(Employee employee);

    Employee deserializeToEmployeeUsingJsonAnySetter(String json);
}
