package com.example.fabricordersserver.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing a raw material or stock item.
 * Matches fields shown in raw materials UI and is persisted to `raw_materials`.
 */
@Entity
@Table(name = "raw_materials")
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String manufacturer;
    private String bookName;
    private String bookCode;
    private String rawNumber;
    private String imageUrl;
    private boolean inUse;
    private Double stockYard;
    private String unit;
    private Integer pricePerYard;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    protected RawMaterial() {}

    public RawMaterial(String itemName,
                       String manufacturer,
                       String bookName,
                       String bookCode,
                       String rawNumber,
                       String imageUrl,
                       boolean inUse,
                       Double stockYard,
                       String unit,
                       Integer pricePerYard) {
        this.itemName = itemName;
        this.manufacturer = manufacturer;
        this.bookName = bookName;
        this.bookCode = bookCode;
        this.rawNumber = rawNumber;
        this.imageUrl = imageUrl;
        this.inUse = inUse;
        this.stockYard = stockYard;
        this.unit = unit;
        this.pricePerYard = pricePerYard;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookCode() {
        return bookCode;
    }

    public String getRawNumber() {
        return rawNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isInUse() {
        return inUse;
    }

    public Double getStockYard() {
        return stockYard;
    }

    public String getUnit() {
        return unit;
    }

    public Integer getPricePerYard() {
        return pricePerYard;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setRawNumber(String rawNumber) {
        this.rawNumber = rawNumber;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public void setStockYard(Double stockYard) {
        this.stockYard = stockYard;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setPricePerYard(Integer pricePerYard) {
        this.pricePerYard = pricePerYard;
    }
}
