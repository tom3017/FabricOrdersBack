package com.example.fabricordersserver.dto;

/**
 * DTO used when creating or updating a FabricBook from the frontend.
 */
public class FabricBookRequestDto {

    private String manufacturer;
    private String bookName;
    private String bookCode;
    private String fabricNumber;
    private String imageUrl;
    private Boolean inUse;
    private Double stockYard;
    private Integer pricePerYard;
    private String season;
    private String yarnType;
    private String weaveType;
    private String color;
    private String thickness;
    private String weight;
    private String strength;
    private String materialComposition;
    private String careInstructions;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookCode() {
        return bookCode;
    }

    public String getFabricNumber() {
        return fabricNumber;
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

    public Integer getPricePerYard() {
        return pricePerYard;
    }

    public String getSeason() {
        return season;
    }

    public String getYarnType() {
        return yarnType;
    }

    public String getWeaveType() {
        return weaveType;
    }

    public String getColor() {
        return color;
    }

    public String getThickness() {
        return thickness;
    }

    public String getWeight() {
        return weight;
    }

    public String getStrength() {
        return strength;
    }

    public String getMaterialComposition() {
        return materialComposition;
    }

    public String getCareInstructions() {
        return careInstructions;
    }
}
