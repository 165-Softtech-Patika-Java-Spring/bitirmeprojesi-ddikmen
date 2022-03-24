package com.softtech.finalassignment.app.account.service;

import com.softtech.finalassignment.app.account.converter.AppUserMapper;
import com.softtech.finalassignment.app.account.dao.AppUserDao;
import com.softtech.finalassignment.app.account.dto.request.UserRegisterRequestDto;
import com.softtech.finalassignment.app.account.dto.request.UserUpdateRequestDto;
import com.softtech.finalassignment.app.account.dto.response.UserRegisterResponseDto;
import com.softtech.finalassignment.app.account.dto.response.UserUpdateResponseDto;
import com.softtech.finalassignment.app.account.entity.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public UserUpdateResponseDto update(String username, UserUpdateRequestDto userUpdateRequestDto){

        Optional<AppUser> optionalAppUser = appUserDao.findByUsername(username);


        UserUpdateResponseDto updateResponseDto;
        if(optionalAppUser.isPresent()){
            AppUser user = optionalAppUser.get();
            Long id = user.getId();
            user = AppUserMapper.INSTANCE.convertToUser(userUpdateRequestDto);
            user.setId(id);
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            appUserDao.save(user);
            updateResponseDto = AppUserMapper.INSTANCE.convertToUserUpdateResponseDto(user);
        }else{
            throw new RuntimeException("User not found!");
        }

        return updateResponseDto;
    }

    public void deleteUser(String username){
        Optional<AppUser> userOptional = appUserDao.findByUsername(username);
        if(userOptional.isPresent()){
            appUserDao.delete(userOptional.get());
        }else{
            throw new RuntimeException("User not found!");
        }
    }

    private AppUser convertToUser(UserRegisterRequestDto userRegisterRequestDto) {
        return AppUserMapper.INSTANCE.convertToUser(userRegisterRequestDto);
    }

    private UserRegisterResponseDto convertToUserRegisterResponseDto(AppUser appUser) {
        return AppUserMapper.INSTANCE.convertToUserRegisterResponseDto(appUser);
    }

}
