package com.example.fabricordersserver.repository;

import com.example.fabricordersserver.entity.CompanySetting;

import com.example.fabricordersserver.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanySettingRepository

        extends JpaRepository<CompanySetting, Long> {

    Optional<CompanySetting>

    findByUser(User user);
}