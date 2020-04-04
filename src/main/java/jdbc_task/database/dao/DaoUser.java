package jdbc_task.database.dao;

import jdbc_task.database.Connect;
import jdbc_task.mvc.model.Account;
import jdbc_task.mvc.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUser implements DaiUser {

    private String CREATE_REQUEST =
            "insert into banktask_schema.user(login, password, address, phone) VALUES (?, ?, ?, ?)";
    private String GET_USER_REQUEST = "select * from banktask_schema.user where (phone = ? or login = ?) and password = ?";
    private String GET_ACCOUNT_LIST_REQUEST = "select * from `banktask_schema`.account ac  where ac.client_id = ?";

    @Override
    public boolean createNewUser(User user) throws SQLException {
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(CREATE_REQUEST);
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getAddress());
        preparedStatement.setString(4, user.getPhone());
        return preparedStatement.execute();
    }

    @Override
    public User getUser(String login, String password) throws SQLException {
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(GET_USER_REQUEST);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, login);
        preparedStatement.setString(3, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new User(resultSet.getInt("id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("address"),
                    resultSet.getString("phone"));
        }
        return null;
    }

    @Override
    public List<Account> getAccountList(int id) throws SQLException {
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(GET_ACCOUNT_LIST_REQUEST);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Account> accountList = new ArrayList<>(5);
        while (resultSet.next()) {
            Account account = new Account(resultSet.getInt("id"),
                    resultSet.getInt("client_id"),
                    resultSet.getDouble("amount"),
                    resultSet.getString("accCode"));
            accountList.add(account);
        }
        return accountList;
    }
}
