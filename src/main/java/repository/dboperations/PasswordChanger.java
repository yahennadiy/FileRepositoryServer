package repository.dboperations;

import io.netty.channel.ChannelHandlerContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.Main;
import repository.persistentclasses.UsersPersistentClass;
import repository.queryhandlers.errorhandlers.DataBaseOperationErrorHandler;
import java.util.List;

public class PasswordChanger {
    public static void exec(ChannelHandlerContext currentCtx, String userName, String newHashPassword) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            List userData = UserHqlSelector.exec(currentCtx, userName);
            UsersPersistentClass user = (UsersPersistentClass) userData.get(0);
            user.setHashPassword(newHashPassword);
            session.update(user);
            tx.commit();
        } catch (HibernateException he) {
            Main.getLogger().error("Hibernate exception in PasswordChanger class:", he);
            DataBaseOperationErrorHandler.exec(currentCtx);
        }
    }
}
