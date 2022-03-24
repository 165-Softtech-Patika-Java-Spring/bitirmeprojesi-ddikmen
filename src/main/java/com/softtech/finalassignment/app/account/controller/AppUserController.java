package com.softtech.finalassignment.app.account.controller;

import com.softtech.finalassignment.app.account.dto.request.UserRegisterRequestDto;
import com.softtech.finalassignment.app.account.dto.response.UserRegisterResponseDto;
import com.softtech.finalassignment.app.account.service.AppUserService;
import com.softtech.finalassignment.app.generic.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping
    public ResponseEntity register(@RequestBody UserRegisterRequestDto userRegisterRequestDto){

        UserRegisterResponseDto userRegisterResponseDto = appUserService.save(userRegisterRequestDto);

        return ResponseEntity.ok(RestResponse.of(userRegisterResponseDto));
    }


}
