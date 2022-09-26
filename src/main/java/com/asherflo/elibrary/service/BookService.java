package com.asherflo.elibrary.service;

import com.asherflo.elibrary.controllers.requestsAndResponses.BookItemUploadRequest;
import com.asherflo.elibrary.exception.LibraryException;
import com.asherflo.elibrary.models.Book;

public interface BookService {
    Book save(BookItemUploadRequest bookItemUploadRequest);
    Book findBookByTitle(String title) throws LibraryException;
}