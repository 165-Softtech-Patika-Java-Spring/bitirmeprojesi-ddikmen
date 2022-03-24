package com.softtech.finalassignment.app.security.jwtsecurity;

import com.softtech.finalassignment.app.account.dao.AppUserDao;
import com.softtech.finalassignment.app.account.entity.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final AppUserDao appUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AppUser> userOptional = appUserDao.findByUsername(username);

        AppUser user;
        if(userOptional.isPresent()){
            user = userOptional.get();
        }else{
            throw new UsernameNotFoundException("User not found!");
        }

        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserByUsername(Long id) throws UsernameNotFoundException {

        Optional<AppUser> userOptional = appUserDao.findById(id);

        AppUser user;
        if(userOptional.isPresent()){
            user = userOptional.get();
        }else{
            throw new UsernameNotFoundException("User not found!");
        }

        return JwtUserDetails.create(user);
    }
}
