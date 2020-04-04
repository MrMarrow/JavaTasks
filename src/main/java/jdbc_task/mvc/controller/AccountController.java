package jdbc_task.mvc.controller;

import jdbc_task.database.dao.DaiAccount;
import jdbc_task.database.dao.DaiValuta;
import jdbc_task.database.dao.DaoAccount;
import jdbc_task.database.dao.DaoValuta;
import jdbc_task.mvc.model.Account;
import jdbc_task.mvc.model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountController {

    private Scanner scanner;
    private User user;

    private DaiAccount daiAccount;
    private DaiValuta daiValuta;

    public AccountController(User user) {
        this.user = user;
        scanner = new Scanner(System.in);
        daiAccount = new DaoAccount();
        daiValuta = new DaoValuta();
    }

    public boolean createNewAccount() throws SQLException {
        System.out.println("Введите тип счёта: ");
        String accCode = scanner.nextLine().trim();
        if (daiAccount.createNewAccount(new Account(user.getId(), accCode))) {
            System.out.println("Счёт создан");
            return true;
        } else {
            System.out.println("Ошибка при создании счёта");
            return false;
        }

    }

    public void increaseAccountAmount(int accountId, double amount, String accCode) throws SQLException {
        String accountAccCode = daiAccount.getAccountAccCode(accountId);
        double newAmount = amount;
        if (daiValuta.isCorrectValuta(accCode)) {
            newAmount = MoneyConverter.convert(amount, accCode, accountAccCode);
        } else {
            System.out.println("данный тип валюты не поддерживается или введён некорректно.");
        }
        if (daiAccount.increaseAmount(accountId, newAmount) > 0) {
            System.out.println("Пополнение произведено");
        } else {
            System.out.println("Ошибка при пополнении счёта");
        }
    }

    public void transferAmountByPhone(int accountId) throws SQLException {
        System.out.println("Введите номер телефона: ");
        String phone = scanner.nextLine().toLowerCase();
        System.out.println("Введите сумму перевода: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Введите тип валюты: ");
        String accDate = scanner.nextLine().toLowerCase();

        if (daiAccount.transferAmountByPhone(accountId, phone, amount, accDate)) {
            System.out.println("Перевод завершён");
        } else {
            System.out.println("Ошибка перевода");
        }
    }
}
