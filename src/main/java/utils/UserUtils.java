package utils;

import entities.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by hovercat on 26.08.16.
 */
public class UserUtils {
    public static UsersEntity loginCheck(String login) {

        UsersEntity user = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
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
