package jdbc_task.database.dao;

import jdbc_task.database.Connect;
import jdbc_task.mvc.controller.MoneyConverter;
import jdbc_task.mvc.model.Account;
import jdbc_task.mvc.model.Operation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DaoAccount implements DaiAccount {

    private DaiOperation daiOperation;

    private String GET_AMOUNT_BY_ID = "select amount from account where id = ?";

    private String CREATE_REQUEST = "insert into account (client_id, amount, accCode) values (?, ?, ?)";

    private String INCREASE_REQUEST = "update account set amount = amount + ? " +
            "where (? > 0 or (? < 0 and abs(?) <= amount)) and id = ?";

    private String GET_ACCOUNT_BY_PHONE_AND_ACCCODE = "select * from account where " +
            "client_id = (select id from banktask_schema.user where phone = ? limit 1)" +
            "and accCode = ? limit 1";

    private String GET_ACCOUNT_ACCCODE = "select accCode from account where id = ?";


    public DaoAccount() {
        daiOperation = new DaoOperation();
    }

    @Override
    public boolean createNewAccount(Account account) throws SQLException {
        int clientId = account.getClientId();
        double amount = 0;
        String accCode = account.getAccCode();
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(CREATE_REQUEST);
        preparedStatement.setInt(1, clientId);
        preparedStatement.setDouble(2, amount);
        preparedStatement.setString(3, accCode);
        try {
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("Счёт с такой валютой уже существует");
            }
            return false;
        }

    }

    @Override
    public int increaseAmount(int id, double amount) throws SQLException {
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(INCREASE_REQUEST);
        preparedStatement.setDouble(1, amount);
        preparedStatement.setDouble(2, amount);
        preparedStatement.setDouble(3, amount);
        preparedStatement.setDouble(4, amount);
        preparedStatement.setInt(5, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public String getAccountAccCode(int accountId) throws SQLException {
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(GET_ACCOUNT_ACCCODE);
        preparedStatement.setDouble(1, accountId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("accCode");
        }
        return null;
    }

    @Override
    public boolean transferAmountByPhone(int accountId, String phone, double amount, String accCode) throws SQLException {

        Integer accountIdTo = getAccountIdByUserPhoneAndAccCode(phone, accCode);
        if (accountIdTo == null) {
            System.out.println("Такого пользователя нет или номер введён некорректно.");
            return false;
        }
        Double accountAmount = getAccountAmount(accountId);
        if (getAccountAmount(accountId) < amount) {
            System.out.println("На счету недостаточно средств.");
            return false;
        }

        double newAmount = MoneyConverter.convert(amount, getAccountAccCode(accountId), accCode);

        if (increaseAmount(accountId, -newAmount) > 0 && increaseAmount(accountIdTo, amount) > 0) {
            daiOperation.createOperation(new Operation(new Date(), accCode,
                    accountId, accountIdTo, newAmount, accountAmount, accountAmount - newAmount));
            return true;
        }
        return false;
    }

    private Double getAccountAmount(int accountId) throws SQLException {
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(GET_AMOUNT_BY_ID);
        preparedStatement.setDouble(1, accountId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getDouble("amount");
        }
        return null;
    }

    private Integer getAccountIdByUserPhoneAndAccCode(String phone, String accCode) throws SQLException {
        PreparedStatement preparedStatement = Connect.getConnection()
                .prepareStatement(GET_ACCOUNT_BY_PHONE_AND_ACCCODE);
        preparedStatement.setString(1, phone);
        preparedStatement.setString(2, accCode);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }
        return null;
    }
}
