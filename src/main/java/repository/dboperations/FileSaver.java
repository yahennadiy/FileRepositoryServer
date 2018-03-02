package repository.dboperations;

import io.netty.channel.ChannelHandlerContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.persistentclasses.FilesPersistentClass;
import repository.queryhandlers.errorhandlers.DataBaseOperationErrorHandler;

public class FileSaver {
    private static FilesPersistentClass file = new FilesPersistentClass();

    public static void exec(ChannelHandlerContext currentCtx, String fileName, int fileOwner, String description,
                            String url) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            file.setFileName(fileName);
            file.setFileOwner(fileOwner);
            file.setDescription(description);
            file.setUrl(url);
            session.save(file);
            tx.commit();
        } catch (HibernateException he) {
            System.out.println("Hibernate exception in FileSaver class: " + he.getMessage());
            DataBaseOperationErrorHandler.exec(currentCtx);
        }
    }

    public static FilesPersistentClass getFile() {
        return file;
    }
}
