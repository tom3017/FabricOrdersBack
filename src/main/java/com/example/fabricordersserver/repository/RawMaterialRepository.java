package com.example.fabricordersserver.repository;

import com.example.fabricordersserver.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {

    List<RawMaterial> findByManufacturerContainingIgnoreCase(String manufacturer);
    List<RawMaterial> findByBookNameContainingIgnoreCase(String bookName);
    List<RawMaterial> findByBookCodeContainingIgnoreCase(String bookCode);
}
