package com.ozerutkualtun.jackson.service;

import com.ozerutkualtun.jackson.model.Bird;

public interface BirdService {

    String serializeBirdUsingJsonRawValue(Bird bird);
}
