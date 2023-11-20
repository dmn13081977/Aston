package javaee;

import javaee.entity.Author;
import javaee.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class NPlusOneSolution {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Author> authorList = session
                    .createQuery("select p from Author p LEFT JOIN FETCH p.bookList").getResultList();
            for (Author x : authorList)
                System.out.println("Author name: " + x.getName()
                        + ", his books: " + x.getBookList());

            session.getTransaction().commit();
        }
    }
}
