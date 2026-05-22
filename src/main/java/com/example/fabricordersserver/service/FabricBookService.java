package com.example.fabricordersserver.service;

import com.example.fabricordersserver.dto.FabricBookRequestDto;
import com.example.fabricordersserver.dto.FabricBookResponseDto;
import com.example.fabricordersserver.entity.FabricBook;
import com.example.fabricordersserver.repository.FabricBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricBookService {

    private final FabricBookRepository fabricBookRepository;

    public FabricBookService(FabricBookRepository fabricBookRepository) {
        this.fabricBookRepository = fabricBookRepository;
    }

    public List<FabricBookResponseDto> getAllFabricBooks() {
        return fabricBookRepository.findAll()
                .stream()
                .map(FabricBookResponseDto::new)
                .collect(Collectors.toList());
    }

    public FabricBookResponseDto getFabricBook(Long id) {
        return fabricBookRepository.findById(id)
                .map(FabricBookResponseDto::new)
                .orElse(null);
    }

    public FabricBookResponseDto createFabricBook(FabricBookRequestDto dto) {
        FabricBook fabricBook = new FabricBook(
                dto.getManufacturer(),
                dto.getBookName(),
                dto.getBookCode(),
                dto.getFabricNumber(),
                dto.getImageUrl(),
                dto.getInUse() != null ? dto.getInUse() : false,
                dto.getStockYard(),
                dto.getPricePerYard(),
                dto.getSeason(),
                dto.getYarnType(),
                dto.getWeaveType(),
                dto.getColor(),
                dto.getThickness(),
                dto.getWeight(),
                dto.getStrength(),
                dto.getMaterialComposition(),
                dto.getCareInstructions()
        );
        return new FabricBookResponseDto(fabricBookRepository.save(fabricBook));
    }

    public FabricBookResponseDto updateFabricBook(Long id, FabricBookRequestDto dto) {
        FabricBook fabricBook = fabricBookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FabricBook not found"));

        fabricBook.setManufacturer(dto.getManufacturer());
        fabricBook.setBookName(dto.getBookName());
        fabricBook.setBookCode(dto.getBookCode());
        fabricBook.setFabricNumber(dto.getFabricNumber());
        fabricBook.setImageUrl(dto.getImageUrl());
        fabricBook.setInUse(dto.getInUse() != null ? dto.getInUse() : false);
        fabricBook.setStockYard(dto.getStockYard());
        fabricBook.setPricePerYard(dto.getPricePerYard());
        fabricBook.setSeason(dto.getSeason());
        fabricBook.setYarnType(dto.getYarnType());
        fabricBook.setWeaveType(dto.getWeaveType());
        fabricBook.setColor(dto.getColor());
        fabricBook.setThickness(dto.getThickness());
        fabricBook.setWeight(dto.getWeight());
        fabricBook.setStrength(dto.getStrength());
        fabricBook.setMaterialComposition(dto.getMaterialComposition());
        fabricBook.setCareInstructions(dto.getCareInstructions());

        return new FabricBookResponseDto(fabricBookRepository.save(fabricBook));
    }

    public void deleteFabricBook(Long id) {
        fabricBookRepository.deleteById(id);
    }

    public List<FabricBookResponseDto> searchByManufacturer(String manufacturer) {
        return fabricBookRepository.findByManufacturerContainingIgnoreCase(manufacturer)
                .stream()
                .map(FabricBookResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<FabricBookResponseDto> searchByBookName(String bookName) {
        return fabricBookRepository.findByBookNameContainingIgnoreCase(bookName)
                .stream()
                .map(FabricBookResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<FabricBookResponseDto> searchByBookCode(String bookCode) {
        return fabricBookRepository.findByBookCodeContainingIgnoreCase(bookCode)
                .stream()
                .map(FabricBookResponseDto::new)
                .collect(Collectors.toList());
    }
}
