package com.ozerutkualtun.jackson.service;

import com.ozerutkualtun.jackson.model.Book;

public interface BookService {

    String serializeBookUsingJsonGetter(Book book);

    Book deserializeBookUsingJsonCreator(String json);
}
