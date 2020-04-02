package com.sgu.testTasks.main.package2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Worker {

    private String name;
    private double salary;
    private int startYear;

    public Worker() {
    }

    public Worker(String name, double salary, int startYear) {
        this.name = name;
        this.salary = salary;
        this.startYear = startYear;
    }

    public int getExpireance(){
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.YEAR) - startYear;
    }

    public int getDaysAfterStartWorking(){
        Calendar currCcalendar = new GregorianCalendar();
        Calendar calendar = new GregorianCalendar(startYear, 0, 0);
        return (int) ((currCcalendar.getTime().getTime() - calendar.getTime().getTime()) / (1000*60*60*24));
    }

    @Override
    public String toString() {
        return "Worker: " + name + "\n"
                + "Salary: " + salary + "\n"
                + "Start year:" + startYear + "\n";
    }
}
