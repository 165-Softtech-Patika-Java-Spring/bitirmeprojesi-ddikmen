package com.softtech.finalassignment.app.security.controller;

import com.softtech.finalassignment.app.account.dto.request.UserRegisterRequestDto;
import com.softtech.finalassignment.app.account.dto.response.UserRegisterResponseDto;
import com.softtech.finalassignment.app.account.service.AppUserService;
import com.softtech.finalassignment.app.generic.dto.RestResponse;
import com.softtech.finalassignment.app.security.dto.SecurityLoginRequestDto;
import com.softtech.finalassignment.app.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecurityLoginRequestDto securityLoginRequestDto){

        String token = authenticationService.login(securityLoginRequestDto);

        return ResponseEntity.ok(RestResponse.of(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRegisterRequestDto userRegisterRequestDto){

        UserRegisterResponseDto userRegisterResponseDto = authenticationService.register(userRegisterRequestDto);

        return ResponseEntity.ok(RestResponse.of(userRegisterResponseDto));
    }
}
