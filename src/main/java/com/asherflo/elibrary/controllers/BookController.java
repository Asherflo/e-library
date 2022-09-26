package com.asherflo.elibrary.controllers;

import com.asherflo.elibrary.controllers.requestsAndResponses.ApiResponse;
import com.asherflo.elibrary.controllers.requestsAndResponses.BookItemUploadRequest;
import com.asherflo.elibrary.exception.LibraryException;
import com.asherflo.elibrary.models.Book;
import com.asherflo.elibrary.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private  final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?>upLoadItem(@RequestBody BookItemUploadRequest bookItemUploadRequest){
        Book book = bookService.save(bookItemUploadRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("success")
                .message("book saved successfully")
                .data(book)
                .build();
        return  new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<?>findBookByTitle(@PathVariable String title) throws LibraryException {
        Book book = bookService.findBookByTitle(title);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("SUCCESS")
                .message("Book found")
                .data(book)
                .result(1)
                .build();
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

}
