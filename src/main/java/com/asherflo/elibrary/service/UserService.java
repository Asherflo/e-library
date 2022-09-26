package com.asherflo.elibrary.service;

import com.asherflo.elibrary.controllers.requestsAndResponses.AccountCreationRequest;
import com.asherflo.elibrary.dto.FindUserRequest;
import com.asherflo.elibrary.dto.UserDto;
import com.asherflo.elibrary.exception.LibraryException;
import com.asherflo.elibrary.models.User;


public interface UserService {
    UserDto createUserAccount(AccountCreationRequest accountCreationRequest) throws LibraryException;
    UserDto findByUser(FindUserRequest request) throws LibraryException;

    UserDto findUserById(String userId) throws LibraryException;
     User findByEmail(String email) throws LibraryException;


}
