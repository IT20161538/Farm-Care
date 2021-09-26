package com.example.fame_care;

public class Crops{
    String productId;
    String Name;
    String Harvest;
    String Order;
    String Remainder;
    String CompanyName;
    String PickupDate;
    String UnitPrice;

    public Crops(String productId, String name, String harvest, String order, String remainder, String companyName, String pickupDate, String unitPrice) {
        this.productId = productId;
        Name = name;
        Harvest = harvest;
        Order = order;
        Remainder = remainder;
        CompanyName = companyName;
        PickupDate = pickupDate;
        UnitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHarvest() {
        return Harvest;
    }

    public void setHarvest(String harvest) {
        Harvest = harvest;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public String getRemainder() {
        return Remainder;
    }

    public void setRemainder(String remainder) {
        Remainder = remainder;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getPickupDate() {
        return PickupDate;
    }

    public void setPickupDate(String pickupDate) {
        PickupDate = pickupDate;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        UnitPrice = unitPrice;
    }
}
