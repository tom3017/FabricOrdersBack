package com.example.fabricordersserver.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fabric_books")
public class FabricBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;
    private String bookName;
    private String bookCode;
    private String fabricNumber;
    private String imageUrl;
    private boolean inUse;
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

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    protected FabricBook() {}

    public FabricBook(String manufacturer,
                      String bookName,
                      String bookCode,
                      String fabricNumber,
                      String imageUrl,
                      boolean inUse,
                      Double stockYard,
                      Integer pricePerYard,
                      String season,
                      String yarnType,
                      String weaveType,
                      String color,
                      String thickness,
                      String weight,
                      String strength,
                      String materialComposition,
                      String careInstructions) {
        this.manufacturer = manufacturer;
        this.bookName = bookName;
        this.bookCode = bookCode;
        this.fabricNumber = fabricNumber;
        this.imageUrl = imageUrl;
        this.inUse = inUse;
        this.stockYard = stockYard;
        this.pricePerYard = pricePerYard;
        this.season = season;
        this.yarnType = yarnType;
        this.weaveType = weaveType;
        this.color = color;
        this.thickness = thickness;
        this.weight = weight;
        this.strength = strength;
        this.materialComposition = materialComposition;
        this.careInstructions = careInstructions;
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

    public boolean isInUse() {
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

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setFabricNumber(String fabricNumber) {
        this.fabricNumber = fabricNumber;
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

    public void setPricePerYard(Integer pricePerYard) {
        this.pricePerYard = pricePerYard;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setYarnType(String yarnType) {
        this.yarnType = yarnType;
    }

    public void setWeaveType(String weaveType) {
        this.weaveType = weaveType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public void setMaterialComposition(String materialComposition) {
        this.materialComposition = materialComposition;
    }

    public void setCareInstructions(String careInstructions) {
        this.careInstructions = careInstructions;
    }
}
