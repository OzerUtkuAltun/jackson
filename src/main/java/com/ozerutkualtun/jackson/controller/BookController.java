package com.ozerutkualtun.jackson.controller;

import com.ozerutkualtun.jackson.model.Book;
import com.ozerutkualtun.jackson.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String getBookAsJson() {

        Book book = new Book(1, "Lord of the Rings: Return of the King");
        return bookService.serializeBookUsingJsonGetter(book);

        /*
                OUTPUT
            {
                 "bookId": 1,
                 "bookName": "Lord of the Rings: Return of the King"
            }
         */
    }
}
