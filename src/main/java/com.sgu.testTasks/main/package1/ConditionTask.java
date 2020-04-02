package com.sgu.testTasks.main.package1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Math.pow;

public class ConditionTask {

    private Scanner scanner;

    public ConditionTask() {
        scanner = new Scanner(System.in);
    }

    /**
     * Ввести с клавиатуры два числа.
     * Определить, что больше, сумма квадратов или квадрат суммы этих чисел.
     * Ответ вывести в виде сообщения.
     */
    public void task1() {
        System.out.println("task1");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int sum1 = (int) pow(a + b, 2);
        int sum2 = a * a + b * b;

        if (sum1 > sum2) {
            System.out.println("Квадрат суммы");
        } else {
            System.out.println("Cумма квадратов");
        }
        System.out.println("--------------------------");
    }

    /**
     * Рассчитать надбавку к зарплате за стаж, если стаж от 2 до 5 лет,
     * надбавка составляет 2%, если стаж от 5 до 10 лет - 5%.
     * Ввести с клавиатуры зарплату и стаж, вывести надбавку и сумму к выплате.
     */
    public void task2() {
        System.out.println("task2");
        double price = scanner.nextDouble();
        int experience = scanner.nextInt();

        if (experience >= 2 && experience < 5) {
            price *= 1.02;
        } else if (experience >= 5 && experience < 10) {
            price *= 1.05;
        }
        System.out.println(price);
        System.out.println("--------------------------");
    }

    /**
     * Ввести с клавиатуры координаты точек А (х0,у0) и В (х1,у1).
     * Определить, какая из точек А или В наиболее удалена от начала координат (О(0,0)).
     * Ответ вывести в виде сообщения.
     */
    public void task3() {
        System.out.println("task3");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        double distance1 = Math.sqrt(x1 * x1 + y1 * y1);
        double distance2 = Math.sqrt(x2 * x2 + y2 * y2);

        if (distance1 > distance2) {
            System.out.println("first point");
        } else {
            System.out.println("Second point");
        }
        System.out.println("--------------------------");
    }

    /**
     * Ввести с клавиатуры значения трех сторон треугольника a, b и c
     * и определить, является ли он прямоугольным.
     * Ответ вывести в виде сообщения.
     */
    public void task4() {
        System.out.println("task4");
        List<Double> lineList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            lineList.add(scanner.nextDouble());
        }

        lineList = lineList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (pow(lineList.get(0), 2) == pow(lineList.get(1), 2) + pow(lineList.get(2), 2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        System.out.println("--------------------------");
    }

    /**
     * Ввести с клавиатуры три числа, положительные возвести в квадрат, а отрицательные оставить без изменений.
     */
    public void task5() {
        System.out.println("task5");
        List<Double> numberList = new ArrayList<>();


        numberList.add(scanner.nextDouble());
        numberList.add(scanner.nextDouble());
        numberList.add(scanner.nextDouble());

        numberList = numberList.stream().map(a -> {
            if (a > 0) {
                return a * a;
            }
            return a;
        }).collect(Collectors.toList());

        System.out.println(numberList);
        System.out.println("--------------------------");
    }

    /**
     * Ввести с экрана число от 1 до 12.
     * По номеру месяца выдать сообщение о времени года.
     * Если пользователь введет недопустимое число, программа должна выдать сообщение об ошибке.
     */
    public void task6() {
        System.out.println("task6");
        int i = scanner.nextInt();

        switch (i) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июль");
                break;
            case 7:
                System.out.println("июнь");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("error");
        }
        System.out.println("--------------------------");
    }
}
