package com.softtech.finalassignment.app.account.service;

import com.softtech.finalassignment.app.account.converter.AppUserMapper;
import com.softtech.finalassignment.app.account.dao.AppUserDao;
import com.softtech.finalassignment.app.account.dto.request.AppUserRegisterRequestDto;
import com.softtech.finalassignment.app.account.dto.request.UserUpdateRequestDto;
import com.softtech.finalassignment.app.account.dto.response.AppUserRegisterResponseDto;
import com.softtech.finalassignment.app.account.dto.response.UserUpdateResponseDto;
import com.softtech.finalassignment.app.account.entity.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserService{

    private final AppUserDao appUserDao;
    private final PasswordEncoder passwordEncoder;

    public AppUserRegisterResponseDto save(AppUserRegisterRequestDto appUserRegisterRequestDto){

        AppUser appUser = convertToUser(appUserRegisterRequestDto);

        String encodedPassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        appUserDao.save(appUser);

        AppUserRegisterResponseDto appUserRegisterResponseDto = convertToUserRegisterResponseDto(appUser);

        return appUserRegisterResponseDto;
    }

    public String updateUsername(String username){

        String currentUser = getUsername();
        Optional<AppUser> userOptional = appUserDao.findByUsername(currentUser);

        if(userOptional.isPresent()){
            AppUser user = userOptional.get();
            user.setUsername(username);
            appUserDao.save(user);
        }else{
            throw new RuntimeException("User not found!");
        }

        return username;
    }

    public void updatePassword(String currentPasswordReq, String newPassword){

        String myPassword = getPassword();

        if(!passwordEncoder.matches(currentPasswordReq,myPassword)){
            throw new RuntimeException("Wrong password");
        }

        String username = getUsername();
        Optional<AppUser> myaccountOptional = appUserDao.findByUsername(username);

        if(myaccountOptional.isPresent()){
            AppUser myaccount = myaccountOptional.get();
            String encodedPassword = passwordEncoder.encode(newPassword);
            myaccount.setPassword(encodedPassword);
            appUserDao.save(myaccount);
        }

    }

    public void deleteUser(String username){
        Optional<AppUser> userOptional = appUserDao.findByUsername(username);
        if(userOptional.isPresent()){
            appUserDao.delete(userOptional.get());
        }else{
            throw new RuntimeException("User not found!");
        }
    }

    private String getUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        String username = ((UserDetails) principal).getUsername();

        return username;
    }

    private String getPassword() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        String password = ((UserDetails) principal).getPassword();

        return password;
    }

    private AppUser convertToUser(AppUserRegisterRequestDto appUserRegisterRequestDto) {
        return AppUserMapper.INSTANCE.convertToUser(appUserRegisterRequestDto);
    }

    private AppUserRegisterResponseDto convertToUserRegisterResponseDto(AppUser appUser) {
        return AppUserMapper.INSTANCE.convertToUserRegisterResponseDto(appUser);
    }

}
