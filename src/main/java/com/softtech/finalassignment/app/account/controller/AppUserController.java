package com.softtech.finalassignment.app.account.controller;

import com.softtech.finalassignment.app.account.dto.request.UserRegisterRequestDto;
import com.softtech.finalassignment.app.account.dto.request.UserUpdateRequestDto;
import com.softtech.finalassignment.app.account.dto.response.UserRegisterResponseDto;
import com.softtech.finalassignment.app.account.dto.response.UserUpdateResponseDto;
import com.softtech.finalassignment.app.account.service.AppUserService;
import com.softtech.finalassignment.app.generic.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @PutMapping("/username")
    public ResponseEntity updateUser(@RequestParam String username, @RequestBody UserUpdateRequestDto userUpdateRequestDto){

        UserUpdateResponseDto updateResponseDto = appUserService.update(username, userUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(updateResponseDto));
    }

    @DeleteMapping("/username")
    public ResponseEntity deleteUser(@RequestParam String username){

        appUserService.deleteUser(username);

        return ResponseEntity.ok(RestResponse.empty());
    }

}