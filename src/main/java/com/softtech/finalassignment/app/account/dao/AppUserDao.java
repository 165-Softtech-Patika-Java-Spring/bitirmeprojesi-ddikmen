package com.softtech.finalassignment.app.account.dao;

import com.softtech.finalassignment.app.account.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserDao extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUserName(String username);

}
