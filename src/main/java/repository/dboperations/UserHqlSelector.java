package repository.dboperations;

import io.netty.channel.ChannelHandlerContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import repository.Main;
import repository.queryhandlers.errorhandlers.DataBaseOperationErrorHandler;
import java.util.List;

public class UserHqlSelector {
    public static List exec(ChannelHandlerContext currentCtx, String userName) {
        List userData = null;
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("FROM UsersPersistentClass WHERE userName = :USER_NAME");
            query.setParameter("USER_NAME", userName);
            userData = query.list();
        } catch (HibernateException he) {
            Main.getLogger().error("Hibernate exception in UserHqlSelector class:", he);
            DataBaseOperationErrorHandler.exec(currentCtx);
        }

        return userData;
    }
}
