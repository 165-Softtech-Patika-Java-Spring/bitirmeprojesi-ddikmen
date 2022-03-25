package com.softtech.finalassignment.app.account.dto.request;

import lombok.Data;

@Data
public class AppUserRegisterRequestDto {

    private String firstname;
    private String lastname;
    private String username;
    private String password;

}
