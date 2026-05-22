package com.example.fabricordersserver.service;

import com.example.fabricordersserver.dto.VendorRequestDto;
import com.example.fabricordersserver.dto.VendorResponseDto;
import com.example.fabricordersserver.entity.Vendor;
import com.example.fabricordersserver.repository.VendorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
/**
 * Service layer for vendor business logic. Handles CRUD and simple queries.
 */
public class VendorService {

    private final VendorRepository vendorRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public VendorService(VendorRepository vendorRepository,
                         BCryptPasswordEncoder passwordEncoder) {
        this.vendorRepository = vendorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<VendorResponseDto> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(VendorResponseDto::new)
                .collect(Collectors.toList());
    }

    public VendorResponseDto getVendor(Long id) {
        return vendorRepository.findById(id)
                .map(VendorResponseDto::new)
                .orElse(null);
    }

    public VendorResponseDto createVendor(VendorRequestDto dto) {
        if (vendorRepository.existsByLoginId(dto.getLoginId())) {
            throw new IllegalArgumentException("Vendor login ID already exists");
        }

        Vendor vendor = new Vendor(
                dto.getGroupName(),
                dto.getBranchName(),
                dto.getLoginId(),
                passwordEncoder.encode(dto.getPassword()),
                dto.getRepresentativeName(),
                dto.getBusinessName(),
                dto.getBusinessNumber(),
                dto.getBusinessType(),
                dto.getBusinessItem(),
                dto.getZipcode(),
                dto.getAddress(),
                dto.getDetailAddress(),
                dto.getMobile(),
                dto.getFax(),
                dto.getEmail(),
                dto.getTaxEmail(),
                dto.getBaseRatePercent(),
                dto.getBaseRateWon()
        );

        return new VendorResponseDto(vendorRepository.save(vendor));
    }

    public VendorResponseDto updateVendor(Long id, VendorRequestDto dto) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found"));

        vendor.setGroupName(dto.getGroupName());
        vendor.setBranchName(dto.getBranchName());
        vendor.setRepresentativeName(dto.getRepresentativeName());
        vendor.setBusinessName(dto.getBusinessName());
        vendor.setBusinessNumber(dto.getBusinessNumber());
        vendor.setBusinessType(dto.getBusinessType());
        vendor.setBusinessItem(dto.getBusinessItem());
        vendor.setZipcode(dto.getZipcode());
        vendor.setAddress(dto.getAddress());
        vendor.setDetailAddress(dto.getDetailAddress());
        vendor.setMobile(dto.getMobile());
        vendor.setFax(dto.getFax());
        vendor.setEmail(dto.getEmail());
        vendor.setTaxEmail(dto.getTaxEmail());
        vendor.setBaseRatePercent(dto.getBaseRatePercent());
        vendor.setBaseRateWon(dto.getBaseRateWon());
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            vendor.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        return new VendorResponseDto(vendorRepository.save(vendor));
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }

    public boolean checkDuplicateLoginId(String loginId) {
        return vendorRepository.existsByLoginId(loginId);
    }

    public List<String> getVendorGroups() {
        return vendorRepository.findAll()
                .stream()
                .map(Vendor::getGroupName)
                .distinct()
                .collect(Collectors.toList());
    }
}
