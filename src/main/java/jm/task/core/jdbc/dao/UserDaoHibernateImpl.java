package jm.task.core.jdbc.dao;

import java.util.List;
import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {  // конструктор

    }

    @Override
    public void createUsersTable() {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS Users " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(45), " +
                    " lastName VARCHAR (45), " +
                    " age INTEGER, " +
                    " PRIMARY KEY (id))";
            session.createSQLQuery(sql).addEntity(User.class).executeUpdate();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS Users";
            int query = session.createSQLQuery(sql).addEntity(User.class).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = getSessionFactory().openSession()) {
            session.getTransaction().begin();
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user); // фиксирует изменения
            session.getTransaction().commit(); // сохранить изменения
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = getSessionFactory().openSession()) {
            session.getTransaction().begin();
            User user = new User();
            int result = session.createQuery("delete from User where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            //session.save(user); // фиксирует изменения
            //session.getTransaction().commit(); // сохранить изменения
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.createQuery("delete from User").executeUpdate();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
