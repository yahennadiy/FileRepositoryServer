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

public class NextFilesHqlSelector {
    public static List exec(ChannelHandlerContext currentCtx, String fromFileName, String numberOfRows) {
        List fileData = null;
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("FROM FilesPersistentClass WHERE FILE_NAME > :fileName" +
                    " ORDER BY FILE_NAME");
            query.setParameter("fileName", fromFileName);
            query.setMaxResults(Integer.parseInt(numberOfRows));
            fileData = query.list();
        } catch (HibernateException he) {
            Main.getLogger().error("Hibernate exception in NextFilesHQLSelector class:", he);
            DataBaseOperationErrorHandler.exec(currentCtx);
        }

        return fileData;
    }
}
