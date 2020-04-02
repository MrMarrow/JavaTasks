package com.sgu.testTasks.main.collection_tasks;

import java.util.Scanner;

public class PhoneBookInterface {

    private Scanner scanner;
    private PhoneBook phoneBook;

    public PhoneBookInterface(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {

            System.out.println("Выберете действие:");
            System.out.println("1) Добавить номер");
            System.out.println("2) Удалить номер по его id в списке");
            System.out.println("3) Вывести список номеров");
            System.out.println("4) Вывести номер по его id в списке");
            System.out.println("0) Выйти");
            System.out.print("Вы выбрали: ");
            int chooseAction = scanner.nextInt();

            System.out.println("------------------------------------------");

            switch (chooseAction) {
                case 1: {
                    doAdding();
                    break;
                }
                case 2: {
                    doDeleting();
                    break;
                }
                case 3: {
                    showList();
                    break;
                }
                case 4: {
                    getPhoneItem();
                    break;
                }
                case 0: {
                    return;
                }
            }
        }
    }

    private void getPhoneItem() {
        System.out.print("Веедите id номера в списке: ");
        int id = scanner.nextInt();
        PhoneItem phoneItem = phoneBook.getPhoneItemById(id);
        if (phoneItem == null) {
            return;
        }

        System.out.println("Выбранный номер: ");
        System.out.println(phoneItem.toString());

        System.out.println("Выберете действие:");
        System.out.println("1) Изменить номер");
        System.out.println("2) Перейти в предыдущий раздел");

        System.out.println("Вы выбрали: ");
        int actionNumber = scanner.nextInt();
        switch (actionNumber) {
            case 1: {
                changePhoneItem(phoneItem);
                break;
            }
        }
    }

    private void changePhoneItem(PhoneItem phoneItem) {
        System.out.println("Что вы хотите изменить?");
        System.out.println("1) Номер телефона");
        System.out.println("2) Имя владельца номера телефона");
        System.out.println("3) Адрес владельца номера телефона");
        System.out.print("Вы выбрали: ");
        int actionNumber = scanner.nextInt();

        switch (actionNumber) {
            case 1: {
                System.out.println("Введите новый номер телефона: ");
                String newPhoneNumber = scanner.nextLine().trim();
                phoneItem.setPhoneNumber(newPhoneNumber);
                break;
            }
            case 2: {
                System.out.println("Введите новое имя владельца: ");
                String newOwnerName = scanner.nextLine().trim();
                phoneItem.setOwnerName(newOwnerName);
                break;
            }
            case 3: {
                System.out.println("Введите новый адрес владельца: ");
                String newOwnerAddress = scanner.nextLine().trim();
                phoneItem.setAddress(newOwnerAddress);
                break;
            }
            default: {
                System.out.println("Некорректный выбор");
            }
        }
    }

    private void showList() {
        System.out.println("Список номеров: ");
        for (int i = 0; i < phoneBook.getPhoneItems().size(); i++) {
            System.out.println(i + ") " + phoneBook.getPhoneItemById(i).toString());
        }
    }

    private void doDeleting() {
        System.out.println("Введите id номер в списке: ");
        int id = scanner.nextInt();
        try {
            phoneBook.deletePhoneItem(id);
            System.out.println("Удаление успешно");
        } catch (Exception e) {
            System.out.println("Неверно указан id");
        }
    }

    private void doAdding() {
        System.out.println("Введите номер: ");
        String number = scanner.nextLine().trim();
        System.out.println("Введите имя владельца: ");
        String name = scanner.nextLine().trim();
        System.out.println("Введите адрес : ");
        String address = scanner.nextLine().trim();

        phoneBook.addPhoneItem(new PhoneItem(number, name, address));
    }
}
