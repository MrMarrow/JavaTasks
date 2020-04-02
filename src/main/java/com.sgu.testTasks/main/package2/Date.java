package com.sgu.testTasks.main.package2;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void addYear(){
        year++;
    }

    public void minus2day(){
        day -= 2;
        if (day < 0){
            day = 0;
        }
    }

    public boolean equalsDayAndMonth() {
        return day == month;
    }

    public void addMonth(){
        month++;
        if (month == 13) {
            month = 1;
            year++;
        }
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }
}
