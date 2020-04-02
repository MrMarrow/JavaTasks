package com.sgu.testTasks.main.package2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Book {

    private String name;
    private double price;
    private int pageAmount;
    private int publicationYear;

    public Book() {
    }

    public Book(String name, double price, int pageAmount, int year) {
        this.name = name;
        this.price = price;
        this.pageAmount = pageAmount;
        this.publicationYear = year;
    }

    public double getAveragePrice() {
        return price / pageAmount;
    }

    public int getDaysAfterPublication(){
        Calendar currCcalendar = new GregorianCalendar();
        Calendar calendar = new GregorianCalendar(publicationYear, 0, 0);
        return (int) ((currCcalendar.getTime().getTime() - calendar.getTime().getTime()) / (1000*60*60*24));
    }

    @Override
    public String toString() {
        return "Book: " + name + "\n"
                + "Price: " + price + "\n"
                + "Page amount" + pageAmount + "\n"
                + "Publication year:" + publicationYear + "\n";
    }
}
