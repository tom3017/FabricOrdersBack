package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.entity.Manufacturer;

import com.example.fabricordersserver.service.ManufacturerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private final ManufacturerService
            manufacturerService;

    public ManufacturerController(
            ManufacturerService manufacturerService
    ) {
        this.manufacturerService = manufacturerService;
    }

    // 제조사 전체 조회
    @GetMapping
    public List<Manufacturer> getManufacturers() {

        return manufacturerService.getAllManufacturers();
    }

    // 제조사 등록
    @PostMapping
    public String createManufacturer(
            @RequestBody Map<String, String> body
    ) {

        String name = body.get("name");

        return manufacturerService
                .createManufacturer(name);
    }

    // 제조사 수정
    @PutMapping("/{id}")
    public String updateManufacturer(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {

        String name = body.get("name");

        return manufacturerService
                .updateManufacturer(id, name);
    }

    // 제조사 삭제
    @DeleteMapping("/{id}")
    public String deleteManufacturer(
            @PathVariable Long id
    ) {

        return manufacturerService
                .deleteManufacturer(id);
    }
}