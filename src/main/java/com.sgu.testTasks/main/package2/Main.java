package com.sgu.testTasks.main.package2;

public class Main {
    public static void main(String[] args) {

        runData();
        runTime();
        runRectangle();
        runBook();
        runWorker();
    }

    private static void runWorker() {
        System.out.println("Running Worker...");

        Worker worker = new Worker("Vasya", 50000, 2005);
        System.out.println(worker.toString());

        System.out.println("Worker experience: " + worker.getExpireance());
        System.out.println("Days after start working: " + worker.getDaysAfterStartWorking());

        System.out.println("-------------------------------");
    }

    private static void runBook() {
        System.out.println("Running Book...");

        Book book = new Book("The Lord of the Rings", 100, 992, 1954);
        System.out.println(book.toString());

        System.out.println("Average price: " + book.getAveragePrice());
        System.out.println("Days after publication: " + book.getDaysAfterPublication());

        System.out.println("-------------------------------");
    }

    private static void runRectangle() {
        System.out.println("Running Rectangle...");

        Rectangle rectangle = new Rectangle(1, 1, 5, 5);
        System.out.println(rectangle.toString());

        System.out.println("Rectangle area: " + rectangle.getAreaRectangle());
        System.out.println("Is rectangle square: " + rectangle.isSquere());

        System.out.println("-------------------------------");
    }

    private static void runTime() {
        System.out.println("Running Time...");

        Time time = new Time(15, 46, 57);
        System.out.println(time.toString());

        System.out.println("Add 5 seconds:");
        time.add5second();
        System.out.println(time.toString());

        System.out.println("Seconds in time: " + time.getAllSeconds());

        System.out.println("-------------------------------");
    }

    private static void runData() {
        System.out.println("Running Data...");

        Date date = new Date(15, 6, 2020);
        System.out.println(date.toString());

        System.out.println("Add month:");
        date.addMonth();
        System.out.println(date.toString());

        System.out.println("Add year:");
        date.addYear();
        System.out.println(date.toString());

        System.out.println("Minus 2 days:");
        date.minus2day();
        System.out.println(date.toString());

        System.out.println("Aquals days and months: " + date.equalsDayAndMonth());

        System.out.println("-------------------------------");
    }
}
