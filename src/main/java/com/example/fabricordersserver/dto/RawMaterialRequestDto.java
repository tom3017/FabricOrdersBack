package com.example.fabricordersserver.dto;

/**
 * DTO for creating or updating raw materials from frontend requests.
 */
public class RawMaterialRequestDto {

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
