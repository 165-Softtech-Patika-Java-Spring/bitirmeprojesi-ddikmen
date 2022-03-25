package com.softtech.finalassignment.app.security.service;

import com.softtech.finalassignment.app.account.dto.request.AppUserRegisterRequestDto;
import com.softtech.finalassignment.app.account.dto.response.AppUserRegisterResponseDto;
import com.softtech.finalassignment.app.account.service.AppUserService;
import com.softtech.finalassignment.app.security.dto.SecurityLoginRequestDto;
import com.softtech.finalassignment.app.security.enums.EnumJwtConstant;
import com.softtech.finalassignment.app.security.jwtsecurity.JwtTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AppUserService appUserService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    public AppUserRegisterResponseDto register(AppUserRegisterRequestDto appUserRegisterRequestDto){

        AppUserRegisterResponseDto appUserRegisterResponseDto = appUserService.save(appUserRegisterRequestDto);

        return appUserRegisterResponseDto;
    }

    public String login(SecurityLoginRequestDto securityLoginRequestDto){

        String username = securityLoginRequestDto.getUsername();
        String password = securityLoginRequestDto.getPassword();

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String bearer = EnumJwtConstant.BEARER.getConstant();

        return bearer + token;
    }
}
