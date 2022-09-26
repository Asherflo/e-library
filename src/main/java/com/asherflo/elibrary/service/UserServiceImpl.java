package com.asherflo.elibrary.service;

import com.asherflo.elibrary.controllers.requestsAndResponses.AccountCreationRequest;
import com.asherflo.elibrary.dto.FindUserRequest;
import com.asherflo.elibrary.dto.UserDto;
import com.asherflo.elibrary.exception.LibraryException;
import com.asherflo.elibrary.models.User;
import com.asherflo.elibrary.respositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUserAccount(AccountCreationRequest accountCreationRequest) {
        User user = new User(accountCreationRequest.getFirstName(), accountCreationRequest.getLastName(),
                accountCreationRequest.getEmail(), accountCreationRequest.getPassword(), accountCreationRequest.getGender(),
                accountCreationRequest.getLocation());
        user.setDateJoined(LocalDate.now());
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto findByUser(FindUserRequest request) {
        Optional<User> user = userRepository.findById(request.getId());
        if (user.isPresent()){
            UserDto userDto = new UserDto();
            userDto.setFirstName(user.get().getFirstName());
            userDto.setEmail(user.get().getEmail());
            return userDto;
        }
        return  null;
    }

    @Override
    public UserDto findUserById(String userId) throws LibraryException {
        User user = userRepository.findById(Long.parseLong(userId)).orElseThrow(
                ()-> new LibraryException(String.format("User with  id %s not found",userId))
                );
                return  modelMapper.map(user,UserDto.class);


    }

    @Override
    public User findByEmail(String email) throws LibraryException {
        return userRepository.findUserByEmail(email).orElseThrow(()->new LibraryException("User not found"));
    }
}
