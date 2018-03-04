package repository.dboperations;

import io.netty.channel.ChannelHandlerContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.persistentclasses.FilesPersistentClass;
import repository.queryhandlers.errorhandlers.DataBaseOperationErrorHandler;

import java.util.List;

public class FileRemover {
    public static void exec(ChannelHandlerContext currentCtx, String fileName) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            List fileData = FileHqlSelector.exec(currentCtx, fileName);
            FilesPersistentClass file = (FilesPersistentClass) fileData.get(0);
            session.delete(file);
            tx.commit();
        } catch (HibernateException he) {
            System.out.println("Hibernate exception in FileRemover class: " + he.getMessage());
            DataBaseOperationErrorHandler.exec(currentCtx);
        }
    }
}
