package com.usa.project.model.custom;

public class YearAmount {

    private int year;
    private int amount;

    public YearAmount(int year,int amount){
        this.year=year;
        this.amount=amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
