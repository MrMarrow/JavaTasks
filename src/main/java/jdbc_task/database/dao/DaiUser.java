package jdbc_task.database.dao;

import jdbc_task.mvc.model.Account;
import jdbc_task.mvc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface DaiUser {

    boolean createNewUser(User user) throws SQLException;

    User getUser(String login, String password) throws SQLException;

    List<Account> getAccountList(int id) throws SQLException;

}
