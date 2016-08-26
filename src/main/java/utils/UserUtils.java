package utils;

import entities.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by hovercat on 26.08.16.
 */
public class UserUtils {
    public static UsersEntity loginCheck(String login) {

        UsersEntity user = null;
        Transaction tx = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            tx = session.beginTransaction();
            String queryString = "from UsersEntity where login = :login";
            Query query = session.createQuery(queryString);
            query.setString("login", login);
//            query.setString("password", password);
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
