package com.example.fabricordersserver.repository;

import com.example.fabricordersserver.entity.User;
import com.example.fabricordersserver.entity.UserSetting;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSettingRepository
        extends JpaRepository<UserSetting, Long> {

    Optional<UserSetting> findByUser(User user);
}