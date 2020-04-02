package com.sgu.testTasks.main.package1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoopTask {

    private Scanner scanner;

    public LoopTask() {
        scanner = new Scanner(System.in);
    }

    /**
     * Найти все числа некратные пяти и кратные 3,
     * и сумма цифр которых также некратные пяти и кратна 3.
     */
    public void task1() {
        System.out.println("task1");
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int numSum = getNumSum(i);
            if (i % 3 == 0 && i % 5 != 0 && numSum % 3 == 0 && numSum % 5 != 0) {
                resList.add(i);
            }
        }
        System.out.println(resList);
        System.out.println("--------------------------");
    }

    private int getNumSum(int n) {
        int sum = 0;
        for (; n != 0; n /= 10) {
            sum += (n % 10);
        }
        return sum;
    }

    /**
     * Найти все числа кратные пяти для чисел от 1 до N.
     */
    public void task2() {
        System.out.println("task2");
        int n = scanner.nextInt();

        List<Integer> resList = IntStream.rangeClosed(0, n).boxed()
                .filter(i -> i % 5 == 0).collect(Collectors.toList());

        System.out.println(resList);
        System.out.println("--------------------------");
    }

    /**
     * Является ли заданное натуральное число степенью двойки?
     */
    public void task3() {
        System.out.println("task3");
        int num = scanner.nextInt();

        while (num != 1 && num % 2 == 0) {
            num /= 2;
        }

        System.out.println(num == 1 ? "YES" : "NO");
        System.out.println("--------------------------");
    }

    /**
     * Составьте программу, позволяющую найти все числа Фибоначчи, меньшие заданного числа N.
     */
    public void task4() {
        System.out.println("task4");
        int n = scanner.nextInt();
        List<Integer> resList = new ArrayList<>();
        resList.add(0);
        resList.add(1);

        for (int i = 1; resList.get(i) < n; i++) {
            resList.add(resList.get(i) + resList.get(i - 1));
        }

        resList.remove(resList.size() - 1);

        System.out.println(resList);
        System.out.println("--------------------------");
    }

    /**
     * Даны два целых числа A и B (A < B).
     * Найти все целые числа, расположенные между данными числами (включая сами эти числа),
     * в порядке их возрастания, а также количество N этих чисел.
     */
    public void task5() {
        System.out.println("task5");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        List<Integer> resList = IntStream.rangeClosed(a, b).boxed()
                .collect(Collectors.toList());

        int n = resList.size();

        System.out.println("list: " + resList);
        System.out.println("size: " + n);
        System.out.println("--------------------------");
    }

    /**
     * Даны два целых числа A и B (A < B).
     * Найти все целые числа, расположенные между данными числами (не включая сами эти числа),
     * в порядке их убывания, а также количество N этих чисел.
     */
    public void task6() {
        System.out.println("task6");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        List<Integer> resList = IntStream.rangeClosed(a, b).boxed()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        int n = resList.size();

        System.out.println("list: " + resList);
        System.out.println("size: " + n);
        System.out.println("--------------------------");
    }

    /**
     * Дано вещественное число A и целое число N (> 0).
     * Найти A в степени N: AN = A•A••A (числа A перемножаются N раз) .
     */
    public void task7() {
        System.out.println("task7");
        int a = scanner.nextInt();
        int n = scanner.nextInt();

        int res = a;

        for (int i = 1; i < n; i++) {
            res *= a;
        }

        System.out.println(res);
        System.out.println("--------------------------");
    }

    /**
     * Дано вещественное число A и целое число N (> 0).
     * Найти все целые степени числа A от 1 до N.
     */
    public void task8() {
        System.out.println("task8");
        int a = scanner.nextInt();
        int n = scanner.nextInt();

        List<Integer> resList = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            resList.add((int) Math.pow(a, i));
        }

        System.out.println(resList);
        System.out.println("--------------------------");
    }
}
