package crud;

import entities.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hovercat on 24.08.16.
 */
public class UserCrud {

    public static Integer addUser(UsersEntity user) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer userID = null;

        try {
            tx = session.beginTransaction();
            userID = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return userID;
    }

    public static void updateUser(UsersEntity user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public static void deleteUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            UsersEntity user = (UsersEntity) session.load(UsersEntity.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public static List<UsersEntity> getAllUsers() {
        List<UsersEntity> users = new ArrayList<>();
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            users = session.createCriteria(UsersEntity.class).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }

    public static UsersEntity getUser(int id) {
        UsersEntity user = null;
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            String queryString = "from UsersEntity where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            user = (UsersEntity) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }

}