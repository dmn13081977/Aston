package javaee.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaee.entity.Author;
import javaee.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.io.PrintWriter;

public class ManyToManyHibernate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Author author = session.get(Author.class, 2);
            System.out.println(author);
            System.out.println(author.getBookList());
            pw.println(author);
            pw.println(author.getBookList());

            System.out.println("**********");
            pw.println("**********");

            Book book = session.get(Book.class, 5);
            System.out.println(book);
            System.out.println(book.getAuthorList());
            pw.println(book);
            pw.println(book.getAuthorList());
            session.getTransaction().commit();
        }
    }
}
