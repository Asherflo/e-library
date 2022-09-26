package com.asherflo.elibrary.service;

import com.asherflo.elibrary.controllers.requestsAndResponses.BookItemUploadRequest;
import com.asherflo.elibrary.models.Book;
import com.asherflo.elibrary.respositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;



    @Override
    public Book save(BookItemUploadRequest bookItemUploadRequest) {

        Book book =modelMapper.map(bookItemUploadRequest,Book.class);
        return bookRepository.save(book);
    }

    @Override
    public Book findBookByTitle(String title) {

        Book book = bookRepository.findBookByTitle(title);
        System.out.println("this is the book tittle:  "+book.getTitle());

        return book;
    }
}
