package com.example.jerrypaddy.inventorycategories;

public class FrozenProducts {
    String name;
    int numberInPackage;


    float costPerItem;

    float sellingPrice;

    float gross_cost;

    public FrozenProducts(String name, int numberInPackage, float costPerItem, float sellingPrice) {
        this.name = name;
        this.numberInPackage = numberInPackage;
        this.costPerItem = costPerItem;
        this.sellingPrice = sellingPrice;
        this.gross_cost = numberInPackage * costPerItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberInPackage() {
        return numberInPackage;
    }

    public void setNumberInPackage(int numberInPackage) {
        this.numberInPackage = numberInPackage;
    }

    public float getCostPerItem() {
        return costPerItem;
    }

    public void setCostPerItem(float costPerItem) {
        this.costPerItem = costPerItem;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getGross_cost() {
        return gross_cost;
    }

    public void setGross_cost(float gross_cost) {
        this.gross_cost = gross_cost;
    }

}
