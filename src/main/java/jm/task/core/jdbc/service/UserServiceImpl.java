package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {
    UserDaoHibernateImpl dao = new UserDaoHibernateImpl();

    public void createUsersTable() throws ClassNotFoundException, SQLException {
        dao.createUsersTable();
    }

    public void dropUsersTable() throws ClassNotFoundException, SQLException {
        dao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException, ClassNotFoundException {
        dao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws ClassNotFoundException, SQLException {
        dao.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return dao.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException, ClassNotFoundException {
        dao.cleanUsersTable();
    }
}
