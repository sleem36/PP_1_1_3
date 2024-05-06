package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // реализуйте алгоритм здесь

            //UserDao userDao = new UserDaoJDBCImpl();
        UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();

            userDao.createUsersTable();
            userDao.dropUsersTable();
            userDao.createUsersTable();

//            userDao.saveUser("Name1", "LastName1", (byte) 20);
//            userDao.saveUser("Name2", "LastName2", (byte) 25);
//            userDao.saveUser("Name32", "LastName3", (byte) 31);
//            userDao.saveUser("Name42", "LastName4", (byte) 38);
//
//            userDao.removeUserById(3);
//            System.out.println(userDao.getAllUsers().toString());
//            userDao.cleanUsersTable();

    }
}
