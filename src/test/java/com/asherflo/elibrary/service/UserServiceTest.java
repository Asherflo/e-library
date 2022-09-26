//package com.asherflo.elibrary.service;
//
//import com.asherflo.elibrary.controllers.requestsAndResponses.AccountCreationRequest;
//import com.asherflo.elibrary.controllers.requestsAndResponses.ApiResponse;
//import com.asherflo.elibrary.dto.UserDto;
//import com.asherflo.elibrary.models.enums.Gender;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static com.asherflo.elibrary.models.enums.Gender.FEMALE;
//import static com.asherflo.elibrary.models.enums.Gender.NON_BINARY;
//import static org.junit.jupiter.api.Assertions.*;
//@Slf4j
//@SpringBootTest
//class UserServiceTest {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private ModelMapper mapper;
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//    @Test
//    @DisplayName("A user can be created")
//    void testThatAUserCanBeCreated(){
//        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
//        accountCreationRequest.setFirstName("Amaka");
//        accountCreationRequest.setLastName("Daniel");
//        accountCreationRequest.setEmail("techsis@gmail.com");
//        accountCreationRequest.setPassword("*1234#");
//        accountCreationRequest.setGender(FEMALE);
//        accountCreationRequest.setLocation("23,Emily Akinola street,Lagos");
//        UserDto userDto  =userService.createUserAccount(accountCreationRequest);
//        assertNotNull(userDto);
//    }
//    @Test
//    @DisplayName("Multiple User can be created")
//    void testThatMultipleUserCanRegister(){
//        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
//        accountCreationRequest.setFirstName("Great");
//        accountCreationRequest.setLastName("Grace");
//        accountCreationRequest.setEmail("techmama12@gmail.com");
//        accountCreationRequest.setPassword("1198gtj");
//        accountCreationRequest.setGender(NON_BINARY);
//        accountCreationRequest.setLocation("London");
//        UserDto userDto  =userService.createUserAccount(accountCreationRequest);
//        assertNotNull(userDto);
//    }
//    @Test
//    @DisplayName("find by id")
//    void  testToFindUserById(){
//        ApiResponse response = userService.findByUserById(5L);
//        assertNotNull(response);
//    }
//}