package com.example.teashop.payload.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SignupRequest {

    @NotBlank(message = "User is required")
    @NotEmpty
    private String username;

    @NotEmpty(message = "Password is required")
    @Size(min = 6)
    private String password;



}
