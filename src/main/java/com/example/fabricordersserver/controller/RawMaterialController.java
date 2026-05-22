package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.dto.RawMaterialRequestDto;
import com.example.fabricordersserver.dto.RawMaterialResponseDto;
import com.example.fabricordersserver.service.RawMaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/raw-materials")
public class RawMaterialController {

    private final RawMaterialService rawMaterialService;

    public RawMaterialController(RawMaterialService rawMaterialService) {
        this.rawMaterialService = rawMaterialService;
    }

    @GetMapping
    public List<RawMaterialResponseDto> getAllMaterials() {
        return rawMaterialService.getAllMaterials();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RawMaterialResponseDto> getMaterial(@PathVariable Long id) {
        RawMaterialResponseDto response = rawMaterialService.getMaterial(id);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RawMaterialResponseDto> createMaterial(@RequestBody RawMaterialRequestDto dto) {
        return ResponseEntity.ok(rawMaterialService.createMaterial(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RawMaterialResponseDto> updateMaterial(@PathVariable Long id, @RequestBody RawMaterialRequestDto dto) {
        return ResponseEntity.ok(rawMaterialService.updateMaterial(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        rawMaterialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<RawMaterialResponseDto> searchMaterials(
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) String bookName,
            @RequestParam(required = false) String bookCode
    ) {
        return rawMaterialService.searchMaterials(manufacturer, bookName, bookCode);
    }
}
