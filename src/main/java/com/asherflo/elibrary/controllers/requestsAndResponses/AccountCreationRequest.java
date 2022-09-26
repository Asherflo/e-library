package com.asherflo.elibrary.controllers.requestsAndResponses;

import com.asherflo.elibrary.models.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public class AccountCreationRequest {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Gender gender;
        private String location;

        @Override
        public String toString() {
            return "AccountCreationRequest{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", gender='" + gender + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }
    }

