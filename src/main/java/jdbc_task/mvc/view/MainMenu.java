package jdbc_task.mvc.view;

import jdbc_task.mvc.controller.UserController;
import jdbc_task.mvc.model.Account;
import jdbc_task.mvc.model.Operation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainMenu {

    UserController userController;
    private Scanner scanner;

    public MainMenu() {
        scanner = new Scanner(System.in);
        userController = new UserController();
    }

    public void start() throws SQLException {
        authorizationTemp();
        actionTemp();
    }

    private void actionTemp() throws SQLException {
        while (true) {
            printMakeChoice();
            printChoice(1, "Создать новый счёт");
            printChoice(2, "Посмотреть счета");
            printChoice(3, "Просмотор истроии операций");
            printYourChoice();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    userController.createNewAccount();
                    break;
                }
                case 2: {
                    List<Account> accountList = userController.getAccountList();
                    System.out.println("Ваши счета: ");
                    for (int i = 0; i < accountList.size(); i++) {
                        System.out.println((i + 1) + ") " + accountList.get(i).toString() + "\n");
                    }
                    System.out.println();
                    accountActionTemp(accountList);
                    break;
                }
                case 3: {
                    List<Operation> operationList = userController.getOperationList();
                    operationList.forEach(operation -> System.out.println(operation.toString()));
                    System.out.println();
                    break;
                }
                default: {
                    printIncorretInput();
                }
            }
        }
    }

    private void accountActionTemp(List<Account> accountList) throws SQLException {
        int choice;
        printMakeChoice();
        printChoice(1, "Пополнить счёт");
        printChoice(2, "Перевести деньги другому пользователю");
        printChoice(3, "Назад");
        printYourChoice();
        choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                increaseAmount(accountList);
                break;
            }
            case 2: {
                transferAmount(accountList);
            }
            case 3: {
                break;
            }
            default: {
                printIncorretInput();
            }
        }
    }

    private void transferAmount(List<Account> accountList) throws SQLException {
        System.out.println("Выберете id счёта: ");
        int number = scanner.nextInt();
        List<Account> list = accountList.stream()
                .filter(account -> account.getId() == number)
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            printIncorretInput();
            return;
        }
        userController.transferAmountByPhone(number);
    }

    private void increaseAmount(List<Account> accountList) throws SQLException {
        System.out.println("Выберете id счёта: ");
        int number = scanner.nextInt();
        List<Account> list = accountList.stream()
                .filter(account -> account.getId() == number)
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            printIncorretInput();
            return;
        }
        userController.increaseAccountAmount(number);
    }

    private void printYourChoice() {
        System.out.print("Ваш выбор: ");
    }

    private void printChoice(int i2, String s) {
        System.out.println(i2 + ")" + s);
    }

    private void printMakeChoice() {
        System.out.println("Выберите действие: ");
    }

    private void authorizationTemp() throws SQLException {
        System.out.println("Добро пожаловать!");
        printMakeChoice();
        boolean authorizationFlag = true;
        while (authorizationFlag) {
            printChoice(1, "Войти");
            printChoice(2, "Регистрация");
            printYourChoice();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    if (logIn()) {
                        authorizationFlag = false;
                    }
                    break;
                }
                case 2: {
                    if (registration()) {
                        authorizationFlag = false;
                    }
                    break;
                }
                default: {
                    printIncorretInput();
                }
            }
        }
    }

    private void printIncorretInput() {
        System.out.println("Некорректный ввод");
    }

    private boolean registration() throws SQLException {
        return userController.createNewUser();
    }

    private boolean logIn() throws SQLException {
        scanner.nextLine();
        System.out.print("Введите логин/номер телефона: ");
        String login = scanner.nextLine().toLowerCase();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        if (userController.logIn(login, password)) {
            System.out.println("Авториция прошла успешно");
            return true;
        } else {
            System.out.println("Неправильный логин или пароль");
            return false;
        }
    }

}
