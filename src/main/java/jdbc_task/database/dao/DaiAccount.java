package jdbc_task.database.dao;

import jdbc_task.mvc.model.Account;

import java.sql.SQLException;

public interface DaiAccount {

    boolean createNewAccount(Account account) throws SQLException;

    int increaseAmount(int id, double amount) throws SQLException;

    String getAccountAccCode(int accountId) throws SQLException;

    boolean transferAmountByPhone(int accountId, String phone, double amount, String accCode) throws SQLException;

}
