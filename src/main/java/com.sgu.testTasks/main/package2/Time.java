package com.sgu.testTasks.main.package2;

public class Time {

    private int hour;
    private int minute;
    private int second;

    public Time() {
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getAllSeconds(){
        return (hour * 60 + minute) * 60 + second;
    }

    public void add5second(){
        second += 5;

        if (second > 60){
            second %= 60;
            minute++;
            if (minute == 60){
                minute = 0;
                hour++;
                if (hour == 24){
                    hour = 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}
