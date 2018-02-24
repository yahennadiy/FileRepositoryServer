package repository.dboperations;

import io.netty.channel.ChannelHandlerContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import repository.queryhandlers.errorhandlers.DataBaseOperationErrorHandler;
import java.util.List;

public class PrevFilesHqlSelector {
    public static List exec(ChannelHandlerContext currentCtx, String fromFileName, String numberOfRows) {
        List fileData = null;
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("SELECT COUNT(*) FROM FilesPersistentClass WHERE FILE_NAME < " +
                    ":fileName ORDER BY FILE_NAME");
            query.setParameter("fileName", fromFileName);
            Long countFilesLeft = (Long) query.uniqueResult();
            query = session.createQuery("FROM FilesPersistentClass WHERE FILE_NAME < :fileName ORDER BY FILE_NAME");
            query.setParameter("fileName", fromFileName);
            int numberOfRowsInt = Integer.parseInt(numberOfRows);
            if (countFilesLeft > numberOfRowsInt) {
                query.setFirstResult((int) (countFilesLeft - numberOfRowsInt));
            }

            fileData = query.list();
        } catch (HibernateException he) {
            System.out.println("Hibernate exception in LessFilesHQLSelector class: " + he.getMessage());
            DataBaseOperationErrorHandler.exec(currentCtx);
        }

        return fileData;
    }
}
