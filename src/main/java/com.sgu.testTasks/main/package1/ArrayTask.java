package com.sgu.testTasks.main.package1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayTask {

    private Scanner scanner;

    public ArrayTask() {
        scanner = new Scanner(System.in);
    }

    /**
     * Ввести с консоли n целых чисел и поместить их в массив.
     * На консоль вывести четные и нечетные числа.
     */
    public void task1() {
        System.out.println("task1");
        List<Integer> numList = inputNumbers();
        Integer[] evenList = numList.stream().filter(i -> i % 2 == 0).toArray(Integer[]::new);
        Integer[] oddList = numList.stream().filter(i -> i % 2 == 1).toArray(Integer[]::new);

        List<Integer> resList = Stream.concat(Stream.of(evenList), Stream.of(oddList)).collect(Collectors.toList());

        System.out.println(resList);
        System.out.println("--------------------------");
    }

    /**
     * Ввести с консоли n целых чисел и поместить их в массив.
     * На консоль вывести числа, которые делятся на 3 или на 9.
     */
    public void task2() {
        System.out.println("task2");
        List<Integer> numList = inputNumbers();

        List<Integer> resList = numList.stream()
                .filter(i -> i % 3 == 0 || i % 9 == 0).collect(Collectors.toList());

        System.out.println(resList);
        System.out.println("--------------------------");
    }

    /**
     * Ввести с консоли n целых чисел и поместить их в массив.
     * На консоль вывести числа, которые делятся на 5 или на 10.
     */
    public void task3() {
        System.out.println("task3");
        List<Integer> numList = inputNumbers();

        List<Integer> resList = numList.stream()
                .filter(i -> i % 5 == 0 || i % 10 == 0).collect(Collectors.toList());

        System.out.println(resList);
    }

    /**
     * Ввести с консоли n целых чисел и поместить их в массив.
     * На консоль вывести наибольший общий делитель и наименьшее общее кратное этих чисел.
     */
    public void task4() {
        System.out.println("task4");
        List<Integer> numList = inputNumbers();

        int gcd = findGCD(numList);
        int lcm = fingLCM(numList);

        System.out.println("gcd: " + gcd);
        System.out.println("lcm: " + lcm);
        System.out.println("--------------------------");
    }

    private List<Integer> inputNumbers() {
        int n = scanner.nextInt();

        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numList.add(scanner.nextInt());
        }
        return numList;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private int findGCD(List<Integer> list) {
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = gcd(list.get(i), result);

            if (result == 1) {
                return 1;
            }
        }

        return result;
    }

    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private int fingLCM(List<Integer> list) {
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = lcm(result, list.get(i));
        }
        return result;
    }

    /**
     * Ввести с консоли n целых чисел и поместить их в массив.
     * На консоль вывести простые числа.
     */
    public void task5() {
        System.out.println("task5");
        List<Integer> numList = inputNumbers();

        List<Integer> resList = numList.stream()
                .filter(this::isPrime)
                .collect(Collectors.toList());

        System.out.println(resList);
        System.out.println("--------------------------");
    }

    private boolean isPrime(int n) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .allMatch(i -> n % i != 0);
    }

    /**
     * Ввести с консоли n целых чисел и поместить их в массив.
     * На консоль вывести "счастливые" числа.
     */
    public void task6() {
        System.out.println("task6");
        String numString = scanner.nextLine().trim();
        int length = numString.length();

        if (length == 1) {
            System.out.println("YES");
            return;
        }

        int num1, num2;
        if (length % 2 == 0) {
            num1 = Integer.parseInt(numString.substring(0, length / 2));
            num2 = Integer.parseInt(numString.substring(length / 2, length));
        } else {
            num1 = Integer.parseInt(numString.substring(0, length / 2));
            num2 = Integer.parseInt(numString.substring(length / 2 + 1, length));
        }

        if (getNumSum(num1) == getNumSum(num2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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
     * Для произвольной цифры от 0 до 9 вывести на консоль ее значение прописью.
     */
    public void task7() {
        System.out.println("task7");
        String[] numbers = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};

        int n = scanner.nextInt();

        System.out.println(numbers[n]);
        System.out.println("--------------------------");
    }
}