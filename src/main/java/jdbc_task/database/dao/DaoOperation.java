package jdbc_task.database.dao;

import jdbc_task.database.Connect;
import jdbc_task.mvc.model.Operation;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoOperation implements DaiOperation {

    private String CREATE_REQUEST = "insert into banktask_schema.operation(date, accCode, id_account_from, id_account_to, sum, amount_before, amount_after)" +
            "values (?, ?, ?, ?, ?, ?, ?)";
    private String GET_OPERATION_LIST_REQUEST = "select operation.* from banktask_schema.operation, " +
            "(select id from banktask_schema.account ac  where ac.client_id = ?) ac_id " +
            "where operation.id_account_from = ac_id.id or operation.id_account_to = ac_id.id";

    @Override
    public boolean createOperation(Operation operation) throws SQLException {
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(CREATE_REQUEST);
        preparedStatement.setDate(1, new Date(operation.getDate().getTime()));
        preparedStatement.setString(2, operation.getAccCode());
        preparedStatement.setInt(3, operation.getIdAccountFrom());
        preparedStatement.setInt(4, operation.getIdAccountTo());
        preparedStatement.setDouble(5, operation.getSum());
        preparedStatement.setDouble(6, operation.getAmountBefore());
        preparedStatement.setDouble(7, operation.getAmountAfter());
        return preparedStatement.execute();
    }

    @Override
    public List<Operation> getOperationList(int userId) throws SQLException {
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(GET_OPERATION_LIST_REQUEST);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Operation> operationList = new ArrayList<>();
        while (resultSet.next()) {
            Operation operation = new Operation(resultSet.getInt("id"),
                    resultSet.getDate("date"),
                    resultSet.getString("accCode"),
                    resultSet.getInt("id_account_from"),
                    resultSet.getInt("id_account_to"),
                    resultSet.getDouble("sum"),
                    resultSet.getDouble("amount_before"),
                    resultSet.getDouble("amount_after"));
            operationList.add(operation);
        }
        return operationList;
    }
}
