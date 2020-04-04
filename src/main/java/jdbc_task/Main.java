package jdbc_task;

import jdbc_task.database.Connect;
import jdbc_task.mvc.view.MainMenu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connect.setConnect("root", "qwerty");
        MainMenu mainMenu = new MainMenu();
        mainMenu.start();
    }
}
