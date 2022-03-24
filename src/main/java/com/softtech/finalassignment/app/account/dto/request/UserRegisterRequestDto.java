package com.softtech.finalassignment.app.account.dto.request;

import lombok.Data;

@Data
public class UserRegisterRequestDto {

    private String firstname;
    private String lastname;
    private String username;
    private String password;

}
