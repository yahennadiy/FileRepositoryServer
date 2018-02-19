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

public class UserUpdater {
    private static UsersPersistentClass user;
    public static void exec(Channel currentChannel, String userName, String password, String firstName, String lastName) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            List userData = UserHqlSelector.exec(currentChannel, userName);
                user = (UsersPersistentClass) userData.get(0);
                user.setUserName(userName);
                user.setPassword(password);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                session.update(user);
                tx.commit();
        } catch (HibernateException he) {
            System.out.println("Hibernate exception in UserUpdater class: " + he.getMessage());
            DataBaseOperationErrorHandler.exec(currentChannel);
        }
    }

    public static UsersPersistentClass getUser() {
        return user;
    }
}
