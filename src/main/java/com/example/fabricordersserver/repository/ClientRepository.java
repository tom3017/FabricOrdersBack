package com.example.fabricordersserver.repository;

import com.example.fabricordersserver.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository
        extends JpaRepository<Client, Long> {

    // =========================
    // 거래처명 중복 확인
    // =========================
    boolean existsByName(String name);
}