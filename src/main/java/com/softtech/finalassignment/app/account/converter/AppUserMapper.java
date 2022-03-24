package com.softtech.finalassignment.app.account.converter;

import com.softtech.finalassignment.app.account.dto.request.UserRegisterRequestDto;
import com.softtech.finalassignment.app.account.dto.request.UserUpdateRequestDto;
import com.softtech.finalassignment.app.account.dto.response.UserRegisterResponseDto;
import com.softtech.finalassignment.app.account.dto.response.UserUpdateResponseDto;
import com.softtech.finalassignment.app.account.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppUserMapper {

    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);

    AppUser convertToUser(UserRegisterRequestDto userRegisterRequestDto);

    AppUser convertToUser(UserUpdateRequestDto userUpdateRequestDto);

    UserRegisterResponseDto convertToUserRegisterResponseDto(AppUser appUser);

    UserUpdateResponseDto convertToUserUpdateResponseDto(AppUser appUser);
}
