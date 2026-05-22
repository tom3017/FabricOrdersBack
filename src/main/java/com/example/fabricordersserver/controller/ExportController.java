package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.service.FabricBookService;
import com.example.fabricordersserver.service.RawMaterialService;
import com.example.fabricordersserver.service.VendorService;
import com.example.fabricordersserver.util.ExcelGenerator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller exposing Excel export endpoints for vendors, fabric books and raw materials.
 * Each endpoint builds an XLSX in-memory and returns it as a downloadable attachment.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/export")
public class ExportController {

    private final VendorService vendorService;
    private final FabricBookService fabricBookService;
    private final RawMaterialService rawMaterialService;

    public ExportController(VendorService vendorService,
                            FabricBookService fabricBookService,
                            RawMaterialService rawMaterialService) {
        this.vendorService = vendorService;
        this.fabricBookService = fabricBookService;
        this.rawMaterialService = rawMaterialService;
    }

    // Export vendors to XLSX
    @GetMapping("/vendors")
    public ResponseEntity<byte[]> exportVendors() throws IOException {
        // Prepare headers in a predictable order
        List<String> headers = List.of("ID", "Group", "Branch", "LoginId", "Representative", "BusinessName", "BusinessNumber", "Phone", "Email", "Active");

        // Fetch vendor DTOs and map to rows
        List<Map<String, Object>> rows = new ArrayList<>();
        vendorService.getAllVendors().forEach(v -> {
            Map<String, Object> m = new HashMap<>();
            m.put("ID", v.getId());
            m.put("Group", v.getGroupName());
            m.put("Branch", v.getBranchName());
            m.put("LoginId", v.getLoginId());
            m.put("Representative", v.getRepresentativeName());
            m.put("BusinessName", v.getBusinessName());
            m.put("BusinessNumber", v.getBusinessNumber());
            m.put("Phone", v.getMobile());
            m.put("Email", v.getEmail());
            m.put("Active", v.isActive());
            rows.add(m);
        });

        byte[] bytes = ExcelGenerator.generateXlsx(headers, rows);
        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        h.setContentDispositionFormData("attachment", "vendors.xlsx");
        return ResponseEntity.ok().headers(h).body(bytes);
    }

    // Export fabric books to XLSX
    @GetMapping("/fabric-books")
    public ResponseEntity<byte[]> exportFabricBooks() throws IOException {
        List<String> headers = List.of("ID", "Manufacturer", "BookName", "BookCode", "FabricNumber", "InUse", "StockYard", "PricePerYard");
        List<Map<String, Object>> rows = new ArrayList<>();
        fabricBookService.getAllFabricBooks().forEach(b -> {
            Map<String, Object> m = new HashMap<>();
            m.put("ID", b.getId());
            m.put("Manufacturer", b.getManufacturer());
            m.put("BookName", b.getBookName());
            m.put("BookCode", b.getBookCode());
            m.put("FabricNumber", b.getFabricNumber());
            m.put("InUse", b.getInUse());
            m.put("StockYard", b.getStockYard());
            m.put("PricePerYard", b.getPricePerYard());
            rows.add(m);
        });
        byte[] bytes = ExcelGenerator.generateXlsx(headers, rows);
        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        h.setContentDispositionFormData("attachment", "fabric-books.xlsx");
        return ResponseEntity.ok().headers(h).body(bytes);
    }

    // Export raw materials to XLSX
    @GetMapping("/raw-materials")
    public ResponseEntity<byte[]> exportRawMaterials() throws IOException {
        List<String> headers = List.of("ID", "ItemName", "Manufacturer", "BookName", "BookCode", "RawNumber", "InUse", "StockYard", "Unit", "PricePerYard");
        List<Map<String, Object>> rows = new ArrayList<>();
        rawMaterialService.getAllMaterials().forEach(mv -> {
            Map<String, Object> m = new HashMap<>();
            m.put("ID", mv.getId());
            m.put("ItemName", mv.getItemName());
            m.put("Manufacturer", mv.getManufacturer());
            m.put("BookName", mv.getBookName());
            m.put("BookCode", mv.getBookCode());
            m.put("RawNumber", mv.getRawNumber());
            m.put("InUse", mv.getInUse());
            m.put("StockYard", mv.getStockYard());
            m.put("Unit", mv.getUnit());
            m.put("PricePerYard", mv.getPricePerYard());
            rows.add(m);
        });
        byte[] bytes = ExcelGenerator.generateXlsx(headers, rows);
        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        h.setContentDispositionFormData("attachment", "raw-materials.xlsx");
        return ResponseEntity.ok().headers(h).body(bytes);
    }
}
