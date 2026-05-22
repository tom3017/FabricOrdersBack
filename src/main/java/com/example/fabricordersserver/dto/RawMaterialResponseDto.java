package com.example.fabricordersserver.dto;

import com.example.fabricordersserver.entity.RawMaterial;

/**
 * Response DTO returned to the frontend representing a raw material.
 */
public class RawMaterialResponseDto {

    private Long id;
    private String itemName;
    private String manufacturer;
    private String bookName;
    private String bookCode;
    private String rawNumber;
    private String imageUrl;
    private Boolean inUse;
    private Double stockYard;
    private String unit;
    private Integer pricePerYard;

    public RawMaterialResponseDto(RawMaterial material) {
        this.id = material.getId();
        this.itemName = material.getItemName();
        this.manufacturer = material.getManufacturer();
        this.bookName = material.getBookName();
        this.bookCode = material.getBookCode();
        this.rawNumber = material.getRawNumber();
        this.imageUrl = material.getImageUrl();
        this.inUse = material.isInUse();
        this.stockYard = material.getStockYard();
        this.unit = material.getUnit();
        this.pricePerYard = material.getPricePerYard();
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

    public Boolean getInUse() {
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
}
