package jdbc_task.database.dao;

import jdbc_task.mvc.model.Operation;

import java.sql.SQLException;
import java.util.List;

public interface DaiOperation {

    boolean createOperation(Operation operation) throws SQLException;

    List<Operation> getOperationList(int userId) throws SQLException;

}
