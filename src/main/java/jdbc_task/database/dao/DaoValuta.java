package jdbc_task.database.dao;

import jdbc_task.database.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoValuta implements DaiValuta {

    @Override
    public boolean isCorrectValuta(String accCode) throws SQLException {
        PreparedStatement preparedStatement = Connect.getConnection()
                .prepareStatement("select accCode from valuta where accCode = ?");
        preparedStatement.setString(1, accCode);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
