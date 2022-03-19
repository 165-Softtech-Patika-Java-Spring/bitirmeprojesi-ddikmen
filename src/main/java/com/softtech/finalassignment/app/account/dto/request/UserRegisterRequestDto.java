package com.softtech.finalassignment.app.account.dto.request;

import lombok.Data;

@Data
public class UserRegisterRequestDto {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

}
