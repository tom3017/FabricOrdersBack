package com.example.fabricordersserver.repository;

import com.example.fabricordersserver.entity.Manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository
        extends JpaRepository<Manufacturer, Long> {

    // 제조사명 중복 확인
    boolean existsByName(String name);
}