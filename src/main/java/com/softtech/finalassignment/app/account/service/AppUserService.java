package com.softtech.finalassignment.app.account.service;

import com.softtech.finalassignment.app.account.converter.AppUserMapper;
import com.softtech.finalassignment.app.account.dao.AppUserDao;
import com.softtech.finalassignment.app.account.dto.request.UserRegisterRequestDto;
import com.softtech.finalassignment.app.account.dto.response.UserRegisterResponseDto;
import com.softtech.finalassignment.app.account.entity.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserDao appUserDao;

    public UserRegisterResponseDto registerUser(UserRegisterRequestDto userRegisterRequestDto){

        AppUser appUser = convertToUser(userRegisterRequestDto);

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserDao.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        //todo exceptions
    }
}
