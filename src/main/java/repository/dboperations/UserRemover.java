package repository.dboperations;

import io.netty.channel.Channel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.persistentclasses.UsersPersistentClass;
import repository.queryhandlers.errorhandlers.DataBaseOperationErrorHandler;

import java.util.List;

public class UserRemover {
    public static void exec(Channel currentChannel, String userName) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            List userData = UserHqlSelector.exec(currentChannel, userName);
                UsersPersistentClass user = (UsersPersistentClass) userData.get(0);
                session.delete(user);
                tx.commit();
        } catch (HibernateException he) {
            System.out.println("Hibernate exception in UserRemover class: " + he.getMessage());
            DataBaseOperationErrorHandler.exec(currentChannel);
        }
    }
}
