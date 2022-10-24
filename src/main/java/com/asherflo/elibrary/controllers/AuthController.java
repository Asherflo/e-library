package com.asherflo.elibrary.controllers;

import com.asherflo.elibrary.controllers.requestsAndResponses.AccountCreationRequest;
import com.asherflo.elibrary.controllers.requestsAndResponses.ApiResponse;
import com.asherflo.elibrary.dto.UserDto;
import com.asherflo.elibrary.exception.LibraryException;
import com.asherflo.elibrary.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<?> createUser(@RequestBody AccountCreationRequest accountCreationRequest) throws LibraryException {
        UserDto userDto = userService.createUserAccount(accountCreationRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("success")
                .message("user successfully created")
                .data(userDto)
                .result(1)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
