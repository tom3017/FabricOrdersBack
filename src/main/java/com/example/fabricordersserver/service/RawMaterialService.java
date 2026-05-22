package com.example.fabricordersserver.service;

import com.example.fabricordersserver.dto.RawMaterialRequestDto;
import com.example.fabricordersserver.dto.RawMaterialResponseDto;
import com.example.fabricordersserver.entity.RawMaterial;
import com.example.fabricordersserver.repository.RawMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
/**
 * Service layer for raw material operations: CRUD and search logic.
 */
public class RawMaterialService {

    private final RawMaterialRepository rawMaterialRepository;

    public RawMaterialService(RawMaterialRepository rawMaterialRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
    }

    public List<RawMaterialResponseDto> getAllMaterials() {
        return rawMaterialRepository.findAll()
                .stream()
                .map(RawMaterialResponseDto::new)
                .collect(Collectors.toList());
    }

    public RawMaterialResponseDto getMaterial(Long id) {
        return rawMaterialRepository.findById(id)
                .map(RawMaterialResponseDto::new)
                .orElse(null);
    }

    public RawMaterialResponseDto createMaterial(RawMaterialRequestDto dto) {
        RawMaterial material = new RawMaterial(
                dto.getItemName(),
                dto.getManufacturer(),
                dto.getBookName(),
                dto.getBookCode(),
                dto.getRawNumber(),
                dto.getImageUrl(),
                dto.getInUse() != null ? dto.getInUse() : false,
                dto.getStockYard(),
                dto.getUnit(),
                dto.getPricePerYard()
        );
        return new RawMaterialResponseDto(rawMaterialRepository.save(material));
    }

    public RawMaterialResponseDto updateMaterial(Long id, RawMaterialRequestDto dto) {
        RawMaterial material = rawMaterialRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Raw material not found"));

        material.setItemName(dto.getItemName());
        material.setManufacturer(dto.getManufacturer());
        material.setBookName(dto.getBookName());
        material.setBookCode(dto.getBookCode());
        material.setRawNumber(dto.getRawNumber());
        material.setImageUrl(dto.getImageUrl());
        material.setInUse(dto.getInUse() != null ? dto.getInUse() : false);
        material.setStockYard(dto.getStockYard());
        material.setUnit(dto.getUnit());
        material.setPricePerYard(dto.getPricePerYard());

        return new RawMaterialResponseDto(rawMaterialRepository.save(material));
    }

    public void deleteMaterial(Long id) {
        rawMaterialRepository.deleteById(id);
    }

    public List<RawMaterialResponseDto> searchMaterials(String manufacturer, String bookName, String bookCode) {
        if (manufacturer != null && !manufacturer.isBlank()) {
            return rawMaterialRepository.findByManufacturerContainingIgnoreCase(manufacturer)
                    .stream()
                    .map(RawMaterialResponseDto::new)
                    .collect(Collectors.toList());
        }
        if (bookName != null && !bookName.isBlank()) {
            return rawMaterialRepository.findByBookNameContainingIgnoreCase(bookName)
                    .stream()
                    .map(RawMaterialResponseDto::new)
                    .collect(Collectors.toList());
        }
        if (bookCode != null && !bookCode.isBlank()) {
            return rawMaterialRepository.findByBookCodeContainingIgnoreCase(bookCode)
                    .stream()
                    .map(RawMaterialResponseDto::new)
                    .collect(Collectors.toList());
        }
        return getAllMaterials();
    }
}
