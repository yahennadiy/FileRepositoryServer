package repository.dboperations;

import io.netty.channel.ChannelHandlerContext;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.persistentclasses.UsersPersistentClass;
import repository.queryhandlers.errorhandlers.DataBaseOperationErrorHandler;

public class UserSaver {
    private static UsersPersistentClass user = new UsersPersistentClass();

    public static void exec(ChannelHandlerContext currentCtx, String userName, String hashPassword,
                            String firstName, String lastName) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
                user.setUserName(userName);
                user.setHashPassword(hashPassword);
                user.setAccess("user");
                user.setFirstName(firstName);
                user.setLastName(lastName);
                session.save(user);
                tx.commit();
        } catch (HibernateException he) {
            System.out.println("Hibernate exception in UserSaver class: " + he.getMessage());
            DataBaseOperationErrorHandler.exec(currentCtx);
        }
    }

    public static UsersPersistentClass getUser() {
        return user;
    }
}
