package com.example.jerrypaddy.others;

public class Vendors {
    String name;
    String gender;
    int age;

    int phoneNumber;

    String productCategory;

    public Vendors(String name, String productCategory, String gender, int age, int phoneNumber){
        this.name = name;
        this.productCategory = productCategory;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getProductCategory(){
        return productCategory;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }




}
