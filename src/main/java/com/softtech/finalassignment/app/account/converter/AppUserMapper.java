package com.softtech.finalassignment.app.account.converter;

import com.softtech.finalassignment.app.account.dto.request.AppUserRegisterRequestDto;
import com.softtech.finalassignment.app.account.dto.request.UserUpdateRequestDto;
import com.softtech.finalassignment.app.account.dto.response.AppUserRegisterResponseDto;
import com.softtech.finalassignment.app.account.dto.response.UserUpdateResponseDto;
import com.softtech.finalassignment.app.account.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppUserMapper {

    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);

    AppUser convertToUser(AppUserRegisterRequestDto appUserRegisterRequestDto);

    AppUser convertToUser(UserUpdateRequestDto userUpdateRequestDto);

    AppUserRegisterResponseDto convertToUserRegisterResponseDto(AppUser appUser);

    UserUpdateResponseDto convertToUserUpdateResponseDto(AppUser appUser);
}
