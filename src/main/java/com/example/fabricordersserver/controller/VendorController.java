package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.dto.VendorRequestDto;
import com.example.fabricordersserver.dto.VendorResponseDto;
import com.example.fabricordersserver.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<VendorResponseDto> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorResponseDto> getVendor(@PathVariable Long id) {
        VendorResponseDto vendor = vendorService.getVendor(id);
        return vendor != null ? ResponseEntity.ok(vendor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<VendorResponseDto> createVendor(@RequestBody VendorRequestDto dto) {
        VendorResponseDto vendor = vendorService.createVendor(dto);
        return ResponseEntity.ok(vendor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorResponseDto> updateVendor(@PathVariable Long id, @RequestBody VendorRequestDto dto) {
        VendorResponseDto vendor = vendorService.updateVendor(id, dto);
        return ResponseEntity.ok(vendor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/check-id")
    public ResponseEntity<Boolean> checkDuplicateLoginId(@RequestParam String loginId) {
        return ResponseEntity.ok(vendorService.checkDuplicateLoginId(loginId));
    }

    @GetMapping("/groups")
    public ResponseEntity<List<String>> getVendorGroups() {
        return ResponseEntity.ok(vendorService.getVendorGroups());
    }
}
