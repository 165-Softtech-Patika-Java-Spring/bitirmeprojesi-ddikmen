package com.softtech.finalassignment.app.account.service;

import com.softtech.finalassignment.app.account.converter.AppUserMapper;
import com.softtech.finalassignment.app.account.dao.AppUserDao;
import com.softtech.finalassignment.app.account.dto.request.UserRegisterRequestDto;
import com.softtech.finalassignment.app.account.dto.response.UserRegisterResponseDto;
import com.softtech.finalassignment.app.account.entity.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService{

    private final AppUserDao appUserDao;
    private final PasswordEncoder passwordEncoder;

    public UserRegisterResponseDto save(UserRegisterRequestDto userRegisterRequestDto){

        AppUser appUser = convertToUser(userRegisterRequestDto);

        String encodedPassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        appUserDao.save(appUser);

        UserRegisterResponseDto userRegisterResponseDto = convertToUserRegisterResponseDto(appUser);

        return userRegisterResponseDto;
    }


    private AppUser convertToUser(UserRegisterRequestDto userRegisterRequestDto) {
        return AppUserMapper.INSTANCE.convertToUser(userRegisterRequestDto);
    }

    private UserRegisterResponseDto convertToUserRegisterResponseDto(AppUser appUser) {
        return AppUserMapper.INSTANCE.convertToUserRegisterResponseDto(appUser);
    }

}
