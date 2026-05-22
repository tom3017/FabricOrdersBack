package com.example.fabricordersserver.dto;

import com.example.fabricordersserver.entity.FabricBook;

/**
 * Response DTO returned to the frontend representing a FabricBook.
 */
public class FabricBookResponseDto {

    private Long id;
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

    public FabricBookResponseDto(FabricBook fabricBook) {
        this.id = fabricBook.getId();
        this.manufacturer = fabricBook.getManufacturer();
        this.bookName = fabricBook.getBookName();
        this.bookCode = fabricBook.getBookCode();
        this.fabricNumber = fabricBook.getFabricNumber();
        this.imageUrl = fabricBook.getImageUrl();
        this.inUse = fabricBook.isInUse();
        this.stockYard = fabricBook.getStockYard();
        this.pricePerYard = fabricBook.getPricePerYard();
        this.season = fabricBook.getSeason();
        this.yarnType = fabricBook.getYarnType();
        this.weaveType = fabricBook.getWeaveType();
        this.color = fabricBook.getColor();
        this.thickness = fabricBook.getThickness();
        this.weight = fabricBook.getWeight();
        this.strength = fabricBook.getStrength();
        this.materialComposition = fabricBook.getMaterialComposition();
        this.careInstructions = fabricBook.getCareInstructions();
    }

    public Long getId() {
        return id;
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
