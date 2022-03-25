package com.softtech.finalassignment.app.account.controller;

import com.softtech.finalassignment.app.account.dto.request.UserUpdateRequestDto;
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

    @PatchMapping("/username-change")
    public ResponseEntity updateUsername(@RequestParam String username){

        String updatedUsername = appUserService.updateUsername(username);

        return ResponseEntity.ok(RestResponse.of(updatedUsername));
    }

    @PatchMapping("/password-change")
    public ResponseEntity updatePassword(@RequestParam String currentPassword, @RequestParam String newPassword){

        appUserService.updatePassword(currentPassword,newPassword);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @PatchMapping("/user-details-update")
    public ResponseEntity updateNameAndLastName(@RequestBody UserUpdateRequestDto userUpdateRequestDto){

        UserUpdateResponseDto updateResponseDto = appUserService.updateNameAndLastName(userUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(updateResponseDto));
    }

    @DeleteMapping("/username")
    public ResponseEntity deleteUser(@RequestParam String username){

        appUserService.deleteUser(username);

        return ResponseEntity.ok(RestResponse.empty());
    }

}