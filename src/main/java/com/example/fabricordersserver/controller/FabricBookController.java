package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.dto.FabricBookRequestDto;
import com.example.fabricordersserver.dto.FabricBookResponseDto;
import com.example.fabricordersserver.service.FabricBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/fabric-books")
public class FabricBookController {

    private final FabricBookService fabricBookService;

    public FabricBookController(FabricBookService fabricBookService) {
        this.fabricBookService = fabricBookService;
    }

    @GetMapping
    public List<FabricBookResponseDto> getAllFabricBooks() {
        return fabricBookService.getAllFabricBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricBookResponseDto> getFabricBook(@PathVariable Long id) {
        FabricBookResponseDto response = fabricBookService.getFabricBook(id);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FabricBookResponseDto> createFabricBook(@RequestBody FabricBookRequestDto dto) {
        return ResponseEntity.ok(fabricBookService.createFabricBook(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricBookResponseDto> updateFabricBook(@PathVariable Long id, @RequestBody FabricBookRequestDto dto) {
        return ResponseEntity.ok(fabricBookService.updateFabricBook(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabricBook(@PathVariable Long id) {
        fabricBookService.deleteFabricBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<FabricBookResponseDto> searchFabricBooks(
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) String bookName,
            @RequestParam(required = false) String bookCode
    ) {
        if (manufacturer != null && !manufacturer.isBlank()) {
            return fabricBookService.searchByManufacturer(manufacturer);
        }
        if (bookName != null && !bookName.isBlank()) {
            return fabricBookService.searchByBookName(bookName);
        }
        if (bookCode != null && !bookCode.isBlank()) {
            return fabricBookService.searchByBookCode(bookCode);
        }
        return fabricBookService.getAllFabricBooks();
    }
}
