package com.ozerutkualtun.jackson.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozerutkualtun.jackson.model.Book;
import com.ozerutkualtun.jackson.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final ObjectMapper objectMapper;

    @Override
    public String serializeBookUsingJsonGetter(Book book) {

        try {
            return objectMapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
