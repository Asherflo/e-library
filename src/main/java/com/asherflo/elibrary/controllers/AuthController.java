package com.asherflo.elibrary.controllers;

import com.asherflo.elibrary.controllers.requestsAndResponses.AccountCreationRequest;
import com.asherflo.elibrary.controllers.requestsAndResponses.ApiResponse;
import com.asherflo.elibrary.controllers.requestsAndResponses.LoginRequest;
import com.asherflo.elibrary.dto.UserDto;
import com.asherflo.elibrary.exception.LibraryException;
import com.asherflo.elibrary.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
@PostMapping("/signup")
    public ResponseEntity<?> createUser(HttpServletRequest request, @RequestBody AccountCreationRequest accountCreationRequest) throws LibraryException {
        String host = request.getRequestURL().toString();
        int index = host.indexOf("/",host.indexOf("/",host.indexOf("/"))+ 2);
        host = host.substring(0, index +1);
        log.info("Host-> {}",host);
        UserDto userDto = userService.createUserAccount(accountCreationRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("success")
                .message("user successfully created")
                .data(userDto)
                .result(1)
                .build();
        log.info("Returning response");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
    @PostMapping("")
    public ResponseEntity<?>login(@RequestBody LoginRequest loginRequest){
        return null;
    }

}
