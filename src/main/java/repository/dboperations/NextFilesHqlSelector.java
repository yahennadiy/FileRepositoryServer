package repository.dboperations;

import io.netty.channel.Channel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import repository.queryhandlers.errorhandlers.DataBaseOperationErrorHandler;
import java.util.List;

public class NextFilesHqlSelector {
    public static List exec(Channel currentChannel, String fromFileName, String numberOfRows) {
        List fileData = null;
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("FROM FilesPersistentClass WHERE FILE_NAME > :fileName" +
                    " ORDER BY FILE_NAME");
            query.setParameter("fileName", fromFileName);
            query.setMaxResults(Integer.parseInt(numberOfRows));
            fileData = query.list();
        } catch (HibernateException he) {
            System.out.println("Hibernate exception in MoreFilesHQLSelector class: " + he.getMessage());
            DataBaseOperationErrorHandler.exec(currentChannel);
        }

        return fileData;
    }
}
