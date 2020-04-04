package jdbc_task.mvc.controller;

import jdbc_task.database.dao.DaiOperation;
import jdbc_task.database.dao.DaiUser;
import jdbc_task.database.dao.DaoOperation;
import jdbc_task.database.dao.DaoUser;
import jdbc_task.mvc.model.Account;
import jdbc_task.mvc.model.Operation;
import jdbc_task.mvc.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserController {

    private Scanner scanner;
    private User user;
    private AccountController accountController;

    private DaiUser daiUser;
    private DaiOperation daiOperation;


    public UserController() {
        scanner = new Scanner(System.in);
        daiUser = new DaoUser();
        daiOperation = new DaoOperation();
    }

    public boolean createNewUser() throws SQLException {
        System.out.println("Введите логин: ");
        String login = scanner.nextLine().toLowerCase();
        String password1;
        while (true) {
            System.out.println("Введите пароль: ");
            password1 = scanner.nextLine();
            System.out.println("Повторите пароль: ");
            String password2 = scanner.nextLine();
            if (password1.equals(password2)) {
                break;
            } else {
                System.out.println("Пароли несовпадают");
            }
        }
        System.out.println("Введите адрес: ");
        String address = scanner.nextLine();
        System.out.println("Введите номер телефона: ");
        String phone = scanner.nextLine().toLowerCase();

        if (daiUser.createNewUser(new User(login, password1, address, phone))) {
            System.out.println("Пользователь создан");
            return true;
        } else {
            System.out.println("Ошибка регистрации");
            return false;
        }
    }

    public boolean logIn(String loginOrPhone, String password) throws SQLException {
        user = daiUser.getUser(loginOrPhone, password);
        if (user != null) {
            accountController = new AccountController(user);
            return true;
        }
        return false;
    }

    public boolean createNewAccount() throws SQLException {
        return accountController.createNewAccount();
    }

    public List<Account> getAccountList() throws SQLException {
        return daiUser.getAccountList(user.getId());
    }

    public void increaseAccountAmount(int accountId) throws SQLException {
        System.out.println("Введите вид валюты: ");
        String accCode = scanner.nextLine().toLowerCase();
        System.out.println("Введите сумму пополнения: ");
        double amount = scanner.nextDouble();
        accountController.increaseAccountAmount(accountId, amount, accCode);
    }

    public void transferAmountByPhone(int accountId) throws SQLException {
        accountController.transferAmountByPhone(accountId);
    }

    public List<Operation> getOperationList() throws SQLException {
        return daiOperation.getOperationList(user.getId());
    }
}
