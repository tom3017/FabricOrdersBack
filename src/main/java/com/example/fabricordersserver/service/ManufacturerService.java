package com.example.fabricordersserver.service;

import com.example.fabricordersserver.entity.Manufacturer;

import com.example.fabricordersserver.repository.ManufacturerRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    private final ManufacturerRepository
            manufacturerRepository;

    public ManufacturerService(
            ManufacturerRepository manufacturerRepository
    ) {
        this.manufacturerRepository = manufacturerRepository;
    }

    // 제조사 전체 조회
    public List<Manufacturer> getAllManufacturers() {

        return manufacturerRepository.findAll();
    }

    // 제조사 등록
    public String createManufacturer(String name) {

        if (name == null || name.trim().isEmpty()) {

            return "EMPTY_NAME";
        }

        if (manufacturerRepository.existsByName(name)) {

            return "DUPLICATE_NAME";
        }

        Manufacturer manufacturer
                = new Manufacturer(name.trim());

        manufacturerRepository.save(manufacturer);

        return "SUCCESS";
    }

    // 제조사 수정
    public String updateManufacturer(
            Long id,
            String name
    ) {

        Manufacturer manufacturer
                = manufacturerRepository
                .findById(id)
                .orElse(null);

        if (manufacturer == null) {

            return "NOT_FOUND";
        }

        if (name == null || name.trim().isEmpty()) {

            return "EMPTY_NAME";
        }

        manufacturer.setName(name.trim());

        manufacturerRepository.save(manufacturer);

        return "SUCCESS";
    }

    // 제조사 삭제
    public String deleteManufacturer(Long id) {

        if (!manufacturerRepository.existsById(id)) {

            return "NOT_FOUND";
        }

        manufacturerRepository.deleteById(id);

        return "SUCCESS";
    }
}