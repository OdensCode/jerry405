package com.example.jerrypaddy.others;

public class IssuedGoods {
    String receiver;
    String good;
    int quantity;
    float cost;
    float gross_cost;

    public IssuedGoods(String receiver, String good, int quantity, float cost){
        this.receiver = receiver;
        this.good = good;
        this.quantity = quantity;
        this.cost = cost;
        this.gross_cost = cost * quantity;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getGross_cost() {
        return gross_cost;
    }

    public void setGross_cost(float gross_cost) {
        this.gross_cost = gross_cost;
    }

}
