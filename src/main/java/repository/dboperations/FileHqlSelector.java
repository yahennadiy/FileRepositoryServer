package repository.dboperations;

import io.netty.channel.ChannelHandlerContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import repository.queryhandlers.errorhandlers.DataBaseOperationErrorHandler;
import java.util.List;

public class FileHqlSelector {
    public static List exec(ChannelHandlerContext currentCtx, String fileName) {
        List fileData = null;
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("FROM FilesPersistentClass WHERE FILE_NAME = :fileName");
            query.setParameter("fileName", fileName);
            fileData = query.list();
        } catch (HibernateException he) {
            System.out.println("Hibernate exception in FileHQLSelector class: " + he.getMessage());
            DataBaseOperationErrorHandler.exec(currentCtx);
        }

        return fileData;
    }
}
