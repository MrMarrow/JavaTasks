package jdbc_task.database.dao;

import java.sql.SQLException;

public interface DaiValuta {
    boolean isCorrectValuta(String accCode) throws SQLException;
}
