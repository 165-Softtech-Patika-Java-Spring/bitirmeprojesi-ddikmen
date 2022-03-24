package com.softtech.finalassignment.app.account.entity;

import com.softtech.finalassignment.app.account.enums.AppUserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USER")
@Getter
@Setter
public class AppUser{

    @Id
    @SequenceGenerator(name = "User",sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "User")
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastname;

    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE", nullable = false)
    private AppUserRole appUserRole = AppUserRole.USER;

}
