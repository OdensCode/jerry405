package com.example.jerrypaddy.others;

public class Bill {
    String billName;

    float billAmount;

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public float getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(float billAmount) {
        this.billAmount = billAmount;
    }

    public Bill(String billName, float billAmount) {
        this.billName = billName;
        this.billAmount = billAmount;
    }
}
