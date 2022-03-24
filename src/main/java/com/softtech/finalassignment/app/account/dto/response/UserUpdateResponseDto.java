package com.softtech.finalassignment.app.account.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdateResponseDto {

    private String firstname;
    private String lastname;
    private String username;
    private String password;

}
