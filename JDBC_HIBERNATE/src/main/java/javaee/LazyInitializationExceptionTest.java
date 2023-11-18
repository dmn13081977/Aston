package javaee;

import javaee.entity.Author;
import javaee.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LazyInitializationExceptionTest {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Author author = session.get(Author.class, 2);

            session.getTransaction().commit();

            System.out.println(author);
            System.out.println(author.getBookList());
        }
    }
}
