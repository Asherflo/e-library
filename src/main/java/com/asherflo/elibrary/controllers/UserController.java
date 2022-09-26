package com.asherflo.elibrary.controllers;

import com.asherflo.elibrary.controllers.requestsAndResponses.AccountCreationRequest;
import com.asherflo.elibrary.controllers.requestsAndResponses.ApiResponse;
import com.asherflo.elibrary.dto.FindUserRequest;
import com.asherflo.elibrary.dto.UserDto;
import com.asherflo.elibrary.exception.LibraryException;
import com.asherflo.elibrary.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody AccountCreationRequest accountCreationRequest) throws LibraryException {
         try{
        UserDto userDto = userService.createUserAccount(accountCreationRequest);
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("success")
                    .message("user successfully created")
                    .data(userDto)
                    .result(1)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (LibraryException e){
             ApiResponse apiResponse = ApiResponse.builder()
                     .status("fail")
                     .message(e.getMessage())
                     .build();
             return  new ResponseEntity<>(apiResponse, HttpStatus.valueOf(e.getMessage()));
         }
    }
    @GetMapping("/userId")
    public ResponseEntity<?> getUser(@RequestBody FindUserRequest request) throws LibraryException{
        UserDto userDto = userService.findByUser(request);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("success")
                .message("user successfully created")
                .data(userDto)
                .result(1)
                .build();
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>getUserById (@PathVariable("id") String userId) throws LibraryException {
        try {
            if (("null").equals(userId) || ("").equals(userId.trim())) {
                throw new LibraryException("String id cannot be  null");
            }
            UserDto userDto = userService.findUserById(userId);
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("Success")
                    .message("user found")
                    .data(userDto)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (LibraryException e) {
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("fail")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.valueOf(e.getMessage()));
        }
    }

}
